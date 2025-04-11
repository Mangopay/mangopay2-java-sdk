package com.mangopay.core.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mangopay.entities.Transfer;

import java.lang.reflect.Type;

public class TransferSerializer implements JsonSerializer<Transfer> {
    @Override
    public JsonElement serialize(Transfer src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = SerializedTransaction.getTransactionObject(src, context);
        object.add("DebitedWalletId", context.serialize(src.getDebitedWalletId()));
        object.add("CreditedWalletId", context.serialize(src.getCreditedWalletId()));
        object.add("ScaContext", context.serialize(src.getScaContext()));
        return object;
    }
}
