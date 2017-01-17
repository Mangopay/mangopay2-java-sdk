package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.*;

/**
 * Mandate entity.
 */
public class Mandate extends EntityBase {

    /**
     * The bank account ID to associate this mandate against (and hence from where the payins will come from).
     *
     * @deprecated Use {@link #getBankAccountId()} and {@link #setBankAccountId(String)} instead.
     */
    @Deprecated
    public String BankAccountId;

    /**
     * The type of mandate – it will be SEPA or BACS but will only be completed once the mandate has been submitted.
     *
     * @deprecated Use {@link #getScheme()} and {@link #setScheme(MandateScheme)} instead.
     */
    @Deprecated
    public MandateScheme Scheme;

    /**
     * The language to use for the confirmation web page presented to your user.
     *
     * @deprecated Use {@link #getCulture()} and {@link #setCulture(CultureCode)} instead.
     */
    @Deprecated
    public CultureCode Culture;

    /**
     * The URL to view/download the mandate document.
     *
     * @deprecated Use {@link #getDocumentURL()} and {@link #setDocumentURL(String)} instead.
     */
    @Deprecated
    public String DocumentURL;

    /**
     * The URL where you must redirect the user for them to confirm the setup of their mandate and then he will be redirected to the ReturnURL.
     *
     * @deprecated Use {@link #getRedirectURL()} and {@link #setRedirectURL(String)} instead.
     */
    @Deprecated
    public String RedirectURL;

    /**
     * URL format expected.
     *
     * @deprecated Use {@link #getReturnURL()} and {@link #setReturnURL(String)} instead.
     */
    @Deprecated
    public String ReturnURL;

    /**
     * ID of the user to which this mandate belongs.
     *
     * @deprecated Use {@link #getUserId()} and {@link #setUserId(String)} instead.
     */
    @Deprecated
    public String UserId;

    /**
     * The status of the mandate:
     * CREATED (the mandate has been created),
     * SUBMITTED (the mandate has been submitted to the banks and you can now do payments with this mandate),
     * ACTIVE (the mandate is active and has been accepted by the banks and/or successfully used in a payment),
     * FAILED (the mandate has failed for a variety of reasons and is no longer available for payments).
     *
     * @deprecated Use {@link #getStatus()} and {@link #setStatus(MandateStatus)} instead.
     */
    @Deprecated
    public MandateStatus Status;

    /**
     * Mandate result code.
     *
     * @deprecated Use {@link #getResultCode()} and {@link #setResultCode(String)} instead.
     */
    @Deprecated
    public String ResultCode;

    /**
     * Mandate result message.
     *
     * @deprecated Use {@link #getResultMessage()} and {@link #setResultMessage(String)} instead.
     */
    @Deprecated
    public String ResultMessage;

    /**
     * Type of mandate.
     *
     * @deprecated Use {@link #getMandateType()} and {@link #setMandateType(MandateType)} instead.
     */
    @Deprecated
    public MandateType MandateType;

    /**
     * How the mandate has been created.
     *
     * @deprecated Use {@link #getExecutionType()} and {@link #setExecutionType(MandateExecutionType)} instead.
     */
    @Deprecated
    public MandateExecutionType ExecutionType;

    public String getBankAccountId() {
        return BankAccountId;
    }

    public void setBankAccountId(String bankAccountId) {
        this.BankAccountId = bankAccountId;
    }

    public MandateScheme getScheme() {
        return Scheme;
    }

    public void setScheme(MandateScheme scheme) {
        this.Scheme = scheme;
    }

    public CultureCode getCulture() {
        return Culture;
    }

    public void setCulture(CultureCode culture) {
        this.Culture = culture;
    }

    public String getDocumentURL() {
        return DocumentURL;
    }

    public void setDocumentURL(String documentURL) {
        this.DocumentURL = documentURL;
    }

    public String getRedirectURL() {
        return RedirectURL;
    }

    public void setRedirectURL(String redirectURL) {
        this.RedirectURL = redirectURL;
    }

    public String getReturnURL() {
        return ReturnURL;
    }

    public void setReturnURL(String returnURL) {
        this.ReturnURL = returnURL;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
    }

    public MandateStatus getStatus() {
        return Status;
    }

    public void setStatus(MandateStatus status) {
        this.Status = status;
    }

    public String getResultCode() {
        return ResultCode;
    }

    public void setResultCode(String resultCode) {
        this.ResultCode = resultCode;
    }

    public String getResultMessage() {
        return ResultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.ResultMessage = resultMessage;
    }

    public MandateType getMandateType() {
        return MandateType;
    }

    public void setMandateType(MandateType mandateType) {
        this.MandateType = mandateType;
    }

    public MandateExecutionType getExecutionType() {
        return ExecutionType;
    }

    public void setExecutionType(MandateExecutionType executionType) {
        this.ExecutionType = executionType;
    }
}
