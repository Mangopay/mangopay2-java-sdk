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

    @SerializedName("CancelURL")
    private String cancelUrl;

    @SerializedName("PaypalPayerID")
    private String paypalPayerId;

    @SerializedName("BuyerCountry")
    private String buyerCountry;

    @SerializedName("BuyerFirstname")
    private String buyerFirstName;

    @SerializedName("BuyerLastname")
    private String buyerLastName;

    @SerializedName("BuyerPhone")
    private String buyerPhone;

    @SerializedName("PaypalOrderID")
    private String paypalOrderID;

    @SerializedName("PaypalBuyerAccountEmail")
    private String paypalBuyerAccountEmail;

    @SerializedName("Trackings")
    private List<PayPalWebTracking> trackings;

    @SerializedName("DataCollectionId")
    private String dataCollectionId;

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

    public String getCancelUrl() {
        return cancelUrl;
    }

    public PayInPaymentDetailsPayPal setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
        return this;
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

    public PayInPaymentDetailsPayPal setShippingPreference(ShippingPreference shippingPreference) {
        this.shippingPreference = shippingPreference;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public PayInPaymentDetailsPayPal setReference(String reference) {
        this.reference = reference;
        return this;
    }

    public String getPaypalPayerId() {
        return paypalPayerId;
    }

    public PayInPaymentDetailsPayPal setPaypalPayerId(String paypalPayerId) {
        this.paypalPayerId = paypalPayerId;
        return this;
    }

    public String getBuyerCountry() {
        return buyerCountry;
    }

    public PayInPaymentDetailsPayPal setBuyerCountry(String buyerCountry) {
        this.buyerCountry = buyerCountry;
        return this;
    }

    public String getBuyerFirstName() {
        return buyerFirstName;
    }

    public PayInPaymentDetailsPayPal setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
        return this;
    }

    public String getBuyerLastName() {
        return buyerLastName;
    }

    public PayInPaymentDetailsPayPal setBuyerLastName(String buyerLastName) {
        this.buyerLastName = buyerLastName;
        return this;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public PayInPaymentDetailsPayPal setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
        return this;
    }

    public String getPaypalOrderID() {
        return paypalOrderID;
    }

    public PayInPaymentDetailsPayPal setPaypalOrderID(String paypalOrderID) {
        this.paypalOrderID = paypalOrderID;
        return this;
    }

    public List<PayPalWebTracking> getTrackings() {
        return trackings;
    }

    public PayInPaymentDetailsPayPal setTrackings(List<PayPalWebTracking> trackings) {
        this.trackings = trackings;
        return this;
    }

    public String getDataCollectionId() {
        return dataCollectionId;
    }

    public PayInPaymentDetailsPayPal setDataCollectionId(String dataCollectionId) {
        this.dataCollectionId = dataCollectionId;
        return this;
    }

    @Override
    public Map<String, Type> getSubObjects() {
        Map<String, Type> subObjects = super.getSubObjects();

        subObjects.put("ShippingAddress", ShippingAddress.class);
        subObjects.put("Shipping", Shipping.class);

        return subObjects;
    }
}
