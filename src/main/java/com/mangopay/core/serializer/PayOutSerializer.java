package com.mangopay.core.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mangopay.entities.PayOut;
import com.mangopay.entities.subentities.PayOutPaymentDetailsBankWire;

import java.lang.reflect.Type;

public class PayOutSerializer implements JsonSerializer<PayOut> {
    @Override
    public JsonElement serialize(PayOut src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = SerializedTransaction.getTransactionObject(src, context);
        object.add("DebitedWalletId", context.serialize(src.getDebitedWalletId()));
        object.add("PaymentType", context.serialize(src.getPaymentType()));
        switch (src.getMeanOfPaymentDetails().getClass().getSimpleName()) {
            case "PayOutPaymentDetailsBankWire":
                object.add("BankAccountId", context.serialize(((PayOutPaymentDetailsBankWire) src.getMeanOfPaymentDetails()).getBankAccountId()));
                object.add("BankWireRef", context.serialize(((PayOutPaymentDetailsBankWire) src.getMeanOfPaymentDetails()).getBankWireRef()));
                object.add("PayoutModeRequested", context.serialize(((PayOutPaymentDetailsBankWire) src.getMeanOfPaymentDetails()).getPayoutModeRequested()));
                object.add("RecipientVerificationOfPayee", context.serialize(((PayOutPaymentDetailsBankWire) src.getMeanOfPaymentDetails()).getRecipientVerificationOfPayee()));
                return object;
            default:
                return null;
        }
    }
}
