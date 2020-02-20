package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Billing;
import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.PayInPaymentDetails;

import java.lang.reflect.Type;
import java.util.Map;

public class PayInPaymentDetailsGooglePay extends Dto implements PayInPaymentDetails {

    @SerializedName("PaymentData")
    private PaymentData paymentData;

    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    @SerializedName("Billing")
    private Billing billing;

    public PaymentData getPaymentData() {
        return paymentData;
    }

    public PayInPaymentDetailsGooglePay setPaymentData(PaymentData paymentData) {
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

    @Override
    public Map<String, Type> getSubObjects() {
        Map<String, Type> subObjects = super.getSubObjects();

        subObjects.put("PaymentData", PaymentData.class);
        subObjects.put("Billing", Billing.class);

        return subObjects;
    }
}
