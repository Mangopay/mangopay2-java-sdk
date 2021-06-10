package com.mangopay.core;

import com.mangopay.MangoPayApi;
import com.mangopay.core.enumerations.*;
import com.mangopay.entities.*;
import com.mangopay.entities.subentities.*;
import org.junit.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@Ignore("Just a base class for tests: nothing to test here")
public abstract class BaseTest {

    protected MangoPayApi api;

    private static UserNatural JOHN;
    private static UserLegal MATRIX;
    private static UboDeclaration MATRIX_UBO_DECLARATION;
    private static Ubo MATRIX_UBO;
    private static BankAccount JOHNS_ACCOUNT;
    private static Wallet JOHNS_WALLET;
    private static Wallet JOHNS_WALLET_WITH_MONEY;
    private static Card JOHNS_3DSECURE_CARD;
    private static Wallet JOHNS_WALLET_WITH_MONEY_3D_SECURE;
    private static PayIn JOHNS_PAYIN_CARD_WEB;
    private static PayInPaymentDetailsCard PAYIN_PAYMENT_DETAILS_CARD;
    private static PayInExecutionDetailsWeb PAYIN_EXECUTION_DETAILS_WEB;
    private static PayOut JOHNS_PAYOUT_BANKWIRE;
    private static CardRegistration JOHNS_CARD_REGISTRATION;
    private static KycDocument JOHNS_KYC_DOCUMENT;
    private static PayOut JOHNS_PAYOUT_FOR_CARD_DIRECT;
    private static Hook JOHNS_HOOK;
    private static ReportRequest JOHNS_REPORT;
    private static BankingAlias JOHNS_BANKING_ALIAS;
    private static UboDeclaration UBO_DECLARATION;
    private static PayInTemplateURLOptions PAYIN_TEMPLATE_URL_OPTIONS;

