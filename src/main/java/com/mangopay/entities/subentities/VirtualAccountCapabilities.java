package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.enumerations.CurrencyIso;

import java.util.List;

public class VirtualAccountCapabilities extends Dto {

    /**
     * Whether local bank wires can be made to this account.
     */
    @SerializedName("LocalPayInAvailable")
    private Boolean localPayInAvailable;

    /**
     * Whether international bank wires can be made to this account
     */
    @SerializedName("InternationalPayInAvailable")
    private Boolean internationalPayInAvailable;

    /**
     * List of currencies supported by the account
     */
    @SerializedName("Currencies")
    private List<CurrencyIso> currencies;

    public VirtualAccountCapabilities(Boolean localPayInAvailable, Boolean internationalPayInAvailable, List<CurrencyIso> currencies) {
        this.localPayInAvailable = localPayInAvailable;
        this.internationalPayInAvailable = internationalPayInAvailable;
        this.currencies = currencies;
    }


    public Boolean getLocalPayInAvailable() {
        return localPayInAvailable;
    }

    public VirtualAccountCapabilities setLocalPayInAvailable(Boolean localPayInAvailable) {
        this.localPayInAvailable = localPayInAvailable;
        return this;
    }

    public Boolean getInternationalPayInAvailable() {
        return internationalPayInAvailable;
    }

    public VirtualAccountCapabilities setInternationalPayInAvailable(Boolean internationalPayInAvailable) {
        this.internationalPayInAvailable = internationalPayInAvailable;
        return this;
    }

    public List<CurrencyIso> getCurrencies() {
        return currencies;
    }

    public VirtualAccountCapabilities setCurrencies(List<CurrencyIso> currencies) {
        this.currencies = currencies;
        return this;
    }
}
