package com.mangopay.core.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mangopay.entities.Card;

import java.lang.reflect.Type;

public class CardSerializer implements JsonSerializer<Card> {
    @Override
    public JsonElement serialize(Card src, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(src);
    }
}
