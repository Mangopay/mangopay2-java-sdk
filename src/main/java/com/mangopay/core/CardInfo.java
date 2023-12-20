package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

public class CardInfo extends Dto {

    /**
     * The 6-digit bank identification number (BIN) of the card issuer.
     */
    @SerializedName("BIN")
    private String bin;

    /**
     * The name of the card issuer.
     */
    @SerializedName("IssuingBank")
    private String issuingBank;

    /**
     * The country where the card was issued.
     */
    @SerializedName("IssuerCountryCode")
    private String issuerCountryCode;

    /**
     * The type of card product: DEBIT, CREDIT, CHARGE CARD.
     */
    @SerializedName("Type")
    private String type;

    /**
     * The card brand. Examples include: AMERICAN EXPRESS, DISCOVER, JCB, MASTERCARD, VISA, etc.
     */
    @SerializedName("Brand")
    private String brand;

    /**
     * The subtype of the card product. Examples include: CLASSIC, GOLD, PLATINUM, PREPAID, etc.
     */
    @SerializedName("SubType")
    private String subType;

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getIssuingBank() {
        return issuingBank;
    }

    public void setIssuingBank(String issuingBank) {
        this.issuingBank = issuingBank;
    }

    public String getIssuerCountryCode() {
        return issuerCountryCode;
    }

    public void setIssuerCountryCode(String issuerCountryCode) {
        this.issuerCountryCode = issuerCountryCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }
}
