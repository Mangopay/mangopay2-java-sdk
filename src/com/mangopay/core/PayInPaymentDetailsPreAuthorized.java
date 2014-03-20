package com.mangopay.core;

/**
 * Class representing the Web type for execution option in PayIn entity.
 */
public class PayInPaymentDetailsPreAuthorized extends Dto implements IPayInPaymentDetails {
    
    /**
     * The identifier of the Preauthorization object.
     */
    public String PreauthorizationId;
    
}
