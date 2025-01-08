package com.mangopay.core.enumerations;

public class PayInReferences {

    private String type;

    private String value;

    public PayInReferences(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
