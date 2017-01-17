package com.mangopay.entities;

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
     *
     * @deprecated Use {@link #getCreditedWalletId()} and {@link #setCreditedWalletId(String)} instead.
     */
    @Deprecated
    public String CreditedWalletId;

    /**
     * Type of payment.
     *
     * @deprecated Use {@link #getPaymentType()} and {@link #setPaymentType(PayInPaymentType)} instead.
     */
    @Deprecated
    public PayInPaymentType PaymentType;

    /**
     * One of PayInPaymentDetails implementations, depending on PaymentType.
     *
     * @deprecated Use {@link #getPaymentDetails()} and {@link #setPaymentDetails(PayInPaymentDetails)} instead.
     */
    @Deprecated
    public PayInPaymentDetails PaymentDetails;

    /**
     * Type of execution.
     *
     * @deprecated Use {@link #getExecutionType()} and {@link #setExecutionType(PayInExecutionType)} instead.
     */
    @Deprecated
    public PayInExecutionType ExecutionType;

    /**
     * One of PayInExecutionDetails implementations, depending on ExecutionType.
     *
     * @deprecated Use {@link #getExecutionDetails()} and {@link #setExecutionDetails(PayInExecutionDetails)} instead.
     */
    @Deprecated
    public PayInExecutionDetails ExecutionDetails;

    public String getCreditedWalletId() {
        return CreditedWalletId;
    }

    public void setCreditedWalletId(String creditedWalletId) {
        this.CreditedWalletId = creditedWalletId;
    }

    public PayInPaymentType getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(PayInPaymentType paymentType) {
        this.PaymentType = paymentType;
    }

    public PayInPaymentDetails getPaymentDetails() {
        return PaymentDetails;
    }

    public void setPaymentDetails(PayInPaymentDetails paymentDetails) {
        this.PaymentDetails = paymentDetails;
    }

    public PayInExecutionType getExecutionType() {
        return ExecutionType;
    }

    public void setExecutionType(PayInExecutionType executionType) {
        this.ExecutionType = executionType;
    }

    public PayInExecutionDetails getExecutionDetails() {
        return ExecutionDetails;
    }

    public void setExecutionDetails(PayInExecutionDetails executionDetails) {
        this.ExecutionDetails = executionDetails;
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
