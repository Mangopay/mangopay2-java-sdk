package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;

public class PaymentData extends Dto {

    private String transactionId;

    public String getNetwork() {
        return network;
    }

    public PaymentData setNetwork(String network) {
        this.network = network;
        return this;
    }

    public String getTokenData() {
        return tokenData;
    }

    public PaymentData setTokenData(String tokenData) {
        this.tokenData = tokenData;
        return this;
    }

    private String network;

    private String tokenData;

    public String getTransactionId() {
        return transactionId;
    }

    public PaymentData setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }
}