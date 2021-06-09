package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.ObjectTool;
import com.mangopay.core.Shipping;
import com.mangopay.core.interfaces.PayInPaymentDetails;
import com.mangopay.core.enumerations.CardType;

/**
 * Class representing the Card type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsCard extends Dto implements PayInPaymentDetails {

    /**
     * Card type.
     */
    @SerializedName("CardType")
    private CardType cardType;
    
    /**
     * Card identifier.
     */
    @SerializedName("CardId")
    private String cardId;
    
    /**
     * An optional value to be specified on the user's bank statement
     */
    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    @SerializedName("Shipping")
    private Shipping shipping;

    @SerializedName("BrowserInfo")
    private BrowserInfo browserInfo;

    @SerializedName("IpAddress")
    private String ipAddress;

    public PayInPaymentDetailsCard() {
    }

    public PayInPaymentDetailsCard(CardType cardType, String cardId) {
        this.cardType = cardType;
        this.cardId = cardId;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public void setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public PayInPaymentDetailsCard setShipping(Shipping shipping) {
        this.shipping = shipping;
        return this;
    }

    public static PayInPaymentDetailsCard build(CardType cardType, String cardId) {
        return new PayInPaymentDetailsCard(cardType, cardId);
    }

    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public PayInPaymentDetailsCard setBrowserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
        return this;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public PayInPaymentDetailsCard setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public PayInPaymentDetailsCard(CardType cardType, String cardId, String statementDescriptor, Shipping shipping) {
        this.cardType = cardType;
        this.cardId = cardId;
        this.statementDescriptor = statementDescriptor;
        this.shipping = shipping;
    }
    
    public static PayInPaymentDetailsCard build(CardType cardType, String cardId, String statementDescriptor, Shipping shipping) {
        return new PayInPaymentDetailsCard(cardType, cardId, statementDescriptor, shipping);
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
