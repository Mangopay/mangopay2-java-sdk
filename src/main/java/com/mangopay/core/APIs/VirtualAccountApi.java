package com.mangopay.core.APIs;

import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.VirtualAccount;
import com.mangopay.entities.subentities.VirtualAccountAvailabilities;

import java.util.List;

public interface VirtualAccountApi {

    /**
     * Create new Virtual Account
     * @param walletId ID of the wallet for which the alias is being created.
     * @param virtualAccount VirtualAccount to be created
     * @return Virtual Account object returned from API
     */
    VirtualAccount create(String walletId, VirtualAccount virtualAccount) throws Exception;

    /**
     * Create new Virtual Account
     * @param walletId ID of the wallet for which the alias is being created.
     * @param virtualAccount VirtualAccount to be created
     * @param idempotencyKey Idempotency key for this request.
     * @return Virtual Account object returned from API
     */
    VirtualAccount create(String walletId, VirtualAccount virtualAccount, String idempotencyKey) throws Exception;

    /**
     * Create new Virtual Account
     * @param walletId ID of the wallet for which the alias is being created.
     * @param virtualAccountId VirtualAccount to be created
     * @return Virtual Account object returned from API
     */
    VirtualAccount get(String walletId, String virtualAccountId) throws Exception;

    /**
     * Create new Virtual Account
     * @param walletId ID of the wallet.
     * @param pagination Pagination object
     * @param sorting Sorting object
     * @return Virtual Account object returned from API
     */
    List<VirtualAccount> getAll(String walletId, Pagination pagination, Sorting sorting) throws Exception;

    /**
     * @param walletId ID of the wallet.
     * @param virtualAccountId ID of the searched virtualAccount
     * @return \MangoPay\VirtualAccount
     */
    VirtualAccount deactivate(String walletId, String virtualAccountId) throws Exception;

    /**
     * @return VirtualAccountAvailabilities
     */
    VirtualAccountAvailabilities GetAvailabilities() throws Exception;


}
