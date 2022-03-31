package com.mangopay.core.APIs;

import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.PayOut;
import com.mangopay.entities.PayOutEligibility;
import com.mangopay.entities.PayOutEligibilityResult;
import com.mangopay.entities.Refund;

import java.util.List;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface PayOutApi {
    /**
     * Creates new PayOut object.
     * @param payOut    The PayOut object to be created.
     * @return          Created PayOut object returned by API.
     * @throws Exception
     */
    PayOut create(PayOut payOut) throws Exception;

    /**
     * Creates new PayOut object.
     * @param idempotencyKey    idempotency key for this request.
     * @param payOut            The PayOut object to be created.
     * @return                  Created PayOut object returned by API.
     * @throws Exception
     */
    PayOut create(String idempotencyKey, PayOut payOut) throws Exception;

    /**
     *
     * @param idempotencyKey    idempotency key for this request.
     * @param payOutEligibility The PayOut object to check
     * @return                  PayOutEligibility Result
     * @throws Exception
     */
    PayOutEligibilityResult checkInstantPayoutEligibility(String idempotencyKey, PayOutEligibility payOutEligibility) throws Exception;

    /**
     * Gets PayOut entity by its identifier.
     * @param payOutId  PayOut identifier.
     * @return          PayOut instance returned by API.
     * @throws Exception
     */
    PayOut get(String payOutId) throws Exception;

    /**
     * Gets PayOut Bankwire entity by its identifier.
     * @param payOutId  PayOut identifier.
     * @return          PayOut instance returned by API.
     * @throws Exception
     */
    PayOut getBankwire(String payOutId) throws Exception;

    /**
     * Get refunds for a payout
     * @param payOutId PayOut identifier
     * @return A list of refunds
     * @throws Exception
     */
    List<Refund> getRefunds(String payOutId) throws Exception;

    /**
     * Get a page of payout refunds
     * @param payOutId PayOut identifier
     * @param pagination Pagination object
     * @param sorting Sorting object
     * @return Collection of payout refunds
     * @throws Exception
     */
    List<Refund> getRefunds(String payOutId, Pagination pagination, Sorting sorting) throws Exception;
}
