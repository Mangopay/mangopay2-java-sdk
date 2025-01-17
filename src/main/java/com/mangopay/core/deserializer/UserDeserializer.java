package com.mangopay.core.deserializer;

import com.google.gson.*;
import com.mangopay.core.enumerations.PersonType;
import com.mangopay.entities.*;

import java.lang.reflect.Type;

public class UserDeserializer implements JsonDeserializer<User> {
    @Override
    public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        PersonType type = PersonType.valueOf(jsonObject.get("PersonType").getAsString());
        if (type.equals(PersonType.LEGAL)) {
            // if the json has SCA related properties -> deserialize to UserLegalSca
            // !!! THIS LOGIC SHOULD NOT BE CHANGED ON API SIDE !!!
            if (jsonObject.has("PendingUserAction")) {
                return context.deserialize(json, UserLegalSca.class);
            }
            return context.deserialize(json, UserLegal.class);
        } else if (type.equals(PersonType.NATURAL)) {
            // if the json has SCA related properties -> deserialize to UserNaturalSca
            // !!! THIS LOGIC SHOULD NOT BE CHANGED ON API SIDE !!!
            if (jsonObject.has("PendingUserAction")) {
                return context.deserialize(json, UserNaturalSca.class);
            }
            return context.deserialize(json, UserNatural.class);
        } else {
            throw new IllegalArgumentException("Invalid user JSON:" + json.getAsJsonObject().toString());
        }
    }
}
