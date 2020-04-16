package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.enumerations.CultureCode;
import com.mangopay.core.enumerations.DirectDebitType;
import com.mangopay.core.interfaces.PayInPaymentDetails;

/**
 * Class representing the Direct-Debit type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsDirectDebit extends Dto implements PayInPaymentDetails {

    /**
     * Direct debit type.
     */
    @SerializedName("DirectDebitType")
    private DirectDebitType directDebitType;

    /**
     * Mandate identifier.
     */
    @SerializedName("MandateId")
    private String mandateId;

    /**
     * An optional value to be specified on the user's bank statement
     */
    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    /**
     * The date when the user will be charged.
     */
    @SerializedName("ChargeDate")
    private String chargeDate;

    /**
     * The language to use for the payment page - needs to be the ISO code of the language
     */
    @SerializedName("Culture")
    private CultureCode culture;

    public DirectDebitType getDirectDebitType() {
        return directDebitType;
    }

    public void setDirectDebitType(DirectDebitType directDebitType) {
        this.directDebitType = directDebitType;
    }

    public String getMandateId() {
        return mandateId;
    }

    public void setMandateId(String mandateId) {
        this.mandateId = mandateId;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public void setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
    }

    public String getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(String chargeDate) {
        this.chargeDate = chargeDate;
    }

    public CultureCode getCulture() {
        return culture;
    }

    public void setCulture(CultureCode culture) {
        this.culture = culture;
    }}
