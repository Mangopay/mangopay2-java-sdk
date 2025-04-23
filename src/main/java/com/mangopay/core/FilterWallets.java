package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class FilterWallets extends Dto {

    /**
     * Possible values: USER_NOT_PRESENT, USER_PRESENT
     */
    @SerializedName("ScaContext")
    private String scaContext;

    public String getScaContext() {
        return scaContext;
    }

    public FilterWallets setScaContext(String scaContext) {
        this.scaContext = scaContext;
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

        if (scaContext != null) result.put("ScaContext", scaContext);

        return result;
    }
}
