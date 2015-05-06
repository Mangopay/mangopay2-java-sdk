package com.mangopay.core;

import com.mangopay.entities.subentities.BankAccountDetailsOTHER;
import com.mangopay.entities.subentities.BankAccountDetailsGB;
import com.mangopay.entities.subentities.BankAccountDetailsCA;
import com.mangopay.entities.subentities.BankAccountDetailsUS;
import com.mangopay.entities.subentities.PayInPaymentDetailsCard;
import com.mangopay.core.enumerations.*;
import com.mangopay.entities.*;
import java.net.URL;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ApiUsers test methods
 */
public class ApiUsersTest extends BaseTest {
    
    @Test
    public void test_Users_CreateNatural() throws Exception {
        UserNatural john = this.getJohn();
        assertTrue(john.Id.length() > 0);
        assertTrue(john.PersonType.equals(PersonType.NATURAL));
    }

    @Test
    public void test_Users_CreateLegal() throws Exception {
        UserLegal matrix = this.getMatrix();
        assertTrue(matrix.Id.length() > 0);
        assertTrue(matrix.PersonType.equals(PersonType.LEGAL));
    }

    @Test
    public void test_Users_CreateLegal_FailsIfRequiredPropsNotProvided() throws Exception {
        UserLegal user = new UserLegal();
        
        User ret = null;
        
        try {
            ret = this._api.Users.create(user);
            
            Assert.fail("CreateLegal() should throw an exception when required props are not provided");
        } catch (ResponseException ex) {
            assertNull(ret);
        }
    }

    @Test
    public void test_Users_CreateLegal_PassesIfRequiredPropsProvided() throws Exception {
        UserLegal user = new UserLegal();
        user.Name = "SomeOtherSampleOrg";
        user.LegalPersonType = LegalPersonType.BUSINESS;
        user.LegalRepresentativeFirstName = "RepFName";
        user.LegalRepresentativeLastName = "RepLName";
        Calendar c = Calendar.getInstance();
        c.set(1975, 12, 21, 0, 0, 0);
        user.LegalRepresentativeBirthday = c.getTimeInMillis() / 1000;
        user.LegalRepresentativeNationality = CountryIso.FR;
        user.LegalRepresentativeCountryOfResidence = CountryIso.FR;
        user.Email = "email@email.org";
        
        User ret = null;
        
        ret = this._api.Users.create(user);
        
        assertTrue("Created successfully after required props set", ret.Id.length() > 0);
        
        assertEqualInputProps(user, ret);
    }
    
    @Test
    public void test_Users_GetAll() throws Exception {
        Sorting sort = new Sorting();
        sort.addField("CreationDate", SortDirection.desc);
        List<User> users = this._api.Users.getAll(null, sort);
        
        assertTrue(users.get(0).CreationDate > users.get(users.size() - 1).CreationDate);
        
        sort = new Sorting();
        sort.addField("CreationDate", SortDirection.asc);
        users = this._api.Users.getAll(null, sort);
        
        assertTrue(users.get(0).CreationDate < users.get(users.size() - 1).CreationDate);
    }

    @Test
    public void test_Users_GetNatural() throws Exception {
        UserNatural john = this.getJohn();

        User user1 = this._api.Users.get(john.Id);
        UserNatural user2 = this._api.Users.getNatural(john.Id);

        assertTrue(user1.PersonType.equals(PersonType.NATURAL));
        assertTrue(user1.Id.equals(john.Id));
        assertTrue(user2.PersonType.equals(PersonType.NATURAL));
        assertTrue(user2.Id.equals(john.Id));
        
        assertEqualInputProps(user1, john);
    }

    @Test
    public void test_Users_GetNatural_FailsForLegalUser() throws Exception {
        UserLegal matrix = this.getMatrix();
        
        UserNatural user = null;
        try {
            user = this._api.Users.getNatural(matrix.Id);
            
            Assert.fail("GetUser() should throw an exception when called with legal user id");
        } catch (ResponseException ex) {
            assertNull(user);
        }
    }

