package com.mangopay.core.deserializer;

import com.google.gson.*;
import com.mangopay.core.Money;
import com.mangopay.core.enumerations.PayoutMode;
import com.mangopay.entities.PayOut;
import com.mangopay.entities.subentities.FallbackReason;
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
                if (object.has("ModeRequested") && !object.get("ModeRequested").isJsonNull())
                    meanOfPaymentDetails.setPayoutModeRequested(PayoutMode.valueOf(object.get("ModeRequested").getAsString()));
                if (object.has("ModeApplied") && !object.get("ModeApplied").isJsonNull())
                    meanOfPaymentDetails.setPayoutModeApplied(object.get("ModeApplied").getAsString());
                if (object.has("FallbackReason")&& !object.get("FallbackReason").isJsonNull())
                    meanOfPaymentDetails.setFallbackReason((FallbackReason) context.deserialize(object.get("FallbackReason"), FallbackReason.class));
                if (object.has("Status") && !object.get("Status").isJsonNull())
                    meanOfPaymentDetails.setStatus(object.get("Status").getAsString());
                payOut.setMeanOfPaymentDetails(meanOfPaymentDetails);
                return payOut;
            default:
                return null;
        }
    }
}
