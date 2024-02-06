package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;

public class BinData {

    /**
     * The subtype of the card product. Examples include: CLASSIC, GOLD, PLATINUM, PREPAID, etc.
     */
    @SerializedName("SubType")
    private String subType;

    /**
     * The card brand. Examples include: AMERICAN EXPRESS, DISCOVER, JCB, MASTERCARD, VISA, etc.
     */
    @SerializedName("Brand")
    private String brand;

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