    public BaseTest() {
        this.api = buildNewMangoPayApi();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    protected MangoPayApi getApi() {
        return api;
    }

    protected final MangoPayApi buildNewMangoPayApi() {
        MangoPayApi newApi = new MangoPayApi();

        // use test client credentails
        newApi.getConfig().setClientId("sdk-unit-tests");
        newApi.getConfig().setClientPassword("cqFfFrWfCcb7UadHNxx2C9Lo6Djw8ZduLi7J9USTmu8bhxxpju");
        newApi.getConfig().setDebugMode(true);

        // register storage strategy for tests
        newApi.getOAuthTokenManager().registerCustomStorageStrategy(new DefaultStorageStrategyForTests());

        return newApi;
    }

    /**
     * Makes the current thread to sleep for given period of time in seconds.
     *
     * @param sleepTimeInSeconds How long to sleep.
     */
    protected void holdOn(int sleepTimeInSeconds) {
        try {
            TimeUnit.SECONDS.sleep(sleepTimeInSeconds);
        } catch (InterruptedException ex) {
            /* intentionally suppressed InterruptedException here */
        }
    }

    protected Address getNewAddress() {
        Address result = new Address();

        result.setAddressLine1("Address line 1");
        result.setAddressLine2("Address line 2");
        result.setCity("City");
        result.setCountry(CountryIso.PL);
        result.setPostalCode("11222");
        result.setRegion("Region");

        return result;
    }

    protected Billing getNewBilling() {
        Billing billing = new Billing();
        Address address = getNewAddress();

        billing.setFirstName("John");
        billing.setLastName("Doe");
        billing.setAddress(address);

        return billing;
    }

    protected Shipping getNewShipping() {
        Shipping shipping = new Shipping();
        Address address = getNewAddress();

        shipping.setFirstName("John");
        shipping.setLastName("Doe");
        shipping.setAddress(address);

        return shipping;
    }

    protected UserNatural getJohn() throws Exception {
        return getJohn(false);
    }

    protected UserNatural getJohn(Boolean recreate) throws Exception {
        if (BaseTest.JOHN == null || recreate) {
            Calendar c = Calendar.getInstance();
            c.set(1975, 12, 21, 0, 0, 0);

            UserNatural user = new UserNatural();
            user.setFirstName("John");
            user.setLastName("Doe");
            user.setEmail("john.doe@sample.org");
            user.setAddress(this.getNewAddress());
            user.setBirthday(c.getTimeInMillis() / 1000);
            user.setNationality(CountryIso.FR);
            user.setCountryOfResidence(CountryIso.FR);
            user.setOccupation("programmer");
            user.setIncomeRange(3);

            BaseTest.JOHN = (UserNatural) this.api.getUserApi().create(user);
            BaseTest.JOHNS_WALLET = null;
            BaseTest.JOHNS_WALLET_WITH_MONEY = null;
            BaseTest.JOHNS_ACCOUNT = null;
            BaseTest.JOHNS_CARD_REGISTRATION = null;
            BaseTest.JOHNS_HOOK = null;
            BaseTest.JOHNS_KYC_DOCUMENT = null;
            BaseTest.JOHNS_PAYIN_CARD_WEB = null;
            BaseTest.JOHNS_PAYOUT_BANKWIRE = null;
            BaseTest.JOHNS_PAYOUT_FOR_CARD_DIRECT = null;
            BaseTest.JOHNS_BANKING_ALIAS = null;
        }
        return BaseTest.JOHN;
    }

    protected UserNatural getNewDeclarativeJohn() throws Exception {
        return getNewJohn(true);
    }

    protected UserNatural getNewJohn(boolean declarative) throws Exception {

        Calendar c = Calendar.getInstance();
        c.set(1975, 12, 21, 0, 0, 0);

        UserNatural user = new UserNatural();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@sample.org");
        user.setAddress(this.getNewAddress());
        user.setBirthday(c.getTimeInMillis() / 1000);
        user.setNationality(CountryIso.FR);
        user.setCountryOfResidence(CountryIso.FR);
        user.setOccupation("programmer");
        user.setIncomeRange(3);
        if (declarative) {
            user.setCapacity(NaturalUserCapacity.DECLARATIVE);
        }
        return (UserNatural) this.api.getUserApi().create(user);
    }

    protected UserLegal getMatrix() throws Exception {
        if (BaseTest.MATRIX == null) {
            UserNatural john = this.getJohn();
            UserLegal user = new UserLegal();
            user.setName("MartixSampleOrg");
            user.setLegalPersonType(LegalPersonType.BUSINESS);
            user.setHeadquartersAddress(this.getNewAddress());
            user.setLegalRepresentativeFirstName(john.getFirstName());
            user.setLegalRepresentativeLastName(john.getLastName());
            user.setLegalRepresentativeAddress(john.getAddress());
            user.setLegalRepresentativeEmail(john.getEmail());
            user.setLegalRepresentativeBirthday(john.getBirthday());
            user.setLegalRepresentativeNationality(john.getNationality());
            user.setLegalRepresentativeCountryOfResidence(john.getCountryOfResidence());
            user.setCompanyNumber("LU12345678");

            Calendar c = Calendar.getInstance();
            c.set(1975, 12, 21, 0, 0, 0);
            user.setLegalRepresentativeBirthday(c.getTimeInMillis() / 1000);
            user.setEmail(john.getEmail());

            BaseTest.MATRIX = (UserLegal) this.api.getUserApi().create(user);
        }
        return BaseTest.MATRIX;
    }

    /**
        Current optional fields are:
            HeadquartersAddress, LegalRepresentativeAddress, LegalRepresentativeEmail, CompanyNumber
    */
    protected UserLegal getMatrixWithoutOptionalFields() throws Exception {
        if (BaseTest.MATRIX == null) {
            UserNatural john = this.getJohn();
            UserLegal user = new UserLegal();
            user.setName("MartixSampleOrg");
            user.setLegalPersonType(LegalPersonType.BUSINESS);
            user.setLegalRepresentativeFirstName(john.getFirstName());
            user.setLegalRepresentativeLastName(john.getLastName());
            user.setLegalRepresentativeBirthday(john.getBirthday());
            user.setLegalRepresentativeNationality(john.getNationality());
            user.setLegalRepresentativeCountryOfResidence(john.getCountryOfResidence());

            Calendar c = Calendar.getInstance();
            c.set(1975, 12, 21, 0, 0, 0);
            user.setLegalRepresentativeBirthday(c.getTimeInMillis() / 1000);
            user.setEmail(john.getEmail());

            BaseTest.MATRIX = (UserLegal) this.api.getUserApi().create(user);
        }
        return BaseTest.MATRIX;
    }

    protected BankAccount getJohnsAccount() throws Exception {
        return getJohnsAccount(false);
    }

    protected BankAccount getJohnsAccount(Boolean recreate) throws Exception {
        if (BaseTest.JOHNS_ACCOUNT == null || recreate) {
            UserNatural john = this.getJohn();
            BankAccount account = new BankAccount();
            account.setType(BankAccountType.IBAN);
            account.setOwnerName(john.getFirstName() + " " + john.getLastName());
            account.setOwnerAddress(john.getAddress());
            account.setUserId(john.getId());
            BankAccountDetailsIBAN bankAccountDetails = new BankAccountDetailsIBAN();
            bankAccountDetails.setIban("FR7630004000031234567890143");
            bankAccountDetails.setBic("BNPAFRPP");
            account.setDetails(bankAccountDetails);
            BaseTest.JOHNS_ACCOUNT = this.api.getUserApi().createBankAccount(john.getId(), account);
        }
        return BaseTest.JOHNS_ACCOUNT;
    }

    protected BankAccount getNewBankAccount() throws Exception {
        BaseTest.JOHNS_ACCOUNT = null;
        return getJohnsAccount();
    }

    protected Wallet getJohnsWallet() throws Exception {
        if (BaseTest.JOHNS_WALLET == null) {
            UserNatural john = this.getJohn();

            Wallet wallet = new Wallet();
            wallet.setOwners(new ArrayList<String>());
            wallet.getOwners().add(john.getId());

            wallet.setCurrency(CurrencyIso.EUR);
            wallet.setDescription("WALLET IN EUR");

            BaseTest.JOHNS_WALLET = this.api.getWalletApi().create(wallet);
        }

        return BaseTest.JOHNS_WALLET;
    }

    /**
     * Creates wallet for John, loaded with 10k EUR (John's got lucky) if not
     * created yet, or returns an existing one.
     *
     * @return Wallet instance loaded with 10k EUR.
     */
    protected Wallet getJohnsWalletWithMoney() throws Exception {
        return getJohnsWalletWithMoney(10000);
    }

    /**
     * Creates wallet for John, if not created yet, or returns an existing one.
     *
     * @param amount Initial wallet's money amount.
     * @return Wallet entity instance.
     */
    protected Map<String, String> getJohnsWalletWithMoney3DSecure(int amount) throws Exception {

        if (BaseTest.JOHNS_WALLET_WITH_MONEY_3D_SECURE == null) {
            UserNatural john = this.getJohn();

            // create wallet with money
            Wallet wallet = new Wallet();
            wallet.setOwners(new ArrayList<String>());
            wallet.getOwners().add(john.getId());
            wallet.setCurrency(CurrencyIso.EUR);
            wallet.setDescription("WALLET IN EUR WITH MONEY");

            BaseTest.JOHNS_WALLET_WITH_MONEY_3D_SECURE = this.api.getWalletApi().create(wallet);

            CardRegistration cardRegistration = new CardRegistration();
            cardRegistration.setUserId(BaseTest.JOHNS_WALLET_WITH_MONEY_3D_SECURE.getOwners().get(0));
            cardRegistration.setCurrency(CurrencyIso.EUR);
            cardRegistration = this.api.getCardRegistrationApi().create(cardRegistration);

            cardRegistration.setRegistrationData(this.getPaylineCorrectRegistartionData3DSecure(cardRegistration));
            cardRegistration = this.api.getCardRegistrationApi().update(cardRegistration);

            Card card = this.api.getCardApi().get(cardRegistration.getCardId());
            BaseTest.JOHNS_3DSECURE_CARD = card;

            // create pay-in CARD DIRECT
            PayIn payIn = new PayIn();
            payIn.setCreditedWalletId(BaseTest.JOHNS_WALLET_WITH_MONEY_3D_SECURE.getId());
            payIn.setAuthorId(cardRegistration.getUserId());
            payIn.setDebitedFunds(new Money());
            payIn.getDebitedFunds().setAmount(amount);
            payIn.getDebitedFunds().setCurrency(CurrencyIso.EUR);
            payIn.setFees(new Money());
            payIn.getFees().setAmount(0);
            payIn.getFees().setCurrency(CurrencyIso.EUR);

            // payment type as CARD
            payIn.setPaymentDetails(new PayInPaymentDetailsCard());
            ((PayInPaymentDetailsCard) payIn.getPaymentDetails()).setCardType(card.getCardType());

            // execution type as DIRECT
            payIn.setExecutionDetails(new PayInExecutionDetailsDirect());
            ((PayInExecutionDetailsDirect) payIn.getExecutionDetails()).setCardId(card.getId());
            ((PayInExecutionDetailsDirect) payIn.getExecutionDetails()).setSecureModeReturnUrl("http://test.com");

            // create Pay-In
            this.api.getPayInApi().create(payIn);
        }

        Wallet wally = this.api.getWalletApi().get(BaseTest.JOHNS_WALLET_WITH_MONEY_3D_SECURE.getId());

        Map<String, String> map = new HashMap<>();
        map.put("cardId", BaseTest.JOHNS_3DSECURE_CARD.getId());
        map.put("walletId", wally.getId());

        return map;
    }

    protected RecurringPayment createJohnsRecurringPayment() throws Exception {
        Map<String, String> data = this.getJohnsWalletWithMoney3DSecure(1000);
        UserNatural john = this.getJohn();

        CreateRecurringPayment createRecurringPayment = new CreateRecurringPayment();
        createRecurringPayment.setAuthorId(john.getId());
        createRecurringPayment.setCardId(data.get("cardId"));
        createRecurringPayment.setCreditedUserId(john.getId());
        createRecurringPayment.setCreditedWalletId(data.get("walletId"));
        createRecurringPayment.setFirstTransactionDebitedFunds(new Money().setAmount(10).setCurrency(CurrencyIso.EUR));
        createRecurringPayment.setFirstTransactionFees(new Money().setAmount(1).setCurrency(CurrencyIso.EUR));
        createRecurringPayment.setShipping(this.getNewShipping());
        createRecurringPayment.setBilling(this.getNewBilling());

        return api.getPayInApi().createRecurringPayment(null, createRecurringPayment);
    }

    /**
     * Creates wallet for John, if not created yet, or returns an existing one.
     *
     * @param amount Initial wallet's money amount.
     * @return Wallet entity instance.
     */
    protected Wallet getJohnsWalletWithMoney(int amount) throws Exception {

        if (BaseTest.JOHNS_WALLET_WITH_MONEY == null) {

            UserNatural john = this.getJohn();

            // create wallet with money
            Wallet wallet = new Wallet();
            wallet.setOwners(new ArrayList<String>());
            wallet.getOwners().add(john.getId());
            wallet.setCurrency(CurrencyIso.EUR);
            wallet.setDescription("WALLET IN EUR WITH MONEY");

            BaseTest.JOHNS_WALLET_WITH_MONEY = this.api.getWalletApi().create(wallet);

            CardRegistration cardRegistration = new CardRegistration();
            cardRegistration.setUserId(BaseTest.JOHNS_WALLET_WITH_MONEY.getOwners().get(0));
            cardRegistration.setCurrency(CurrencyIso.EUR);
            cardRegistration = this.api.getCardRegistrationApi().create(cardRegistration);

            cardRegistration.setRegistrationData(this.getPaylineCorrectRegistartionData(cardRegistration));
            cardRegistration = this.api.getCardRegistrationApi().update(cardRegistration);

            Card card = this.api.getCardApi().get(cardRegistration.getCardId());

            // create pay-in CARD DIRECT
            PayIn payIn = new PayIn();
            payIn.setCreditedWalletId(BaseTest.JOHNS_WALLET_WITH_MONEY.getId());
            payIn.setAuthorId(cardRegistration.getUserId());
            payIn.setDebitedFunds(new Money());
            payIn.getDebitedFunds().setAmount(amount);
            payIn.getDebitedFunds().setCurrency(CurrencyIso.EUR);
            payIn.setFees(new Money());
            payIn.getFees().setAmount(0);
            payIn.getFees().setCurrency(CurrencyIso.EUR);

            // payment type as CARD
            payIn.setPaymentDetails(new PayInPaymentDetailsCard());
            ((PayInPaymentDetailsCard) payIn.getPaymentDetails()).setCardType(card.getCardType());

            // execution type as DIRECT
            payIn.setExecutionDetails(new PayInExecutionDetailsDirect());
            ((PayInExecutionDetailsDirect) payIn.getExecutionDetails()).setCardId(card.getId());
            ((PayInExecutionDetailsDirect) payIn.getExecutionDetails()).setSecureModeReturnUrl("http://test.com");

            // create Pay-In
            this.api.getPayInApi().create(payIn);
        }

        return this.api.getWalletApi().get(BaseTest.JOHNS_WALLET_WITH_MONEY.getId());
    }

    private PayInPaymentDetailsCard getPayInPaymentDetailsCard() {
        if (BaseTest.PAYIN_PAYMENT_DETAILS_CARD == null) {
            BaseTest.PAYIN_PAYMENT_DETAILS_CARD = new PayInPaymentDetailsCard();
            BaseTest.PAYIN_PAYMENT_DETAILS_CARD.setCardType(CardType.CB_VISA_MASTERCARD);
        }

        return BaseTest.PAYIN_PAYMENT_DETAILS_CARD;
    }

    private PayInExecutionDetailsWeb getPayInExecutionDetailsWeb() {
        if (BaseTest.PAYIN_EXECUTION_DETAILS_WEB == null) {
            BaseTest.PAYIN_EXECUTION_DETAILS_WEB = new PayInExecutionDetailsWeb();
            BaseTest.PAYIN_EXECUTION_DETAILS_WEB.setTemplateUrl("https://TemplateURL.com");
            BaseTest.PAYIN_EXECUTION_DETAILS_WEB.setSecureMode(SecureMode.DEFAULT);
            BaseTest.PAYIN_EXECUTION_DETAILS_WEB.setCulture(CultureCode.FR);
            BaseTest.PAYIN_EXECUTION_DETAILS_WEB.setReturnUrl("https://test.com");
            
            if(BaseTest.PAYIN_TEMPLATE_URL_OPTIONS == null) {
                BaseTest.PAYIN_TEMPLATE_URL_OPTIONS = new PayInTemplateURLOptions();
                BaseTest.PAYIN_TEMPLATE_URL_OPTIONS.PAYLINE = "https://www.maysite.com/payline_template/";
                BaseTest.PAYIN_TEMPLATE_URL_OPTIONS.PAYLINEV2 = "https://www.maysite.com/payline_template/";
                BaseTest.PAYIN_EXECUTION_DETAILS_WEB.setTemplateURLOptions(PAYIN_TEMPLATE_URL_OPTIONS);
            }
        }

        return BaseTest.PAYIN_EXECUTION_DETAILS_WEB;
    }

    protected PayIn getJohnsPayInCardWeb() throws Exception {
        if (BaseTest.JOHNS_PAYIN_CARD_WEB == null) {
            Wallet wallet = this.getJohnsWallet();
            UserNatural user = this.getJohn();

            PayIn payIn = new PayIn();
            payIn.setAuthorId(user.getId());
            payIn.setCreditedUserId(user.getId());
            payIn.setDebitedFunds(new Money());
            payIn.getDebitedFunds().setCurrency(CurrencyIso.EUR);
            payIn.getDebitedFunds().setAmount(500);
            payIn.setFees(new Money());
            payIn.getFees().setCurrency(CurrencyIso.EUR);
            payIn.getFees().setAmount(5);
            payIn.setCreditedWalletId(wallet.getId());
            payIn.setPaymentDetails(this.getPayInPaymentDetailsCard());
            payIn.setExecutionDetails(this.getPayInExecutionDetailsWeb());

            BaseTest.JOHNS_PAYIN_CARD_WEB = this.api.getPayInApi().create(payIn);
        }

        return BaseTest.JOHNS_PAYIN_CARD_WEB;
    }

    protected PayIn getNewPayInCardWeb() throws Exception {
        BaseTest.JOHNS_PAYIN_CARD_WEB = null;
        return getJohnsPayInCardWeb();
    }

//    protected PayIn getJohnsPayInBankWireDirect() throws Exception {
//        Wallet wallet = this.getJohnsWallet();
//
//        PayIn payIn = new PayIn();
//        payIn.CreditedWalletId = wallet.Id;
//        payIn.AuthorId = wallet.Owners.get(0);
//
//        // payment type as CARD
//        payIn.PaymentDetails = new PayInPaymentDetailsBankWire();
//    }

    protected PayIn getNewPayInCardDirect() throws Exception {
        return getNewPayInCardDirect(null);
    }

    /**
     * Creates Pay-In Card Direct object
     *
     * @return PayIn
     */
    protected PayIn getNewPayInCardDirect(String userId) throws Exception {
        PayIn payIn = getPayInCardDirect(userId);

        return this.api.getPayInApi().create(payIn);
    }

    private PayIn getPayInCardDirect(String userId) throws Exception {

        Wallet wallet = this.getJohnsWalletWithMoney();

        if (userId == null) {
            UserNatural user = this.getJohn();
            userId = user.getId();
        }

        CardRegistration cardRegistration = new CardRegistration();
        cardRegistration.setUserId(userId);
        cardRegistration.setCurrency(CurrencyIso.EUR);
        cardRegistration = this.api.getCardRegistrationApi().create(cardRegistration);
        cardRegistration.setRegistrationData(this.getPaylineCorrectRegistartionData(cardRegistration));
        cardRegistration = this.api.getCardRegistrationApi().update(cardRegistration);

        Card card = this.api.getCardApi().get(cardRegistration.getCardId());

        // create pay-in CARD DIRECT
        PayIn payIn = new PayIn();
        payIn.setCreditedWalletId(wallet.getId());
        payIn.setAuthorId(userId);
        payIn.setDebitedFunds(new Money());
        payIn.getDebitedFunds().setAmount(500);
        payIn.getDebitedFunds().setCurrency(CurrencyIso.EUR);
        payIn.setFees(new Money());
        payIn.getFees().setAmount(0);
        payIn.getFees().setCurrency(CurrencyIso.EUR);

        // payment type as CARD
        payIn.setPaymentDetails(new PayInPaymentDetailsCard());
        ((PayInPaymentDetailsCard) payIn.getPaymentDetails()).setCardType(card.getCardType());

        // execution type as DIRECT
        payIn.setExecutionDetails(new PayInExecutionDetailsDirect());
        ((PayInExecutionDetailsDirect) payIn.getExecutionDetails()).setCardId(card.getId());
        ((PayInExecutionDetailsDirect) payIn.getExecutionDetails()).setSecureModeReturnUrl("http://test.com");
        ((PayInExecutionDetailsDirect) payIn.getExecutionDetails()).setCulture(CultureCode.FR);

        return payIn;
    }

    protected PayIn getNewPayInCardDirectWithRequested3DSVersion() throws Exception {
        PayIn payIn = getPayInCardDirect(null);

        PayInExecutionDetailsDirect executionDetails = (PayInExecutionDetailsDirect) payIn.getExecutionDetails();
        executionDetails.setRequested3DSVersion("V1");

        return this.api.getPayInApi().create(payIn);
    }

    protected PayIn getNewPayInCardDirectWithBilling() throws Exception {
        PayIn payIn = getPayInCardDirect(null);

        PayInExecutionDetailsDirect executionDetails = (PayInExecutionDetailsDirect) payIn.getExecutionDetails();
        Billing billing = new Billing();
        Address address = new Address();
        address.setCity("Halo");
        address.setAddressLine1("Street street");
        address.setCountry(CountryIso.FR);
        address.setPostalCode("65400");
        billing.setAddress(address);
        billing.setFirstName("John");
        billing.setLastName("Doe");
        executionDetails.setBilling(billing);

        return this.api.getPayInApi().create(payIn);
    }

    protected BrowserInfo getNewBrowserInfo() {
        BrowserInfo browserInfo = new BrowserInfo();
        browserInfo.setAcceptHeader("text/html, application/xhtml+xml, application/xml;q=0.9, /;q=0.8");
        browserInfo.setColorDepth(4);
        browserInfo.setJavaEnabled(true);
        browserInfo.setJavaEnabled(true);
        browserInfo.setLanguage("FR-FR");
        browserInfo.setScreenHeight(1800);
        browserInfo.setScreenWidth(400);
        browserInfo.setTimeZoneOffset("+60");
        browserInfo.setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 13_6_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148");

        return browserInfo;
    }

    protected PayIn getNewPayInCardDirectWithBrowserInfo() throws Exception{
        PayIn payIn = getPayInCardDirect(null);

        ((PayInPaymentDetailsCard) payIn.getPaymentDetails()).setBrowserInfo(getNewBrowserInfo());

        return this.api.getPayInApi().create(payIn);
    }

    protected PayIn getNewPayInCardDirectWithIpAddress() throws Exception{
        PayIn payIn = getPayInCardDirect(null);

        ((PayInPaymentDetailsCard) payIn.getPaymentDetails()).setIpAddress("2001:0620:0000:0000:0211:24FF:FE80:C12C");

        return this.api.getPayInApi().create(payIn);
    }

    protected PayOut getJohnsPayOutBankWire() throws Exception {
        if (BaseTest.JOHNS_PAYOUT_BANKWIRE == null) {
            Wallet wallet = this.getJohnsWallet();
            UserNatural user = this.getJohn();
            BankAccount account = this.getJohnsAccount();

            PayOut payOut = new PayOut();
            payOut.setTag("DefaultTag");
            payOut.setAuthorId(user.getId());
            payOut.setCreditedUserId(user.getId());
            payOut.setDebitedFunds(new Money());
            payOut.getDebitedFunds().setCurrency(CurrencyIso.EUR);
            payOut.getDebitedFunds().setAmount(10);
            payOut.setFees(new Money());
            payOut.getFees().setCurrency(CurrencyIso.EUR);
            payOut.getFees().setAmount(5);

            payOut.setDebitedWalletId(wallet.getId());
            payOut.setMeanOfPaymentDetails(new PayOutPaymentDetailsBankWire());
            ((PayOutPaymentDetailsBankWire) payOut.getMeanOfPaymentDetails()).setBankAccountId(account.getId());
            ((PayOutPaymentDetailsBankWire) payOut.getMeanOfPaymentDetails()).setPayoutModeRequested(PayoutMode.STANDARD);

            BaseTest.JOHNS_PAYOUT_BANKWIRE = this.api.getPayOutApi().create(payOut);
        }

        return BaseTest.JOHNS_PAYOUT_BANKWIRE;
    }

    /**
     * Creates Pay-Out Bank Wire object.
     *
     * @return PayOut
     * @throws Exception
     */
    protected PayOut getJohnsPayOutForCardDirect() throws Exception {
        if (BaseTest.JOHNS_PAYOUT_FOR_CARD_DIRECT == null) {
            PayIn payIn = this.getNewPayInCardDirect();
            BankAccount account = this.getJohnsAccount();

            PayOut payOut = new PayOut();
            payOut.setTag("DefaultTag");
            payOut.setAuthorId(payIn.getAuthorId());
            payOut.setCreditedUserId(payIn.getAuthorId());
            payOut.setDebitedFunds(new Money());
            payOut.getDebitedFunds().setCurrency(CurrencyIso.EUR);
            payOut.getDebitedFunds().setAmount(10);
            payOut.setFees(new Money());
            payOut.getFees().setCurrency(CurrencyIso.EUR);
            payOut.getFees().setAmount(5);

            payOut.setDebitedWalletId(payIn.getCreditedWalletId());
            payOut.setMeanOfPaymentDetails(new PayOutPaymentDetailsBankWire());
            ((PayOutPaymentDetailsBankWire) payOut.getMeanOfPaymentDetails()).setBankAccountId(account.getId());

            BaseTest.JOHNS_PAYOUT_FOR_CARD_DIRECT = this.api.getPayOutApi().create(payOut);
        }

        return BaseTest.JOHNS_PAYOUT_FOR_CARD_DIRECT;
    }

    protected Transfer getNewTransfer() throws Exception {
        Wallet walletWithMoney = this.getJohnsWalletWithMoney();
        UserNatural user = this.getJohn();

        Wallet wallet = new Wallet();
        wallet.setOwners(new ArrayList<String>());
        wallet.getOwners().add(user.getId());
        wallet.setCurrency(CurrencyIso.EUR);
        wallet.setDescription("WALLET IN EUR FOR TRANSFER");
        wallet = this.api.getWalletApi().create(wallet);

        Transfer transfer = new Transfer();
        transfer.setTag("DefaultTag");
        transfer.setAuthorId(user.getId());
        transfer.setCreditedUserId(user.getId());
        transfer.setDebitedFunds(new Money());
        transfer.getDebitedFunds().setCurrency(CurrencyIso.EUR);
        transfer.getDebitedFunds().setAmount(100);
        transfer.setFees(new Money());
        transfer.getFees().setCurrency(CurrencyIso.EUR);
        transfer.getFees().setAmount(0);

        transfer.setDebitedWalletId(walletWithMoney.getId());
        transfer.setCreditedWalletId(wallet.getId());

        return this.api.getTransferApi().create(transfer);
    }

    /**
     * Creates refund object for transfer.
     */
    protected Refund getNewRefundForTransfer(Transfer transfer) throws Exception {
        UserNatural user = this.getJohn();

        Refund refund = new Refund();
        refund.setDebitedWalletId(transfer.getDebitedWalletId());
        refund.setCreditedWalletId(transfer.getCreditedWalletId());
        refund.setAuthorId(user.getId());
        refund.setDebitedFunds(new Money());
        refund.getDebitedFunds().setAmount(transfer.getDebitedFunds().getAmount());
        refund.getDebitedFunds().setCurrency(transfer.getDebitedFunds().getCurrency());
        refund.setFees(new Money());
        refund.getFees().setAmount(transfer.getFees().getAmount());
        refund.getFees().setCurrency(transfer.getFees().getCurrency());

        return this.api.getTransferApi().createRefund(transfer.getId(), refund);
    }

    /**
     * Creates refund object for PayIn.
     *
     * @return Created Refund entity.
     */
    protected Refund getNewRefundForPayIn(PayIn payIn) throws Exception {
        UserNatural user = this.getJohn();

        Refund refund = new Refund();
        refund.setCreditedWalletId(payIn.getCreditedWalletId());
        refund.setAuthorId(user.getId());
        refund.setDebitedFunds(new Money());
        refund.getDebitedFunds().setAmount(payIn.getDebitedFunds().getAmount());
        refund.getDebitedFunds().setCurrency(payIn.getDebitedFunds().getCurrency());
        refund.setFees(new Money());
        refund.getFees().setAmount(payIn.getFees().getAmount());
        refund.getFees().setCurrency(payIn.getFees().getCurrency());

        return this.api.getPayInApi().createRefund(payIn.getId(), refund);
    }

    /**
     * Creates card registration object.
     *
     * @return CardRegistration instance returned from API.
     */
    protected CardRegistration getJohnsCardRegistration() throws Exception {
        return getJohnsCardRegistration(CardType.CB_VISA_MASTERCARD);
    }

    protected CardRegistration getJohnsCardRegistration(CardType cardType) throws Exception {
        if (BaseTest.JOHNS_CARD_REGISTRATION == null) {
            UserNatural user = this.getJohn();

            CardRegistration cardRegistration = new CardRegistration(cardType);
            cardRegistration.setUserId(user.getId());
            cardRegistration.setCurrency(CurrencyIso.EUR);

            BaseTest.JOHNS_CARD_REGISTRATION = this.api.getCardRegistrationApi().create(cardRegistration);
        }

        return BaseTest.JOHNS_CARD_REGISTRATION;
    }

    protected CardRegistration getNewJohnsCardRegistration(CardType cardType) throws Exception {
        BaseTest.JOHNS_CARD_REGISTRATION = null;

        return getJohnsCardRegistration(cardType);
    }

    /**
     * Creates card registration object.
     */
    protected CardPreAuthorization getJohnsCardPreAuthorization() throws Exception {
        CardPreAuthorization cardPreAuthorization = getPreAuthorization();

        return this.api.getCardPreAuthorizationApi().create(cardPreAuthorization);
    }

    protected CardPreAuthorization getPreAuthorization() throws Exception {
        UserNatural user = this.getJohn();
        CardRegistration cardRegistration = new CardRegistration();
        cardRegistration.setUserId(user.getId());
        cardRegistration.setCurrency(CurrencyIso.EUR);
        CardRegistration newCardRegistration = this.api.getCardRegistrationApi().create(cardRegistration);

        String registrationData = this.getPaylineCorrectRegistartionData(newCardRegistration);
        newCardRegistration.setRegistrationData(registrationData);
        CardRegistration getCardRegistration = this.api.getCardRegistrationApi().update(newCardRegistration);

        CardPreAuthorization cardPreAuthorization = new CardPreAuthorization();
        cardPreAuthorization.setAuthorId(user.getId());
        cardPreAuthorization.setDebitedFunds(new Money());
        cardPreAuthorization.getDebitedFunds().setCurrency(CurrencyIso.EUR);
        cardPreAuthorization.getDebitedFunds().setAmount(500);
        cardPreAuthorization.setRemainingFunds(new Money());
        cardPreAuthorization.getRemainingFunds().setCurrency(CurrencyIso.EUR);
        cardPreAuthorization.getRemainingFunds().setAmount(500);
        cardPreAuthorization.setCardId(getCardRegistration.getCardId());
        cardPreAuthorization.setSecureModeReturnUrl("http://test.com");
        cardPreAuthorization.setCulture(CultureCode.FR);

        //Shipping shipping = getNewShipping();
        //cardPreAuthorization.setShipping(shipping);

        return cardPreAuthorization;
    }

    protected KycDocument getJohnsKycDocument() throws Exception {
        if (BaseTest.JOHNS_KYC_DOCUMENT == null) {
            String johnsId = this.getJohn().getId();

            BaseTest.JOHNS_KYC_DOCUMENT = this.api.getUserApi().createKycDocument(johnsId, KycDocumentType.IDENTITY_PROOF);
        }

        return BaseTest.JOHNS_KYC_DOCUMENT;
    }

    protected KycDocument getNewKycDocument() throws Exception {
        BaseTest.JOHNS_KYC_DOCUMENT = null;
        return getJohnsKycDocument();
    }

    /**
     * Gets registration data from Payline service 3DSecure.
     *
     * @param cardRegistration
     * @return Registration data.
     */
    protected String getPaylineCorrectRegistartionData3DSecure(CardRegistration cardRegistration) throws MalformedURLException, IOException, Exception {

        String data = "data=" + cardRegistration.getPreregistrationData() +
                "&accessKeyRef=" + cardRegistration.getAccessKey() +
                "&cardNumber=4970105191923460" +
                "&cardExpirationDate=1224" +
                "&cardCvx=123";

        URL url = new URL(cardRegistration.getCardRegistrationUrl());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
            wr.writeBytes(data);
            wr.flush();
        }

        int responseCode = connection.getResponseCode();
        InputStream is;
        if (responseCode != 200) {
            is = connection.getErrorStream();
        } else {
            is = connection.getInputStream();
        }

        StringBuffer resp;
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(is))) {
            String line;
            resp = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                resp.append(line);
            }
        }
        String responseString = resp.toString();

        if (responseCode == 200)
            return responseString;
        else
            throw new Exception(responseString);
    }

    /**
     * Gets registration data from Payline service.
     *
     * @param cardRegistration
     * @return Registration data.
     */
    protected String getPaylineCorrectRegistartionData(CardRegistration cardRegistration) throws MalformedURLException, IOException, Exception {

        String data = "data=" + cardRegistration.getPreregistrationData() +
                "&accessKeyRef=" + cardRegistration.getAccessKey() +
                "&cardNumber=4972485830400056" +
                "&cardExpirationDate=1224" +
                "&cardCvx=123";

        URL url = new URL(cardRegistration.getCardRegistrationUrl());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
            wr.writeBytes(data);
            wr.flush();
        }

        int responseCode = connection.getResponseCode();
        InputStream is;
        if (responseCode != 200) {
            is = connection.getErrorStream();
        } else {
            is = connection.getInputStream();
        }

        StringBuffer resp;
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(is))) {
            String line;
            resp = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                resp.append(line);
            }
        }
        String responseString = resp.toString();

        if (responseCode == 200)
            return responseString;
        else
            throw new Exception(responseString);
    }

    protected Hook getJohnsHook() throws Exception {
        if (BaseTest.JOHNS_HOOK == null) {

            Pagination pagination = new Pagination(1, 1);
            List<Hook> list = this.api.getHookApi().getAll(pagination, null);

            if (list != null && list.size() > 0 && list.get(0) != null) {
                BaseTest.JOHNS_HOOK = list.get(0);
            } else {
                Hook hook = new Hook();
                hook.setEventType(EventType.PAYIN_NORMAL_CREATED);
                hook.setUrl("http://test.com");
                BaseTest.JOHNS_HOOK = this.api.getHookApi().create(hook);
            }
        }

        return BaseTest.JOHNS_HOOK;
    }

    protected ReportRequest getJohnsReport() throws Exception {
        if (BaseTest.JOHNS_REPORT == null) {
            ReportRequest reportPost = new ReportRequest();
            reportPost.setReportType(ReportType.TRANSACTIONS);
            BaseTest.JOHNS_REPORT = this.api.getReportApi().create(reportPost);
        }

        return BaseTest.JOHNS_REPORT;
    }

    protected ReportRequest getNewJohnsReport() throws Exception {
        ReportRequest reportPost = new ReportRequest();
        reportPost.setReportType(ReportType.TRANSACTIONS);
        BaseTest.JOHNS_REPORT = this.api.getReportApi().create(reportPost);

        return BaseTest.JOHNS_REPORT;
    }

    protected BankingAlias getJohnsBankingAlias() throws Exception {
        if (BaseTest.JOHNS_BANKING_ALIAS == null) {
            BankingAlias bankingAlias = new BankingAlias();
            bankingAlias.setOwnerName(getJohn().getFirstName() + " " + getJohn().getLastName());
            bankingAlias.setCountry(CountryIso.FR);
            BaseTest.JOHNS_BANKING_ALIAS = api.getBankingAliases().create(getJohnsWallet().getId(), bankingAlias);
        }
        return BaseTest.JOHNS_BANKING_ALIAS;
    }

    protected BankingAlias getNewJohnsBankingAlias() throws Exception {
        BankingAlias bankingAlias = new BankingAlias();
        bankingAlias.setOwnerName(getJohn().getFirstName() + " " + getJohn().getLastName());
        bankingAlias.setCountry(CountryIso.FR);
        BaseTest.JOHNS_BANKING_ALIAS = api.getBankingAliases().create(getJohnsWallet().getId(), bankingAlias);
        return BaseTest.JOHNS_BANKING_ALIAS;
    }

    protected UboDeclaration getMatrixUboDeclaration() throws Exception {
        if (MATRIX_UBO_DECLARATION == null) {
            MATRIX_UBO_DECLARATION = api.getUboDeclarationApi().create(this.getMatrix().getId());
        }
        return MATRIX_UBO_DECLARATION;
    }

    protected Ubo createNewUboForMatrix() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1975, 12, 21, 0, 0, 0);

        Ubo ubo = new Ubo();
        ubo.setFirstName("First");
        ubo.setLastName("Last");
        ubo.setAddress(this.getNewAddress());
        ubo.setNationality(CountryIso.FR);
        ubo.setBirthday(calendar.getTimeInMillis() / 1000);
        ubo.setBirthplace(new Birthplace("City", CountryIso.FR));
        return ubo;
    }

    protected Ubo getMatrixUbo() throws Exception {
        if (MATRIX_UBO == null) {
            UserLegal matrix = this.getMatrix();
            UboDeclaration uboDeclaration = this.getMatrixUboDeclaration();

            Ubo ubo = this.createNewUboForMatrix();
            MATRIX_UBO = api.getUboDeclarationApi().createUbo(matrix.getId(), uboDeclaration.getId(), ubo);
        }
        return MATRIX_UBO;
    }

    protected BankAccount getClientBankAccount() throws Exception {
        BankAccount bankAccountIBAN = new BankAccount();
        BankAccountDetailsIBAN detailsIBAN = new BankAccountDetailsIBAN();
        detailsIBAN.setIban("FR7630004000031234567890143");
        detailsIBAN.setBic("BNPAFRPP");

        Address address = new Address();
        address.setCity("Paris");
        address.setRegion("Ile de France");
        address.setAddressLine1("1 Mangopay Street");
        address.setAddressLine2("The Loop");
        address.setCountry(CountryIso.FR);
        address.setPostalCode("75001");

        bankAccountIBAN.setOwnerName("Joe Blogs");
        bankAccountIBAN.setOwnerAddress(address);
        bankAccountIBAN.setTag("custom meta");
        bankAccountIBAN.setDetails(detailsIBAN);
        bankAccountIBAN.setType(BankAccountType.IBAN);

        return this.api.getClientApi().createBankAccountIBAN(bankAccountIBAN);
    }

    protected <T> void assertEqualInputProps(T entity1, T entity2) throws Exception {

        if (entity1 instanceof UserNatural) {
            assertEquals(((UserNatural) entity1).getTag(), ((UserNatural) entity2).getTag());
            assertEquals(((UserNatural) entity1).getPersonType(), ((UserNatural) entity2).getPersonType());
            assertEquals(((UserNatural) entity1).getFirstName(), ((UserNatural) entity2).getFirstName());
            assertEquals(((UserNatural) entity1).getLastName(), ((UserNatural) entity2).getLastName());
            assertEquals(((UserNatural) entity1).getEmail(), ((UserNatural) entity2).getEmail());

            if (((UserNatural) entity1).getAddress() == null) {
                assertNull(((UserNatural) entity2).getAddress());
            } else {
                assertNotNull(((UserNatural) entity2).getAddress());
                assertEquals(((UserNatural) entity1).getAddress().getAddressLine1(), ((UserNatural) entity2).getAddress().getAddressLine1());
                assertEquals(((UserNatural) entity1).getAddress().getAddressLine2(), ((UserNatural) entity2).getAddress().getAddressLine2());
                assertEquals(((UserNatural) entity1).getAddress().getCity(), ((UserNatural) entity2).getAddress().getCity());
                assertEquals(((UserNatural) entity1).getAddress().getCountry(), ((UserNatural) entity2).getAddress().getCountry());
                assertEquals(((UserNatural) entity1).getAddress().getPostalCode(), ((UserNatural) entity2).getAddress().getPostalCode());
                assertEquals(((UserNatural) entity1).getAddress().getRegion(), ((UserNatural) entity2).getAddress().getRegion());
            }

            assertEquals(((UserNatural) entity1).getBirthday(), ((UserNatural) entity2).getBirthday());
            assertEquals(((UserNatural) entity1).getNationality(), ((UserNatural) entity2).getNationality());
            assertEquals(((UserNatural) entity1).getCountryOfResidence(), ((UserNatural) entity2).getCountryOfResidence());
            assertEquals(((UserNatural) entity1).getOccupation(), ((UserNatural) entity2).getOccupation());
            assertEquals(((UserNatural) entity1).getIncomeRange(), ((UserNatural) entity2).getIncomeRange());

        } else if (entity1 instanceof UserLegal) {
            assertEquals(((UserLegal) entity1).getTag(), ((UserLegal) entity2).getTag());
            assertEquals(((UserLegal) entity1).getPersonType(), ((UserLegal) entity2).getPersonType());
            assertEquals(((UserLegal) entity1).getName(), ((UserLegal) entity2).getName());
            assertNotNull(((UserLegal) entity1).getHeadquartersAddress());
            assertNotNull(((UserLegal) entity2).getHeadquartersAddress());
            assertEquals(((UserLegal) entity1).getHeadquartersAddress().getAddressLine1(), ((UserLegal) entity2).getHeadquartersAddress().getAddressLine1());
            assertEquals(((UserLegal) entity1).getHeadquartersAddress().getAddressLine2(), ((UserLegal) entity2).getHeadquartersAddress().getAddressLine2());
            assertEquals(((UserLegal) entity1).getHeadquartersAddress().getCity(), ((UserLegal) entity2).getHeadquartersAddress().getCity());
            assertEquals(((UserLegal) entity1).getHeadquartersAddress().getCountry(), ((UserLegal) entity2).getHeadquartersAddress().getCountry());
            assertEquals(((UserLegal) entity1).getHeadquartersAddress().getPostalCode(), ((UserLegal) entity2).getHeadquartersAddress().getPostalCode());
            assertEquals(((UserLegal) entity1).getHeadquartersAddress().getRegion(), ((UserLegal) entity2).getHeadquartersAddress().getRegion());

            assertEquals(((UserLegal) entity1).getLegalRepresentativeFirstName(), ((UserLegal) entity2).getLegalRepresentativeFirstName());
            assertEquals(((UserLegal) entity1).getLegalRepresentativeLastName(), ((UserLegal) entity2).getLegalRepresentativeLastName());
            //assertEquals("***** TEMPORARY API ISSUE: RETURNED OBJECT MISSES THIS PROP AFTER CREATION *****", ((UserLegal)entity1).LegalRepresentativeAddress, ((UserLegal)entity2).LegalRepresentativeAddress);
            assertEquals(((UserLegal) entity1).getLegalRepresentativeEmail(), ((UserLegal) entity2).getLegalRepresentativeEmail());
            //assertEquals("***** TEMPORARY API ISSUE: RETURNED OBJECT HAS THIS PROP CHANGED FROM TIMESTAMP INTO ISO STRING AFTER CREATION *****", ((UserLegal)entity1).LegalRepresentativeBirthday, ((UserLegal)entity2).LegalRepresentativeBirthday);
            assertEquals(((UserLegal) entity1).getLegalRepresentativeBirthday(), ((UserLegal) entity2).getLegalRepresentativeBirthday());
            assertEquals(((UserLegal) entity1).getLegalRepresentativeNationality(), ((UserLegal) entity2).getLegalRepresentativeNationality());
            assertEquals(((UserLegal) entity1).getLegalRepresentativeCountryOfResidence(), ((UserLegal) entity2).getLegalRepresentativeCountryOfResidence());

        } else if (entity1 instanceof BankAccount) {
            assertEquals(((BankAccount) entity1).getTag(), ((BankAccount) entity2).getTag());
            assertEquals(((BankAccount) entity1).getUserId(), ((BankAccount) entity2).getUserId());
            assertEquals(((BankAccount) entity1).getType(), ((BankAccount) entity2).getType());
            assertEquals(((BankAccount) entity1).getOwnerName(), ((BankAccount) entity2).getOwnerName());
            assertNotNull(((BankAccount) entity1).getOwnerAddress());
            assertNotNull(((BankAccount) entity2).getOwnerAddress());
            assertEquals(((BankAccount) entity1).getOwnerAddress().getAddressLine1(), ((BankAccount) entity2).getOwnerAddress().getAddressLine1());
            assertEquals(((BankAccount) entity1).getOwnerAddress().getAddressLine2(), ((BankAccount) entity2).getOwnerAddress().getAddressLine2());
            assertEquals(((BankAccount) entity1).getOwnerAddress().getCity(), ((BankAccount) entity2).getOwnerAddress().getCity());
            assertEquals(((BankAccount) entity1).getOwnerAddress().getCountry(), ((BankAccount) entity2).getOwnerAddress().getCountry());
            assertEquals(((BankAccount) entity1).getOwnerAddress().getPostalCode(), ((BankAccount) entity2).getOwnerAddress().getPostalCode());
            assertEquals(((BankAccount) entity1).getOwnerAddress().getRegion(), ((BankAccount) entity2).getOwnerAddress().getRegion());


            if (((BankAccount) entity1).getType() == BankAccountType.IBAN) {
                assertEquals(((BankAccountDetailsIBAN) ((BankAccount) entity1).getDetails()).getIban(), ((BankAccountDetailsIBAN) ((BankAccount) entity2).getDetails()).getIban());
                assertEquals(((BankAccountDetailsIBAN) ((BankAccount) entity1).getDetails()).getBic(), ((BankAccountDetailsIBAN) ((BankAccount) entity2).getDetails()).getBic());
            } else if (((BankAccount) entity1).getType() == BankAccountType.GB) {
                assertEquals(((BankAccountDetailsGB) ((BankAccount) entity1).getDetails()).getAccountNumber(), ((BankAccountDetailsGB) ((BankAccount) entity2).getDetails()).getAccountNumber());
                assertEquals(((BankAccountDetailsGB) ((BankAccount) entity1).getDetails()).getSortCode(), ((BankAccountDetailsGB) ((BankAccount) entity2).getDetails()).getSortCode());
            } else if (((BankAccount) entity1).getType() == BankAccountType.US) {
                assertEquals(((BankAccountDetailsUS) ((BankAccount) entity1).getDetails()).getAccountNumber(), ((BankAccountDetailsUS) ((BankAccount) entity2).getDetails()).getAccountNumber());
                assertEquals(((BankAccountDetailsUS) ((BankAccount) entity1).getDetails()).getAba(), ((BankAccountDetailsUS) ((BankAccount) entity2).getDetails()).getAba());
            } else if (((BankAccount) entity1).getType() == BankAccountType.CA) {
                assertEquals(((BankAccountDetailsCA) ((BankAccount) entity1).getDetails()).getAccountNumber(), ((BankAccountDetailsCA) ((BankAccount) entity2).getDetails()).getAccountNumber());
                assertEquals(((BankAccountDetailsCA) ((BankAccount) entity1).getDetails()).getBankName(), ((BankAccountDetailsCA) ((BankAccount) entity2).getDetails()).getBankName());
                assertEquals(((BankAccountDetailsCA) ((BankAccount) entity1).getDetails()).getInstitutionNumber(), ((BankAccountDetailsCA) ((BankAccount) entity2).getDetails()).getInstitutionNumber());
                assertEquals(((BankAccountDetailsCA) ((BankAccount) entity1).getDetails()).getBranchCode(), ((BankAccountDetailsCA) ((BankAccount) entity2).getDetails()).getBranchCode());
            } else if (((BankAccount) entity1).getType() == BankAccountType.OTHER) {
                assertEquals(((BankAccountDetailsOTHER) ((BankAccount) entity1).getDetails()).getAccountNumber(), ((BankAccountDetailsOTHER) ((BankAccount) entity2).getDetails()).getAccountNumber());
                //assertEquals(((BankAccountDetailsOTHER)((BankAccount)entity1).getDetails()).Type, ((BankAccountDetailsOTHER)((BankAccount)entity2).getDetails()).Type);
                assertEquals(((BankAccountDetailsOTHER) ((BankAccount) entity1).getDetails()).getCountry(), ((BankAccountDetailsOTHER) ((BankAccount) entity2).getDetails()).getCountry());
                assertEquals(((BankAccountDetailsOTHER) ((BankAccount) entity1).getDetails()).getBic(), ((BankAccountDetailsOTHER) ((BankAccount) entity2).getDetails()).getBic());
            }

        } else if (entity1 instanceof PayIn) {
            assertEquals(((PayIn) entity1).getTag(), ((PayIn) entity2).getTag());
            assertEquals(((PayIn) entity1).getAuthorId(), ((PayIn) entity2).getAuthorId());
            assertEquals(((PayIn) entity1).getCreditedUserId(), ((PayIn) entity2).getCreditedUserId());

            assertEqualInputProps(((PayIn) entity1).getDebitedFunds(), ((PayIn) entity2).getDebitedFunds());
            if (((PayIn) entity1).getCreditedFunds() != null && ((PayIn) entity2).getCreditedFunds() != null) {
                assertEqualInputProps(((PayIn) entity1).getCreditedFunds(), ((PayIn) entity2).getCreditedFunds());
            }
            assertEqualInputProps(((PayIn) entity1).getFees(), ((PayIn) entity2).getFees());

        } else if (entity1 instanceof Card) {
            assertEquals(((Card) entity1).getExpirationDate(), ((Card) entity2).getExpirationDate());
            assertEquals(((Card) entity1).getAlias(), ((Card) entity2).getAlias());
            assertEquals(((Card) entity1).getCardType(), ((Card) entity2).getCardType());
            assertEquals(((Card) entity1).getCurrency(), ((Card) entity2).getCurrency());

        } else if (entity1 instanceof PayInPaymentDetailsCard) {
            assertEquals(((PayInPaymentDetailsCard) entity1).getCardType(), ((PayInPaymentDetailsCard) entity2).getCardType());

        } else if (entity1 instanceof PayInExecutionDetailsWeb) {
            assertEquals(((PayInExecutionDetailsWeb) entity1).getTemplateUrl(), ((PayInExecutionDetailsWeb) entity2).getTemplateUrl());
            assertEquals(((PayInExecutionDetailsWeb) entity1).getCulture(), ((PayInExecutionDetailsWeb) entity2).getCulture());
            assertEquals(((PayInExecutionDetailsWeb) entity1).getSecureMode(), ((PayInExecutionDetailsWeb) entity2).getSecureMode());
            assertEquals(((PayInExecutionDetailsWeb) entity1).getRedirectUrl(), ((PayInExecutionDetailsWeb) entity2).getRedirectUrl());
            assertEquals(((PayInExecutionDetailsWeb) entity1).getReturnUrl(), ((PayInExecutionDetailsWeb) entity2).getReturnUrl());

        } else if (entity1 instanceof PayInPaymentDetailsPayPal) {
            PayInPaymentDetailsPayPal payPalDetails1 = (PayInPaymentDetailsPayPal) entity1;
            PayInPaymentDetailsPayPal payPalDetails2 = (PayInPaymentDetailsPayPal) entity2;
            assertEqualInputProps(payPalDetails1.getShippingAddress(), payPalDetails2.getShippingAddress());
        } else if (entity1 instanceof ShippingAddress) {
            ShippingAddress address1 = (ShippingAddress) entity1;
            ShippingAddress address2 = (ShippingAddress) entity2;
            assertEquals(address1.getRecipientName(), address2.getRecipientName());
            assertEqualInputProps(address1.getAddress(), address2.getAddress());
        } else if (entity1 instanceof Address) {
            Address address1 = (Address) entity1;
            Address address2 = (Address) entity2;
            assertEquals(address1.getAddressLine1(), address2.getAddressLine1());
            assertEquals(address1.getAddressLine2(), address2.getAddressLine2());
            assertEquals(address1.getCity(), address2.getCity());
            assertEquals(address1.getRegion(), address2.getRegion());
            assertEquals(address1.getPostalCode(), address2.getPostalCode());
            assertEquals(address1.getCountry(), address2.getCountry());
        } else if (entity1 instanceof PayOut) {
            assertEquals(((PayOut) entity1).getTag(), ((PayOut) entity2).getTag());
            assertEquals(((PayOut) entity1).getAuthorId(), ((PayOut) entity2).getAuthorId());
            assertEquals(((PayOut) entity1).getCreditedUserId(), ((PayOut) entity2).getCreditedUserId());

            assertEqualInputProps(((PayOut) entity1).getDebitedFunds(), ((PayOut) entity2).getDebitedFunds());
            assertEqualInputProps(((PayOut) entity1).getCreditedFunds(), ((PayOut) entity2).getCreditedFunds());
            assertEqualInputProps(((PayOut) entity1).getFees(), ((PayOut) entity2).getFees());
            assertEqualInputProps(((PayOut) entity1).getMeanOfPaymentDetails(), ((PayOut) entity2).getMeanOfPaymentDetails());

        } else if (entity1 instanceof Transfer) {
            assertEquals(((Transfer) entity1).getTag(), ((Transfer) entity2).getTag());
            assertEquals(((Transfer) entity1).getAuthorId(), ((Transfer) entity2).getAuthorId());
            assertEquals(((Transfer) entity1).getCreditedUserId(), ((Transfer) entity2).getCreditedUserId());

            assertEqualInputProps(((Transfer) entity1).getDebitedFunds(), ((Transfer) entity2).getDebitedFunds());
            assertEqualInputProps(((Transfer) entity1).getCreditedFunds(), ((Transfer) entity2).getCreditedFunds());
            assertEqualInputProps(((Transfer) entity1).getFees(), ((Transfer) entity2).getFees());

        } else if (entity1 instanceof PayOutPaymentDetailsBankWire) {
            assertEquals(((PayOutPaymentDetailsBankWire) entity1).getBankAccountId(), ((PayOutPaymentDetailsBankWire) entity2).getBankAccountId());

        } else if (entity1 instanceof Transaction) {
            assertEquals(((Transaction) entity1).getTag(), ((Transaction) entity2).getTag());

            assertEqualInputProps(((Transaction) entity1).getDebitedFunds(), ((Transaction) entity2).getDebitedFunds());
            assertEqualInputProps(((Transaction) entity1).getFees(), ((Transaction) entity2).getFees());
            assertEqualInputProps(((Transaction) entity1).getCreditedFunds(), ((Transaction) entity2).getCreditedFunds());

            assertEquals(((Transaction) entity1).getStatus(), ((Transaction) entity2).getStatus());

        } else if (entity1 instanceof Money) {
            assertEquals(((Money) entity1).getCurrency(), ((Money) entity2).getCurrency());
            assertEquals(((Money) entity1).getAmount(), ((Money) entity2).getAmount());
        } else if (entity1 instanceof KycDocument) {
            assertEquals(((KycDocument) entity1).getType(), ((KycDocument) entity2).getType());
            //same as getKycDocument
            //assertEquals(((KycDocument) entity1).getStatus(), ((KycDocument) entity2).getStatus());
            assertEquals(((KycDocument) entity1).getUserId(), ((KycDocument) entity2).getUserId());
        } else {
            throw new Exception("Unsupported type");
        }

    }

}
