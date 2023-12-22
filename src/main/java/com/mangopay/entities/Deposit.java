package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.*;
import com.mangopay.core.enumerations.*;
import com.mangopay.entities.subentities.BrowserInfo;
import com.mangopay.entities.subentities.PayinsLinked;

/**
 * Deposit entity.
 */
public class Deposit extends EntityBase {
    @SerializedName("AuthorId")
    private String authorId;

    @SerializedName("DebitedFunds")
    private Money debitedFunds;

    @SerializedName("Status")
    private DepositStatus status;

    @SerializedName("PaymentStatus")
    private PaymentStatus paymentStatus;

    @SerializedName("PayinsLinked")
    private PayinsLinked payinsLinked;

    @SerializedName("ResultCode")
    private String resultCode;

    @SerializedName("ResultMessage")
    private String resultMessage;

    @SerializedName("CardId")
    private String cardId;

    @SerializedName("SecureModeReturnURL")
    private String secureModeReturnUrl;

    @SerializedName("SecureModeRedirectURL")
    private String secureModeRedirectUrl;

    @SerializedName("SecureModeNeeded")
    private Boolean secureModeNeeded;

    @SerializedName("ExpirationDate")
    private Long expirationDate;

    @SerializedName("PaymentType")
    private PayInPaymentType paymentType;

    @SerializedName("ExecutionType")
    private PayInExecutionType executionType;

    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    @SerializedName("Culture")
    private CultureCode culture;

    @SerializedName("IpAddress")
    private String ipAddress;

    @SerializedName("BrowserInfo")
    private BrowserInfo browserInfo;

    @SerializedName("Billing")
    private Billing billing;

    @SerializedName("Shipping")
    private Shipping shipping;

    @SerializedName("Requested3DSVersion")
    private String requested3DSVersion;

    @SerializedName("Applied3DSVersion")
    private String applied3DSVersion;

    @SerializedName("CardInfo")
    private CardInfo cardInfo;

    public CardInfo getCardInfo() {
        return cardInfo;
    }

    public Deposit setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
        return this;
    }

    public String getAuthorId() {
        return authorId;
    }

    public Deposit setAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }

    public Money getDebitedFunds() {
        return debitedFunds;
    }

    public Deposit setDebitedFunds(Money debitedFunds) {
        this.debitedFunds = debitedFunds;
        return this;
    }

    public DepositStatus getStatus() {
        return status;
    }

    public Deposit setStatus(DepositStatus status) {
        this.status = status;
        return this;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public Deposit setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
        return this;
    }

    public PayinsLinked getPayinsLinked() {
        return payinsLinked;
    }

    public Deposit setPayinsLinked(PayinsLinked payinsLinked) {
        this.payinsLinked = payinsLinked;
        return this;
    }

    public String getResultCode() {
        return resultCode;
    }

    public Deposit setResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public Deposit setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
        return this;
    }

    public String getCardId() {
        return cardId;
    }

    public Deposit setCardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    public String getSecureModeReturnUrl() {
        return secureModeReturnUrl;
    }

    public Deposit setSecureModeReturnUrl(String secureModeReturnUrl) {
        this.secureModeReturnUrl = secureModeReturnUrl;
        return this;
    }

    public String getSecureModeRedirectUrl() {
        return secureModeRedirectUrl;
    }

    public Deposit setSecureModeRedirectUrl(String secureModeRedirectUrl) {
        this.secureModeRedirectUrl = secureModeRedirectUrl;
        return this;
    }

    public Boolean getSecureModeNeeded() {
        return secureModeNeeded;
    }

    public Deposit setSecureModeNeeded(Boolean secureModeNeeded) {
        this.secureModeNeeded = secureModeNeeded;
        return this;
    }

    public Long getExpirationDate() {
        return expirationDate;
    }

    public Deposit setExpirationDate(Long expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public PayInPaymentType getPaymentType() {
        return paymentType;
    }

    public Deposit setPaymentType(PayInPaymentType paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public PayInExecutionType getExecutionType() {
        return executionType;
    }

    public Deposit setExecutionType(PayInExecutionType executionType) {
        this.executionType = executionType;
        return this;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public Deposit setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
        return this;
    }

    public CultureCode getCulture() {
        return culture;
    }

    public Deposit setCulture(CultureCode culture) {
        this.culture = culture;
        return this;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Deposit setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public Deposit setBrowserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
        return this;
    }

    public Billing getBilling() {
        return billing;
    }

    public Deposit setBilling(Billing billing) {
        this.billing = billing;
        return this;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public Deposit setShipping(Shipping shipping) {
        this.shipping = shipping;
        return this;
    }

    public String getRequested3DSVersion() {
        return requested3DSVersion;
    }

    public Deposit setRequested3DSVersion(String requested3DSVersion) {
        this.requested3DSVersion = requested3DSVersion;
        return this;
    }

    public String getApplied3DSVersion() {
        return applied3DSVersion;
    }

    public Deposit setApplied3DSVersion(String applied3DSVersion) {
        this.applied3DSVersion = applied3DSVersion;
        return this;
    }
}
