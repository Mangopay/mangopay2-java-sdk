package com.mangopay.core.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mangopay.core.enumerations.BankAccountType;
import com.mangopay.entities.BankAccount;
import com.mangopay.entities.subentities.*;

import java.lang.reflect.Type;

public class BankAccountSerializer implements JsonSerializer<BankAccount> {
    @Override
    public JsonElement serialize(BankAccount src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("Id", src.getId());
        object.addProperty("Tag", src.getTag());
        object.addProperty("CreationDate", src.getCreationDate());
        object.addProperty("UserId", src.getUserId());
        object.addProperty("Type", String.valueOf(src.getType()));
        object.addProperty("OwnerName", src.getOwnerName());
        object.add("OwnerAddress", context.serialize(src.getOwnerAddress()));
        BankAccountType accountType = src.getType();
        switch (accountType) {
            case GB:
                BankAccountDetailsGB accountDetailsGB = (BankAccountDetailsGB) src.getDetails();
                object.addProperty("AccountNumber", accountDetailsGB.getAccountNumber());
                object.addProperty("SortCode", accountDetailsGB.getSortCode());
                break;
            case US:
                BankAccountDetailsUS bankAccountDetailsUS = (BankAccountDetailsUS) src.getDetails();
                object.addProperty("ABA", bankAccountDetailsUS.getAba());
                object.addProperty("AccountNumber", bankAccountDetailsUS.getAccountNumber());
                object.addProperty("DepositAccountType", bankAccountDetailsUS.getDepositAccountType().toString());
                break;
            case CA:
                BankAccountDetailsCA bankAccountDetailsCA = (BankAccountDetailsCA) src.getDetails();
                object.addProperty("AccountNumber", bankAccountDetailsCA.getAccountNumber());
                object.addProperty("BankName", bankAccountDetailsCA.getBankName());
                object.addProperty("BranchCode", bankAccountDetailsCA.getBranchCode());
                object.addProperty("InstitutionNumber", bankAccountDetailsCA.getInstitutionNumber());
                break;
            case IBAN:
                BankAccountDetailsIBAN bankAccountDetailsIBAN = (BankAccountDetailsIBAN) src.getDetails();
                object.addProperty("BIC", bankAccountDetailsIBAN.getBic());
                object.addProperty("IBAN", bankAccountDetailsIBAN.getIban());
                break;
            case OTHER:
                BankAccountDetailsOTHER bankAccountDetailsOTHER = (BankAccountDetailsOTHER) src.getDetails();
                object.addProperty("AccountNumber", bankAccountDetailsOTHER.getAccountNumber());
                object.addProperty("BIC", bankAccountDetailsOTHER.getBic());
                object.addProperty("Country", bankAccountDetailsOTHER.getCountry().toString());
                break;
            default:
                throw new IllegalArgumentException("Invalid BankAccountDetails JSON");
        }
        return object;
    }
}
