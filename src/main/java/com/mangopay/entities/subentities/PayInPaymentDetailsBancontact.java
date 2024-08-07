package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.PayInPaymentDetails;

/**
 * Class representing the BANCONTACT type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsBancontact extends Dto implements PayInPaymentDetails {

    /**
     * The URL where you should redirect your client in a mobile app experience
     */
    @SerializedName("DeepLinkURL")
    private String deepLinkUrl;

    /**
     * An optional value to be specified on the user's bank statement
     * It can be up to 10 char alphanumeric and space.
     */
    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    /**
     * Whether the Bancontact pay-ins are being made to be re-used in a recurring payment flow
     */
    @SerializedName("Recurring")
    private Boolean recurring;

    public String getDeepLinkUrl() {
        return deepLinkUrl;
    }

    public void setDeepLinkUrl(String deepLinkUrl) {
        this.deepLinkUrl = deepLinkUrl;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public void setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
    }

    public Boolean getRecurring() {
        return recurring;
    }

    public void setRecurring(Boolean recurring) {
        this.recurring = recurring;
    }
}
