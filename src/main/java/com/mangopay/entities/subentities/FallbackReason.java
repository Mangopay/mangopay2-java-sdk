package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;

public class FallbackReason  {
    @SerializedName("Code")
    private String code;

    @SerializedName("Message")
    private String message;

    public String getCode() {
        return code;
    }

    public FallbackReason setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public FallbackReason setMessage(String message) {
        this.message = message;
        return this;
    }
}
