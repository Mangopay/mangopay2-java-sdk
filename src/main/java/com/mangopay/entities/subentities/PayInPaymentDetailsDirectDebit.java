package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.IPayInPaymentDetails;
import com.mangopay.core.enumerations.DirectDebitType;

/**
 * Class representing the Direct-Debit type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsDirectDebit extends Dto implements IPayInPaymentDetails {
    
    /**
     * Direct debit type.
     */
    public DirectDebitType DirectDebitType;
    
    /**
     * Mandate identifier.
     */
    public String MandateId;
    
    /**
     * An optional value to be specified on the user's bank statement
     */
    public String StatementDescriptor;
}
