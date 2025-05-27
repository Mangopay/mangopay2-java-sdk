package com.mangopay.core;

import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.entities.Recipient;
import com.mangopay.entities.subentities.IndividualRecipient;
import com.mangopay.entities.subentities.PayoutMethods;
import com.mangopay.entities.subentities.RecipientPropertySchema;
import com.mangopay.entities.subentities.RecipientSchema;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RecipientApiImplTest extends BaseTest {
    // already activated SCA Natural user ID
    private final static String ACTIVE_USER_NATURAL_SCA_ID = "user_m_01JKZW095BFB2TRQMCZ8GE7M8D";
    private static Recipient recipient;

    @Test
    public void createRecipient() throws Exception {
        createNewRecipient();
        assertNotNull(recipient);
        assertNotNull(recipient.getStatus());
        assertNotNull(recipient.getDisplayName());
        assertNotNull(recipient.getPayoutMethodType());
        assertNotNull(recipient.getRecipientType());
        assertNotNull(recipient.getIndividualRecipient());
        assertNotNull(recipient.getLocalBankTransfer());
        assertNotNull(recipient.getPendingUserAction());
        assertNotNull(recipient.getRecipientScope());
        assertNotNull(recipient.getUserId());
        assertNotNull(recipient.getCountry());
    }

    @Test
    public void getRecipient() throws Exception {
        createNewRecipient();
        Recipient fetched = getApi().getRecipientApi().get(recipient.getId());
        assertNotNull(fetched);
        assertEquals(recipient.getId(), fetched.getId());
        assertEquals(recipient.getStatus(), fetched.getStatus());
    }

    @Test
    public void getUserRecipients() throws Exception {
        List<Recipient> recipients1 = getApi().getRecipientApi().getUserRecipients(ACTIVE_USER_NATURAL_SCA_ID);
        List<Recipient> recipients2 =
            getApi().getRecipientApi().getUserRecipients(ACTIVE_USER_NATURAL_SCA_ID, null, null, null);
        List<Recipient> recipients3 = getApi().getRecipientApi().getUserRecipients(ACTIVE_USER_NATURAL_SCA_ID, null);
        List<Recipient> recipients4 =
            getApi().getRecipientApi().getUserRecipients(ACTIVE_USER_NATURAL_SCA_ID, new FilterRecipients().setRecipientScope("PAYOUT"));
        List<Recipient> recipients5 =
            getApi().getRecipientApi().getUserRecipients(ACTIVE_USER_NATURAL_SCA_ID, new FilterRecipients().setRecipientScope("PAYIN"));

        assertFalse(recipients1.isEmpty());
        assertEquals(recipients1.size(), recipients2.size());
        assertEquals(recipients1.size(), recipients3.size());
        assertEquals(recipients1.size(), recipients4.size());
        assertTrue(recipients5.isEmpty());
    }

    @Test
    public void getSchemaLocalBankTransferIndividual() throws Exception {
        RecipientSchema schema = getApi().getRecipientApi().getSchema("LocalBankTransfer",
            "Individual", CurrencyIso.GBP, CountryIso.GB);
        assertNotNull(schema);
        assertNotNull(schema.getDisplayName());
        assertNotNull(schema.getCurrency());
        assertNotNull(schema.getRecipientType());
        assertNotNull(schema.getPayoutMethodType());
        assertNotNull(schema.getRecipientScope());
        assertNotNull(schema.getTag());
        assertNotNull(schema.getIndividualRecipient());
        assertNotNull(schema.getLocalBankTransfer());
        assertNull(schema.getInternationalBankTransfer());
        assertNull(schema.getBusinessRecipient());

        Map<String, Map<String, RecipientPropertySchema>> localBankTransferSchema = schema.getLocalBankTransfer();
        assertNotNull(localBankTransferSchema.get(CurrencyIso.GBP.toString()));

        Map<String, RecipientPropertySchema> gbpSchema = localBankTransferSchema.get(CurrencyIso.GBP.toString());
        assertNotNull(gbpSchema.get("AccountNumber"));
        assertNotNull(gbpSchema.get("SortCode"));
    }

    @Test
    public void getSchemaInternationalBankTransferBusiness() throws Exception {
        RecipientSchema schema = getApi().getRecipientApi().getSchema("InternationalBankTransfer",
            "Business", CurrencyIso.GBP, CountryIso.GB);
        assertNotNull(schema);
        assertNotNull(schema.getDisplayName());
        assertNotNull(schema.getCurrency());
        assertNotNull(schema.getRecipientType());
        assertNotNull(schema.getRecipientScope());
        assertNotNull(schema.getTag());
        assertNotNull(schema.getPayoutMethodType());
        assertNotNull(schema.getInternationalBankTransfer());
        assertNotNull(schema.getBusinessRecipient());
        assertNull(schema.getIndividualRecipient());
        assertNull(schema.getLocalBankTransfer());
    }

    @Test
    public void validate() throws Exception {
        createNewRecipient();
        // if it fails, the test will crash with error
        getApi().getRecipientApi().validate(recipient, ACTIVE_USER_NATURAL_SCA_ID);
    }

    @Ignore("A recipient needs to be manually activated before running the test")
    @Test
    public void deactivateRecipient() throws Exception {
        String recipientId = "rec_01JRYVYE0BSX25DHHP2K803PG9";
        Recipient beforeDeactivation = getApi().getRecipientApi().get(recipientId);
        assertEquals("ACTIVE", beforeDeactivation.getStatus());

        Recipient deactivated = getApi().getRecipientApi().deactivate(recipientId);
        Recipient afterDeactivation = getApi().getRecipientApi().get(recipientId);

        assertEquals("DEACTIVATED", afterDeactivation.getStatus());
        assertEquals("DEACTIVATED", deactivated.getStatus());
    }

    @Test
    public void getPayoutMethods() throws Exception {
        PayoutMethods payoutMethods = getApi().getRecipientApi().getPayoutMethods(CountryIso.DE, CurrencyIso.EUR);
        assertNotNull(payoutMethods);
        assertFalse(payoutMethods.getAvailablePayoutMethods().isEmpty());
    }

    private void createNewRecipient() throws Exception {
        if (recipient == null) {
            Map<String, Object> localBankTransfer = new HashMap<>();
            Map<String, Object> gbpDetails = new HashMap<>();
            gbpDetails.put("SortCode", "010039");
            gbpDetails.put("AccountNumber", "11696419");
            localBankTransfer.put(CurrencyIso.GBP.name(), gbpDetails);

            Recipient toCreate = new Recipient()
                .setDisplayName("My GB account")
                .setPayoutMethodType("LocalBankTransfer")
                .setRecipientType("Individual")
                .setCurrency(CurrencyIso.GBP)
                .setIndividualRecipient(
                    new IndividualRecipient()
                        .setFirstName("Payout")
                        .setLastName("Team")
                        .setAddress(getNewAddress())
                )
                .setLocalBankTransfer(localBankTransfer)
                .setCountry(CountryIso.GB);

            recipient = getApi().getRecipientApi().create(toCreate, ACTIVE_USER_NATURAL_SCA_ID);
        }
    }
}
