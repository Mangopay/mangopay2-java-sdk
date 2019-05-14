package com.mangopay.core.deserializer;

import com.google.gson.*;
import com.mangopay.entities.Transfer;

import java.lang.reflect.Type;

public class TransferDeserializer implements JsonDeserializer<Transfer> {
    @Override
    public Transfer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        Transfer transfer = new Gson().fromJson(jsonObject.toString(), Transfer.class);
        transfer.setCreditedWalletId(jsonObject.get("CreditedWalletId").getAsString());
        transfer.setDebitedWalletId(jsonObject.get("DebitedWalletId").getAsString());
        return transfer;
    }
}
