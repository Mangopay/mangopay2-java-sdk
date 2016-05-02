package com.mangopay.core;
import com.mangopay.core.enumerations.CultureCode;
import com.mangopay.core.enumerations.MandateStatus;
import com.mangopay.entities.Mandate;
import com.mangopay.entities.UserNatural;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * ApiMandates test methods.
 */
public class ApiMandatesTest extends BaseTest {
    
    @Test
    public void test_Mandate_Create() throws Exception
    {
        Mandate mandatePost = new Mandate();
        mandatePost.BankAccountId = this.getJohnsAccount().Id;
        mandatePost.ReturnURL = "http://test.test";
        mandatePost.Culture = CultureCode.EN;

        Mandate mandate = this._api.Mandates.create(mandatePost);
        assertNotNull(mandate);
        assertFalse(mandate.Id.isEmpty());
    }

    @Test
    public void test_Mandate_Get() throws Exception
    {
        Mandate mandatePost = new Mandate();
        mandatePost.BankAccountId = this.getJohnsAccount().Id;
        mandatePost.ReturnURL = "http://test.test";
        mandatePost.Culture = CultureCode.EN;

        Mandate mandateCreated = this._api.Mandates.create(mandatePost);

        Mandate mandate = this._api.Mandates.get(mandateCreated.Id);

        assertNotNull(mandate);
        assertFalse(mandate.Id.isEmpty());
        assertEquals(mandateCreated.Id, mandate.Id);
    }
    
    @Test
    public void test_Mandate_Cancel() throws Exception {
        String bankAccountId = this.getJohnsAccount().Id;
        String returnUrl = "http://test.test";
        
        Mandate mandatePost = new Mandate();
        mandatePost.BankAccountId = bankAccountId;
        mandatePost.Culture = CultureCode.EN;
        mandatePost.ReturnURL = returnUrl;
        
        Mandate mandate = this._api.Mandates.create(mandatePost);
        
        //	! IMPORTANT NOTE !
        //	
        //	In order to make this test pass, at this place you have to set a breakpoint,
        //	navigate to URL the mandate.RedirectURL property points to and click "CONFIRM" button.
        
        mandate = this._api.Mandates.get(mandate.Id);
        
        assertTrue("In order to make this test pass, after creating mandate and before cancelling it you have to navigate to URL the mandate.RedirectURL property points to and click CONFIRM button.", mandate.Status == MandateStatus.SUBMITTED);
        
        mandate = this._api.Mandates.cancel(mandate.Id);
        
        assertNotNull(mandate);
        assertTrue(mandate.Status == MandateStatus.FAILED);
    }

    @Test
    public void test_Mandates_GetAll() throws Exception
    {
        FilterMandates filters = new FilterMandates();
        List<Mandate> mandates = this._api.Mandates.getAll(filters, null, null);

        assertNotNull(mandates);
        assertTrue(mandates.size() > 0);
    }
    
    @Test
    public void test_Mandates_GetForUser() throws Exception
    {
        UserNatural user = this.getJohn(true);
        
        Mandate mandatePost = new Mandate();
        mandatePost.BankAccountId = this.getJohnsAccount(true).Id;
        mandatePost.ReturnURL = "http://test.test";
        mandatePost.Culture = CultureCode.EN;

        Mandate mandateCreated = this._api.Mandates.create(mandatePost);

        List<Mandate> mandates = this._api.Mandates.getForUser(user.Id, new FilterMandates(), new Pagination(1, 1), null);

        assertNotNull(mandates);
        assertTrue(mandates.size() > 0);

        assertNotNull(mandates.get(0));
        assertTrue(mandates.get(0).Id.length() > 0);
        assertEquals(mandateCreated.Id, mandates.get(0).Id);
    }
    
    @Test
    public void test_Mandates_GetForBankAccount() throws Exception
    {
        UserNatural user = this.getJohn(true);
        
        Mandate mandatePost = new Mandate();
        mandatePost.BankAccountId = this.getJohnsAccount(true).Id;
        mandatePost.ReturnURL = "http://test.test";
        mandatePost.Culture = CultureCode.EN;

        Mandate mandateCreated = this._api.Mandates.create(mandatePost);

        List<Mandate> mandates = this._api.Mandates.getForBankAccount(user.Id, mandatePost.BankAccountId, new FilterMandates(), new Pagination(1, 1), null);

        assertNotNull(mandates);
        assertTrue(mandates.size() > 0);

        assertNotNull(mandates.get(0));
        assertTrue(mandates.get(0).Id.length() > 0);
        assertEquals(mandateCreated.Id, mandates.get(0).Id);
    }
    
}
