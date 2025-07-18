package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.SettlementApi;
import com.mangopay.entities.Settlement;
import com.mangopay.entities.SettlementTransfer;

/**
 * API for settlements
 */
public class SettlementApiImpl extends ApiBase implements SettlementApi {

    public SettlementApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public SettlementTransfer get(String id) throws Exception {
        return this.getObject(SettlementTransfer.class, "settlements_get", id);
    }

    @Override
    public Settlement upload(byte[] file, String idempotencyKey) throws Exception {
        return this.createOrUpdateMultipart(Settlement.class, "settlement_upload", file, idempotencyKey);
    }

    @Override
    public Settlement getSettlement(String settlementId) throws Exception {
        return this.getObject(Settlement.class, "settlement_get", settlementId);
    }

    @Override
    public Settlement update(String settlementId, byte[] file) throws Exception {
        return this.createOrUpdateMultipart(Settlement.class, "settlement_update", file, null, settlementId);
    }
}
