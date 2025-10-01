package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

public class VerificationOfPayee extends Dto {
    /**
     * A unique identifier of the VOP check performed by Mangopay.
     */
    @SerializedName("RecipientVerificationId")
    private String recipientVerificationId;

    /**
     * The outcome of the VOP check performed by Mangopay
     */
    @SerializedName("RecipientVerificationCheck")
    private String recipientVerificationCheck;

    /**
     * The explanation of the check outcome
     */
    @SerializedName("RecipientVerificationMessage")
    private String recipientVerificationMessage;

    public String getRecipientVerificationId() {
        return recipientVerificationId;
    }

    public VerificationOfPayee setRecipientVerificationId(String recipientVerificationId) {
        this.recipientVerificationId = recipientVerificationId;
        return this;
    }

    public String getRecipientVerificationCheck() {
        return recipientVerificationCheck;
    }

    public VerificationOfPayee setRecipientVerificationCheck(String recipientVerificationCheck) {
        this.recipientVerificationCheck = recipientVerificationCheck;
        return this;
    }

    public String getRecipientVerificationMessage() {
        return recipientVerificationMessage;
    }

    public VerificationOfPayee setRecipientVerificationMessage(String recipientVerificationMessage) {
        this.recipientVerificationMessage = recipientVerificationMessage;
        return this;
    }
}
