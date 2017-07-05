package com.mangopay.core.APIs;

import com.mangopay.core.FilterTransactions;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.Transaction;
import com.mangopay.entities.Wallet;

import java.util.List;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface WalletApi {

    /**
     * Creates a new wallet.
     * @param wallet        Wallet instance to be created.
     * @return              Wallet instance returned from API.
     * @throws Exception
     */
    Wallet create(Wallet wallet) throws Exception;

    /**
     * Creates a new wallet.
     * @param idempotencyKey    idempotency key for this request.
     * @param wallet            Wallet instance to be created.
     * @return                  Wallet instance returned from API.
     * @throws Exception
     */
    Wallet create(String idempotencyKey, Wallet wallet) throws Exception;

    /**
     * Gets the wallet.
     * @param walletId      Wallet identifier.
     * @return              Wallet instance returned from API.
     * @throws Exception
     */
    Wallet get(String walletId) throws Exception;

    /**
     * Updates the wallet.
     * @param wallet        Wallet object to save.
     * @return              Wallet instance returned from API.
     * @throws Exception
     */
    Wallet update(Wallet wallet) throws Exception;

    /**
     * Gets transactions for the wallet.
     * @param walletId      Wallet identifier.
     * @param pagination    Pagination object.
     * @param filter        Object to filter data.
     * @return              Transactions for wallet returned from API.
     * @throws Exception
     */
    List<Transaction> getTransactions(String walletId, Pagination pagination, FilterTransactions filter, Sorting sorting) throws Exception;

    /**
     * Gets transactions for the wallet.
     * @param walletId      Wallet identifier.
     * @param pagination    Pagination object.
     * @param filter        Object to filter data.
     * @return              Transactions for wallet returned from API.
     * @throws Exception
     */
    List<Transaction> getTransactions(String walletId, Pagination pagination, FilterTransactions filter) throws Exception;

    /**
     * Gets transactions for the wallet.
     * @param walletId      Wallet identifier.
     * @param pagination    Pagination object.
     * @return              Transactions for wallet returned from API.
     * @throws Exception
     */
    List<Transaction> getTransactions(String walletId, Pagination pagination) throws Exception;

    /**
     * Gets transactions for the wallet.
     * @param walletId      Wallet identifier.
     * @return              Transactions for wallet returned from API.
     * @throws Exception
     */
    List<Transaction> getTransactions(String walletId) throws Exception;
}
