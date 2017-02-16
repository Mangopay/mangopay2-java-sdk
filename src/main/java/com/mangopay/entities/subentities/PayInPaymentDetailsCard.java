package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.ObjectTool;
import com.mangopay.core.interfaces.PayInPaymentDetails;
import com.mangopay.core.enumerations.CardType;

/**
 * Class representing the Card type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsCard extends Dto implements PayInPaymentDetails {

    /**
     * Card type.
     *
     * @deprecated Use {@link #getCardType()} and {@link #setCardType(com.mangopay.core.enumerations.CardType)} instead.
     */
    @Deprecated
    public CardType CardType;
    
    /**
     * Card identifier.
     *
     * @deprecated Use {@link #getCardId()} and {@link #setCardId(String)} instead.
     */
    @Deprecated
    public String CardId;
    
    /**
     * An optional value to be specified on the user's bank statement
     *
     * @deprecated Use {@link #getStatementDescriptor()} and {@link #setStatementDescriptor(String)} instead.
     */
    @Deprecated
    public String StatementDescriptor;

    public PayInPaymentDetailsCard() {
    }

    public PayInPaymentDetailsCard(CardType cardType, String cardId) {
        this.CardType = cardType;
        this.CardId = cardId;
    }

    public CardType getCardType() {
        return CardType;
    }

    public void setCardType(CardType cardType) {
        this.CardType = cardType;
    }

    public String getCardId() {
        return CardId;
    }

    public void setCardId(String cardId) {
        this.CardId = cardId;
    }

    public String getStatementDescriptor() {
        return StatementDescriptor;
    }

    public void setStatementDescriptor(String statementDescriptor) {
        this.StatementDescriptor = statementDescriptor;
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
    
    public static PayInPaymentDetailsCard convert(PayInPaymentDetails paymentDetails) throws Exception {
        if (ObjectTool.isNull(paymentDetails)) {
            throw new Exception("PayInPaymentDetails null value");
        } else if (paymentDetails  instanceof PayInPaymentDetailsCard) {
            return (PayInPaymentDetailsCard) paymentDetails;
        } else {
            throw new Exception("PayInPaymentDetails instance isn't PayInPaymentDetailsCard instance");
        }
    }
}
