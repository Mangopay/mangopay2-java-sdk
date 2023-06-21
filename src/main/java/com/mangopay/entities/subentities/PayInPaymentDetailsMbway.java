package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.PayInPaymentDetails;

/**
 * Class representing the MBWAY type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsMbway extends Dto implements PayInPaymentDetails {

    /**
     * An optional value to be specified on the user's bank statement
     */
    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    /**
     * The mobile phone number of the user initiating the pay-in
     * Country code followed by hash symbol (#) followed by the rest of the number. Only digits and hash allowed
     */
    @SerializedName("PhoneNumber")
    private String phoneNumber;

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public PayInPaymentDetailsMbway setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PayInPaymentDetailsMbway setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
