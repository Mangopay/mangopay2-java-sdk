package com.mangopay.core.APIs.implementation;

import com.google.gson.GsonBuilder;
import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.SettlementApi;
import com.mangopay.entities.SettlementTransfer;

/**
 * API for settlements
 */
public class SettlementApiImpl extends ApiBase implements SettlementApi {

    private GsonBuilder gsonBuilder;

    public SettlementApiImpl(MangoPayApi root, GsonBuilder gsonBuilder) {
        super(root);
        this.gsonBuilder = gsonBuilder;
    }

    @Override
    public SettlementTransfer get(String id) throws Exception {
        return this.getObject(SettlementTransfer.class, "settlements_get", id);
    }
}
