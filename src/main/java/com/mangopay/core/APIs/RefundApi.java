package com.mangopay.core.APIs;

import com.mangopay.entities.Refund;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface RefundApi {
    /**
     * Gets refund entity.
     *
     * @param refundId Refund identifier.
     * @return Refund entity instance returned from API.
     * @throws Exception
     */
    Refund get(String refundId) throws Exception;
}
