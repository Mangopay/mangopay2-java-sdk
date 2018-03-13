package com.mangopay.core;

import com.mangopay.core.enumerations.AVSResult;

public class SecurityInfo extends Dto {

    private AVSResult avsResult;

    public AVSResult getAvsResult() {
        return avsResult;
    }

    public void setAvsResult(AVSResult avsResult) {
        this.avsResult = avsResult;
    }
}
