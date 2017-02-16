package com.mangopay.core.APIs;

import com.mangopay.core.FilterBankingAlias;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.BankingAlias;

import java.util.List;

/**
 * API declaration for banking aliases.
 */
public interface BankingAliasApi {

    /**
     * Creates a new banking alias.
     *
     * @param bankingAlias Banking alias instance to be created.
     * @param walletId     ID of the wallet for which the alias is being created.
     * @return Banking alias instance returned from API.
     */
    BankingAlias create(String walletId, BankingAlias bankingAlias) throws Exception;

    /**
     * Creates a new banking alias.
     *
     * @param idempotencyKey Idempotency key for this request.
     * @param walletId       ID of the wallet for which the alias is being created.
     * @param bankingAlias   Banking alias instance to be created.
     * @return Banking alias instance returned from API.
     */
    BankingAlias create(String idempotencyKey, String walletId, BankingAlias bankingAlias) throws Exception;

    /**
     * Gets the banking alias.
     *
     * @param bankingAliasId Banking alias identifier.
     * @return Banking alias instance returned from API.
     */
    BankingAlias get(String bankingAliasId) throws Exception;

    /**
     * Gets banking aliases for the wallet.
     *
     * @param walletId   Wallet identifier.
     * @param pagination Pagination object
     * @param filter     Object to filter data.
     * @param sorting    Object to sort data.
     * @return Banking aliases for wallet returned from API.
     */
    List<BankingAlias> listForWallet(String walletId, Pagination pagination, FilterBankingAlias filter, Sorting sorting) throws Exception;

    /**
     * Gets banking aliases for the wallet.
     *
     * @param walletId   Wallet identifier.
     * @param pagination Pagination object
     * @param filter     Object to filter data.
     * @return Banking aliases for wallet returned from API.
     */
    List<BankingAlias> listForWallet(String walletId, Pagination pagination, FilterBankingAlias filter) throws Exception;

    /**
     * Gets banking aliases for the wallet.
     *
     * @param walletId   Wallet identifier.
     * @param pagination Pagination object
     * @return Banking aliases for wallet returned from API.
     */
    List<BankingAlias> listForWallet(String walletId, Pagination pagination) throws Exception;

    /**
     * Gets banking aliases for the wallet.
     *
     * @param walletId Wallet identifier.
     * @return Banking aliases for wallet returned from API.
     */
    List<BankingAlias> listForWallet(String walletId) throws Exception;

    /**
     * Deactivates a banking alias.
     *
     * @param bankingAliasId ID of the banking alias to be deactivated.
     * @param bankingAlias   Banking alias locally marked as deactivated.
     * @return
     */
    BankingAlias deactivate(String bankingAliasId, BankingAlias bankingAlias) throws Exception;
}
