package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.*;
import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.core.enumerations.CultureCode;
import com.mangopay.core.interfaces.PayInPaymentDetails;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Class representing the KLARNA type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsKlarna extends Dto implements PayInPaymentDetails {


    @SerializedName("LineItems")
    private List<LineItem> lineItems;

    @SerializedName("Billing")
    private Billing billing;

    @SerializedName("Shipping")
    private Shipping shipping;

    @SerializedName("PaymentMethod")
    private String paymentMethod;

    @SerializedName("MerchantOrderId")
    private String merchantOrderId;

    @SerializedName("Country")
    private CountryIso country;

    @SerializedName("Culture")
    private CultureCode culture;

    @SerializedName("Phone")
    private String phone;

    @SerializedName("Email")
    private String email;

    @SerializedName("AdditionalData")
    private String additionalData;

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public PayInPaymentDetailsKlarna setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
        return this;
    }

    public Billing getBilling() {
        return billing;
    }

    public PayInPaymentDetailsKlarna setBilling(Billing billing) {
        this.billing = billing;
        return this;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public PayInPaymentDetailsKlarna setShipping(Shipping shipping) {
        this.shipping = shipping;
        return this;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public PayInPaymentDetailsKlarna setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public PayInPaymentDetailsKlarna setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
        return this;
    }

    public CountryIso getCountry() {
        return country;
    }

    public PayInPaymentDetailsKlarna setCountry(CountryIso country) {
        this.country = country;
        return this;
    }

    public CultureCode getCulture() {
        return culture;
    }

    public PayInPaymentDetailsKlarna setCulture(CultureCode culture) {
        this.culture = culture;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public PayInPaymentDetailsKlarna setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PayInPaymentDetailsKlarna setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public PayInPaymentDetailsKlarna setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
        return this;
    }

    @Override
    public Map<String, Type> getSubObjects() {
        Map<String, Type> subObjects = super.getSubObjects();

        subObjects.put("Billing", Billing.class);
        subObjects.put("Shipping", Shipping.class);
        subObjects.put("Country", CountryIso.class);
        subObjects.put("Culture", CultureCode.class);
        return subObjects;
    }
}
