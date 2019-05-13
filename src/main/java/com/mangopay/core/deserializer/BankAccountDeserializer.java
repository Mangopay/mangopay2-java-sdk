package com.mangopay.core.deserializer;

import com.google.gson.*;
import com.mangopay.core.enumerations.BankAccountType;
import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.core.enumerations.DepositAccountType;
import com.mangopay.entities.BankAccount;
import com.mangopay.entities.subentities.*;

import java.lang.reflect.Type;

public class BankAccountDeserializer implements JsonDeserializer<BankAccount> {
    @Override
    public BankAccount deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        BankAccount bankAccount = new Gson().fromJson(jsonObject.toString(), BankAccount.class);
        BankAccountType accountType = bankAccount.getType();
        switch (accountType) {
            case GB:
                BankAccountDetailsGB bankAccountDetailsGB = new BankAccountDetailsGB();
                bankAccountDetailsGB.setAccountNumber(jsonObject.get("AccountNumber").getAsString());
                bankAccountDetailsGB.setSortCode(jsonObject.get("SortCode").getAsString());
                bankAccount.setDetails(bankAccountDetailsGB);
                break;
            case US:
                BankAccountDetailsUS bankAccountDetailsUS = new BankAccountDetailsUS();
                bankAccountDetailsUS.setAba(jsonObject.get("ABA").getAsString());
                bankAccountDetailsUS.setAccountNumber(jsonObject.get("AccountNumber").getAsString());
                bankAccountDetailsUS.setDepositAccountType(DepositAccountType.valueOf(jsonObject.get("DepositAccountType").getAsString()));
                bankAccount.setDetails(bankAccountDetailsUS);
                break;
            case CA:
                BankAccountDetailsCA bankAccountDetailsCA = new BankAccountDetailsCA();
                bankAccountDetailsCA.setAccountNumber(jsonObject.get("AccountNumber").getAsString());
                bankAccountDetailsCA.setBankName(jsonObject.get("BankName").getAsString());
                bankAccountDetailsCA.setBranchCode(jsonObject.get("BranchCode").getAsString());
                bankAccountDetailsCA.setInstitutionNumber(jsonObject.get("InstitutionNumber").getAsString());
                bankAccount.setDetails(bankAccountDetailsCA);
                break;
            case IBAN:
                BankAccountDetailsIBAN bankAccountDetailsIBAN = new BankAccountDetailsIBAN();
                bankAccountDetailsIBAN.setBic(jsonObject.get("BIC").getAsString());
                bankAccountDetailsIBAN.setIban(jsonObject.get("IBAN").getAsString());
                bankAccount.setDetails(bankAccountDetailsIBAN);
                break;
            case OTHER:
                BankAccountDetailsOTHER bankAccountDetailsOTHER = new BankAccountDetailsOTHER();
                bankAccountDetailsOTHER.setAccountNumber(jsonObject.get("AccountNumber").getAsString());
                bankAccountDetailsOTHER.setBic(jsonObject.get("BIC").getAsString());
                bankAccountDetailsOTHER.setCountry(CountryIso.valueOf(jsonObject.get("Country").getAsString()));
                bankAccount.setDetails(bankAccountDetailsOTHER);
                break;
            default:
                return null;
        }
        return bankAccount;
    }
}
