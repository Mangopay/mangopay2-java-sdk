package com.mangopay.core;

/**
 * Class representing the Direct-Debit type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsDirectDebit extends Dto implements IPayInPaymentDetails {
    
    /**
     * Direct debit type {SOFORT, ELV, GIROPAY}
     */
    public String DirectDebitType;
}
