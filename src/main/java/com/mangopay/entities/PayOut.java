package com.mangopay.entities;

import com.mangopay.core.enumerations.PayOutPaymentType;
import com.mangopay.core.interfaces.PayOutPaymentDetails;
import com.mangopay.entities.subentities.PayOutPaymentDetailsBankWire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * PayOut entity.
 */
public class PayOut extends Transaction {

    /**
     * Debited wallet identifier.
     *
     * @deprecated Use {@link #getDebitedWalletId()} and {@link #setDebitedWalletId(String)} instead.
     */
    @Deprecated
    public String DebitedWalletId;

    /**
     * Payment type.
     *
     * @deprecated Use {@link #getPaymentType()} and {@link #setPaymentType(PayOutPaymentType)} instead.
     */
    @Deprecated
    public PayOutPaymentType PaymentType;

    /**
     * One of PayOutPaymentDetails implementations, depending on PaymentType.
     *
     * @deprecated Use {@link #getMeanOfPaymentDetails()} and {@link #setMeanOfPaymentDetails(PayOutPaymentDetails)} instead.
     */
    @Deprecated
    public PayOutPaymentDetails MeanOfPaymentDetails;

    public String getDebitedWalletId() {
        return DebitedWalletId;
    }

    public void setDebitedWalletId(String debitedWalletId) {
        this.DebitedWalletId = debitedWalletId;
    }

    public PayOutPaymentType getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(PayOutPaymentType paymentType) {
        this.PaymentType = paymentType;
    }

    public PayOutPaymentDetails getMeanOfPaymentDetails() {
        return MeanOfPaymentDetails;
    }

    public void setMeanOfPaymentDetails(PayOutPaymentDetails meanOfPaymentDetails) {
        this.MeanOfPaymentDetails = meanOfPaymentDetails;
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
                        put("BANK_WIRE", new HashMap<String, Class<?>>() {{
                                    put("MeanOfPaymentDetails", PayOutPaymentDetailsBankWire.class);
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

        return result;
    }
}
