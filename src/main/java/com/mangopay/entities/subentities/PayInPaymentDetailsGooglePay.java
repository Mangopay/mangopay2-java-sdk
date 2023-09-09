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

    @SerializedName("SecurityInfo")
    private SecurityInfo securityInfo;

    @SerializedName("SecureModeRedirectURL")
    private String secureModeRedirectUrl;

    @SerializedName("SecureModeNeeded")
    private boolean secureModeNeeded;

    public boolean getSecureModeNeeded() {
        return secureModeNeeded;
    }

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

    public PayInPaymentDetailsGooglePay setShipping(Shipping shipping) {
        this.shipping = shipping;
        return this;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public PayInPaymentDetailsGooglePay setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public String getSecureModeReturnURL() {
        return secureModeReturnURL;
    }

    public PayInPaymentDetailsGooglePay setSecureModeReturnURL(String secureModeReturnURL) {
        this.secureModeReturnURL = secureModeReturnURL;
        return this;
    }

    public String getSecureMode() {
        return secureMode;
    }

    public PayInPaymentDetailsGooglePay setSecureMode(String secureMode) {
        this.secureMode = secureMode;
        return this;
    }

    public String getReturnURL() {
        return returnURL;
    }

    public PayInPaymentDetailsGooglePay setReturnURL(String returnURL) {
        this.returnURL = returnURL;
        return this;
    }

    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public PayInPaymentDetailsGooglePay setBrowserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
        return this;
    }

    public PayInPaymentDetailsGooglePay setSecureModeNeeded(boolean secureModeNeeded) {
        this.secureModeNeeded = secureModeNeeded;
        return this;
    }

    public SecurityInfo getSecurityInfo() {
        return securityInfo;
    }

    public PayInPaymentDetailsGooglePay setSecurityInfo(SecurityInfo securityInfo) {
        this.securityInfo = securityInfo;
        return this;
    }

    public String getSecureModeRedirectUrl() {
        return secureModeRedirectUrl;
    }

    public PayInPaymentDetailsGooglePay setSecureModeRedirectUrl(String secureModeRedirectUrl) {
        this.secureModeRedirectUrl = secureModeRedirectUrl;
        return this;
    }

    @Override
    public Map<String, Type> getSubObjects() {
        Map<String, Type> subObjects = super.getSubObjects();

        subObjects.put("Billing", Billing.class);
        subObjects.put("Shipping", Shipping.class);
        subObjects.put("BrowserInfo", BrowserInfo.class);
        subObjects.put("SecurityInfo", SecurityInfo.class);

        return subObjects;
    }
}
