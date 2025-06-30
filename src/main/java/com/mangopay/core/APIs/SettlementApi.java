package com.mangopay.core.APIs;

import com.mangopay.entities.Settlement;
import com.mangopay.entities.SettlementTransfer;

import java.io.File;

public interface SettlementApi {

    /**
     * Get settlement transfer entity
     *
     * @param id settlement identifier
     * @return settlement entity returned from API
     * @throws Exception
     */
    SettlementTransfer get(String id) throws Exception;

    /**
     * Upload a settlement file (API V3)
     *
     * @param file           The settlement file provided by the external payment provider,
     *                       formatted to comply with Mangopay’s generic settlement structure (CSV)
     * @param idempotencyKey Idempotency key for this request. Can be null.
     * @return Settlement object returned by the API
     * @throws Exception
     */
    Settlement upload(File file, String idempotencyKey) throws Exception;

    /**
     * Fetches a Settlement (API V3)
     *
     * @param settlementId Settlement identifier
     * @return Settlement instance
     * @throws Exception
     */
    Settlement getSettlement(String settlementId) throws Exception;

    /**
     * Update a settlement file (API V3)
     *
     * @param settlementId Settlement identifier
     * @param file         The settlement file provided by the external payment provider,
     *                     formatted to comply with Mangopay’s generic settlement structure (CSV)
     * @return Settlement object returned by the API
     * @throws Exception
     */
    Settlement update(String settlementId, File file) throws Exception;
}
