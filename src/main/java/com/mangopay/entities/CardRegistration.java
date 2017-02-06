package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.CardType;
import com.mangopay.core.enumerations.CurrencyIso;

import java.util.ArrayList;

/**
 * CardRegistration entity.
 */
public class CardRegistration extends EntityBase {

    /**
     * User Id.
     *
     * @deprecated Use {@link #getUserId()} and {@link #setUserId(String)} instead.
     */
    @Deprecated
    public String UserId;

    /**
     * Access key.
     *
     * @deprecated Use {@link #getAccessKey()} and {@link #setAccessKey(String)} instead.
     */
    @Deprecated
    public String AccessKey;

    /**
     * Pre-registration data.
     *
     * @deprecated Use {@link #getPreregistrationData()} and {@link #setPreregistrationData(String)} instead.
     */
    @Deprecated
    public String PreregistrationData;

    /**
     * Card registration URL.
     *
     * @deprecated Use {@link #getCardRegistrationURL()} and {@link #setCardRegistrationURL(String)} instead.
     */
    @Deprecated
    public String CardRegistrationURL;

    /**
     * Card identifier.
     *
     * @deprecated Use {@link #getCardId()} and {@link #setCardId(String)} instead.
     */
    @Deprecated
    public String CardId;

    /**
     * Card registration data.
     *
     * @deprecated Use {@link #getRegistrationData()} and {@link #setRegistrationData(String)} instead.
     */
    @Deprecated
    public String RegistrationData;

    /**
     * Result code.
     *
     * @deprecated Use {@link #getResultCode()} and {@link #setResultCode(String)} instead.
     */
    @Deprecated
    public String ResultCode;

    /**
     * Currency.
     *
     * @deprecated Use {@link #getCurrency()} and {@link #setCurrency(CurrencyIso)} instead.
     */
    @Deprecated
    public CurrencyIso Currency;

    /**
     * Status.
     *
     * @deprecated Use {@link #getStatus()} and {@link #setStatus(String)} instead.
     */
    @Deprecated
    public String Status;

    /**
     * Card type.
     *
     * @deprecated Use {@link #getCardType()} and {@link #setCardType(CardType)} instead.
     */
    @Deprecated
    public CardType CardType;

    public CardRegistration() {
        this.CardType = CardType.CB_VISA_MASTERCARD;
    }

    public CardRegistration(CardType cardType) {
        this.CardType = cardType;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
    }

    public String getAccessKey() {
        return AccessKey;
    }

    public void setAccessKey(String accessKey) {
        this.AccessKey = accessKey;
    }

    public String getPreregistrationData() {
        return PreregistrationData;
    }

    public void setPreregistrationData(String preregistrationData) {
        this.PreregistrationData = preregistrationData;
    }

    public String getCardRegistrationURL() {
        return CardRegistrationURL;
    }

    public void setCardRegistrationURL(String cardRegistrationURL) {
        this.CardRegistrationURL = cardRegistrationURL;
    }

    public String getCardId() {
        return CardId;
    }

    public void setCardId(String cardId) {
        this.CardId = cardId;
    }

    public String getRegistrationData() {
        return RegistrationData;
    }

    public void setRegistrationData(String registrationData) {
        this.RegistrationData = registrationData;
    }

    public String getResultCode() {
        return ResultCode;
    }

    public void setResultCode(String resultCode) {
        this.ResultCode = resultCode;
    }

    public CurrencyIso getCurrency() {
        return Currency;
    }

    public void setCurrency(CurrencyIso currency) {
        this.Currency = currency;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public CardType getCardType() {
        return CardType;
    }

    public void setCardType(CardType cardType) {
        this.CardType = cardType;
    }

    /**
     * Gets the collection of read-only fields names.
     *
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {

        ArrayList<String> result = super.getReadOnlyProperties();

        result.add("AccessKey");
        result.add("PreregistrationData");
        result.add("CardRegistrationURL");
        result.add("CardId");
        result.add("ResultCode");
        result.add("Status");

        return result;
    }

}
