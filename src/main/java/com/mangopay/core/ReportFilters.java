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
}
