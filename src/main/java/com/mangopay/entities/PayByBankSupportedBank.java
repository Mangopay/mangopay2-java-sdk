package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.entities.subentities.SupportedBank;

public class PayByBankSupportedBank extends Dto {
    @SerializedName("SupportedBanks")
    private SupportedBank supportedBanks;

    public SupportedBank getSupportedBanks() {
        return supportedBanks;
    }

    public PayByBankSupportedBank setSupportedBanks(SupportedBank supportedBanks) {
        this.supportedBanks = supportedBanks;
        return this;
    }
}
