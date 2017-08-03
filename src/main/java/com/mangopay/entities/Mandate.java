package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.*;

import java.util.ArrayList;

/**
 * Mandate entity.
 */
public class Mandate extends EntityBase {

    /**
     * The bank account ID to associate this mandate against (and hence from where the payins will come from).
     */
    @SerializedName("BankAccountId")
    private String bankAccountId;

    /**
     * The type of mandate – it will be SEPA or BACS but will only be completed once the mandate has been submitted.
     */
    @SerializedName("Scheme")
    private MandateScheme scheme;

    /**
     * The language to use for the confirmation web page presented to your user.
     */
    @SerializedName("Culture")
    private CultureCode culture;

    /**
     * The URL to view/download the mandate document.
     */
    @SerializedName("DocumentURL")
    private String documentUrl;

    /**
     * The URL where you must redirect the user for them to confirm the setup of their mandate and then he will be redirected to the ReturnURL.
     */
    @SerializedName("RedirectURL")
    private String redirectUrl;

    /**
     * URL format expected.
     */
    @SerializedName("ReturnURL")
    private String returnUrl;

    /**
     * ID of the user to which this mandate belongs.
     */
    @SerializedName("UserId")
    private String userId;

    /**
     * The status of the mandate:
     * CREATED (the mandate has been created),
     * SUBMITTED (the mandate has been submitted to the banks and you can now do payments with this mandate),
     * ACTIVE (the mandate is active and has been accepted by the banks and/or successfully used in a payment),
     * FAILED (the mandate has failed for a variety of reasons and is no longer available for payments).
     */
    @SerializedName("Status")
    private MandateStatus status;

    /**
     * Mandate result code.
     */
    @SerializedName("ResultCode")
    private String resultCode;

    /**
     * Mandate result message.
     */
    @SerializedName("ResultMessage")
    private String resultMessage;

    /**
     * Type of mandate.
     */
    @SerializedName("MandateType")
    private MandateType mandateType;

    /**
     * How the mandate has been created.
     */
    @SerializedName("ExecutionType")
    private MandateExecutionType executionType;

    @SerializedName("BankReference")
    private String bankReference;

    public String getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public MandateScheme getScheme() {
        return scheme;
    }

    public void setScheme(MandateScheme scheme) {
        this.scheme = scheme;
    }

    public CultureCode getCulture() {
        return culture;
    }

    public void setCulture(CultureCode culture) {
        this.culture = culture;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public MandateStatus getStatus() {
        return status;
    }

    public void setStatus(MandateStatus status) {
        this.status = status;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public MandateType getMandateType() {
        return mandateType;
    }

    public void setMandateType(MandateType mandateType) {
        this.mandateType = mandateType;
    }

    public MandateExecutionType getExecutionType() {
        return executionType;
    }

    public void setExecutionType(MandateExecutionType executionType) {
        this.executionType = executionType;
    }

    public String getBankReference() {
        return bankReference;
    }

    public void setBankReference(String bankReference) {
        this.bankReference = bankReference;
    }

    @Override
    public ArrayList<String> getReadOnlyProperties() {
        ArrayList<String> result = super.getReadOnlyProperties();

        result.add("BankReference");

        return result;
    }
}
