package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.CardType;
import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.core.enumerations.Validity;

import java.util.ArrayList;

/**
 * Card entity.
 */
public class Card extends EntityBase {

    /**
     * User Id.
     *
     * @deprecated Use {@link #getUserId()} and {@link #setUserId(String)} instead.
     */
    @Deprecated
    public String UserId;

    /**
     * Country.
     *
     * @deprecated Use {@link #getCountry()} and {@link #setCountry(String)} instead.
     */
    @Deprecated
    public String Country;

    /**
     * Expiration date.
     *
     * @deprecated Use {@link #getExpirationDate()} and {@link #setExpirationDate(String)} instead.
     */
    @Deprecated
    public String ExpirationDate;

    /**
     * Alias.
     *
     * @deprecated Use {@link #getAlias()} and {@link #setAlias(String)} instead.
     */
    @Deprecated
    public String Alias;

    /**
     * The card provider, it could be CB, VISA, MASTERCARD, etc.
     *
     * @deprecated Use {@link #getCardProvider()} and {@link #setCardProvider(String)} instead.
     */
    @Deprecated
    public String CardProvider;

    /**
     * Card type.
     *
     * @deprecated Use {@link #getCardType()} and {@link #setCardType(CardType)} instead.
     */
    @Deprecated
    public CardType CardType;

    /**
     * Product codes.
     *
     * @deprecated Use {@link #getProduct()} and {@link #setProduct(String)} instead.
     */
    @Deprecated
    public String Product;

    /**
     * Bank code.
     *
     * @deprecated Use {@link #getBankCode()} and {@link #setBankCode(String)} instead.
     */
    @Deprecated
    public String BankCode;

    /**
     * Active.
     *
     * @deprecated Use {@link #isActive()} and {@link #setActive(Boolean)} instead.
     */
    @Deprecated
    public Boolean Active;

    /**
     * The currency accepted in the wallet.
     *
     * @deprecated Use {@link #getCurrency()} and {@link #setCurrency(CurrencyIso)} instead.
     */
    @Deprecated
    public CurrencyIso Currency;

    /**
     * Validity.
     *
     * @deprecated Use {@link #getValidity()} and {@link #setValidity(Validity)} instead.
     */
    @Deprecated
    public Validity Validity;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public String getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.ExpirationDate = expirationDate;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String alias) {
        this.Alias = alias;
    }

    public String getCardProvider() {
        return CardProvider;
    }

    public void setCardProvider(String cardProvider) {
        this.CardProvider = cardProvider;
    }

    public CardType getCardType() {
        return CardType;
    }

    public void setCardType(CardType cardType) {
        this.CardType = cardType;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        this.Product = product;
    }

    public String getBankCode() {
        return BankCode;
    }

    public void setBankCode(String bankCode) {
        this.BankCode = bankCode;
    }

    public Boolean isActive() {
        return Active;
    }

    public void setActive(Boolean active) {
        this.Active = active;
    }

    public CurrencyIso getCurrency() {
        return Currency;
    }

    public void setCurrency(CurrencyIso currency) {
        this.Currency = currency;
    }

    public Validity getValidity() {
        return Validity;
    }

    public void setValidity(Validity validity) {
        this.Validity = validity;
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

        return result;
    }
}
