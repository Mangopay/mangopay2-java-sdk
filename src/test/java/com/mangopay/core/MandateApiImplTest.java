package com.mangopay.core;

import com.mangopay.entities.Mandate;
import com.mangopay.entities.Transfer;
import com.mangopay.entities.UserNatural;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * MandateApiImpl test methods.
 */
public class MandateApiImplTest extends BaseTest {

    @Test
    public void createMandate() throws Exception {
        Mandate mandate = this.createMandate(false);
        assertNotNull(mandate);
        assertFalse(mandate.getId().isEmpty());
    }

    @Test
    public void getMandate() throws Exception {
        Mandate created = this.createMandate(false);
        Mandate fetched = this.api.getMandateApi().get(created.getId());

        assertNotNull(fetched);
        assertFalse(fetched.getId().isEmpty());
        assertEquals(created.getId(), fetched.getId());
    }

    /*
    @Test
    public void cancelMandate() throws Exception {
        String bankAccountId = this.getJohnsAccount().getId();
        String returnUrl = "http://test.test";

        Mandate mandatePost = new Mandate();
        mandatePost.setBankAccountId(bankAccountId);
        mandatePost.setCulture(CultureCode.EN);
        mandatePost.setReturnURL(returnUrl);

        Mandate mandate = this.api.getMandateApi().create(mandatePost);

        //	! IMPORTANT NOTE !
        //	
        //	In order to make this test pass, at this place you have to set a breakpoint,
        //	navigate to URL the mandate.RedirectURL property points to and click "CONFIRM" button.

        mandate = this.api.getMandateApi().get(mandate.getId());

        assertTrue("In order to make this test pass, after creating mandate and before cancelling it you have to navigate to URL the mandate.RedirectURL property points to and click CONFIRM button.", mandate.getStatus() == MandateStatus.SUBMITTED);

        mandate = this.api.getMandateApi().cancel(mandate.getId());

        assertNotNull(mandate);
        assertTrue(mandate.getStatus() == MandateStatus.FAILED);
    }
    */

    @Test
    public void getAllMandates() throws Exception {
        FilterMandates filters = new FilterMandates();
        List<Mandate> mandates = this.api.getMandateApi().getAll(filters, null, null);

        assertNotNull(mandates);
        assertTrue(mandates.size() > 0);
    }

    @Test
    public void getMandatesForUser() throws Exception {
        UserNatural user = this.getJohnOwner(false, false);
        Mandate mandateCreated = this.createMandate(false);

        List<Mandate> mandates = this.api.getMandateApi().getForUser(user.getId(), new FilterMandates(), new Pagination(1, 1), null);

        assertNotNull(mandates);
        assertTrue(mandates.size() > 0);

        assertNotNull(mandates.get(0));
        assertTrue(mandates.get(0).getId().length() > 0);
        assertEquals(mandateCreated.getId(), mandates.get(0).getId());
    }

    @Test
    public void getMandatesForBankAccount() throws Exception {
        UserNatural user = this.getJohnOwner(false, false);
        Mandate mandateCreated = this.createMandate(false);

        List<Mandate> mandates = this.api.getMandateApi().getForBankAccount(user.getId(), this.getJohnsAccount().getId(), new FilterMandates(), new Pagination(1, 1), null);

        assertNotNull(mandates);
        assertTrue(mandates.size() > 0);

        assertNotNull(mandates.get(0));
        assertTrue(mandates.get(0).getId().length() > 0);
        assertEquals(mandateCreated.getId(), mandates.get(0).getId());
    }

    @Test
    public void getMandateTransfers() throws Exception {
        Mandate mandate = this.createMandate(false);
        this.createDirectDebitDirect();

        // wait for the Transaction to be created on API side
        Thread.sleep(2000);

        List<Transfer> transfers = this.api.getMandateApi().getTransfers(mandate.getId(), new Pagination(1, 1), null);
        assertNotNull(transfers);
        assertTrue(transfers.size() == 1);
    }

}
