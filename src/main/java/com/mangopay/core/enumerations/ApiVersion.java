package com.mangopay.core.enumerations;

public enum ApiVersion {
    V2_01("v2.01"),
    V3_0("V3.0");

    private final String urlValue;

    ApiVersion(String urlValue) {
        this.urlValue = urlValue;
    }

    public String getUrlValue() {
        return urlValue;
    }
}