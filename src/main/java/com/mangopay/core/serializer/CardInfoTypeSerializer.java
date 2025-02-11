package com.mangopay.core.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mangopay.core.enumerations.CardInfoType;

import java.lang.reflect.Type;

public class CardInfoTypeSerializer implements JsonSerializer<CardInfoType> {
    @Override
    public JsonElement serialize(CardInfoType src, Type typeOfSrc, JsonSerializationContext context) {
        if (src == CardInfoType.CHARGE_CARD) {
            return new JsonPrimitive("CHARGE CARD");
        }
        return new JsonPrimitive(src.name());
    }
}
