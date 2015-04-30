package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.IPayInPaymentDetails;

/**
 * Class representing the PreAuthorized type for execution option in PayIn entity.
 */
public class PayInPaymentDetailsPreAuthorized extends Dto implements IPayInPaymentDetails {
    
    /**
     * Pre-authorization identifier.
     */
    public String PreauthorizationId;
    
}
