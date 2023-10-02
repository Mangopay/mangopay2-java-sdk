package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.PayInPaymentDetails;

/**
 * Class representing the IDEAL type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsIdeal extends Dto implements PayInPaymentDetails {

    /**
     * An optional value to be specified on the user's bank statement
     */
    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    /**
     * Name of the end-user’s bank
     */
    @SerializedName("BankName")
    private String bankName;

    /**
     * The BIC identifier of the end-user’s bank
     */
    @SerializedName("Bic")
    private String bic;

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public void setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }
}