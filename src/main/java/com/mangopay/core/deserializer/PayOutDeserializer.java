package com.mangopay.core.deserializer;

import com.google.gson.*;
import com.mangopay.entities.PayOut;
import com.mangopay.entities.subentities.PayOutPaymentDetailsBankWire;

import java.lang.reflect.Type;

public class PayOutDeserializer implements JsonDeserializer<PayOut> {
    @Override
    public PayOut deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();
        PayOut payOut = new Gson().fromJson(object.toString(), PayOut.class);
        switch (payOut.getPaymentType()) {
            case BANK_WIRE:
                String bankAccountId = object.get("BankAccountId").getAsString();
                String bankWireRef = object.get("BankWireRef").getAsString();

                PayOutPaymentDetailsBankWire meanOfPaymentDetails = new PayOutPaymentDetailsBankWire(
                        bankAccountId,
                        bankWireRef);
                payOut.setMeanOfPaymentDetails(meanOfPaymentDetails);
                return payOut;
            default:
                return null;
        }
    }
}
