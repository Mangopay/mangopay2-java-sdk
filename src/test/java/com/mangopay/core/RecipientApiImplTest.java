package com.mangopay.core;

import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.entities.Recipient;
import com.mangopay.entities.subentities.IndividualRecipient;
import com.mangopay.entities.subentities.UserRecipients;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RecipientApiImplTest extends BaseTest {

    // already active SCA Natural user ID
    private final static String ACTIVE_USER_NATURAL_SCA_ID = "user_m_01JKZW095BFB2TRQMCZ8GE7M8D";
    private static Recipient recipient;

    @Before
    public void initialize() throws Exception {
        recipient = createNewRecipient();
    }

    @Test
    public void createRecipient() {
        assertNotNull(recipient);
        assertNotNull(recipient.getStatus());
        assertNotNull(recipient.getDisplayName());
        assertNotNull(recipient.getPayoutMethodType());
        assertNotNull(recipient.getRecipientType());
        assertNotNull(recipient.getIndividualRecipient());
        assertNotNull(recipient.getLocalBankTransfer());
        assertNotNull(recipient.getPendingUserAction());
    }

    @Test
    public void getRecipient() throws Exception {
        Recipient fetched = getApi().getRecipientApi().get(recipient.getId());
        assertNotNull(fetched);
        assertEquals(recipient.getId(), fetched.getId());
        assertEquals(recipient.getStatus(), fetched.getStatus());
    }

    @Test
    public void getUserRecipients() throws Exception {
        UserRecipients recipients = getApi().getRecipientApi().getUserRecipients(ACTIVE_USER_NATURAL_SCA_ID);
        assertNotNull(recipients.getRecipients());
        assertFalse(recipients.getRecipients().isEmpty());
    }

    private Recipient createNewRecipient() throws Exception {
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
                .setLocalBankTransfer(localBankTransfer);

            recipient = getApi().getRecipientApi().create(toCreate, ACTIVE_USER_NATURAL_SCA_ID);
        }
        return recipient;
    }
}