    @Test
    public void test_Users_GetLegal_FailsForNaturalUser() throws Exception {
        UserNatural john = this.getJohn();
        
        User user = null;
        try {
            user = this._api.Users.getLegal(john.Id);
            
            Assert.fail("GetLegal() should throw an exception when called with natural user id");
        } catch (ResponseException ex) {
            assertNull(user);
        }
    }

    @Test
    public void test_Users_GetLegal() throws Exception {
        UserLegal matrix = this.getMatrix();

        User user1 = this._api.Users.get(matrix.Id);
        User user2 = this._api.Users.getLegal(matrix.Id);

        assertEqualInputProps((UserLegal)user1, matrix);
        assertEqualInputProps((UserLegal)user2, matrix);
    }

    @Test
    public void test_Users_Save_Natural() throws Exception {
        UserNatural john = this.getJohn();
        john.LastName += " - CHANGED";
        
        User userSaved = this._api.Users.update(john);
        User userFetched = this._api.Users.get(john.Id);
        
        assertEqualInputProps(john, userSaved);
        assertEqualInputProps(john, userFetched);
    }

    @Test
    public void test_Users_Save_Natural_NonASCII() throws Exception {
        UserNatural john = this.getJohn();
        john.LastName += " - CHANGED";
        
        User userSaved = this._api.Users.update(john);
        User userFetched = this._api.Users.get(john.Id);
        
        assertEqualInputProps(john, userSaved);
        assertEqualInputProps(john, userFetched);
    }

    @Test
    public void test_Users_Save_Legal() throws Exception {
        UserLegal matrix = this.getMatrix();
        matrix.LegalRepresentativeLastName += " - CHANGED";
        
        User userSaved = this._api.Users.update(matrix);
        User userFetched = this._api.Users.get(matrix.Id);
        
        assertEqualInputProps(userSaved, matrix);
        assertEqualInputProps(userFetched, matrix);
    }
    
