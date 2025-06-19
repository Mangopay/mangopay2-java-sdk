package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.PayInPaymentDetails;

/**
 * Class representing the Bizum type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsBizum extends Dto implements PayInPaymentDetails {

    /**
     * An optional value to be specified on the user's bank statement
     * It can be up to 10 char alphanumeric and space.
     */
    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    /**
     * Format: International E.164 standard (preceded by plus sign and country code, +34 in Spain); pattern: ^[+][1-9][\d]{4,14}$
     * The phone number of the end user to which the Bizum push notification is sent to authenticate the transaction.
     * If the Phone parameter is sent, then RedirectURL is not returned and ReturnURL is ignored.
     */
    @SerializedName("Phone")
    private String phone;

    /**
     * The unique reference generated for the profiling session, used by the fraud prevention solution to produce recommendations for the transaction using the profiling data.
     */
    @SerializedName("ProfilingAttemptReference")
    private String profilingAttemptReference;

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public void setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getProfilingAttemptReference() { return profilingAttemptReference; }

    public void setProfilingAttemptReference(String profilingAttemptReference) { this.profilingAttemptReference = profilingAttemptReference; }
}
