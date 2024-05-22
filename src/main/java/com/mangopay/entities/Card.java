package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.CardType;
import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.core.enumerations.Validity;
import com.mangopay.core.Shipping;

import java.util.ArrayList;

/**
 * Card entity.
 */
public class Card extends EntityBase {

    /**
     * User Id.
     */
    @SerializedName("UserId")
    private String userId;

    /**
     * Country.
     */
    @SerializedName("Country")
    private String country;

    /**
     * Expiration date.
     */
    @SerializedName("ExpirationDate")
    private String expirationDate;

    /**
     * Alias.
     */
    @SerializedName("Alias")
    private String alias;

    /**
     * The card provider, it could be CB, VISA, MASTERCARD, etc.
     */
    @SerializedName("CardProvider")
    private String cardProvider;

    /**
     * Card type.
     */
    @SerializedName("CardType")
    private CardType cardType;

    /**
     * Product codes.
     */
    @SerializedName("Product")
    private String product;

    /**
     * Bank code.
     */
    @SerializedName("BankCode")
    private String bankCode;

    /**
     * Active.
     */
    @SerializedName("Active")
    private Boolean active;

    /**
     * The currency accepted in the wallet.
     */
    @SerializedName("Currency")
    private CurrencyIso currency;

    /**
     * Validity.
     */
    @SerializedName("Validity")
    private Validity validity;

    /**
     * Card's fingerprint, which is unique per 16-digit card number.
     */
    @SerializedName("Fingerprint")
    private String fingerprint;

    @SerializedName("Shipping")
    private Shipping shipping;

    /**
     * The cardholder’s name shown on the payment card.
     */
    @SerializedName("CardHolderName")
    private String cardHolderName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCardProvider() {
        return cardProvider;
    }

    public void setCardProvider(String cardProvider) {
        this.cardProvider = cardProvider;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public CurrencyIso getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyIso currency) {
        this.currency = currency;
    }

    public Validity getValidity() {
        return validity;
    }

    public void setValidity(Validity validity) {
        this.validity = validity;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public Shipping getShipping() { return shipping; }

    public void setShipping(Shipping shipping) { this.shipping = shipping; }

    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
     * Gets the collection of read-only fields names.
     *
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {

        ArrayList<String> result = super.getReadOnlyProperties();

        result.add("UserId");
        result.add("Country");
        result.add("ExpirationDate");
        result.add("Alias");
        result.add("CardProvider");
        result.add("CardType");
        result.add("Product");
        result.add("BankCode");
        result.add("Active");
        result.add("Currency");
        result.add("Fingerprint");

        return result;
    }
}
