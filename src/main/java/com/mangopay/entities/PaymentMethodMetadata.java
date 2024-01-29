package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;

public class PaymentMethodMetadata extends EntityBase {

    /**
     * The type of metadata. Allowed values: BIN, GOOGLE_PAY
     */
    @SerializedName("Type")
    private String type;

    /**
     * The bank identification number (BIN). (Format: 6 or 8 digits)
     */
    @SerializedName("Bin")
    private String bin;

    /**
     * The tokenized payment data provided by the third-party payment method.
     */
    @SerializedName("Token")
    private String token;

    /**
     * In the case of Google Pay, the format of the Token.
     * PAN_ONLY – The card is registered in the Google account and requires 3DS authentication.
     * CRYPTOGRAM_3DS – The card is enrolled in the customer’s Google Wallet and authentication is handled by the Android device.
     */
    @SerializedName("TokenFormat")
    private String tokenFormat;

    /**
     * The type of the card. Allowed / Returned / Default values: CREDIT, DEBIT, CHARGE CARD
     */
    @SerializedName("CardType")
    private String cardType;

    /**
     * The country where the card was issued. Format: ISO-3166 alpha-2 two-letter country code
     */
    @SerializedName("IssuerCountryCode")
    private String issuerCountryCode;

    /**
     * The name of the card issuer.
     */
    @SerializedName("IssuingBank")
    private String issuingBank;

    /**
     * Whether the card is held in a personal or commercial capacity.
     */
    @SerializedName("CommercialIndicator")
    private String commercialIndicator;

    /**
     * Additional data about the card based on the BIN. In the case of co-branded card products, two objects are returned.
     */
    @SerializedName("BinData")
    private BinData[] binData;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenFormat() {
        return tokenFormat;
    }

    public void setTokenFormat(String tokenFormat) {
        this.tokenFormat = tokenFormat;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getIssuerCountryCode() {
        return issuerCountryCode;
    }

    public void setIssuerCountryCode(String issuerCountryCode) {
        this.issuerCountryCode = issuerCountryCode;
    }

    public String getIssuingBank() {
        return issuingBank;
    }

    public void setIssuingBank(String issuingBank) {
        this.issuingBank = issuingBank;
    }

    public String getCommercialIndicator() {
        return commercialIndicator;
    }

    public void setCommercialIndicator(String commercialIndicator) {
        this.commercialIndicator = commercialIndicator;
    }

    public BinData[] getBinData() {
        return binData;
    }

    public void setBinData(BinData[] binData) {
        this.binData = binData;
    }
}
