package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.*;
import com.mangopay.core.enumerations.*;
import com.mangopay.core.Shipping;
import com.mangopay.entities.subentities.BrowserInfo;
import com.mangopay.entities.subentities.PayInPaymentDetailsPreAuthorized;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * CardPreAuthorization entity.
 */
public class CardPreAuthorization extends EntityBase {

    /**
     * The user Id of the author of the pre-authorization.
     */
    @SerializedName("AuthorId")
    private String authorId;

    /**
     * Represents the amount debited on the bank account
     * of the Author. DebitedFunds = Fees + CreditedFunds
     * (amount received on wallet)
     */
    @SerializedName("DebitedFunds")
    private Money debitedFunds;

    /**
     *
     * */
    @SerializedName("RemainingFunds")
    private Money remainingFunds;

    /**
     * Status of the PreAuthorization.
     */
    @SerializedName("Status")
    private PreAuthorizationStatus status;

    /**
     * The status of the payment after the PreAuthorization.
     */
    @SerializedName("PaymentStatus")
    private PaymentStatus paymentStatus;

    /**
     * The PreAuthorization result code.
     */
    @SerializedName("ResultCode")
    private String resultCode;

    /**
     * The PreAuthorization result Message explaining the result code.
     */
    @SerializedName("ResultMessage")
    private String resultMessage;

    /**
     * How the PreAuthorization has been executed.
     */
    @SerializedName("ExecutionType")
    private PreAuthorizationExecutionType executionType;

    /**
     * The SecureMode correspond to '3D secure' for CB Visa and MasterCard
     * or 'Amex Safe Key' for American Express.
     * This field lets you activate it manually.
     */
    @SerializedName("SecureMode")
    private SecureMode secureMode;

    /**
     * Identifier of the registered card (got through CardRegistration object).
     */
    @SerializedName("CardId")
    private String cardId;

    /**
     * An optional value to be specified on the user's bank statement
     */
    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    /**
     * Boolean. The value is 'true' if the SecureMode was used.
     */
    @SerializedName("SecureModeNeeded")
    private String secureModeNeeded;

    /**
     * This is the URL where to redirect users to proceed
     * to 3D secure validation.
     */
    @SerializedName("SecureModeRedirectURL")
    private String secureModeRedirectUrl;

    /**
     * This is the URL where users are automatically redirected
     * after 3D secure validation (if activated).
     */
    @SerializedName("SecureModeReturnURL")
    private String secureModeReturnUrl;

    /**
     * The date when the payment has been processed (UNIX timestamp).
     */
    @SerializedName("ExpirationDate")
    private Long expirationDate;

    /**
     * Identifier of the associated PayIn.
     */
    @SerializedName("PayInId")
    private String payInId;

    @SerializedName("Billing")
    private Billing billing;

    @SerializedName("SecurityInfo")
    private SecurityInfo securityInfo;

    @SerializedName("MultiCapture")
    private Boolean multiCapture;

    @SerializedName("Shipping")
    private Shipping shipping;

    @SerializedName("BrowserInfo")
    private BrowserInfo browserInfo;

    @SerializedName("IpAddress")
    private String ipAddress;

    @SerializedName("Requested3DSVersion")
    private String requested3DSVersion;

    @SerializedName("Applied3DSVersion")
    private String applied3DSVersion;

    /**
     * The language to use for the payment page - needs to be the ISO code of the language
     */
    @SerializedName("Culture")
    private CultureCode culture;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Money getDebitedFunds() {
        return debitedFunds;
    }

    public void setDebitedFunds(Money debitedFunds) {
        this.debitedFunds = debitedFunds;
    }

    public PreAuthorizationStatus getStatus() {
        return status;
    }

    public void setStatus(PreAuthorizationStatus status) {
        this.status = status;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
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

    public PreAuthorizationExecutionType getExecutionType() {
        return executionType;
    }

    public void setExecutionType(PreAuthorizationExecutionType executionType) {
        this.executionType = executionType;
    }

    public SecureMode getSecureMode() {
        return secureMode;
    }

    public void setSecureMode(SecureMode secureMode) {
        this.secureMode = secureMode;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public void setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
    }

    public Shipping getShipping() { return shipping; }

    public void setShipping(Shipping shipping) { this.shipping = shipping; }

    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public CardPreAuthorization setBrowserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
        return this;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public CardPreAuthorization setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    /**
     * Is SecureMode Needed
     *
     * @return True if is needed
     */
    public boolean isSecureModeNeeded() {
        if (ObjectTool.nonNull(secureModeNeeded)) {
            return Boolean.parseBoolean(secureModeNeeded);
        } else {
            return false;
        }
    }

    public void setSecureModeNeeded(String secureModeNeeded) {
        this.secureModeNeeded = secureModeNeeded;
    }

    public String getSecureModeRedirectUrl() {
        return secureModeRedirectUrl;
    }

    public void setSecureModeRedirectUrl(String secureModeRedirectUrl) {
        this.secureModeRedirectUrl = secureModeRedirectUrl;
    }

    public String getSecureModeReturnUrl() {
        return secureModeReturnUrl;
    }

    public void setSecureModeReturnUrl(String secureModeReturnUrl) {
        this.secureModeReturnUrl = secureModeReturnUrl;
    }

    public Long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Long expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPayInId() {
        return payInId;
    }

    public void setPayInId(String payInId) {
        this.payInId = payInId;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public SecurityInfo getSecurityInfo() {
        return securityInfo;
    }

    public void setSecurityInfo(SecurityInfo securityInfo) {
        this.securityInfo = securityInfo;
    }

    public Boolean getMultiCapture() { return multiCapture; }

    public void setMultiCapture(Boolean multiCapture) { this.multiCapture = multiCapture; }

    public Money getRemainingFunds() {
        return remainingFunds;
    }

    public void setRemainingFunds(Money remainingFunds) {
        this.remainingFunds = remainingFunds;
    }

    public String getRequested3DSVersion() { return requested3DSVersion; }

    public void setRequested3DSVersion(String requested3DSVersion) { this.requested3DSVersion = requested3DSVersion; }

    public String getApplied3DSVersion() {  return applied3DSVersion; }

    public void setApplied3DSVersion(String applied3DSVersion) { this.applied3DSVersion = applied3DSVersion; }

    public CultureCode getCulture() {
        return culture;
    }

    public void setCulture(CultureCode culture) {
        this.culture = culture;
    }

    /**
     * Gets map which property is an object and what type of object.
     * To be overridden in child class if has any sub objects.
     *
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {

        HashMap<String, Type> result = new HashMap<>();

        result.put("DebitedFunds", Money.class);
        result.put("RemainingFunds", Money.class);
        result.put("SecurityInfo", SecurityInfo.class);

        return result;
    }

    /**
     * Gets the collection of read-only fields names.
     *
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {

        ArrayList<String> result = super.getReadOnlyProperties();

        result.add("Status");
        result.add("ResultCode");
        result.add("ResultMessage");

        return result;
    }
}
