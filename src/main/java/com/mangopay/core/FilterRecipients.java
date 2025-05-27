package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Filter for recipients list.
 */
public class FilterRecipients extends Dto {

    @SerializedName("RecipientScope")
    private String recipientScope;

    public String getRecipientScope() {
        return recipientScope;
    }

    public FilterRecipients setRecipientScope(String recipientScope) {
        this.recipientScope = recipientScope;
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
        if (recipientScope != null) result.put("RecipientScope", recipientScope);
        return result;
    }
}
