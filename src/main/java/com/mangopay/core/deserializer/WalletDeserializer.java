package com.mangopay.core.deserializer;

import com.google.gson.*;
import com.mangopay.core.Money;
import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.core.enumerations.FundsType;
import com.mangopay.entities.Wallet;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class WalletDeserializer implements JsonDeserializer<Wallet> {
    @Override
    public Wallet deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();
        JsonArray ownersJson = object.get("Owners").getAsJsonArray();
        ArrayList<String> owners = new ArrayList<>();
        for (JsonElement owner : ownersJson) {
            owners.add((String) context.deserialize(owner, String.class));
        }
        JsonObject balance = object.get("Balance").getAsJsonObject();
        return new Wallet(owners,
                object.get("Description").getAsString(),
                (Money) context.deserialize(balance, Money.class),
                CurrencyIso.valueOf(object.get("Currency").getAsString()),
                FundsType.valueOf(object.get("FundsType").getAsString()));
    }
}
