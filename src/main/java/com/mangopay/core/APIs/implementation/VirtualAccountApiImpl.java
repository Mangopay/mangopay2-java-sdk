package com.mangopay.core.APIs.implementation;

import com.google.gson.GsonBuilder;
import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.VirtualAccountApi;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.VirtualAccount;
import com.mangopay.entities.subentities.VirtualAccountAvailabilities;

import java.util.List;

public class VirtualAccountApiImpl extends ApiBase implements VirtualAccountApi {

    /**
     * Creates new VirtualAccountApiImpl instance.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public VirtualAccountApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public VirtualAccount create(String walletId, VirtualAccount virtualAccount) throws Exception {
        return this.create(walletId, virtualAccount, null);
    }

    @Override
    public VirtualAccount create(String walletId, VirtualAccount virtualAccount, String idempotencyKey) throws Exception {
        return this.createObject(VirtualAccount.class, idempotencyKey, "virtual_account_create", virtualAccount, walletId);
    }

    @Override
    public VirtualAccount get(String walletId, String virtualAccountId) throws Exception {
        return this.getObject(VirtualAccount.class, "virtual_account_get", walletId, virtualAccountId);
    }

    @Override
    public List<VirtualAccount> getAll(String walletId, Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(VirtualAccount[].class, VirtualAccount.class, "virtual_account_get_all", pagination, walletId, sorting);
    }

    @Override
    public VirtualAccount deactivate(String walletId, String virtualAccountId) throws Exception {
        return this.updateObject(VirtualAccount.class, "virtual_account_deactivate", new VirtualAccount(), walletId, virtualAccountId);
    }

    @Override
    public VirtualAccountAvailabilities getAvailabilities() throws Exception {
        return this.getObject(VirtualAccountAvailabilities.class, "virtual_account_get_availabilities", (Object) null);
    }
}
