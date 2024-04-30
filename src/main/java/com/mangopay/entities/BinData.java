package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;

public class BinData {

    /**
     * The subtype of the card product. Examples include: CLASSIC, GOLD, PLATINUM, PREPAID, etc.
     */
    @SerializedName("Subtype")
    private String subtype;

    /**
     * The card brand. Examples include: AMERICAN EXPRESS, DISCOVER, JCB, MASTERCARD, VISA, etc.
     */
    @SerializedName("Brand")
    private String brand;

    /**
     * Whether the card is held in a personal or commercial capacity.
     */
    @SerializedName("CommercialIndicator")
    private String commercialIndicator;

    /**
     * The type of the card. Allowed / Returned / Default values: CREDIT, DEBIT, CHARGE CARD
     */
    @SerializedName("CardType")
    private String cardType;

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCommercialIndicator() {
        return commercialIndicator;
    }

    public BinData setCommercialIndicator(String commercialIndicator) {
        this.commercialIndicator = commercialIndicator;
        return this;
    }

    public String getCardType() {
        return cardType;
    }

    public BinData setCardType(String cardType) {
        this.cardType = cardType;
        return this;
    }
}
