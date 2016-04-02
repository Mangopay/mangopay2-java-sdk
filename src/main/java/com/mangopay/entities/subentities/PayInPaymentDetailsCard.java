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
}
