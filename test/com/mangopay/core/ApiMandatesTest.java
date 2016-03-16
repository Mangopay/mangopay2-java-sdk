package com.mangopay.core;
import com.mangopay.core.enumerations.CultureCode;
import com.mangopay.entities.*;
import java.util.List;
import org.junit.Test;
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
