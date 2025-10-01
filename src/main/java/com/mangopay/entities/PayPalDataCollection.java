package com.mangopay.entities;

import com.mangopay.core.EntityBase;

import java.util.Map;

public class PayPalDataCollection extends EntityBase {
    private Map<String, Object> data;

    public Map<String, Object> getData() {
        return data;
    }

    public PayPalDataCollection setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }
}
