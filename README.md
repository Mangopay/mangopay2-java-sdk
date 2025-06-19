# Mangopay Java SDK

Officially supported Java library for interacting with the [Mangopay API](https://docs.mangopay.com/). 

The SDK is published as an artifact on [Maven Central Repository](https://central.sonatype.com/artifact/com.mangopay/mangopay2-java-sdk) and can be used with Gradle or Maven.

The Mangopay Java SDK is distributed under MIT license (see [LICENSE](/license.md) file).

## Prerequisites

To run the Mangopay Java SDK, you'll need:
- A `ClientId` and an API key – if you don't have these, [contact Sales](https://mangopay.com/contact) to get access to the [Mangopay Dashboard](https://hub.mangopay.com/)
- Java 8.0 or higher
- Maven or Gradle

## Installation

### Install with Gradle

Add the following to your build.gradle file:

```shell
repositories {
    mavenCentral()
}

dependencies {
    implementation 'com.mangopay:mangopay2-java-sdk:2.XX.X' // use latest version
    // other dependencies
}
```

### Install with Maven

Add the Mangopay dependency to your pom.xml file:

```xml 
<dependency>
    <groupId>com.mangopay</groupId>
    <artifactId>mangopay2-java-sdk</artifactId>
    <version>2.XX.X</version> <!-- use latest version -->
</dependency>
```

## Initialization

```java 
import com.mangopay.MangoPayApi;

public class Main {
    public static void main(String[] args) throws Exception {
        MangoPayApi mangopay = new MangoPayApi();
        mangopay.getConfig().setClientId("your-mangopay-client-id");
        mangopay.getConfig().setClientPassword("your-mangopay-api-key");

        ...
    }
}
```

| Key | Type | Default value | Description |
| :-- | :-- | :-- | :-- |
| `setClientId` | string | None | Your Mangopay `ClientId` for Sandbox or Production (managed in the [Dashboard](https://hub.mangopay.com/)). |
| `setClientPassword` | string | None | The Mangopay API key associated with the `ClientId` (managed in the [Dashboard](https://hub.mangopay.com/)). |
| `setBaseUrl` | string | https://api.sandbox.mangopay.com/v2.01/ | The API base URL, which is set to the Sandbox environment by default. To enable the production environment, set it to https://api.mangopay.com/ |
| `setConnectTimeout` | integer | `60000` | Time to wait in milliseconds while trying to establish a connection before terminating the attempt and generating an error. |
| `setReadTimeout` | integer | `60000` | Time to wait in milliseconds to receive a response before terminating the attempt and generating an error. |
| `setDebugMode` | boolean | `false` | Activates the debug mode. Recommended only in Sandbox. |
| `setUkHeaderFlag` | boolean | `false` | Indicates the UK Production environment. Platforms that have contracted with Mangopay’s UK entity (MANGOPAY U.K. LIMITED) must set this to `true`. |

## Support

In the Mangopay docs [API reference](https://docs.mangopay.com/api-reference), you can find examples of Java functions for calling each endpoint. 

The SDK's unit tests are also useful for understanding how to use different functions. JUnit tests are placed in the [test directory](https://github.com/Mangopay/mangopay2-java-sdk/tree/master/src/test/java/com/mangopay).

For any issues with SDK code or Java-related documentation that don't require sensitive data (e.g. `ClientId`, object IDs, etc.), please raise a GitHub issue. Otherwise, please contact Mangopay via the [Dashboard](https://hub.mangopay.com/).

You can also provide product feedback via either channel and PR contributions are welcome.

## Sample usage

### Pagination, sorting, and filtering

For endpoints that support pagination, use the `Pagination` object to specify the page and items per page. If sorting is supported, in the `Sorting` object use the `addField()` method to specify the sort direction (possible values are: `none`, `asc`, `desc`).

```java
import com.mangopay.MangoPayApi;
import com.mangopay.entities.User;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import java.util.List;

MangoPayApi api = new MangoPayApi();

// get all users (with pagination and sorting)
Pagination pagination = new Pagination(1, 8); // get 1st page, 8 items per page
Sorting sort = new Sorting();
sort.addField("SortingField", SortDirection.asc); // Sorting is an enum, its values: none, asc, desc
List<User> users = api.getUserApi().getAll(pagination, sort);
```

### Idempotency

To use the [idempotency](https://docs.mangopay.com/api-reference/overview/idempotency) support of the Mangopay API, add the `idempotencyKey` parameter to your function.

#### Example call with idempotency key

```java
import com.mangopay.MangoPayApi;
import com.mangopay.core.Address;
import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.core.enumerations.UserCategory;
import com.mangopay.entities.User;
import com.mangopay.entities.UserNatural;

import java.lang.reflect.Field;

public class CreateNaturalUserWithKey {
    public static void main(String[] args) throws Exception {
        MangoPayApi mangopay = new MangoPayApi();
        mangopay.getConfig().setClientId("your-mangopay-client-id");
        mangopay.getConfig().setClientPassword("your-mangopay-api-key");

        UserNatural user = new UserNatural();
        Address address = new Address();

        address.setAddressLine1("27 Rue de Rivoli");
        address.setCity("Paris");
        address.setRegion("Île-de-France");
        address.setPostalCode("75001");
        address.setCountry(CountryIso.FR);

        user.setFirstName("Alex");
        user.setLastName("Smith");
        user.setEmail("alex.smith@example.com");
        user.setAddress(address);
        user.setBirthday(655772400);
        user.setNationality(CountryIso.FR);
        user.setCountryOfResidence(CountryIso.FR);
        user.setTermsAndConditionsAccepted(true);
        user.setTag("Created with the Mangopay Java SDK");
        user.setUserCategory(UserCategory.PAYER);

        var idempotencyKey = "c5fff42a-f0d4-4fbd-ba04-70e36215f9a8";

        User createUser = mangopay.getUserApi().create(idempotencyKey, user);
        
        System.out.println(createUser);
    }
}
```  

#### Retrieve the request

Retrieve the request made with the idempotency key by calling the [GET View an API response](https://docs.mangopay.com/api-reference/api-responses/view-api-response) endpoint:

```java
import com.mangopay.MangoPayApi;
import com.mangopay.core.Address;
import com.mangopay.entities.IdempotencyResponse;

import java.lang.reflect.Field;

public class GetWithKey {
    public static void main(String[] args) throws Exception {
        MangoPayApi mangopay = new MangoPayApi();
        mangopay.getConfig().setClientId("your-mangopay-client-id");
        mangopay.getConfig().setClientPassword("your-mangopay-api-key");

        var idempotencyKey = "c5fff42a-f0d4-4fbd-ba04-70e36215f9a8";

        IdempotencyResponse respone = mangopay.getIdempotencyApi().get(idempotencyKey);

        printObjectFields(respone);
        System.out.println("resource: ");
        printObjectFields(respone.getResource());
       
    }

    private static void printObjectFields(Object obj) {
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                if (value instanceof Address) {
                    Address address = (Address) value;
                    System.out.println(field.getName() + ": " + address.getAddressLine1() + ", " +
                                       address.getAddressLine2() + ", " +
                                       address.getPostalCode() + " " +
                                       address.getCity() + ", " +
                                       address.getRegion() + ", " +
                                       address.getCountry());
                } else {
                    System.out.println(field.getName() + ": " + value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    
}
```

#### Example output

```shell
statusCode: 200
contentLength: 712
contentType: application/json; charset=utf-8
date: Fri, 22 Mar 2024 10:13:10 GMT
resource: com.mangopay.entities.UserNatural@b2c5e07
requestUrl: https://api.sandbox.mangopay.com/v2.01/your-mangopay-client-id/users/natural
resource: 
firstName: Alex
lastName: Smith
address: 27 Rue de Rivoli, null, 75001 Paris, Île-de-France, FR
birthday: 0
birthplace: null
nationality: null
countryOfResidence: null
occupation: null
incomeRange: null
proofOfIdentity: null
proofOfAddress: null
capacity: NORMAL
```

### Rate limiting

#### Example call to test rate limiting

```java
import com.mangopay.entities.RateLimit;

import java.lang.reflect.Field;

public class TryRateLimiting {

    private RateLimit rateLimit;

    public static int callCounter = 1;

    public TryRateLimiting(int intervalMinutes) {
        this.rateLimit = new RateLimit(intervalMinutes);
    }

    public static void main(String[] args) {
        // Rate limit with allowed calls equal to 10 for demonstration purposes)
        TryRateLimiting example = new TryRateLimiting(1); 
        example.rateLimit.setCallsRemaining(7); 
        example.rateLimit.setResetTimeSeconds(System.currentTimeMillis() / 1000 + (example.rateLimit.getIntervalMinutes() * 60)); // Set initial reset time

        var calls = 10;
        // Simulate multiple API calls
        for (int i = 0; i < calls; i++) {
            example.makeAPICall();
            callCounter++;
        }
    }
    
    // Simulate making an API call
    public void makeAPICall() {

        // Check if the current time has passed the reset time, if so reset the rate limit
        long currentTimeSeconds = System.currentTimeMillis() / 1000;
        if (currentTimeSeconds >= rateLimit.getResetTimeSeconds()) {
            rateLimit.setCallsMade(0);
            rateLimit.setCallsRemaining(rateLimit.getAllowedCalls());
            rateLimit.setResetTimeSeconds(currentTimeSeconds + (rateLimit.getIntervalMinutes() * 60));
        }

        if (rateLimit.getCallsRemaining() > 0) {
            System.out.println("Call #" + callCounter);
            System.out.println("API Call made");

            rateLimit.setCallsMade(rateLimit.getCallsMade() + 1);
            rateLimit.setCallsRemaining(rateLimit.getCallsRemaining() - 1);

            printObjectFields(rateLimit);
        } else {
            System.out.println("Call #" + callCounter);
            System.out.println("Rate limit exceeded. ");
        }
    }

    private static void printObjectFields(Object obj) {
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                System.out.println(field.getName() + ": " + value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
```

#### Example output

```shell
Call #1
API Call made
intervalMinutes: 1
callsMade: 1
callsRemaining: 6
resetTimeSeconds: 1711115417
Call #2
API Call made
intervalMinutes: 1
callsMade: 2
callsRemaining: 5
resetTimeSeconds: 1711115417
Call #3
API Call made
intervalMinutes: 1
callsMade: 3
callsRemaining: 4
resetTimeSeconds: 1711115417
Call #4
API Call made
intervalMinutes: 1
callsMade: 4
callsRemaining: 3
resetTimeSeconds: 1711115417
Call #5
API Call made
intervalMinutes: 1
callsMade: 5
callsRemaining: 2
resetTimeSeconds: 1711115417
Call #6
API Call made
intervalMinutes: 1
callsMade: 6
callsRemaining: 1
resetTimeSeconds: 1711115417
Call #7
API Call made
intervalMinutes: 1
callsMade: 7
callsRemaining: 0
resetTimeSeconds: 1711115417
Call #8
Rate limit exceeded. 
Call #9
Rate limit exceeded. 
Call #10
Rate limit exceeded. 
```
