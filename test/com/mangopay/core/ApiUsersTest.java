package com.mangopay.core;

import com.mangopay.entities.*;
import java.net.URL;
import java.nio.file.AccessDeniedException;
import java.nio.file.NoSuchFileException;
import java.util.Calendar;
import java.util.List;
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
        assertTrue(john.PersonType.equals(User.Types.Natural));
    }

    @Test
    public void test_Users_CreateLegal() throws Exception {
        UserLegal matrix = this.getMatrix();
        assertTrue(matrix.Id.length() > 0);
        assertTrue(matrix.PersonType.equals(User.Types.Legal));
    }

    @Test
    public void test_Users_CreateLegal_FailsIfRequiredPropsNotProvided() throws Exception {
        UserLegal user = new UserLegal();
        
        User ret = null;
        
        try {
            ret = this._api.Users.create(user);
            
            assertTrue("CreateLegal() should throw an exception when required props are not provided", false);
        }
        catch (ResponseException ex) {
            assertNull(ret);
        }
    }

    @Test
    public void test_Users_CreateLegal_PassesIfRequiredPropsProvided() throws Exception {
        UserLegal user = new UserLegal();
        user.Name = "SomeOtherSampleOrg";
        user.LegalPersonType = "BUSINESS";
        user.LegalRepresentativeFirstName = "RepFName";
        user.LegalRepresentativeLastName = "RepLName";
        Calendar c = Calendar.getInstance();
        c.set(1975, 12, 21, 0, 0, 0);
        user.LegalRepresentativeBirthday = c.getTimeInMillis() / 1000;
        user.LegalRepresentativeNationality = "FR";
        user.LegalRepresentativeCountryOfResidence = "FR";
        user.Email = "email@email.org";
        
        User ret = null;
        
        ret = this._api.Users.create(user);
        
        assertTrue("Created successfully after required props set", ret.Id.length() > 0);
        
        assertEqualInputProps(user, ret);
    }

    @Test
    public void test_Users_GetNatural() throws Exception {
        UserNatural john = this.getJohn();

        User user1 = this._api.Users.get(john.Id);
        UserNatural user2 = this._api.Users.getNatural(john.Id);

        assertTrue(user1.PersonType.equals(User.Types.Natural));
        assertTrue(user1.Id.equals(john.Id));
        assertTrue(user2.PersonType.equals(User.Types.Natural));
        assertTrue(user2.Id.equals(john.Id));
        
        //assertIdentical(user1, john);
        //assertIdentical(user2, john);
        assertEqualInputProps(user1, john);
    }

    @Test
    public void test_Users_GetNatural_FailsForLegalUser() throws Exception {
        UserLegal matrix = this.getMatrix();
        
        UserNatural user = null;
        try {
            user = this._api.Users.getNatural(matrix.Id);
            
            assertTrue("GetUser() should throw an exception when called with legal user id", false);
        }
        catch (ResponseException ex) {
            assertNull(user);
        }
    }

    @Test
    public void test_Users_GetLegal_FailsForNaturalUser() throws Exception {
        UserNatural john = this.getJohn();
        
        User user = null;
        try {
            user = this._api.Users.getLegal(john.Id);
            
            assertTrue("GetLegal() should throw an exception when called with natural user id", false);
        } catch (ResponseException ex) {
            assertNull(user);
        }
    }

    @Test
    public void test_Users_GetLegal() throws Exception {
        UserLegal matrix = this.getMatrix();

        User user1 = this._api.Users.get(matrix.Id);
        User user2 = this._api.Users.getLegal(matrix.Id);

//        assertEquals(user1, matrix);
//        assertEquals(user2, matrix);
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
        john.LastName += " - CHANGED (éèęóąśłżźćń)";
        
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
            ((BankAccountDetailsGB)account.Details).AccountNumber = "234234234234";
            ((BankAccountDetailsGB)account.Details).SortCode = "234334";
            
            BankAccount createAccount = this._api.Users.createBankAccount(john.Id, account);
            
            assertTrue(createAccount.Id.length() > 0);
            assertTrue(createAccount.UserId.equals(john.Id));
            assertTrue(createAccount.Type.equals("GB"));
            assertTrue(((BankAccountDetailsGB)createAccount.Details).AccountNumber.equals("234234234234"));
            assertTrue(((BankAccountDetailsGB)createAccount.Details).SortCode.equals("234334"));
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
            assertTrue(createAccount.Type.equals("US"));
            assertTrue(((BankAccountDetailsUS)createAccount.Details).AccountNumber.equals("234234234234"));
            assertTrue(((BankAccountDetailsUS)createAccount.Details).ABA.equals("234334789"));
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
            assertTrue(createAccount.Type.equals("CA"));
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
            ((BankAccountDetailsOTHER)account.Details).Type = "OTHER";
            ((BankAccountDetailsOTHER)account.Details).Country = "FR";
            ((BankAccountDetailsOTHER)account.Details).AccountNumber = "234234234234";
            ((BankAccountDetailsOTHER)account.Details).BIC = "BINAADADXXX";
            
            BankAccount createAccount = this._api.Users.createBankAccount(john.Id, account);
            
            assertTrue(createAccount.Id.length() > 0);
            assertTrue(createAccount.UserId.equals(john.Id));
            assertTrue(createAccount.Type.equals("OTHER"));
            assertTrue(((BankAccountDetailsOTHER)createAccount.Details).Type.equals("OTHER"));
            assertTrue(((BankAccountDetailsOTHER)createAccount.Details).Country.equals("FR"));
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
        
        List<BankAccount> list = this._api.Users.getBankAccounts(john.Id, pagination);
        
        assertTrue(list.get(0) instanceof BankAccount);
        assertTrue(account.Id.equals(list.get(0).Id));
        assertEqualInputProps(account, list.get(0));
        assertTrue(pagination.Page == 1);
        assertTrue(pagination.ItemsPerPage == 12);
    }
    
    
    @Test
    public void test_Users_CreateKycDocument() throws Exception {
        KycDocument kycDocument = this.getJohnsKycDocument();
        
        assertNotNull(kycDocument);
        assertTrue(kycDocument.Status.equals("CREATED"));
    }
    
    @Test
    public void test_Users_SaveKycDocument() throws Exception {
        UserNatural john = this.getJohn();
        KycDocument kycDocument = this.getJohnsKycDocument();
        
        //Calendar c = Calendar.getInstance();
        //Long currTime = c.getTimeInMillis() / 1000;
        //kycDocument.Tag = currTime.toString();
        kycDocument.Status = "VALIDATION_ASKED";
        
        KycDocument result = this._api.Users.updateKycDocument(john.Id, kycDocument);
        
        assertNotNull(result);
        assertTrue(kycDocument.Type.equals(result.Type));
        assertTrue(kycDocument.Status.equals("VALIDATION_ASKED"));
        //assertNotNull(result.Tag);
        //assertTrue(result.Tag.equals(currTime.toString()));
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
        KycDocument kycDocument = this.getJohnsKycDocument();
        
        this._api.Users.createKycPage(john.Id, kycDocument.Id, "Test KYC page".getBytes());
        
        URL url = getClass().getProtectionDomain().getCodeSource().getLocation();
        String filePath = url.toString() + "/com/mangopay/core/TestKycPageFile.txt";
        filePath = filePath.replace("file:/", "").replace("//", "/").replace("/", "\\");
        
        this._api.Users.createKycPage(john.Id, kycDocument.Id, filePath);
    }
    
    @Test
    public void test_Users_AllCards() throws Exception {
        UserNatural john = this.getJohn();
        PayIn payIn = this.getNewPayInCardDirect();
        Pagination pagination = new Pagination(1, 1);
        Card card = this._api.Cards.get(((PayInPaymentDetailsCard)payIn.PaymentDetails).CardId);
        List<Card> cards = this._api.Users.getCards(john.Id, pagination);
        
        assertTrue(cards.size() == 1);
        assertTrue(cards.get(0).CardType != null);
        assertTrue(cards.get(0).Currency != null);
        assertEqualInputProps(cards.get(0), card);
    }
    
    @Test
    public void test_Users_Transactions() throws Exception {
        UserNatural john = this.getJohn();
        Transfer transfer = this.getNewTransfer();
        Pagination pagination = new Pagination(1, 1);
        
        List<Transaction> transactions = this._api.Users.getTransactions(john.Id, pagination, new FilterTransactions());
        
        assertTrue(transactions.size() > 0);
        assertTrue(transactions.get(0).Type != null);
        assertTrue(transactions.get(0).Status != null);
    }
}