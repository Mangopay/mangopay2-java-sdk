package com.mangopay.core.serializer;

import com.google.gson.*;
import com.mangopay.core.enumerations.PersonType;
import com.mangopay.entities.User;
import com.mangopay.entities.UserLegal;
import com.mangopay.entities.UserNatural;
import com.mangopay.entities.UserNaturalSca;

import java.lang.reflect.Type;

public class UserSerializer implements JsonSerializer<User> {
    @Override
    public JsonElement serialize(User src, Type typeOfSrc, JsonSerializationContext context) {
        PersonType personType = src.getPersonType();
        JsonObject object = new Gson().toJsonTree(src, typeOfSrc).getAsJsonObject();
        if (personType.equals(PersonType.LEGAL)) {
            if (((UserLegal)src).getHeadquartersAddress() != null && ((UserLegal)src).getHeadquartersAddress().allFieldsNull())
                object.add("HeadquartersAddress", null);
            if (((UserLegal)src).getLegalRepresentativeAddress() != null &&((UserLegal)src).getLegalRepresentativeAddress().allFieldsNull())
                object.add("LegalRepresentativeAddress", null);
            return object;
        } else {
            if (personType.equals(PersonType.NATURAL)) {
                if (src instanceof UserNaturalSca) {
                    if (((UserNaturalSca)src).getAddress() != null && ((UserNaturalSca)src).getAddress().allFieldsNull())
                        object.add("Address", null);
                    // other sub-objects...
                } else if (src instanceof UserNatural) {
                    if (((UserNatural)src).getAddress() != null && ((UserNatural)src).getAddress().allFieldsNull())
                        object.add("Address", null);
                }
                return object;
            } else {
                throw new IllegalArgumentException("Invalid user JSON:" + context.toString());
            }
        }
    }
}
