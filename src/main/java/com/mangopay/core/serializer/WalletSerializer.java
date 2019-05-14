package com.mangopay.core.serializer;

import com.google.gson.*;
import com.mangopay.entities.Wallet;

import java.lang.reflect.Type;

public class WalletSerializer implements JsonSerializer<Wallet> {
    @Override
    public JsonElement serialize(Wallet src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        JsonArray jsonElements = new JsonArray();
        for (String owner : src.getOwners()) {
            jsonElements.add(owner);
        }
        object.add("Id", context.serialize(src.getId()));
        object.add("Tag", context.serialize(src.getTag()));
        object.add("CreationDate", context.serialize(src.getCreationDate()));
        object.add("Owners", context.serialize(jsonElements));
        object.addProperty("Description", src.getDescription());
        object.add("Balance", context.serialize(src.getBalance()));
        object.addProperty("Currency", String.valueOf(src.getCurrency()));
        object.addProperty("FundsType", String.valueOf(src.getFundsType()));

        return object;
    }
}
