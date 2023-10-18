package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.LineItem;
import com.mangopay.core.Shipping;
import com.mangopay.core.ShippingAddress;
import com.mangopay.core.enumerations.ShippingPreference;
import com.mangopay.core.interfaces.PayInPaymentDetails;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Class representing the PayPal type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsPayPal extends Dto implements PayInPaymentDetails {

    /**
     * Address used instead of the user's PayPal account address.
     */
    @Deprecated
    @SerializedName("ShippingAddress")
    private ShippingAddress shippingAddress;

    @Deprecated
    @SerializedName("PaypalBuyerAccountEmail")
    private String paypalBuyerAccountEmail;


    /// V2 ///

    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    @SerializedName("Shipping")
    private Shipping shipping;

    @SerializedName("LineItems")
    private List<LineItem> lineItems;

    @SerializedName("ShippingPreference")
    private ShippingPreference shippingPreference;

    @SerializedName("Reference")
    private String reference;

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public PayInPaymentDetailsPayPal setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
        return this;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public PayInPaymentDetailsPayPal setShipping(Shipping shipping) {
        this.shipping = shipping;
        return this;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public PayInPaymentDetailsPayPal setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
        return this;
    }

    @Override
    public Map<String, Type> getSubObjects() {
        Map<String, Type> subObjects = super.getSubObjects();

        subObjects.put("ShippingAddress", ShippingAddress.class);
        subObjects.put("Shipping", Shipping.class);

        return subObjects;
    }

    public String getPaypalBuyerAccountEmail() {
        return paypalBuyerAccountEmail;
    }

    public PayInPaymentDetailsPayPal setPaypalBuyerAccountEmail(String paypalBuyerAccountEmail) {
        this.paypalBuyerAccountEmail = paypalBuyerAccountEmail;
        return this;
    }

    public ShippingPreference getShippingPreference() {
        return shippingPreference;
    }

    public void setShippingPreference(ShippingPreference shippingPreference) {
        this.shippingPreference = shippingPreference;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
