package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.PayInPaymentDetails;

import java.lang.reflect.Type;
import java.util.Map;

public class PayInPaymentDetailsApplePay extends Dto implements PayInPaymentDetails {

    @SerializedName("PaymentData")
    private PaymentData paymentData;

    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    public PaymentData getPaymentData() {
        return paymentData;
    }

    public PayInPaymentDetailsApplePay setPaymentData(PaymentData paymentData) {
        this.paymentData = paymentData;
        return this;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public PayInPaymentDetailsApplePay setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
        return this;
    }

    @Override
    public Map<String, Type> getSubObjects() {
        Map<String, Type> subObjects = super.getSubObjects();

        subObjects.put("PaymentData", PaymentData.class);

        return subObjects;
    }
}
