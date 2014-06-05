package com.mangopay.core;

import com.mangopay.MangoPayApi;
import com.mangopay.entities.Transaction;
import com.mangopay.entities.Wallet;
import java.util.List;

/**
 * API for wallets.
 */
public class ApiWallets extends ApiBase {
    
    /**
     * Instantiates new ApiWallets object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance
     */
    public ApiWallets(MangoPayApi root) { super(root); }

    /**
     * Creates a new wallet.
     * @param wallet        Wallet instance to be created.
     * @return              Wallet instance returned from API.
     * @throws Exception
     */
    public Wallet create(Wallet wallet) throws Exception {
        return this.createObject(Wallet.class, "wallets_create", wallet);
    }
    
    /**
     * Gets the wallet.
     * @param walletId      Wallet identifier.
     * @return              Wallet instance returned from API.
     * @throws Exception
     */
    public Wallet get(String walletId) throws Exception {
        return this.getObject(Wallet.class, "wallets_get", walletId);
    }
    
    /**
     * Updates the wallet.
     * @param wallet        Wallet object to save.
     * @return              Wallet instance returned from API.
     * @throws Exception
     */
    public Wallet update(Wallet wallet) throws Exception {
        return this.updateObject(Wallet.class, "wallets_save", wallet);
    }

    /**
     * Gets transactions for the wallet.
     * @param walletId      Wallet identifier.
     * @param pagination    Pagination object.
     * @param filter        Object to filter data.
     * @return              Transactions for wallet returned from API.
     * @throws Exception
     */
    public List<Transaction> getTransactions(String walletId, Pagination pagination, FilterTransactions filter) throws Exception {
        return this.getList(Transaction[].class, Transaction.class, "wallets_alltransactions", pagination, walletId, filter.getValues());
    }
    
    /**
     * Gets transactions for the wallet.
     * @param walletId      Wallet identifier.
     * @param pagination    Pagination object.
     * @return              Transactions for wallet returned from API.
     * @throws Exception
     */
    public List<Transaction> getTransactions(String walletId, Pagination pagination) throws Exception {
        return getTransactions(walletId, pagination, new FilterTransactions());
    }
    
    /**
     * Gets transactions for the wallet.
     * @param walletId      Wallet identifier.
     * @return              Transactions for wallet returned from API.
     * @throws Exception
     */
    public List<Transaction> getTransactions(String walletId) throws Exception {
        return getTransactions(walletId, null, new FilterTransactions());
    }
    
}
