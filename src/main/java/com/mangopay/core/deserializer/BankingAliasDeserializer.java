package com.mangopay.core.deserializer;

import com.google.gson.*;
import com.mangopay.core.enumerations.BankingAliasType;
import com.mangopay.entities.BankingAlias;
import com.mangopay.entities.subentities.BankingAliasDetailsIBAN;

import java.lang.reflect.Type;

public class BankingAliasDeserializer implements JsonDeserializer<BankingAlias> {
    @Override
    public BankingAlias deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        BankingAlias bankingAlias = new Gson().fromJson(jsonObject.toString(), BankingAlias.class);
        BankingAliasType type = bankingAlias.getType();
        switch (type){
            case IBAN:
                BankingAliasDetailsIBAN bankingAliasDetailsIBAN = new BankingAliasDetailsIBAN();
                bankingAliasDetailsIBAN.setBIC(jsonObject.get("BIC").getAsString());
                bankingAliasDetailsIBAN.setIBAN(jsonObject.get("IBAN").getAsString());
                bankingAlias.setDetails(bankingAliasDetailsIBAN);
                break;
        }
        return bankingAlias;
    }
}
