package com.mangopay.core;

import com.mangopay.core.APIs.CardApi;
import com.mangopay.entities.Card;
import com.mangopay.entities.PayIn;
import com.mangopay.entities.subentities.PayInPaymentDetailsCard;
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
        }
    }
}
