package com.mangopay.core;

/**
 * Class representing the Card type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsCard extends Dto implements IPayInPaymentDetails {

    /**
     * Card type { CB_VISA_MASTERCARD, AMEX }.
     */
    public String CardType;
    
    /**
     * Card identifier.
     */
    public String CardId;
}
