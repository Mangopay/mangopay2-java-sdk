package com.mangopay.core.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mangopay.entities.PayPalDataCollection;

import java.lang.reflect.Type;
import java.util.Map;

public class PayPalDataCollectionSerializer implements JsonSerializer<PayPalDataCollection> {

    @Override
    public JsonElement serialize(PayPalDataCollection data, Type type, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        Map<String, Object> map = data.getData();

        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jsonObject.add(entry.getKey(), context.serialize(entry.getValue()));
            }
        }

        return jsonObject;
    }
}
