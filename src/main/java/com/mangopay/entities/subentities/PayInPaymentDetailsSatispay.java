package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.PayInPaymentDetails;

/**
 * Class representing the SATISPAY type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsSatispay extends Dto implements PayInPaymentDetails {

    @SerializedName("Country")
    private String country;

    /**
     * An optional value to be specified on the user's bank statement
     */
    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
    
    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public PayInPaymentDetailsSatispay setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
        return this;
    }

   
}
