package com.mangopay.core;

/**
 * Class represents Card type for mean of payment in PayIn entity
 */
public class PayInPaymentDetailsCard extends Dto implements IPayInPaymentDetails {

    /**
     * CardType { CB_VISA_MASTERCARD, AMEX }
     */
    public String CardType;
}
