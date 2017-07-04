package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.*;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.WalletApi;
import com.mangopay.entities.*;
import java.util.List;

/**
 * API for wallets.
 */
public class WalletApiImpl extends ApiBase implements WalletApi {
    
    /**
     * Instantiates new WalletApiImpl object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance
     */
    public WalletApiImpl(MangoPayApi root) { super(root); }

    @Override
    public Wallet create(Wallet wallet) throws Exception {
        return this.create(null, wallet);
    }

    @Override
    public Wallet create(String idempotencyKey, Wallet wallet) throws Exception {
        return this.createObject(Wallet.class, idempotencyKey, "wallets_create", wallet);
    }

    @Override
    public Wallet get(String walletId) throws Exception {
        return this.getObject(Wallet.class, "wallets_get", walletId);
    }

    @Override
    public Wallet update(Wallet wallet) throws Exception {
        return this.updateObject(Wallet.class, "wallets_save", wallet);
    }

    @Override
    public List<Transaction> getTransactions(String walletId, Pagination pagination, FilterTransactions filter, Sorting sorting) throws Exception {
        return this.getList(Transaction[].class, Transaction.class, "wallets_alltransactions", pagination, walletId, filter.getValues(), sorting);
    }

    @Override
    public List<Transaction> getTransactions(String walletId, Pagination pagination, FilterTransactions filter) throws Exception {
        return getTransactions(walletId, pagination, filter, null);
    }

    @Override
    public List<Transaction> getTransactions(String walletId, Pagination pagination) throws Exception {
        return getTransactions(walletId, pagination, new FilterTransactions());
    }

    @Override
    public List<Transaction> getTransactions(String walletId) throws Exception {
        return getTransactions(walletId, null, new FilterTransactions());
    }
    
}
