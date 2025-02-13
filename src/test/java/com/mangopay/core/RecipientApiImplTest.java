package com.mangopay.core;

import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.entities.Recipient;
import com.mangopay.entities.subentities.IndividualRecipient;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class RecipientApiImplTest extends BaseTest {

    private static Recipient recipient;

    @Before
    public void initialize() throws Exception {
        recipient = createNewRecipient();
    }

    @Test
    public void createRecipient() {
        assertNotNull(recipient);
        assertNotNull(recipient.getDisplayName());
        assertNotNull(recipient.getPayoutMethodType());
        assertNotNull(recipient.getRecipientType());
        assertNotNull(recipient.getIndividualRecipient());
        assertNotNull(recipient.getLocalBankTransfer());
        assertNotNull(recipient.getPendingUserAction());
    }

    private Recipient createNewRecipient() throws Exception {
        // already active SCA Natural user ID
        String activeUserNaturalScaId = "user_m_01JKZW095BFB2TRQMCZ8GE7M8D";

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

            recipient = getApi().getRecipientApi().create(toCreate, activeUserNaturalScaId);
        }
        return recipient;
    }
}
