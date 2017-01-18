package com.mangopay.core.APIs;

import com.mangopay.entities.Refund;
import com.mangopay.entities.Transfer;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface ApiTransfers {
    /**
     * Creates new transfer.
     * @param transfer  Instance of Transfer class to be created.
     * @return          Transfer object returned from API.
     * @throws Exception
     */
    Transfer create(Transfer transfer) throws Exception;

    /**
     * Creates new transfer.
     * @param idempotencyKey    Idempotency key for this request.
     * @param transfer          Instance of Transfer class to be created.
     * @return                  Transfer object returned from API.
     * @throws Exception
     */
    Transfer create(String idempotencyKey, Transfer transfer) throws Exception;

    /**
     * Gets the transfer.
     * @param transferId    Transfer identifier.
     * @return              Transfer instance returned from API.
     * @throws Exception
     */
    Transfer get(String transferId) throws Exception;

    /**
     * Creates refund for transfer object.
     * @param transferId Transfer identifier.
     * @param refund Refund object to create.
     * @return Refund entity instance returned from API.
     * @throws Exception
     */
    Refund createRefund(String transferId, Refund refund) throws Exception;

    /**
     * Creates refund for transfer object.
     * @param idempotencyKey    Idempotency key for this request.
     * @param transferId        Transfer identifier.
     * @param refund            Refund object to create.
     * @return Refund entity instance returned from API.
     * @throws Exception
     */
    Refund createRefund(String idempotencyKey, String transferId, Refund refund) throws Exception;

    /**
     * Gets refund for transfer object.
     * @param transferId Transfer identifier.
     * @return Refund entity instance returned from API.
     * @throws Exception
     */
    Refund getRefund(String transferId) throws Exception;
}
