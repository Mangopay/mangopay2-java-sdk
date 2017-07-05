package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
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
     */
    @SerializedName("UserId")
    private String userId;

    /**
     * Access key.
     */
    @SerializedName("AccessKey")
    private String accessKey;

    /**
     * Pre-registration data.
     */
    @SerializedName("PreregistrationData")
    private String preregistrationData;

    /**
     * Card registration URL.
     */
    @SerializedName("CardRegistrationURL")
    private String cardRegistrationUrl;

    /**
     * Card identifier.
     */
    @SerializedName("CardId")
    private String cardId;

    /**
     * Card registration data.
     */
    @SerializedName("RegistrationData")
    private String registrationData;

    /**
     * Result code.
     */
    @SerializedName("ResultCode")
    private String resultCode;

    /**
     * Currency.
     */
    @SerializedName("Currency")
    private CurrencyIso currency;

    /**
     * Status.
     */
    @SerializedName("Status")
    private String status;

    /**
     * Card type.
     */
    @SerializedName("CardType")
    private CardType cardType;

    public CardRegistration() {
        this.cardType = CardType.CB_VISA_MASTERCARD;
    }

    public CardRegistration(CardType cardType) {
        this.cardType = cardType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getPreregistrationData() {
        return preregistrationData;
    }

    public void setPreregistrationData(String preregistrationData) {
        this.preregistrationData = preregistrationData;
    }

    public String getCardRegistrationUrl() {
        return cardRegistrationUrl;
    }

    public void setCardRegistrationUrl(String cardRegistrationUrl) {
        this.cardRegistrationUrl = cardRegistrationUrl;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getRegistrationData() {
        return registrationData;
    }

    public void setRegistrationData(String registrationData) {
        this.registrationData = registrationData;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public CurrencyIso getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyIso currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
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
