package com.mangopay.core.deserializer;

import com.google.gson.*;
import com.mangopay.core.enumerations.PersonType;
import com.mangopay.entities.User;
import com.mangopay.entities.UserLegal;
import com.mangopay.entities.UserNatural;

import java.lang.reflect.Type;

public class UserDeserializer implements JsonDeserializer<User> {
    @Override
    public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        PersonType type = PersonType.valueOf(jsonObject.get("PersonType").getAsString());
        if (type.equals(PersonType.LEGAL)) {
            return context.deserialize(json, UserLegal.class);
        } else if (type.equals(PersonType.NATURAL)) {
            return context.deserialize(json, UserNatural.class);
        } else {
            throw new IllegalArgumentException("Invalid user JSON:" + json.getAsJsonObject().toString());
        }
    }
}
