package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.BankingAliasApi;
import com.mangopay.core.FilterBankingAlias;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.BankingAlias;

import java.util.List;

/**
 * Created by thepa on 08-Feb-17.
 */
public class BankingAliasApiImpl extends ApiBase implements BankingAliasApi {

    /**
     * Creates new BankingAliasApiImpl instance.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public BankingAliasApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public BankingAlias create(String walletId, BankingAlias bankingAlias) throws Exception {
        return this.create(null, walletId, bankingAlias);
    }

    @Override
    public BankingAlias create(String idempotencyKey, String walletId, BankingAlias bankingAlias) throws Exception {
        return this.createObject(BankingAlias.class, idempotencyKey, "banking_alias_create_iban", bankingAlias, walletId);
    }

    @Override
    public BankingAlias get(String bankingAliasId) throws Exception {
        return this.getObject(BankingAlias.class, "banking_alias_get", bankingAliasId);
    }

    @Override
    public List<BankingAlias> listForWallet(String walletId, Pagination pagination, FilterBankingAlias filter, Sorting sorting) throws Exception {
        return this.getList(BankingAlias[].class, BankingAlias.class, "banking_aliases_get_for_wallet", pagination, walletId, filter.getValues(), sorting);
    }

    @Override
    public List<BankingAlias> listForWallet(String walletId, Pagination pagination, FilterBankingAlias filter) throws Exception {
        return listForWallet(walletId, pagination, filter, null);
    }

    @Override
    public List<BankingAlias> listForWallet(String walletId, Pagination pagination) throws Exception {
        return listForWallet(walletId, pagination, new FilterBankingAlias());
    }

    @Override
    public List<BankingAlias> listForWallet(String walletId) throws Exception {
        return listForWallet(walletId, null, new FilterBankingAlias());
    }

    @Override
    public BankingAlias deactivate(String bankingAliasId, BankingAlias bankingAlias) throws Exception {
        return this.updateObject(BankingAlias.class, "banking_alias_deactivate", bankingAlias, bankingAliasId);
    }
}
