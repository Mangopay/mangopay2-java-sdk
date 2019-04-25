package com.mangopay.core.APIs.implementation;

import com.google.gson.GsonBuilder;
import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.TransferApi;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.Refund;
import com.mangopay.entities.Transfer;

import java.util.List;

/**
 * API for transfers.
 */
public class TransferApiImpl extends ApiBase implements TransferApi {

    /**
     * Instantiates new TransferApiImpl object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    private GsonBuilder gsonBuilder;

    public TransferApiImpl(MangoPayApi root, GsonBuilder gsonBuilder) {
        super(root);
        this.gsonBuilder = gsonBuilder;
    }

    @Override
    public Transfer create(Transfer transfer) throws Exception {
        return this.create(null, transfer);
    }

    @Override
    public Transfer create(String idempotencyKey, Transfer transfer) throws Exception {
        return this.createObject(Transfer.class, idempotencyKey, "transfers_create", transfer);
    }

    @Override
    public Transfer get(String transferId) throws Exception {
        return this.getObject(Transfer.class, "transfers_get", transferId);
    }

    @Override
    public Refund createRefund(String transferId, Refund refund) throws Exception {
        return this.createRefund(null, transferId, refund);
    }

    @Override
    public Refund createRefund(String idempotencyKey, String transferId, Refund refund) throws Exception {
        return this.createObject(Refund.class, idempotencyKey, "transfers_createrefunds", refund, transferId);
    }

    @Override
    public Refund getRefund(String transferId) throws Exception {
        return this.getObject(Refund.class, "transfers_getrefunds", transferId);
    }

    @Override
    public List<Refund> getRefunds(String transferId) throws Exception {
        return this.getRefunds(transferId,null,null);
    }

    @Override
    public List<Refund> getRefunds(String transferId, Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(Refund[].class,Refund.class,"transfers_getrefunds",pagination,transferId,sorting);
    }
}
