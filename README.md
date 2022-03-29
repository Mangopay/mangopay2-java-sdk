Mangopay Java SDK [![Build Status](https://travis-ci.org/Mangopay/mangopay2-java-sdk.svg?branch=master)](https://travis-ci.org/Mangopay/mangopay2-java-sdk)
=================================================
MangopaySDK is a Java client library to work with
[Mangopay REST API](http://docs.mangopay.com/api-references/).


Compatibility Note
-------------------------------------------------
Since v1.0.6 of this SDK, you must be using at least v2.01 of the API ([more information about the changes required](https://docs.mangopay.com/api-v2-01-overview/))

Be aware that since v2.0.0 of this SDK, v1.x is not be supported anymore. Every new features will only be added to v2.x versions only.
v2.x version is a refactored version, which now fits with Java coding conventions. It contains some major breaking changes that needs some adaptations on your side.


Installation
-------------------------------------------------
SDK has been written in Java 7.

The SDK is published as a Maven artifact on Maven Central Repository (http://search.maven.org/) and can be used with Gradle or Maven.

```
repositories {
    mavenCentral()
}

dependencies {
    compile 'com.mangopay:mangopay2-java-sdk:2.20.0'
}
```

```xml
<dependency>
  <groupId>com.mangopay</groupId>
  <artifactId>mangopay2-java-sdk</artifactId>
  <version>2.20.0</version>
</dependency>
```

License
-------------------------------------------------
MangopaySDK is distributed under MIT license, see LICENSE file.


Unit Tests
-------------------------------------------------
JUnit tests are placed under
[tests directory](https://github.com/MangoPay/mangopay2-java-sdk/tree/master/src/test/java/com/mangopay).


Contacts
-------------------------------------------------
Report bugs or suggest features using
[issue tracker at GitHub](https://github.com/MangoPay/mangopay2-java-sdk).


Account creation
-------------------------------------------------
You can get yourself a free sandbox account or sign up for a production account by [registering on the Mangopay site](https://www.mangopay.com/start/) (note that validation of your production account involves several steps, so think about doing it in advance of when you actually want to go live).

Configuration
-------------------------------------------------
Using the credential info from the signup process above, you should then set `api.Config.ClientId` to your Mangopay Client ID and `api.Config.ClientPassword` to your APIKey.

`api.Config.BaseUrl` is set to sandbox environment by default. To enable production
environment, set it to `https://api.mangopay.com`.
```java
    import com.mangopay.MangoPayApi;

    // ...

    MangoPayApi api = new MangoPayApi();

    // configuration
    api.getConfig().setClientId("your-client-id");
    api.getConfig().setClientPassword("your-client-password");
    //api.getConfig().setBaseUrl("https://api.mangopay.com");

    // call some API methods...
    List<User> users = api.getUserApi().getAll();
```

Sample usage
-------------------------------------------------
```java
    import com.mangopay.MangoPayApi;
    import com.mangopay.entities.User;
    import com.mangopay.entities.BankAccount;
    import com.mangopay.core.Pagination;
    import java.util.List;

    // ...

    MangoPayApi api = new MangoPayApi();

    // get some user by id
    User john = api.Users.get(someId);

    // change and update some of his data
    john.setTag(john.getTag() + " - CHANGED");
    api.getUserApi().update(john);

    // get all users (with pagination and sorting)
    Pagination pagination = new Pagination(1, 8); // get 1st page, 8 items per page
    Sorting sort = new Sorting();
    sort.addField("SortingField", SortDirection.asc); // Sorting is an enum, its values: none, asc, desc
    List<User> users = api.getUserApi().getAll(pagination, sort);

    // get his bank accounts
    pagination = new Pagination(2, 10); // get 2nd page, 10 items per page
    List<BankAccount> accounts = api.getUserApi().getBankAccounts(john.Id, pagination, sort);
```
