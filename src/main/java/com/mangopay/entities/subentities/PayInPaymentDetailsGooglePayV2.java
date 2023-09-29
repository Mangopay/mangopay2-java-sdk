package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.*;
import com.mangopay.core.interfaces.PayInPaymentDetails;

import java.lang.reflect.Type;
import java.util.Map;

public class PayInPaymentDetailsGooglePayV2 extends Dto implements PayInPaymentDetails {

    @SerializedName("PaymentData")
    private String paymentData;

    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    @SerializedName("Shipping")
    private Shipping shipping;

    @SerializedName("IpAddress")
    private String ipAddress;

    @SerializedName("RedirectURL")
    private String redirectUrl;

    @SerializedName("ReturnURL")
    private String returnUrl;

    @SerializedName("BrowserInfo")
    private BrowserInfo browserInfo;

    public String getPaymentData() {
        return paymentData;
    }

    public PayInPaymentDetailsGooglePayV2 setPaymentData(String paymentData) {
        this.paymentData = paymentData;
        return this;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public PayInPaymentDetailsGooglePayV2 setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
        return this;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public PayInPaymentDetailsGooglePayV2 setShipping(Shipping shipping) {
        this.shipping = shipping;
        return this;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public PayInPaymentDetailsGooglePayV2 setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public PayInPaymentDetailsGooglePayV2 setBrowserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
        return this;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public PayInPaymentDetailsGooglePayV2 setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
        return this;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public PayInPaymentDetailsGooglePayV2 setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
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