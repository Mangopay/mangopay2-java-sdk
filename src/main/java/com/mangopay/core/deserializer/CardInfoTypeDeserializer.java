package com.mangopay.core.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.mangopay.core.enumerations.CardInfoType;

import java.lang.reflect.Type;

public class CardInfoTypeDeserializer implements JsonDeserializer<CardInfoType> {
    @Override
    public CardInfoType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String value = json.getAsString();
        if ("CHARGE CARD".equals(value)) {
            return CardInfoType.CHARGE_CARD;
        }
        return CardInfoType.valueOf(value);
    }
}
