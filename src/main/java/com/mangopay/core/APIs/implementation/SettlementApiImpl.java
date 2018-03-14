package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.SettlementApi;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.SettlementTransfer;

import java.util.List;

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
    public List<SettlementTransfer> getAll(Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(SettlementTransfer[].class, SettlementTransfer.class, "settlements_get_all", pagination, sorting);
    }

    @Override
    public List<SettlementTransfer> getAll() throws Exception {
        return this.getAll(null, null);
    }
}
