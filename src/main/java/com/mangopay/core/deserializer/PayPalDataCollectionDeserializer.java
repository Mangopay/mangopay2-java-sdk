package com.mangopay.core.deserializer;

import com.google.gson.*;
import com.mangopay.entities.PayPalDataCollection;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class PayPalDataCollectionDeserializer implements JsonDeserializer<PayPalDataCollection> {

    @Override
    public PayPalDataCollection deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        if (!json.isJsonObject()) {
            throw new JsonParseException("Expected JSON object");
        }

        JsonObject jsonObject = json.getAsJsonObject();
        Map<String, Object> dataMap = new HashMap<>();

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            JsonElement element = entry.getValue();
            Object value = context.deserialize(element, Object.class);
            dataMap.put(key, value);
        }

        return new PayPalDataCollection().setData(dataMap);
    }
}
