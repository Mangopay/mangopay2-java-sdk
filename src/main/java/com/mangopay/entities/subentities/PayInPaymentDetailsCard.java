package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.IPayInPaymentDetails;
import com.mangopay.core.enumerations.CardType;

/**
 * Class representing the Card type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsCard extends Dto implements IPayInPaymentDetails {

    /**
     * Card type.
     */
    public CardType CardType;
    
    /**
     * Card identifier.
     */
    public String CardId;
    
    /**
     * An optional value to be specified on the user's bank statement
     */
    public String StatementDescriptor;

    public PayInPaymentDetailsCard() {
    }

    public PayInPaymentDetailsCard(CardType cardType, String cardId) {
        this.CardType = cardType;
        this.CardId = cardId;
    }
    
    public static PayInPaymentDetailsCard build(CardType cardType, String cardId) {
        return new PayInPaymentDetailsCard(cardType, cardId);
    }

    public PayInPaymentDetailsCard(CardType cardType, String cardId, String statementDescriptor) {
        this.CardType = cardType;
        this.CardId = cardId;
        this.StatementDescriptor = statementDescriptor;
    }
    
    public static PayInPaymentDetailsCard build(CardType cardType, String cardId, String statementDescriptor) {
        return new PayInPaymentDetailsCard(cardType, cardId, statementDescriptor);
    }
}
