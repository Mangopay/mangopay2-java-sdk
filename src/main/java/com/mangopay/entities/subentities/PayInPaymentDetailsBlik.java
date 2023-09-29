package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.PayInPaymentDetails;

/**
 * Class representing the BLIK type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsBlik extends Dto implements PayInPaymentDetails {

    /**
     * An optional value to be specified on the user's bank statement
     */
    @SerializedName("StatementDescriptor")
    private String statementDescriptor;
    
    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public PayInPaymentDetailsBlik setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
        return this;
    }

   
}
