package com.mangopay.core.deserializer;

import com.google.gson.*;
import com.mangopay.entities.Transfer;

import java.lang.reflect.Type;

public class TransferDeserializer implements JsonDeserializer<Transfer> {
    @Override
    public Transfer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        Transfer transfer = new Gson().fromJson(jsonObject.toString(), Transfer.class);
        if (jsonObject.has("DebitedWalletId") && !jsonObject.get("DebitedWalletId").isJsonNull())
            transfer.setDebitedWalletId(jsonObject.get("DebitedWalletId").getAsString());
        if (jsonObject.has("CreditedWalletId") && !jsonObject.get("CreditedWalletId").isJsonNull())
            transfer.setCreditedWalletId(jsonObject.get("CreditedWalletId").getAsString());
        return transfer;
    }
}
