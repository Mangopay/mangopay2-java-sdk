package com.mangopay.core;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.enumerations.AVSResult;

public class SecurityInfo extends Dto {

    @SerializedName("AVSResult")
    private AVSResult avsResult;

    public AVSResult getAvsResult() {
        return avsResult;
    }

    public void setAvsResult(AVSResult avsResult) {
        this.avsResult = avsResult;
    }
}
