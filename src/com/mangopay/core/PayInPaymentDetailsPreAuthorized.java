package com.mangopay.core;

/**
 * Class representing the PreAuthorized type for execution option in PayIn entity.
 */
public class PayInPaymentDetailsPreAuthorized extends Dto implements IPayInPaymentDetails {
    
    /**
     * Pre-authorization identifier.
     */
    public String PreauthorizationId;
    
}
