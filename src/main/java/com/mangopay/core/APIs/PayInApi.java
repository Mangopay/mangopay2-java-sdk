package com.mangopay.core.APIs;

import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.*;
import com.mangopay.entities.subentities.CreateCardPreAuthorizedDepositPayIn;
import com.mangopay.entities.subentities.PayPalWebTracking;

import java.util.List;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface PayInApi {
    /**
     * Creates new PayIn object.
     * @param payIn     The PayIn object to be created.
     * @return          Created PayIn object returned by API.
     * @throws Exception
     */
    PayIn create(PayIn payIn) throws Exception;

    /**
     * Creates new PayIn object.
     * @param idempotencyKey    Idempotency key for this request.
     * @param payIn             The PayIn object to be created.
     * @return                  Created PayIn object returned by API.
     * @throws Exception
     */
    PayIn create(String idempotencyKey, PayIn payIn) throws Exception;

    /**
     * Gets PayIn entity by its identifier.
     * @param payInId   PayIn identifier.
     * @return          PayIn object returned by API.
     * @throws Exception
     */
    PayIn get(String payInId) throws Exception;

    /**
     *
     * @param idempotencyKey
     * @param createRecurringPayment
     * @return
     * @throws Exception
     */
    RecurringPayment createRecurringPayment(String idempotencyKey, CreateRecurringPayment createRecurringPayment) throws Exception;

    /**
     *
     * @param payInId
     * @return
     * @throws Exception
     */
    RecurringPaymentExtended getRecurringPayment(String payInId) throws Exception;

    /**
     *
     * @param payInId
     * @return
     * @throws Exception
     */
    RecurringPaymentExtended updateRecurringPayment(String payInId, RecurringPaymentUpdate payIn) throws Exception;

    /**
     *
     * @param idempotencyKey
     * @param cit
     * @return
     * @throws Exception
     */
    RecurringPayIn createRecurringPayInCIT(String idempotencyKey, RecurringPayInCIT cit) throws Exception;

    /**
     *
     * @param idempotencyKey
     * @param cit
     * @return
     * @throws Exception
     */
    RecurringPayIn createRecurringPayInMIT(String idempotencyKey, RecurringPayInMIT cit) throws Exception;

    /**
     * Creates a new Recurring PayPal PayIn CIT
     *
     * @param idempotencyKey Idempotency key for this request.
     * @param cit            The RecurringPayPalPayInCIT object to be created
     * @return Instance of RecurringPayIn
     * @throws Exception
     */
    RecurringPayIn createRecurringPayPalPayInCIT(String idempotencyKey, RecurringPayPalPayInCIT cit) throws Exception;

    /**
     * Creates a new Recurring PayPal PayIn MIT
     *
     * @param idempotencyKey Idempotency key for this request.
     * @param mit            The RecurringPayPalPayInMIT object to be created
     * @return Instance of RecurringPayIn
     * @throws Exception
     */
    RecurringPayIn createRecurringPayPalPayInMIT(String idempotencyKey, RecurringPayPalPayInMIT mit) throws Exception;


    /**
     * Creates refund for PayIn object.
     * @param payInId   PayIn identifier.
     * @param refund    Refund object to be created.
     * @return          Refund entity instance returned by REST API.
     * @throws Exception
     */
    Refund createRefund(String payInId, Refund refund) throws Exception;

    /**
     * Creates refund for PayIn object.
     * @param idempotencyKey    Idempotency key for this request.
     * @param payInId           PayIn identifier.
     * @param refund            Refund object to be created.
     * @return                  Refund entity instance returned by REST API.
     * @throws Exception
     */
    Refund createRefund(String idempotencyKey, String payInId, Refund refund) throws Exception;

    /**
     * Gets refund for PayIn object.
     * @param payInId PayIn identifier.
     * @return Refund entity instance returned by REST API.
     * @throws Exception
     */
    Refund getRefund(String payInId) throws Exception;

    /**
     * Get first page of payIn refunds
     * @param payInId PayIn identifier
     * @return Collection of payIn refunds
     * @throws Exception
     */
    List<Refund> getRefunds(String payInId) throws Exception;

    /**
     * Get page of payIn refunds
     * @param payInId PayIn identifier
     * @param pagination Pagination object
     * @param sorting Sorting object
     * @return Collection of payIn refunds
     * @throws Exception
     */
    List<Refund> getRefunds(String payInId, Pagination pagination, Sorting sorting) throws Exception;

    CardPreAuthorizedDepositPayIn createCardPreAuthorizedDepositPayIn(CreateCardPreAuthorizedDepositPayIn payIn, String idempotencyKey) throws Exception;

    /**
     * Creates new PayPal Web PayIn object.
     * @param payIn     The PayIn object to be created.
     * @return          Created PayIn object returned by API.
     * @throws Exception
     */
    PayIn createPayPal(PayIn payIn) throws Exception;

    /**
     * Look up metadata from BIN or Google Pay token
     * @param metadata     The PaymentMethodMetadata post object
     * @return           PaymentMethodMetadata object returned by API.
     * @throws Exception
     */
    PaymentMethodMetadata getPaymentMethodMetadata(PaymentMethodMetadata metadata) throws Exception;


    /**
     * Add tracking information to a PayPal PayIn (add the tracking number and carrier for LineItems shipments.)
     * Caution – Tracking information cannot be edited
     * You can’t modify the TrackingNumber, Carrier, or NotifyBuyer once added.
     * You can only send a unique tracking number once.
     *
     * @param payInId      The ID of the PayIn
     * @param trackingData trackingInformation object
     * @return {PayIn} object returned by the API
     */
    PayIn addPayPalTrackingInformation(String payInId, PayPalWebTracking trackingData) throws Exception;

    /**
     * Creates a Payconiq Web PayIn using the latest API url (payins/payment-methods/payconiq)
     *
     * @param idempotencyKey Idempotency key for this request. Can be null.
     * @param payIn          The PayIn object to be created.
     * @return Created PayIn object returned by API.
     * @throws Exception
     */
    PayIn createPayconiq(PayIn payIn, String idempotencyKey) throws Exception;
}
