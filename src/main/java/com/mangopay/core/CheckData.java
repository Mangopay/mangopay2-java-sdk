package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

public class CheckData extends Dto {

    /**
     * The type of the data point.
     * For more details, <a href="https://mangopay-idv.mintlify.app/guides/users/verification/hosted?_gl=1*1unwn0t*_up*MQ..*_ga*ODg5MjI4ODQzLjE3Mzg5MjY2NjE.*_ga_VZLQHP6CFB*MTczODkyNjY2MC4xLjAuMTczODkyNjY2MC4wLjAuMA..#verified-data-returned">see the Verified data returned.</a>
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
