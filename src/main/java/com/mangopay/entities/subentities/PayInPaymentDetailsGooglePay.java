package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.*;
import com.mangopay.core.interfaces.PayInPaymentDetails;

import java.lang.reflect.Type;
import java.util.Map;

public class PayInPaymentDetailsGooglePay extends Dto implements PayInPaymentDetails {

    @SerializedName("PaymentData")
    private String paymentData;

    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    @SerializedName("Billing")
    private Billing billing;

    @SerializedName("Shipping")
    private Shipping shipping;

    @SerializedName("AuthorId")
    private String authorId;

    @SerializedName("CreditedWalletId")
    private String creditedWalletId;

    @SerializedName("DebitedFunds")
    private DebitedFunds debitedFunds;

    @SerializedName("Fees")
    private Fees fees;

    @SerializedName("Tag")
    private String tag;

    @SerializedName("IpAddress")
    private String ipAddress;

    @SerializedName("SecureModeReturnURL")
    private String secureModeReturnURL;

    @SerializedName("SecureMode")
    private String secureMode;

    @SerializedName("ReturnURL")
    private String returnURL;

    @SerializedName("BrowserInfo")
    private BrowserInfo browserInfo;

    public String getPaymentData() {
        return paymentData;
    }

    public PayInPaymentDetailsGooglePay setPaymentData(String paymentData) {
        this.paymentData = paymentData;
        return this;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public PayInPaymentDetailsGooglePay setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
        return this;
    }

    public Billing getBilling() {
        return billing;
    }

    public PayInPaymentDetailsGooglePay setBilling(Billing billing) {
        this.billing = billing;
        return this;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getCreditedWalletId() {
        return creditedWalletId;
    }

    public void setCreditedWalletId(String creditedWalletId) {
        this.creditedWalletId = creditedWalletId;
    }

    public DebitedFunds getDebitedFunds() {
        return debitedFunds;
    }

    public void setDebitedFunds(DebitedFunds debitedFunds) {
        this.debitedFunds = debitedFunds;
    }

    public Fees getFees() {
        return fees;
    }

    public void setFees(Fees fees) {
        this.fees = fees;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getSecureModeReturnURL() {
        return secureModeReturnURL;
    }

    public void setSecureModeReturnURL(String secureModeReturnURL) {
        this.secureModeReturnURL = secureModeReturnURL;
    }

    public String getSecureMode() {
        return secureMode;
    }

    public void setSecureMode(String secureMode) {
        this.secureMode = secureMode;
    }

    public String getReturnURL() {
        return returnURL;
    }

    public void setReturnURL(String returnURL) {
        this.returnURL = returnURL;
    }

    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public void setBrowserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
    }

    @Override
    public Map<String, Type> getSubObjects() {
        Map<String, Type> subObjects = super.getSubObjects();

        subObjects.put("Billing", Billing.class);
        subObjects.put("Shipping", Shipping.class);
        subObjects.put("DebitedFunds", DebitedFunds.class);
        subObjects.put("Fees", Fees.class);
        subObjects.put("BrowserInfo", BrowserInfo.class);

        return subObjects;
    }
}
