package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;


public class PayInIntentExternalData extends Dto {
    /**
     * The date at which the transaction was created
     */
    @SerializedName("ExternalProcessingDate")
    private String externalProcessingDate;

    /**
     * The unique identifier of the transaction at the provider level
     */
    @SerializedName("ExternalProviderReference")
    private String externalProviderReference;

    /**
     * The unique identifier of the transaction at the merchant level
     */
    @SerializedName("ExternalMerchantReference")
    private String externalMerchantReference;

    /**
     * The name of the external provider processing the transaction
     */
    @SerializedName("ExternalProviderName")
    private String externalProviderName;

    /**
     * The name of the payment method used to process the transaction
     */
    @SerializedName("ExternalProviderPaymentMethod")
    private String externalProviderPaymentMethod;

    public String getExternalProcessingDate() {
        return externalProcessingDate;
    }

    public PayInIntentExternalData setExternalProcessingDate(String externalProcessingDate) {
        this.externalProcessingDate = externalProcessingDate;
        return this;
    }

    public String getExternalProviderReference() {
        return externalProviderReference;
    }

    public PayInIntentExternalData setExternalProviderReference(String externalProviderReference) {
        this.externalProviderReference = externalProviderReference;
        return this;
    }

    public String getExternalMerchantReference() {
        return externalMerchantReference;
    }

    public PayInIntentExternalData setExternalMerchantReference(String externalMerchantReference) {
        this.externalMerchantReference = externalMerchantReference;
        return this;
    }

    public String getExternalProviderName() {
        return externalProviderName;
    }

    public PayInIntentExternalData setExternalProviderName(String externalProviderName) {
        this.externalProviderName = externalProviderName;
        return this;
    }

    public String getExternalProviderPaymentMethod() {
        return externalProviderPaymentMethod;
    }

    public PayInIntentExternalData setExternalProviderPaymentMethod(String externalProviderPaymentMethod) {
        this.externalProviderPaymentMethod = externalProviderPaymentMethod;
        return this;
    }
}
