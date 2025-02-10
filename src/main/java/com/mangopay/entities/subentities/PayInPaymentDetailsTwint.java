package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.PayInPaymentDetails;

/**
 * Class representing the TWINT type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsTwint extends Dto implements PayInPaymentDetails {

    /**
     * Max. length: 10 characters; only alphanumeric and spaces
     * <p></p>
     * Custom description to appear on the user’s bank statement along with the platform name.
     * Different banks may show more or less information. See the <a href="https://docs.mangopay.com/bank-statements">Customizing bank statement references</a> article for details.
     */
    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public PayInPaymentDetailsTwint setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
        return this;
    }

}