    @Test
    public void test_Users_CreateBankAccount_IBAN() {
        try {
            UserNatural john = this.getJohn();
            BankAccount account = this.getJohnsAccount();
            
            assertTrue(account.Id.length() > 0);
            assertEquals(account.UserId, john.Id);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void test_Users_CreateBankAccount_GB() {
        try {
            UserNatural john = this.getJohn();
            BankAccount account = new BankAccount();
            account.OwnerName = john.FirstName + " " + john.LastName;
            account.OwnerAddress = john.Address;
            account.Details = new BankAccountDetailsGB();
            ((BankAccountDetailsGB)account.Details).AccountNumber = "18329068";
            ((BankAccountDetailsGB)account.Details).SortCode = "306541";
            
            BankAccount createAccount = this._api.Users.createBankAccount(john.Id, account);
            
            assertTrue(createAccount.Id.length() > 0);
            assertTrue(createAccount.UserId.equals(john.Id));
            assertTrue(createAccount.Type == BankAccountType.GB);
            assertTrue(((BankAccountDetailsGB)createAccount.Details).AccountNumber.equals("18329068"));
            assertTrue(((BankAccountDetailsGB)createAccount.Details).SortCode.equals("306541"));
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void test_Users_CreateBankAccount_US() {
        try {
            UserNatural john = this.getJohn();
            BankAccount account = new BankAccount();
            account.OwnerName = john.FirstName + " " + john.LastName;
            account.OwnerAddress = john.Address;
            account.Details = new BankAccountDetailsUS();
            ((BankAccountDetailsUS)account.Details).AccountNumber = "234234234234";
            ((BankAccountDetailsUS)account.Details).ABA = "234334789";
            
            BankAccount createAccount = this._api.Users.createBankAccount(john.Id, account);
            
            assertTrue(createAccount.Id.length() > 0);
            assertTrue(createAccount.UserId.equals(john.Id));
            assertTrue(createAccount.Type == BankAccountType.US);
            assertTrue(((BankAccountDetailsUS)createAccount.Details).AccountNumber.equals("234234234234"));
            assertTrue(((BankAccountDetailsUS)createAccount.Details).ABA.equals("234334789"));
            assertTrue(((BankAccountDetailsUS)createAccount.Details).DepositAccountType.equals(DepositAccountType.CHECKING));

            ((BankAccountDetailsUS)account.Details).DepositAccountType = DepositAccountType.SAVINGS;
            BankAccount createAccountSavings = this._api.Users.createBankAccount(john.Id, account);

            assertTrue(createAccountSavings.Id.length() > 0);
            assertTrue(createAccountSavings.UserId.equals(john.Id));
            assertTrue(createAccountSavings.Type == BankAccountType.US);
            assertTrue(((BankAccountDetailsUS)createAccountSavings.Details).AccountNumber.equals("234234234234"));
            assertTrue(((BankAccountDetailsUS)createAccountSavings.Details).ABA.equals("234334789"));
            assertTrue(((BankAccountDetailsUS)createAccountSavings.Details).DepositAccountType.equals(DepositAccountType.SAVINGS));
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void test_Users_CreateBankAccount_CA() {
        try {
            UserNatural john = this.getJohn();
            BankAccount account = new BankAccount();
            account.OwnerName = john.FirstName + " " + john.LastName;
            account.OwnerAddress = john.Address;
            account.Details = new BankAccountDetailsCA();
            ((BankAccountDetailsCA)account.Details).BankName = "TestBankName";
            ((BankAccountDetailsCA)account.Details).BranchCode = "12345";
            ((BankAccountDetailsCA)account.Details).AccountNumber = "234234234234";
            ((BankAccountDetailsCA)account.Details).InstitutionNumber = "123";
            
            BankAccount createAccount = this._api.Users.createBankAccount(john.Id, account);
            
            assertTrue(createAccount.Id.length() > 0);
            assertTrue(createAccount.UserId.equals(john.Id));
            assertTrue(createAccount.Type == BankAccountType.CA);
            assertTrue(((BankAccountDetailsCA)createAccount.Details).AccountNumber.equals("234234234234"));
            assertTrue(((BankAccountDetailsCA)createAccount.Details).BankName.equals("TestBankName"));
            assertTrue(((BankAccountDetailsCA)createAccount.Details).BranchCode.equals("12345"));
            assertTrue(((BankAccountDetailsCA)createAccount.Details).InstitutionNumber.equals("123"));
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void test_Users_CreateBankAccount_OTHER() {
        try {
            UserNatural john = this.getJohn();
            BankAccount account = new BankAccount();
            account.OwnerName = john.FirstName + " " + john.LastName;
            account.OwnerAddress = john.Address;
            account.Details = new BankAccountDetailsOTHER();
            account.Type = BankAccountType.OTHER;
            ((BankAccountDetailsOTHER)account.Details).Country = CountryIso.FR;
            ((BankAccountDetailsOTHER)account.Details).AccountNumber = "234234234234";
            ((BankAccountDetailsOTHER)account.Details).BIC = "BINAADADXXX";
            
            BankAccount createAccount = this._api.Users.createBankAccount(john.Id, account);
            
            assertTrue(createAccount.Id.length() > 0);
            assertTrue(createAccount.UserId.equals(john.Id));
            assertTrue(createAccount.Type == BankAccountType.OTHER);
            assertTrue(((BankAccountDetailsOTHER)createAccount.Details).Country.equals(CountryIso.FR));
            assertTrue(((BankAccountDetailsOTHER)createAccount.Details).AccountNumber.equals("234234234234"));
            assertTrue(((BankAccountDetailsOTHER)createAccount.Details).BIC.equals("BINAADADXXX"));
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void test_Users_CreateBankAccount() throws Exception {
        UserNatural john = this.getJohn();
        BankAccount account = this.getJohnsAccount();
        
        assertTrue(account.Id.length() > 0);
        assertTrue(account.UserId.equals(john.Id));
    }

    @Test
    public void test_Users_BankAccount() throws Exception {
        UserNatural john = this.getJohn();
        BankAccount account = this.getJohnsAccount();
        
        BankAccount accountFetched = this._api.Users.getBankAccount(john.Id, account.Id);
        
        assertEqualInputProps(account, accountFetched);
    }
    
    @Test
    public void test_Users_BankAccounts() throws Exception {
        UserNatural john = this.getJohn();
        BankAccount account = this.getJohnsAccount();
        Pagination pagination = new Pagination(1, 12);
        
        List<BankAccount> list = this._api.Users.getBankAccounts(john.Id, pagination, null);
        
        int index = -1;
        for (int i=0; i<list.size(); i++)
        {
            if (account.Id.equals(list.get(i).Id)){
                index = i;
                break;
            }
        }
        
        assertTrue(list.get(0) instanceof BankAccount);
        assertTrue(index > -1);
        assertEqualInputProps(account, list.get(index));
        assertTrue(pagination.Page == 1);
        assertTrue(pagination.ItemsPerPage == 12);
    }
    
    @Test
    public void test_Users_BankAccounts_SortByCreationDate() throws Exception {
        UserNatural john = this.getJohn();
        this.getJohnsAccount();
        this.holdOn(2);
        this.getNewBankAccount();
        Pagination pagination = new Pagination(1, 12);
        Sorting sorting = new Sorting();
        sorting.addField("CreationDate", SortDirection.desc);
        
        List<BankAccount> list = this._api.Users.getBankAccounts(john.Id, pagination, sorting);
        
        assertNotNull(list);
        assertTrue(list.get(0) instanceof BankAccount);
        assertTrue(list.size() > 1);
        assertTrue(list.get(0).CreationDate > list.get(1).CreationDate);
    }
    
    
    @Test
    public void test_Users_CreateKycDocument() throws Exception {
        KycDocument kycDocument = this.getJohnsKycDocument();
        
        assertNotNull(kycDocument);
        assertTrue(kycDocument.Status == KycStatus.CREATED);
    }
    
    @Test
    public void test_Users_SaveKycDocument() throws Exception {
        UserNatural john = this.getJohn();
        KycDocument kycDocument = this.getJohnsKycDocument();
        
        kycDocument.Status = KycStatus.VALIDATION_ASKED;
        
        KycDocument result = this._api.Users.updateKycDocument(john.Id, kycDocument);
        
        assertNotNull(result);
        assertTrue(kycDocument.Type.equals(result.Type));
        assertTrue(kycDocument.Status == KycStatus.VALIDATION_ASKED);
    }
    
    @Test
    public void test_Users_GetKycDocument() throws Exception {
        UserNatural john = this.getJohn();
        KycDocument kycDocument = this.getJohnsKycDocument();
        
        KycDocument result = this._api.Users.getKycDocument(john.Id, kycDocument.Id);
        
        assertNotNull(result);
        assertTrue(kycDocument.Id.equals(result.Id));
        assertTrue(kycDocument.Type.equals(result.Type));
        assertTrue(kycDocument.Status.equals(result.Status));
        assertTrue(kycDocument.CreationDate == result.CreationDate);
    }
    
    @Test 
    public void test_Users_CreateKycPage() throws Exception {
        UserNatural john = this.getJohn();
        KycDocument kycDocument = this.getNewKycDocument();
        
        URL url = getClass().getProtectionDomain().getCodeSource().getLocation();
        String filePath = url.toString() + "/com/mangopay/core/TestKycPageFile.png";
        filePath = filePath.replace("file:/", "").replace("//", "/").replace("/", "\\");
        
        this._api.Users.createKycPage(john.Id, kycDocument.Id, filePath);
        
        kycDocument = this.getNewKycDocument();
        this._api.Users.createKycPage(john.Id, kycDocument.Id, Files.readAllBytes(Paths.get(filePath)));
    }
    
    @Test
    public void test_Users_AllCards() throws Exception {
        UserNatural john = this.getJohn();
        Pagination pagination = new Pagination(1, 20);
        List<Card> cardsBefore = this._api.Users.getCards(john.Id, pagination, null);
        PayIn payIn = this.getNewPayInCardDirect();
        Card card = this._api.Cards.get(((PayInPaymentDetailsCard)payIn.PaymentDetails).CardId);
        List<Card> cardsAfter = this._api.Users.getCards(john.Id, pagination, null);
        
        assertNotNull(cardsBefore);
        assertTrue(cardsAfter.size() > cardsBefore.size());
    }
    
    @Test
    public void test_Users_AllCards_SortByCreationDate() throws Exception {
        UserNatural john = this.getJohn();
        this.getNewPayInCardDirect();
        this.holdOn(2);
        this.getNewPayInCardDirect();
        Pagination pagination = new Pagination(1, 20);
        Sorting sorting = new Sorting();
        sorting.addField("CreationDate", SortDirection.desc);
        List<Card> cards = this._api.Users.getCards(john.Id, pagination, sorting);
        
        assertNotNull(cards);
        assertTrue(cards.size() > 1);
        assertTrue(cards.get(0).CreationDate > cards.get(1).CreationDate);
    }
    
    @Test
    public void test_Users_Transactions() throws Exception {
        UserNatural john = this.getJohn();
        Transfer transfer = this.getNewTransfer();
        Pagination pagination = new Pagination(1, 20);
        
        List<Transaction> transactions = this._api.Users.getTransactions(john.Id, pagination, new FilterTransactions(), null);
        
        assertTrue(transactions.size() > 0);
        assertTrue(transactions.get(0).Type != null);
        assertTrue(transactions.get(0).Status != null);
    }
    
    @Test
    public void test_Users_Transactions_SortByCreationDate() throws Exception {
        UserNatural john = this.getJohn();
        this.getNewTransfer();
        this.holdOn(2);
        this.getNewTransfer();
        Pagination pagination = new Pagination(1, 20);
        Sorting sorting = new Sorting();
        sorting.addField("CreationDate", SortDirection.desc);
        
        List<Transaction> transactions = this._api.Users.getTransactions(john.Id, pagination, new FilterTransactions(), sorting);
        
        assertNotNull(transactions);
        assertTrue(transactions.size() > 1);
        assertTrue(transactions.get(0).CreationDate > transactions.get(1).CreationDate);
    }
    
    @Test
     public void test_Users_GetKycDocuments() throws Exception{
        KycDocument kycDocument = this.getJohnsKycDocument();
        UserNatural user = this.getJohn();
        Pagination pagination = new Pagination(1, 20);
        
        List<KycDocument> getKycDocuments = this._api.Users.getKycDocuments(user.Id, pagination, null);
        
        assertTrue(getKycDocuments.get(0) instanceof KycDocument);
        KycDocument kycFromList = null;
        for (KycDocument item : getKycDocuments) {
            if (item.Id.equals(kycDocument.Id)) {
                kycFromList = item;
                break;
            }
        }
        assertNotNull(kycFromList);
        assertEquals(kycDocument.Id, kycFromList.Id);
        assertEqualInputProps(kycDocument, kycFromList);
    }
    
    @Test
     public void test_Users_GetKycDocuments_SortByCreationDate() throws Exception{
        this.getJohnsKycDocument();
        this.holdOn(2);
        this.getNewKycDocument();
        UserNatural user = this.getJohn();
        Pagination pagination = new Pagination(1, 20);
        Sorting sorting = new Sorting();
        sorting.addField("CreationDate", SortDirection.desc);
        
        List<KycDocument> getKycDocuments = this._api.Users.getKycDocuments(user.Id, pagination, sorting);
        
        assertNotNull(getKycDocuments);
        assertTrue(getKycDocuments.get(0) instanceof KycDocument);
        assertTrue(getKycDocuments.size() > 1);
        assertTrue(getKycDocuments.get(0).CreationDate > getKycDocuments.get(1).CreationDate);
    }
}