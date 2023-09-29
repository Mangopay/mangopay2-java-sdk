package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.enumerations.PayInExecutionType;
import com.mangopay.core.enumerations.PayInPaymentType;
import com.mangopay.core.interfaces.PayInExecutionDetails;
import com.mangopay.core.interfaces.PayInPaymentDetails;
import com.mangopay.entities.subentities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * PayIn entity.
 */
public class PayIn extends Transaction {

    /**
     * Credited wallet identifier.
     */
    @SerializedName("CreditedWalletId")
    private String creditedWalletId;

    /**
     * Type of payment.
     */
    @SerializedName("PaymentType")
    private PayInPaymentType paymentType;

    /**
     * One of PayInPaymentDetails implementations, depending on PaymentType.
     */
    @SerializedName("PaymentDetails")
    private PayInPaymentDetails paymentDetails;

    /**
     * Type of execution.
     */
    @SerializedName("ExecutionType")
    private PayInExecutionType executionType;

    /**
     * One of PayInExecutionDetails implementations, depending on ExecutionType.
     */
    @SerializedName("ExecutionDetails")
    private PayInExecutionDetails executionDetails;

    public String getCreditedWalletId() {
        return creditedWalletId;
    }

    public void setCreditedWalletId(String creditedWalletId) {
        this.creditedWalletId = creditedWalletId;
    }

    public PayInPaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PayInPaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PayInPaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PayInPaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public PayInExecutionType getExecutionType() {
        return executionType;
    }

    public void setExecutionType(PayInExecutionType executionType) {
        this.executionType = executionType;
    }

    public PayInExecutionDetails getExecutionDetails() {
        return executionDetails;
    }

    public void setExecutionDetails(PayInExecutionDetails executionDetails) {
        this.executionDetails = executionDetails;
    }

    /**
     * Gets the structure that maps which property depends on other property.
     *
     * @return
     */
    @Override
    public Map<String, Map<String, Map<String, Class<?>>>> getDependentObjects() {

        return new HashMap<String, Map<String, Map<String, Class<?>>>>() {{
            put("PaymentType", new HashMap<String, Map<String, Class<?>>>() {{
                        put("CARD", new HashMap<String, Class<?>>() {{
                                    put("PaymentDetails", PayInPaymentDetailsCard.class);
                                }}
                        );
                        put("PREAUTHORIZED", new HashMap<String, Class<?>>() {{
                                    put("PaymentDetails", PayInPaymentDetailsPreAuthorized.class);
                                }}
                        );
                        put("BANK_WIRE", new HashMap<String, Class<?>>() {{
                                    put("PaymentDetails", PayInPaymentDetailsBankWire.class);
                                }}
                        );
                        put("DIRECT_DEBIT", new HashMap<String, Class<?>>() {{
                                    put("PaymentDetails", PayInPaymentDetailsDirectDebit.class);
                                }}
                        );
                        put("PAYPAL", new HashMap<String, Class<?>>() {{
                                    put("PaymentDetails", PayInPaymentDetailsPayPal.class);
                                }}
                        );
                        put("GOOGLEPAY", new HashMap<String, Class<?>>() {{
                                    put("PaymentDetails", PayInPaymentDetailsGooglePay.class);
                                }}
                        );
                        put("PAYCONIQ", new HashMap<String, Class<?>>(){{
                                    put("PaymentDetails", PayInPaymentDetailsPayconiq.class);
                                }}
                        );
                        put("MBWAY", new HashMap<String, Class<?>>() {{
                                    put("PaymentDetails", PayInPaymentDetailsMbway.class);
                                }}
                         );
                        put("SATISPAY", new HashMap<String, Class<?>>() {{
                                put("PaymentDetails", PayInPaymentDetailsSatispay.class);
                            }}
                        );
                        put("BLIK", new HashMap<String, Class<?>>() {{
                                put("PaymentDetails", PayInPaymentDetailsBlik.class);
                            }}
                        );
                        put("MULTIBANCO", new HashMap<String, Class<?>>() {{
                                put("PaymentDetails", PayInPaymentDetailsMultibanco.class);
                            }}
                        );
                        // ...and more in future...
                    }}
            );
            put("ExecutionType", new HashMap<String, Map<String, Class<?>>>() {{
                        put("WEB", new HashMap<String, Class<?>>() {{
                                    put("ExecutionDetails", PayInExecutionDetailsWeb.class);
                                }}
                        );
                        put("DIRECT", new HashMap<String, Class<?>>() {{
                                    put("ExecutionDetails", PayInExecutionDetailsDirect.class);
                                }}
                        );
                        put("EXTERNAL_INSTRUCTION", new HashMap<String, Class<?>>() {{
                                    put("ExecutionDetails", PayInExecutionDetailsBankingAlias.class);
                                }}
                        );
                        // ...and more in future...
                    }}
            );
        }};
    }

    /**
     * Gets the collection of read-only fields names.
     *
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {

        ArrayList<String> result = super.getReadOnlyProperties();

        result.add("PaymentType");
        result.add("ExecutionType");

        return result;
    }
}
