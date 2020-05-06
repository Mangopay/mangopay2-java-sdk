package com.mangopay.core.deserializer;

import com.google.gson.*;
import com.mangopay.core.enumerations.BankAccountType;
import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.core.enumerations.DepositAccountType;
import com.mangopay.entities.BankAccount;
import com.mangopay.entities.subentities.*;

import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                bankAccountDetailsUS.setAccountNumber(jsonObject.get("AccountNumber").getAsString());
                bankAccountDetailsUS.setAba(jsonObject.get("ABA").getAsString());
                bankAccountDetailsUS.setDepositAccountType(DepositAccountType.valueOf(jsonObject.get("DepositAccountType").getAsString()));
                bankAccount.setDetails(bankAccountDetailsUS);
                break;
            case CA:
                BankAccountDetailsCA bankAccountDetailsCA = new BankAccountDetailsCA();
                bankAccountDetailsCA.setBankName(jsonObject.get("BankName").getAsString());
                bankAccountDetailsCA.setInstitutionNumber(jsonObject.get("InstitutionNumber").getAsString());
                bankAccountDetailsCA.setBranchCode(jsonObject.get("BranchCode").getAsString());
                bankAccountDetailsCA.setAccountNumber(jsonObject.get("AccountNumber").getAsString());
                bankAccount.setDetails(bankAccountDetailsCA);
                break;
            case IBAN:
                bankAccount.setDetails(getBankAccountDetailsIBANFromJson(jsonObject));
                break;
            case OTHER:
                BankAccountDetailsOTHER bankAccountDetailsOTHER = new BankAccountDetailsOTHER();
                bankAccountDetailsOTHER.setCountry(CountryIso.valueOf(jsonObject.get("Country").getAsString()));
                bankAccountDetailsOTHER.setBic(jsonObject.get("BIC").getAsString());
                bankAccountDetailsOTHER.setAccountNumber(jsonObject.get("AccountNumber").getAsString());
                bankAccount.setDetails(bankAccountDetailsOTHER);
                break;
            default:
                return null;
        }
        return bankAccount;
    }

    private BankAccountDetailsIBAN getBankAccountDetailsIBANFromJson(JsonObject jObject) {
        BankAccountDetailsIBAN bankAccountDetailsIBAN = new BankAccountDetailsIBAN();
        bankAccountDetailsIBAN.setIban(jObject.get("IBAN").getAsString());
        try {
            bankAccountDetailsIBAN.setBic(jObject.get("BIC").getAsString());

        } catch (NullPointerException e) {
            Logger.getLogger(BankAccountDeserializer.class.getName()).log(Level.SEVERE, "BIC missing", e);
        }

        return bankAccountDetailsIBAN;
    }
}
