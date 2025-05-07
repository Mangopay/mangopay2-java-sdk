package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

public class CheckData extends Dto {

    /**
     * The type of the data point.
     */
    @SerializedName("Type")
    private String type;

    /**
     * The value of the data point.
     */
    @SerializedName("Value")
    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
