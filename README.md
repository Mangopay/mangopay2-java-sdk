MangoPay SDK
=================================================
MangoPaySDK is a Java client library to work with
[MangoPay REST API](http://docs.mangopay.com/api-references/).


Installation
-------------------------------------------------
SDK has been written in Java 7. It depends only on a single external package:
[gson](http://code.google.com/p/google-gson/) 2.2.4.

The installation is as easy as downloading the two jar files and storing them
under any classpath/location that will be available for imports in your project:

- [mangopaysdk](https://github.com/MangoPay/mangopay2-java-sdk/raw/master/dist/mangopaysdk.jar)
- [gson](https://github.com/MangoPay/mangopay2-java-sdk/raw/master/lib/google-gson-2.2.4/gson-2.2.4.jar)


License
-------------------------------------------------
MangoPaySDK is distributed under MIT license, see LICENSE file.


Unit Tests
-------------------------------------------------
JUnit tests are placed under
[tests directory](https://github.com/MangoPay/mangopay2-java-sdk/tree/master/test/com/mangopay).


Contacts
-------------------------------------------------
Report bugs or suggest features using
[issue tracker at GitHub](https://github.com/MangoPay/mangopay2-java-sdk).


Client creation example (you need to call it only once)
-------------------------------------------------

    import com.mangopay.MangoPayApi;
    import com.mangopay.entities.Client;

    // ...

    MangoPayApi api = new MangoPayApi();

    Client client = api.Clients.create(
        "your-client-id", 
        "your-client-name", 
        "your-client-email@sample.org"
    );

    // you receive your password here, note it down and keep in secret
    System.out.println(client.Passphrase);


Configuration
-------------------------------------------------
See the example above and call `api.Clients.create` once to get your passphrase.
Then set `api.Config.ClientId` to your MangoPay Client ID and 
`api.Config.ClientPassword` to your passphrase.

`api.Config.BaseUrl` is set to sandbox environment by default. To enable production
environment, set it to `https://mangopay-api.leetchi.com`.

    import com.mangopay.MangoPayApi;

    // ...

    MangoPayApi api = new MangoPayApi();

    // configuration
    api.Config.ClientId = "your-client-id";
    api.Config.ClientPassword = "your-client-password";
    //api.Config.BaseUrl = "https://mangopay-api.leetchi.com";

    // call some API methods...
    List<User> users = api.Users.getAll();


Sample usage
-------------------------------------------------

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
    john.Tag += " - CHANGED";
    api.Users.update(john);

    // get all users (with pagination)
    Pagination pagination = new Pagination(1, 8); // get 1st page, 8 items per page
    List<User> users = api.Users.getAll(pagination);

    // get his bank accounts
    pagination = new Pagination(2, 10); // get 2nd page, 10 items per page
    List<BankAccount> accounts = api.Users.getBankAccounts(john.Id, pagination);
