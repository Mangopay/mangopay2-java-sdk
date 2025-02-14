package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.entities.Recipient;

import java.util.List;

public class UserRecipients extends Dto {
    /**
     * A list of recipients associated with a specific user
     */
    @SerializedName("Recipients")
    private List<Recipient> recipients;

    public List<Recipient> getRecipients() {
        return recipients;
    }

    public UserRecipients setRecipients(List<Recipient> recipients) {
        this.recipients = recipients;
        return this;
    }
}
