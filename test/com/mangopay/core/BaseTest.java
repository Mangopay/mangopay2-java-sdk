package com.mangopay.core;

import com.mangopay.*;
import com.mangopay.entities.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import static org.junit.Assert.*;

@Ignore("Just a base class for tests: nothing to test here")
public abstract class BaseTest {
    
    protected MangoPayApi _api;

    public static UserNatural John;

    public static UserLegal Matrix;

    public static BankAccount JohnsAccount;

    public static Wallet JohnsWallet;
    
    public static PayIn JohnsPayInCardWeb;
    
    public static PayInPaymentDetailsCard PayInPaymentDetailsCard;
    
    public static PayInExecutionDetailsWeb PayInExecutionDetailsWeb;

    public static PayOut JohnsPayOutBankWire;
    
    public static Transfer JohnsTransfer;
    
    public BaseTest() {
        this._api = buildNewMangoPayApi();
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
    
    protected MangoPayApi buildNewMangoPayApi() {
        MangoPayApi api = new MangoPayApi();
        // use test client credentails
        api.Config.ClientId = "example";
        api.Config.ClientPassword = "uyWsmnwMQyTnqKgi8Y35A3eVB7bGhqrebYqA1tL6x2vYNpGPiY";
        return api;
    }
    
    protected UserNatural getJohn() throws Exception {
        if (BaseTest.John == null) {
            Calendar c = Calendar.getInstance();
            c.set(1975, 12, 21, 0, 0, 0);
            
            UserNatural user = new UserNatural();
            user.FirstName = "John";
            user.LastName = "Doe";
            user.Email = "john.doe@sample.org";
            user.Address = "Some Address";
            user.Birthday = c.getTimeInMillis() / 1000;
            user.Nationality = "FR";
            user.CountryOfResidence = "FR";
            user.Occupation = "programmer";
            user.IncomeRange = 3;
            //try {
                BaseTest.John = (UserNatural)this._api.Users.create(user);
            //} catch (Exception ex) {
            //    Logger.getLogger(BaseTest.class.getName()).log(Level.SEVERE, null, ex);
            //}
        }
        return BaseTest.John;
    }

    protected UserLegal getMatrix() throws Exception {
        if (BaseTest.Matrix == null) {
            UserNatural john = this.getJohn();
            UserLegal user = new UserLegal();
            user.Name = "MartixSampleOrg";
            user.LegalPersonType = "BUSINESS";
            user.HeadquartersAddress = "Some Address";
            user.LegalRepresentativeFirstName = john.FirstName;
            user.LegalRepresentativeLastName = john.LastName;
            user.LegalRepresentativeAddress = john.Address;
            user.LegalRepresentativeEmail = john.Email;
            user.LegalRepresentativeBirthday = john.Birthday;
            user.LegalRepresentativeNationality = john.Nationality;
            user.LegalRepresentativeCountryOfResidence = john.CountryOfResidence;
            //try {
                BaseTest.Matrix = (UserLegal)this._api.Users.create(user);
            //} catch (Exception ex) {
            //    Logger.getLogger(BaseTest.class.getName()).log(Level.SEVERE, null, ex);
            //}
        }
        return BaseTest.Matrix;
    }

    protected BankAccount getJohnsAccount() throws Exception {
        if (BaseTest.JohnsAccount == null) {
            UserNatural john = this.getJohn();
            BankAccount account = new BankAccount();
            account.Type = "IBAN";
            account.OwnerName = john.FirstName + " " + john.LastName;
            account.OwnerAddress = john.Address;
            account.IBAN = "AD12 0001 2030 2003 5910 0100";
            account.BIC = "BINAADADXXX";
            BaseTest.JohnsAccount = this._api.Users.createBankAccount(john.Id, account);
        }
        return BaseTest.JohnsAccount;
    }
    
    protected Wallet getJohnsWallet() throws Exception {
        if (BaseTest.JohnsWallet == null) {
            UserNatural john = this.getJohn();
            
            Wallet wallet = new Wallet();
            wallet.Owners = new ArrayList<>();
            wallet.Owners.add(john.Id);
            
            wallet.Currency = "EUR";
            wallet.Description = "WALLET IN EUR";
            
            BaseTest.JohnsWallet = this._api.Wallets.create(wallet);
        }
        
        return BaseTest.JohnsWallet;
    }
    
    private PayInPaymentDetailsCard getPayInPaymentDetailsCard() {
        if (BaseTest.PayInPaymentDetailsCard == null) {
            BaseTest.PayInPaymentDetailsCard = new PayInPaymentDetailsCard();
            BaseTest.PayInPaymentDetailsCard.CardType = "AMEX";
            BaseTest.PayInPaymentDetailsCard.ReturnURL = "https://test.com";
        }
        
        return BaseTest.PayInPaymentDetailsCard;
    }
    
    private PayInExecutionDetailsWeb getPayInExecutionDetailsWeb() {
        if (BaseTest.PayInExecutionDetailsWeb == null) {
            BaseTest.PayInExecutionDetailsWeb = new PayInExecutionDetailsWeb();
            BaseTest.PayInExecutionDetailsWeb.TemplateURL = "https://TemplateURL.com";
            BaseTest.PayInExecutionDetailsWeb.SecureMode = "DEFAULT";
            BaseTest.PayInExecutionDetailsWeb.Culture = "fr";
        }
        
        return BaseTest.PayInExecutionDetailsWeb;
    }
    
    protected PayIn getJohnsPayInCardWeb() throws Exception {
        if (BaseTest.JohnsPayInCardWeb == null) {
            Wallet wallet = this.getJohnsWallet();
            UserNatural user = this.getJohn();
            
            PayIn payIn = new PayIn();
            payIn.AuthorId = user.Id;
            payIn.CreditedUserId = user.Id;
            payIn.DebitedFunds = new Money();
            payIn.DebitedFunds.Currency = "EUR";
            payIn.DebitedFunds.Amount = 1000.0;
            payIn.Fees = new Money();
            payIn.Fees.Currency = "EUR";
            payIn.Fees.Amount = 5.0;
            payIn.CreditedWalletId = wallet.Id;
            payIn.PaymentDetails = this.getPayInPaymentDetailsCard();
            payIn.ExecutionDetails = this.getPayInExecutionDetailsWeb();
            
            BaseTest.JohnsPayInCardWeb = this._api.PayIns.create(payIn);
        }
        
        return BaseTest.JohnsPayInCardWeb;
    }
    
    protected PayOut getJohnsPayOutBankWire() throws Exception {
        if (BaseTest.JohnsPayOutBankWire == null) {
            Wallet wallet = this.getJohnsWallet();
            UserNatural user = this.getJohn();
            BankAccount account = this.getJohnsAccount();
            
            PayOut payOut = new PayOut();
            payOut.Tag = "DefaultTag";
            payOut.AuthorId = user.Id;
            payOut.CreditedUserId = user.Id;
            payOut.DebitedFunds = new Money();
            payOut.DebitedFunds.Currency = "EUR";
            payOut.DebitedFunds.Amount = 10.0;
            payOut.Fees = new Money();
            payOut.Fees.Currency = "EUR";
            payOut.Fees.Amount = 5.0;
            
            payOut.DebitedWalletId = wallet.Id;
            payOut.MeanOfPaymentDetails = new PayOutPaymentDetailsBankWire();
            ((PayOutPaymentDetailsBankWire)payOut.MeanOfPaymentDetails).BankAccountId = account.Id;
            ((PayOutPaymentDetailsBankWire)payOut.MeanOfPaymentDetails).Communication = "Communication text";
            
            //try {
                BaseTest.JohnsPayOutBankWire = this._api.PayOuts.create(payOut);
            //} catch (Exception ex) {
            //    Logger.getLogger(BaseTest.class.getName()).log(Level.SEVERE, null, ex);
            //}
        }
        
        return BaseTest.JohnsPayOutBankWire;
    }
    
    protected Transfer getJohnsTransfer() throws Exception {
        if (BaseTest.JohnsTransfer == null) {
            Wallet wallet = this.getJohnsWallet();
            UserNatural user = this.getJohn();
            
            Transfer transfer = new Transfer();
            transfer.Tag = "DefaultTag";
            transfer.AuthorId = user.Id;
            transfer.CreditedUserId = user.Id;
            transfer.DebitedFunds = new Money();
            transfer.DebitedFunds.Currency = "EUR";
            transfer.DebitedFunds.Amount = 100.0;
            transfer.Fees = new Money();
            transfer.Fees.Currency = "EUR";
            transfer.Fees.Amount = 10.0;

            transfer.DebitedWalletId = wallet.Id;
            transfer.CreditedWalletId = wallet.Id;

            BaseTest.JohnsTransfer = this._api.Transfers.create(transfer);
        }
        
        return BaseTest.JohnsTransfer;
    }
    
    protected <T> void assertEqualInputProps(T entity1, T entity2) throws Exception {

        if (entity1 instanceof UserNatural) {
            assertEquals(((UserNatural)entity1).Tag, ((UserNatural)entity2).Tag);
            assertEquals(((UserNatural)entity1).PersonType, ((UserNatural)entity2).PersonType);
            assertEquals(((UserNatural)entity1).FirstName, ((UserNatural)entity2).FirstName);
            assertEquals(((UserNatural)entity1).LastName, ((UserNatural)entity2).LastName);
            assertEquals(((UserNatural)entity1).Email, ((UserNatural)entity2).Email);
            assertEquals(((UserNatural)entity1).Address, ((UserNatural)entity2).Address);
            assertEquals(((UserNatural)entity1).Birthday, ((UserNatural)entity2).Birthday);
            assertEquals(((UserNatural)entity1).Nationality, ((UserNatural)entity2).Nationality);
            assertEquals(((UserNatural)entity1).CountryOfResidence, ((UserNatural)entity2).CountryOfResidence);
            assertEquals(((UserNatural)entity1).Occupation, ((UserNatural)entity2).Occupation);
            assertEquals(((UserNatural)entity1).IncomeRange, ((UserNatural)entity2).IncomeRange);

        } else if (entity1 instanceof UserLegal) {
            assertEquals(((UserLegal)entity1).Tag, ((UserLegal)entity2).Tag);
            assertEquals(((UserLegal)entity1).PersonType, ((UserLegal)entity2).PersonType);
            assertEquals(((UserLegal)entity1).Name, ((UserLegal)entity2).Name);
            assertEquals(((UserLegal)entity1).HeadquartersAddress, ((UserLegal)entity2).HeadquartersAddress);
            assertEquals(((UserLegal)entity1).LegalRepresentativeFirstName, ((UserLegal)entity2).LegalRepresentativeFirstName);
            assertEquals(((UserLegal)entity1).LegalRepresentativeLastName, ((UserLegal)entity2).LegalRepresentativeLastName);
            assertEquals("***** TEMPORARY API ISSUE: RETURNED OBJECT MISSES THIS PROP AFTER CREATION *****", ((UserLegal)entity1).LegalRepresentativeAddress, ((UserLegal)entity2).LegalRepresentativeAddress);
            assertEquals(((UserLegal)entity1).LegalRepresentativeEmail, ((UserLegal)entity2).LegalRepresentativeEmail);
            assertEquals("***** TEMPORARY API ISSUE: RETURNED OBJECT HAS THIS PROP CHANGED FROM TIMESTAMP INTO ISO STRING AFTER CREATION *****", ((UserLegal)entity1).LegalRepresentativeBirthday, ((UserLegal)entity2).LegalRepresentativeBirthday);
            assertEquals(((UserLegal)entity1).LegalRepresentativeNationality, ((UserLegal)entity2).LegalRepresentativeNationality);
            assertEquals(((UserLegal)entity1).LegalRepresentativeCountryOfResidence, ((UserLegal)entity2).LegalRepresentativeCountryOfResidence);

        } else if (entity1 instanceof BankAccount) {
            assertEquals(((BankAccount)entity1).Tag, ((BankAccount)entity2).Tag);
            assertEquals(((BankAccount)entity1).UserId, ((BankAccount)entity2).UserId);
            assertEquals(((BankAccount)entity1).Type, ((BankAccount)entity2).Type);
            assertEquals(((BankAccount)entity1).OwnerName, ((BankAccount)entity2).OwnerName);
            assertEquals(((BankAccount)entity1).OwnerAddress, ((BankAccount)entity2).OwnerAddress);
            assertEquals(((BankAccount)entity1).IBAN, ((BankAccount)entity2).IBAN);
            assertEquals(((BankAccount)entity1).BIC, ((BankAccount)entity2).BIC);
            
        } else if (entity1 instanceof PayIn) {
            assertEquals(((PayIn)entity1).Tag, ((PayIn)entity2).Tag);
            assertEquals(((PayIn)entity1).AuthorId, ((PayIn)entity2).AuthorId);
            assertEquals(((PayIn)entity1).CreditedUserId, ((PayIn)entity2).CreditedUserId);
            
            assertEqualInputProps(((PayIn)entity1).DebitedFunds, ((PayIn)entity2).DebitedFunds);
            assertEqualInputProps(((PayIn)entity1).CreditedFunds, ((PayIn)entity2).CreditedFunds);
            assertEqualInputProps(((PayIn)entity1).Fees, ((PayIn)entity2).Fees);
            
        } else if (entity1 instanceof PayInPaymentDetailsCard) {
            assertEquals(((PayInPaymentDetailsCard)entity1).CardType, ((PayInPaymentDetailsCard)entity2).CardType);
            assertEquals(((PayInPaymentDetailsCard)entity1).RedirectURL, ((PayInPaymentDetailsCard)entity2).RedirectURL);
            assertEquals(((PayInPaymentDetailsCard)entity1).ReturnURL, ((PayInPaymentDetailsCard)entity2).ReturnURL);
            
        } else if (entity1 instanceof PayInExecutionDetailsWeb) {
            assertEquals(((PayInExecutionDetailsWeb)entity1).TemplateURL, ((PayInExecutionDetailsWeb)entity2).TemplateURL);
            assertEquals(((PayInExecutionDetailsWeb)entity1).Culture, ((PayInExecutionDetailsWeb)entity2).Culture);
            assertEquals(((PayInExecutionDetailsWeb)entity1).SecureMode, ((PayInExecutionDetailsWeb)entity2).SecureMode);
            
        } else if (entity1 instanceof PayOut) {
            assertEquals(((PayOut)entity1).Tag, ((PayOut)entity2).Tag);
            assertEquals(((PayOut)entity1).AuthorId, ((PayOut)entity2).AuthorId);
            assertEquals(((PayOut)entity1).CreditedUserId, ((PayOut)entity2).CreditedUserId);
            
            assertEqualInputProps(((PayOut)entity1).DebitedFunds, ((PayOut)entity2).DebitedFunds);
            assertEqualInputProps(((PayOut)entity1).CreditedFunds, ((PayOut)entity2).CreditedFunds);
            assertEqualInputProps(((PayOut)entity1).Fees, ((PayOut)entity2).Fees);
            assertEqualInputProps(((PayOut)entity1).MeanOfPaymentDetails, ((PayOut)entity2).MeanOfPaymentDetails);
            
        } else if (entity1 instanceof Transfer) {
            assertEquals(((Transfer)entity1).Tag, ((Transfer)entity2).Tag);
            assertEquals(((Transfer)entity1).AuthorId, ((Transfer)entity2).AuthorId);
            assertEquals(((Transfer)entity1).CreditedUserId, ((Transfer)entity2).CreditedUserId);
            
            assertEqualInputProps(((Transfer)entity1).DebitedFunds, ((Transfer)entity2).DebitedFunds);
            assertEqualInputProps(((Transfer)entity1).CreditedFunds, ((Transfer)entity2).CreditedFunds);
            assertEqualInputProps(((Transfer)entity1).Fees, ((Transfer)entity2).Fees);
            
        } else if (entity1 instanceof PayOutPaymentDetailsBankWire) {
            assertEquals(((PayOutPaymentDetailsBankWire)entity1).BankAccountId, ((PayOutPaymentDetailsBankWire)entity2).BankAccountId);
            assertEquals(((PayOutPaymentDetailsBankWire)entity1).Communication, ((PayOutPaymentDetailsBankWire)entity2).Communication);
            
        } else if (entity1 instanceof Transaction) {
            assertEquals(((Transaction)entity1).Tag, ((Transaction)entity2).Tag);
            
            assertEqualInputProps(((Transaction)entity1).DebitedFunds, ((Transaction)entity2).DebitedFunds);
            assertEqualInputProps(((Transaction)entity1).Fees, ((Transaction)entity2).Fees);
            assertEqualInputProps(((Transaction)entity1).CreditedFunds, ((Transaction)entity2).CreditedFunds);
            
            assertEquals(((Transaction)entity1).Status, ((Transaction)entity2).Status);

        } else if (entity1 instanceof Money) {
            assertEquals(((Money)entity1).Currency, ((Money)entity2).Currency);
            assertEquals(((Money)entity1).Amount, ((Money)entity2).Amount);
        } else {
            throw new Exception("Unsupported type");
        }
        
    }
    
}
