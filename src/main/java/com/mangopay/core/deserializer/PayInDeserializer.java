package com.mangopay.core.deserializer;

import com.google.gson.*;
import com.mangopay.core.Money;
import com.mangopay.entities.BankAccount;
import com.mangopay.entities.PayIn;
import com.mangopay.entities.subentities.PayInPaymentDetailsBankWire;

import java.lang.reflect.Type;

public class PayInDeserializer implements JsonDeserializer<PayIn> {

    @Override
    public PayIn deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();
        PayIn payIn = new Gson().fromJson(object.toString(), PayIn.class);
        switch (payIn.getPaymentType()) {
            case BANK_WIRE:
                JsonObject declaredDebitedFunds = object.get("DeclaredDebitedFunds").getAsJsonObject();
                JsonObject declaredFees = object.get("DeclaredFees").getAsJsonObject();
                JsonObject bankAccount = object.get("BankAccount").getAsJsonObject();
                String wireReference = object.get("WireReference").getAsString();

                PayInPaymentDetailsBankWire payInDetails = new PayInPaymentDetailsBankWire(
                        (Money) context.deserialize(declaredDebitedFunds, Money.class),
                        (Money) context.deserialize(declaredFees, Money.class),
                        (BankAccount) context.deserialize(bankAccount, BankAccount.class),
                        wireReference
                );
                payIn.setPaymentDetails(payInDetails);
                return payIn;
            default:
                return null;
        }
    }
}
