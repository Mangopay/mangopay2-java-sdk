package com.mangopay.core.APIs.implementation;

import com.google.gson.GsonBuilder;
import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.PayInApi;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.core.deserializer.PayInDeserializer;
import com.mangopay.core.deserializer.RecurringPayInDeserializer;
import com.mangopay.core.serializer.PayInSerializer;
import com.mangopay.entities.*;
import com.mangopay.entities.subentities.CreateCardPreAuthorizedDepositPayIn;
import com.mangopay.entities.subentities.PayPalWebTracking;

import java.util.List;

/**
 * API for payIns.
 */
public class PayInApiImpl extends ApiBase implements PayInApi {

    /**
     * Instantiates new PayInApiImpl object.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public PayInApiImpl(MangoPayApi root, GsonBuilder gsonBuilder) {
        super(root);

        gsonBuilder.registerTypeAdapter(PayIn.class, new PayInSerializer());
        gsonBuilder.registerTypeAdapter(PayIn.class, new PayInDeserializer());
        gsonBuilder.registerTypeAdapter(RecurringPayIn.class, new RecurringPayInDeserializer());
    }

    @Override
    public PayIn create(PayIn payIn) throws Exception {
        return this.create(null, payIn);
    }

    @Override
    public PayIn create(String idempotencyKey, PayIn payIn) throws Exception {
        String paymentKey = this.getPaymentKey(payIn);
        String executionKey = this.getExecutionKey(payIn);
        return this.createObject(PayIn.class, idempotencyKey, String.format("payins_%s-%s_create", paymentKey, executionKey), payIn);
    }

    @Override
    public RecurringPayment createRecurringPayment(String idempotencyKey, CreateRecurringPayment createRecurringPayment) throws Exception {
        return this.createObject(RecurringPayment.class, idempotencyKey, "payins_recurring_registration", createRecurringPayment);
    }

    @Override
    public RecurringPaymentExtended getRecurringPayment(String payInId) throws Exception {
        return this.getObject(RecurringPaymentExtended.class, "payins_recurring_registration_get", payInId);
    }

    @Override
    public RecurringPaymentExtended updateRecurringPayment(String payInId, RecurringPaymentUpdate payIn) throws Exception {
        return this.updateObject(RecurringPaymentExtended.class, "payins_recurring_registration_put", payIn, payInId);
    }

    @Override
    public RecurringPayIn createRecurringPayInCIT(String idempotencyKey, RecurringPayInCIT cit) throws Exception {
        return this.createObject(RecurringPayIn.class, idempotencyKey, "payins_recurring_card_direct", cit);
    }

    @Override
    public RecurringPayIn createRecurringPayInMIT(String idempotencyKey, RecurringPayInMIT mit) throws Exception {
        return this.createObject(RecurringPayIn.class, idempotencyKey, "payins_recurring_card_direct", mit);
    }

    @Override
    public RecurringPayIn createRecurringPayPalPayInCIT(String idempotencyKey, RecurringPayPalPayInCIT cit) throws Exception {
        return this.createObject(RecurringPayIn.class, idempotencyKey, "payins_recurring_paypal", cit);
    }

    @Override
    public RecurringPayIn createRecurringPayPalPayInMIT(String idempotencyKey, RecurringPayPalPayInMIT mit) throws Exception {
        return this.createObject(RecurringPayIn.class, idempotencyKey, "payins_recurring_paypal", mit);
    }

    @Override
    public PayIn get(String payInId) throws Exception {
        return this.getObject(PayIn.class, "payins_get", payInId);
    }

    @Override
    public Refund createRefund(String payInId, Refund refund) throws Exception {
        return this.createRefund(null, payInId, refund);
    }

    @Override
    public Refund createRefund(String idempotencyKey, String payInId, Refund refund) throws Exception {
        return this.createObject(Refund.class, idempotencyKey, "payins_createrefunds", refund, payInId);
    }

    @Override
    public Refund getRefund(String payInId) throws Exception {
        return this.getObject(Refund.class, "payins_getrefunds", payInId);
    }

    @Override
    public List<Refund> getRefunds(String payInId) throws Exception {
        return this.getRefunds(payInId, null, null);
    }

    @Override
    public List<Refund> getRefunds(String payInId, Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(Refund[].class, Refund.class, "payin_get_refunds", pagination, payInId, sorting);
    }

    @Override
    public CardPreAuthorizedDepositPayIn createCardPreAuthorizedDepositPayIn(CreateCardPreAuthorizedDepositPayIn payIn, String idempotencyKey) throws Exception {
        return this.createObject(CardPreAuthorizedDepositPayIn.class, idempotencyKey, "payins_card_preauthorized_deposit", payIn);
    }

    private String getPaymentKey(PayIn payIn) throws Exception {

        if (payIn.getPaymentDetails() == null)
            throw new Exception("Payment is not defined or it is not object type");

        String className = payIn.getPaymentDetails().getClass().getSimpleName().replace("PayInPaymentDetails", "");
        return className.toLowerCase();
    }

    private String getExecutionKey(PayIn payIn) throws Exception {

        if (payIn.getExecutionDetails() != null) {
            String className = payIn.getExecutionDetails().getClass().getSimpleName().replace("PayInExecutionDetails", "");
            return className.toLowerCase();
        }
        if (payIn.getExecutionType() != null) {
            return payIn.getExecutionType().toString().toLowerCase();
        }
        throw new Exception("Execution is not defined or it is not object type");
    }

    @Override
    public PayIn createPayPal(PayIn payIn) throws Exception {
        return this.createObject(PayIn.class, null, "payins_paypal-web_create_v2", payIn);
    }

    @Override
    public PaymentMethodMetadata getPaymentMethodMetadata(PaymentMethodMetadata metadata) throws Exception {
        return this.createObject(PaymentMethodMetadata.class, null, "payment_method-metadata", metadata);
    }

    @Override
    public PayIn addPayPalTrackingInformation(String payInId, PayPalWebTracking trackingData) throws Exception {
        return this.updateObject(PayIn.class, "add_tracking_info", trackingData, payInId);
    }

    @Override
    public PayIn createPayconiq(PayIn payIn, String idempotencyKey) throws Exception {
        return this.createObject(PayIn.class, idempotencyKey, "payins_payconiqv2-web_create", payIn);
    }

    @Override
    public PayIn createDepositPreauthorizedPayInWithoutComplement(PayIn payIn, String idempotencyKey) throws Exception {
        return this.createObject(PayIn.class, idempotencyKey, "payins_card_preauthorized_deposit", payIn);
    }

    @Override
    public PayIn createDepositPreauthorizedPayInPriorToComplement(PayIn payIn, String idempotencyKey) throws Exception {
        return this.createObject(PayIn.class, idempotencyKey, "payins_deposit_preauthorized_prior_to_complement", payIn);
    }

    @Override
    public PayIn createDepositPreauthorizedPayInComplement(PayIn payIn, String idempotencyKey) throws Exception {
        return this.createObject(PayIn.class, idempotencyKey, "payins_deposit_preauthorized_complement", payIn);
    }
}
