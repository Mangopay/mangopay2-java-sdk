package com.mangopay.core;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.enumerations.PaymentStatus;
import com.mangopay.core.enumerations.PreAuthorizationStatus;

import java.util.HashMap;
import java.util.Map;

/**
    Filter for PreAuthorizations
 */
public class FilterPreAuthorizations extends Dto {

    private static final String RESULT_CODE = "ResultCode";

    private static final String STATUS = "Status";

    private static final String PAYMENT_STATUS = "PaymentStatus";

    @SerializedName("ResultCode")
    private String resultCode;

    @SerializedName("Status")
    private PreAuthorizationStatus preAuthorizationStatus;

    @SerializedName("PaymentStatus")
    private PaymentStatus paymentStatus;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public PreAuthorizationStatus getPreAuthorizationStatus() {
        return preAuthorizationStatus;
    }

    public void setPreAuthorizationStatus(PreAuthorizationStatus preAuthorizationStatus) {
        this.preAuthorizationStatus = preAuthorizationStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public Map<String, String> getValues() {
        HashMap<String, String> result = new HashMap<>();

        if (!this.resultCode.isEmpty()) { result.put(RESULT_CODE, this.resultCode.toString()); }
        if (this.preAuthorizationStatus != PreAuthorizationStatus.NotSpecified) { result.put(STATUS, this.preAuthorizationStatus.toString()); }
        if (this.paymentStatus != PaymentStatus.NotSpecified) { result.put(PAYMENT_STATUS, this.paymentStatus.toString()); }

        return result;
    }
}
