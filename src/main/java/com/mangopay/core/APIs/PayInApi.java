package com.mangopay.core.APIs;

import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.*;
import com.mangopay.entities.subentities.CreateCardPreAuthorizedDepositPayIn;
import com.mangopay.entities.subentities.IntentSplits;
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

    /**
     * Create a Deposit Preauthorized PayIn without complement
     *
     * @param payIn          The PayIn object to be created
     * @param idempotencyKey Idempotency key for this request. Can be null.
     * @return Created PayIn object returned by API
     * @throws Exception
     * @deprecated This method is deprecated. Please use 'createDepositPreauthorizedWithoutComplement', which follows
     * the same pattern as the other PayIns
     */
    @Deprecated
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

    /**
     * Create a Deposit Preauthorized PayIn without complement
     *
     * @param payIn          The PayIn object to be created
     * @param idempotencyKey Idempotency key for this request. Can be null.
     * @return Created PayIn object returned by API
     * @throws Exception
     */
    PayIn createDepositPreauthorizedPayInWithoutComplement(PayIn payIn, String idempotencyKey) throws Exception;

    /**
     * Create a Deposit Preauthorized PayIn prior to complement
     *
     * @param payIn          The PayIn object to be created
     * @param idempotencyKey Idempotency key for this request. Can be null.
     * @return Created PayIn object returned by API
     * @throws Exception
     */
    PayIn createDepositPreauthorizedPayInPriorToComplement(PayIn payIn, String idempotencyKey) throws Exception;

    /**
     * Create a Deposit Preauthorized PayIn complement
     *
     * @param payIn          The PayIn object to be created
     * @param idempotencyKey Idempotency key for this request. Can be null.
     * @return Created PayIn object returned by API
     * @throws Exception
     */
    PayIn createDepositPreauthorizedPayInComplement(PayIn payIn, String idempotencyKey) throws Exception;

    /**
     * Create a pay in intent authorization
     *
     * @param payInIntent    The PayInIntent object to be created
     * @param idempotencyKey Idempotency key for this request. Can be null.
     * @return Created PayInIntent
     * @throws Exception
     */
    PayInIntent createPayInIntentAuthorization(PayInIntent payInIntent, String idempotencyKey) throws Exception;

    /**
     * Create a pay in intent capture
     *
     * @param payInIntentCapture The PayInIntent capture object to be created
     * @param intentId           Intent identifier
     * @param idempotencyKey     Idempotency key for this request. Can be null.
     * @return Created PayInIntent
     * @throws Exception
     */
    PayInIntent createPayInIntentCapture(PayInIntent payInIntentCapture, String intentId, String idempotencyKey) throws Exception;

    /**
     * Get a PayInIntent
     *
     * @param intentId The intent identifier
     * @return PayInIntent instance
     * @throws Exception
     */
    PayInIntent getPayInIntent(String intentId) throws Exception;

//    /**
//     * Update a PayInIntent
//     *
//     * @param intentId The intent identifier
//     * @param intent   The object containing the updated fields
//     * @return PayInIntent instance
//     * @throws Exception
//     */
//    PayInIntent updatePayInIntent(String intentId, PayInIntent intent) throws Exception;

//    /**
//     * Cancel a PayInIntent
//     *
//     * @param intentId The intent identifier
//     * @param intent   The object containing required fields for canceling
//     * @return PayInIntent instance
//     * @throws Exception
//     */
//    PayInIntent cancelPayInIntent(String intentId, PayInIntent intent) throws Exception;

    /**
     * Create Intent splits
     * @param intentId The Intent identifier
     * @param splits Object containing array of splits to be created
     * @param idempotencyKey Idempotency key for this request. Can be null.
     * @return Created splits
     * @throws Exception
     */
    IntentSplits createPayInIntentSplits(String intentId, IntentSplits splits, String idempotencyKey) throws Exception;

    /**
     * Execute Split
     *
     * @param intentId       The Intent identifier
     * @param splitId        The Split identifier
     * @param idempotencyKey Idempotency key for this request. Can be null.
     * @return Executed split
     * @throws Exception
     */
    PayInIntentSplit executePayInIntentSplit(String intentId, String splitId, String idempotencyKey) throws Exception;

    /**
     * Reverse Split
     *
     * @param intentId       The Intent identifier
     * @param splitId        The Split identifier
     * @param idempotencyKey Idempotency key for this request. Can be null.
     * @return Reversed split
     * @throws Exception
     */
    PayInIntentSplit reversePayInIntentSplit(String intentId, String splitId, String idempotencyKey) throws Exception;

    /**
     * Get Split
     *
     * @param intentId The Intent identifier
     * @param splitId  The Split identifier
     * @return Reversed split
     * @throws Exception
     */
    PayInIntentSplit getPayInIntentSplit(String intentId, String splitId) throws Exception;

    /**
     * Update split
     *
     * @param intentId Intent identifier
     * @param splitId  Split identifier
     * @param split    The split containing properties to be updated
     * @return The updated split
     * @throws Exception
     */
    PayInIntentSplit updatePayInIntentSplit(String intentId, String splitId, PayInIntentSplit split) throws Exception;
}
