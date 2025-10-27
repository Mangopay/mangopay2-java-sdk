package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.CardType;
import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.core.enumerations.PayInExecutionType;
import com.mangopay.core.enumerations.PayInPaymentType;

public class ExtendedWebCardPayIn extends EntityBase {
    @SerializedName("PaymentType")
    private PayInPaymentType paymentType;

    @SerializedName("ExecutionType")
    private PayInExecutionType executionType;

    @SerializedName("ExpirationDate")
    private String expirationDate;

    @SerializedName("Alias")
    private String alias;

    @SerializedName("CardType")
    private CardType cardType;

    @SerializedName("Country")
    private CountryIso country;

    @SerializedName("Fingerprint")
    private String fingerprint;

    public PayInPaymentType getPaymentType() {
        return paymentType;
    }

    public ExtendedWebCardPayIn setPaymentType(PayInPaymentType paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public PayInExecutionType getExecutionType() {
        return executionType;
    }

    public ExtendedWebCardPayIn setExecutionType(PayInExecutionType executionType) {
        this.executionType = executionType;
        return this;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public ExtendedWebCardPayIn setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public ExtendedWebCardPayIn setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public CardType getCardType() {
        return cardType;
    }

    public ExtendedWebCardPayIn setCardType(CardType cardType) {
        this.cardType = cardType;
        return this;
    }

    public CountryIso getCountry() {
        return country;
    }

    public ExtendedWebCardPayIn setCountry(CountryIso country) {
        this.country = country;
        return this;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public ExtendedWebCardPayIn setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
        return this;
    }
}
