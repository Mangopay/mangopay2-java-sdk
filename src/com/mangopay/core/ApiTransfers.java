package com.mangopay.core;

import com.mangopay.MangoPayApi;
import com.mangopay.entities.Transfer;

/**
 * API for Transfers.
 */
public class ApiTransfers extends ApiBase {

    /**
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance
     */
    public ApiTransfers(MangoPayApi root) { super(root); }
    
    /**
     * Creates new transfer.
     * @param transfer  Instance of Transfer class to be created.
     * @return          Transfer object returned from API.
     * @throws Exception
     */
    public Transfer create(Transfer transfer) throws Exception {
        return this.createObject(Transfer.class, "transfers_create", transfer);
    }
    
    /**
     * Gets the transfer.
     * @param transferId    Transfer identifier.
     * @return              Transfer instance returned from API.
     * @throws Exception
     */
    public Transfer get(String transferId) throws Exception {
        return this.getObject(Transfer.class, "transfers_get", transferId);
    }
    
}
