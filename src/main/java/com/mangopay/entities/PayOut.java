package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
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
     */
    @SerializedName("DebitedWalletId")
    private String debitedWalletId;

    /**
     * Payment type.
     */
    @SerializedName("PaymentType")
    private PayOutPaymentType paymentType;

    /**
     * One of PayOutPaymentDetails implementations, depending on PaymentType.
     */
    @SerializedName("MeanOfPaymentDetails")
    private PayOutPaymentDetails meanOfPaymentDetails;

    public String getDebitedWalletId() {
        return debitedWalletId;
    }

    public void setDebitedWalletId(String debitedWalletId) {
        this.debitedWalletId = debitedWalletId;
    }

    public PayOutPaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PayOutPaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PayOutPaymentDetails getMeanOfPaymentDetails() {
        return meanOfPaymentDetails;
    }

    public void setMeanOfPaymentDetails(PayOutPaymentDetails meanOfPaymentDetails) {
        this.meanOfPaymentDetails = meanOfPaymentDetails;
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
