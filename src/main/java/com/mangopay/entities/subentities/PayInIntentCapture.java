package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

import java.util.List;

public class PayInIntentCapture extends Dto {
    /**
     * Unique identifier.
     */
    @SerializedName("Id")
    private String id;

    /**
     * The date at which the object was created
     */
    @SerializedName("CreationDate")
    private Long creationDate;

    /**
     * The date at which the object was successfully moved to CAPTURED
     */
    @SerializedName("ExecutionDate")
    private Long executionDate;

    /**
     * The captured amount
     */
    @SerializedName("Amount")
    private Integer amount;

    /**
     * The status of the capture
     */
    @SerializedName("Status")
    private String status;

    /**
     * Information about the items captured in the transaction.
     */
    @SerializedName("LineItems")
    private List<PayInIntentLineItem> lineItems;

    public String getId() {
        return id;
    }

    public PayInIntentCapture setId(String id) {
        this.id = id;
        return this;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public PayInIntentCapture setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Long getExecutionDate() {
        return executionDate;
    }

    public PayInIntentCapture setExecutionDate(Long executionDate) {
        this.executionDate = executionDate;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public PayInIntentCapture setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public PayInIntentCapture setStatus(String status) {
        this.status = status;
        return this;
    }

    public List<PayInIntentLineItem> getLineItems() {
        return lineItems;
    }

    public PayInIntentCapture setLineItems(List<PayInIntentLineItem> lineItems) {
        this.lineItems = lineItems;
        return this;
    }
}
