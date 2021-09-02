package com.mangopay.core.deserializer;

import com.google.gson.*;
import com.mangopay.core.Billing;
import com.mangopay.core.SecurityInfo;
import com.mangopay.core.enumerations.CardType;
import com.mangopay.core.enumerations.CultureCode;
import com.mangopay.core.enumerations.SecureMode;
import com.mangopay.entities.RecurringPayIn;
import com.mangopay.entities.subentities.*;

import java.lang.reflect.Type;

public class RecurringPayInDeserializer implements JsonDeserializer<RecurringPayIn> {

    @Override
    public RecurringPayIn deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();
        RecurringPayIn payIn = new Gson().fromJson(object.toString(), RecurringPayIn.class);
        if (payIn.getPaymentType() == null)
            return null;
        switch (payIn.getPaymentType()) {
            case CARD:
                PayInPaymentDetailsCard payInPaymentDetailsCard = new PayInPaymentDetailsCard();
                if (object.has("CardType") && !object.get("CardType").isJsonNull())
                    payInPaymentDetailsCard.setCardType(CardType.valueOf(object.get("CardType").getAsString()));
                if (object.has("CardId") && !object.get("CardId").isJsonNull())
                    payInPaymentDetailsCard.setCardId(object.get("CardId").getAsString());
                if (object.has("StatementDescriptor") && !object.get("StatementDescriptor").isJsonNull())
                    payInPaymentDetailsCard.setStatementDescriptor(object.get("StatementDescriptor").getAsString());
                payIn.setPaymentDetails(payInPaymentDetailsCard);
                break;
            default:
                return null;
        }
        switch (payIn.getExecutionType()) {
            case DIRECT:
                PayInExecutionDetailsDirect payInExecutionDetailsDirect = new PayInExecutionDetailsDirect();
                if (object.has("CardId") && !object.get("CardId").isJsonNull())
                    payInExecutionDetailsDirect.setCardId(object.get("CardId").getAsString());
                if (object.has("SecureMode") && !object.get("SecureMode").isJsonNull())
                    payInExecutionDetailsDirect.setSecureMode(SecureMode.valueOf(object.get("SecureMode").getAsString()));
                if (object.has("SecureModeReturnURL") && !object.get("SecureModeReturnURL").isJsonNull())
                    payInExecutionDetailsDirect.setSecureModeReturnUrl(object.get("SecureModeReturnURL").getAsString());
                if (object.has("SecureModeRedirectURL") && !object.get("SecureModeRedirectURL").isJsonNull())
                    payInExecutionDetailsDirect.setSecureModeRedirectUrl(object.get("SecureModeRedirectURL").getAsString());
                if (object.has("SecureModeNeeded") && !object.get("SecureModeNeeded").isJsonNull())
                    payInExecutionDetailsDirect.setSecureModeNeeded(object.get("SecureModeNeeded").getAsString());
                if (object.has("Billing") && !object.get("Billing").isJsonNull())
                    payInExecutionDetailsDirect.setBilling((Billing) context.deserialize(object.get("Billing"), Billing.class));
                if (object.has("SecurityInfo") && !object.get("SecurityInfo").isJsonNull())
                    payInExecutionDetailsDirect.setSecurityInfo((SecurityInfo) context.deserialize(object.get("SecurityInfo"), SecurityInfo.class));
                if (object.has("Culture") && !object.get("Culture").isJsonNull())
                    payInExecutionDetailsDirect.setCulture(CultureCode.valueOf(object.get("Culture").getAsString()));
                if (object.has("Requested3DSVersion") && !object.get("Requested3DSVersion").isJsonNull())
                    payInExecutionDetailsDirect.setRequested3DSVersion(object.get("Requested3DSVersion").getAsString());
                if (object.has("Applied3DSVersion") && !object.get("Applied3DSVersion").isJsonNull())
                    payInExecutionDetailsDirect.setApplied3DSVersion(object.get("Applied3DSVersion").getAsString());
                payIn.setExecutionDetails(payInExecutionDetailsDirect);
                break;
        }

        return payIn;
    }
}
