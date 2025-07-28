package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class FilterPayByBankSupportedBanks extends Dto {
    @SerializedName("CountryCodes")
    private String countryCodes;

    public String getCountryCodes() {
        return countryCodes;
    }

    public FilterPayByBankSupportedBanks setCountryCodes(String countryCodes) {
        this.countryCodes = countryCodes;
        return this;
    }

    /**
     * Gets map of fields and values.
     *
     * @return Collection of field name-field value pairs.
     */
    @Override
    public Map<String, String> getValues() {
        HashMap<String, String> result = new HashMap<>();

        if (countryCodes != null) result.put("CountryCodes", countryCodes);

        return result;
    }
}
