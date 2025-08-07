package com.mangopay.core;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.enumerations.CurrencyIso;

/**
 * Filter for report V2 (2025)
 */
public class ReportFilters extends Dto {
    @SerializedName("Currency")
    private CurrencyIso currency;

    @SerializedName("UserId")
    private String userId;

    @SerializedName("WalletId")
    private String walletId;

    @SerializedName("PaymentMethod")
    private String paymentMethod;

    @SerializedName("Status")
    private String status;

    @SerializedName("Type")
    private String type;

    @SerializedName("IntentId")
    private String intentId;

    @SerializedName("ExternalProviderName")
    private String externalProviderName;

    @SerializedName("Scheduled")
    private Boolean scheduled;

    public CurrencyIso getCurrency() {
        return currency;
    }

    public ReportFilters setCurrency(CurrencyIso currency) {
        this.currency = currency;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public ReportFilters setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getWalletId() {
        return walletId;
    }

    public ReportFilters setWalletId(String walletId) {
        this.walletId = walletId;
        return this;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public ReportFilters setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ReportFilters setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getType() {
        return type;
    }

    public ReportFilters setType(String type) {
        this.type = type;
        return this;
    }

    public String getExternalProviderName() {
        return externalProviderName;
    }

    public ReportFilters setExternalProviderName(String externalProviderName) {
        this.externalProviderName = externalProviderName;
        return this;
    }

    public String getIntentId() {
        return intentId;
    }

    public ReportFilters setIntentId(String intentId) {
        this.intentId = intentId;
        return this;
    }

    public Boolean getScheduled() {
        return scheduled;
    }

    public ReportFilters setScheduled(Boolean scheduled) {
        this.scheduled = scheduled;
        return this;
    }
}
