package com.mangopay.core;

import com.mangopay.core.APIs.CardApi;
import com.mangopay.core.enumerations.TransactionType;
import com.mangopay.entities.*;
import com.mangopay.entities.subentities.PayInPaymentDetailsCard;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CardApiImplTest extends BaseTest {

    @Test
    public void getCardsByFingerprint() throws Exception {
        CardApi cardApi = api.getCardApi();
        PayIn payIn = getNewPayInCardDirect();
        Card card = cardApi.get(((PayInPaymentDetailsCard) payIn.getPaymentDetails()).getCardId());

        List<Card> cardsByFingerprint = cardApi.getByFingerprint(card.getFingerprint());

        for (Card byFingerprint : cardsByFingerprint) {
            assertEquals(card.getFingerprint(), byFingerprint.getFingerprint());
            assertNotNull(card.getCardHolderName());
        }
    }

    @Test
    public void getTransactions() throws Exception {
        PayIn payIn = getNewPayInCardDirect();
        Card card = api.getCardApi().get(((PayInPaymentDetailsCard) payIn.getPaymentDetails()).getCardId());
        Pagination pagination = new Pagination(1, 1);
        List<Transaction> transactions = this.api.getCardApi().getTransactions(card.getId(), pagination, null);

        assertNotNull("Card transactions came back null", transactions);
        assertFalse("Api returned an empty list of card transactions", transactions.isEmpty());
    }

    @Test
    public void getCardPreAuthorizations() throws Exception {
        CardApi cardApi = api.getCardApi();
        CardPreAuthorization cardPreAuthorization = this.getJohnsCardPreAuthorization();
        List<CardPreAuthorization> getCardPreAuthorizations = cardApi.getCardPreAuthorizations(cardPreAuthorization.getCardId());

        assertNotNull(cardPreAuthorization);
        assertNotNull(getCardPreAuthorizations);
        assertTrue(!getCardPreAuthorizations.isEmpty());
        assertNotNull(getCardPreAuthorizations.get(0));
        assertEquals(getCardPreAuthorizations.get(0).getCardId(), cardPreAuthorization.getCardId());
    }

    @Test
    public void validateCard() throws Exception{
        //create card validation
        CardValidation cardValidation = createJohnsCardValidation();

        assertNotNull(cardValidation);
        assertNotNull(cardValidation.getId());
        assertNotNull(cardValidation.getSecureMode());
        assertEquals(TransactionType.CARD_VALIDATION, cardValidation.getType());
        assertEquals("TelephoneOrder", cardValidation.getPaymentCategory());
    }

    @Test
    public void getCardValidation() throws Exception{
        CardValidation cardValidation = getJohnsCardValidation();

        assertNotNull(cardValidation);
        assertNotNull(cardValidation.getId());
        assertEquals(TransactionType.CARD_VALIDATION, cardValidation.getType());
    }

    @Test
    public void disableCard() throws Exception{
        CardApi cardApi = api.getCardApi();
        PayIn payIn = getNewPayInCardDirect();
        Card card = cardApi.get(((PayInPaymentDetailsCard) payIn.getPaymentDetails()).getCardId());
        card.setCardHolderName("placeholder name");

        assertTrue(card.isActive());

        Card update = cardApi.disable(card);

        assertFalse(update.isActive());
        assertEquals("placeholder name", card.getCardHolderName());
    }
}
