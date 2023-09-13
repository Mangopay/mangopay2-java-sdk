package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Billing;
import com.mangopay.core.Dto;
import com.mangopay.core.LineItem;
import com.mangopay.core.Shipping;
import com.mangopay.core.interfaces.PayInPaymentDetails;

import java.util.List;

/**
 * Class representing the KLARNA type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsKlarna extends Dto implements PayInPaymentDetails {

    @SerializedName("LineItems")
    private List<LineItem> lineItems;

    @SerializedName("Shipping")
    private Shipping shipping;

    @SerializedName("Billing")
    private Billing billing;

    @SerializedName("PaymentMethod")
    private String paymentMethod;

    @SerializedName("Country")
    private String country;

    @SerializedName("Culture")
    private String culture;

    @SerializedName("AdditionalData")
    private String additionalData;

    @SerializedName("Phone")
    private String phone;

    @SerializedName("Email")
    private String email;

    @SerializedName("MerchantOrderId")
    private String merchantOrderId;

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }
}
