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
                PayOutPaymentDetailsBankWire meanOfPaymentDetails = new PayOutPaymentDetailsBankWire();
                if (object.has("BankAccountId") && !object.get("BankAccountId").isJsonNull())
                    meanOfPaymentDetails.setBankAccountId(object.get("BankAccountId").getAsString());
                if (object.has("BankWireRef") && !object.get("BankWireRef").isJsonNull())
                    meanOfPaymentDetails.setBankWireRef(object.get("BankWireRef").getAsString());
                if (object.has("PayoutModeRequested") && !object.get("PayoutModeRequested").isJsonNull())
                    meanOfPaymentDetails.setPayoutModeRequested(object.get("PayoutModeRequested").getAsString());
                payOut.setMeanOfPaymentDetails(meanOfPaymentDetails);
                return payOut;
            default:
                return null;
        }
    }
}
