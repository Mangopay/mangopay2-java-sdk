package com.mangopay.core.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mangopay.core.enumerations.PersonType;
import com.mangopay.entities.User;
import com.mangopay.entities.UserLegal;
import com.mangopay.entities.UserNatural;

import java.lang.reflect.Type;

public class UserSerializer implements JsonSerializer<User> {
    @Override
    public JsonElement serialize(User src, Type typeOfSrc, JsonSerializationContext context) {
        PersonType personType = src.getPersonType();
        if (personType.equals(PersonType.LEGAL)) {
            return context.serialize(src, UserLegal.class);
        } else {
            if (personType.equals(PersonType.NATURAL)) {
                return context.serialize(src, UserNatural.class);
            } else {
                throw new IllegalArgumentException("Invalid user JSON:" + context.toString());
            }
        }
    }
}
