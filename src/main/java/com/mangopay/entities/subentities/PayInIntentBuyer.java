package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

public class PayInIntentBuyer extends Dto {
    /**
     * The unique identifier of the user at the source of the transaction
     */
    @SerializedName("Id")
    private String id;

    public String getId() {
        return id;
    }

    public PayInIntentBuyer setId(String id) {
        this.id = id;
        return this;
    }
}
