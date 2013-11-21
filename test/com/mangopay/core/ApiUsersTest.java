package com.mangopay.core;

import com.mangopay.entities.*;
import java.net.URL;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
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
        
        assertEqualInputProps(userSaved, john);
        assertEqualInputProps(userFetched, john);
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
}