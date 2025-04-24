package com.mangopay.core.deserializer;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.mangopay.core.*;
import com.mangopay.core.enumerations.CardType;
import com.mangopay.core.enumerations.CultureCode;
import com.mangopay.core.enumerations.SecureMode;
import com.mangopay.core.enumerations.ShippingPreference;
import com.mangopay.entities.RecurringPayIn;
import com.mangopay.entities.subentities.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
                if (object.has("CardInfo") && !object.get("CardInfo").isJsonNull())
                    payInPaymentDetailsCard.setCardInfo((CardInfo) context.deserialize(object.get("CardInfo"), CardInfo.class));
                payIn.setPaymentDetails(payInPaymentDetailsCard);
                break;
            case PAYPAL:
                PayInPaymentDetailsPayPal payInPaymentDetailsPayPal = new PayInPaymentDetailsPayPal();
                if (object.has("ShippingAddress") && !object.get("ShippingAddress").isJsonNull())
                    payInPaymentDetailsPayPal.setShippingAddress((ShippingAddress) context.deserialize(object.get("ShippingAddress"), ShippingAddress.class));
                if (object.has("PaypalBuyerAccountEmail") && !object.get("PaypalBuyerAccountEmail").isJsonNull())
                    payInPaymentDetailsPayPal.setPaypalBuyerAccountEmail(object.get("PaypalBuyerAccountEmail").getAsString());
                // v2
                if (object.has("StatementDescriptor") && !object.get("StatementDescriptor").isJsonNull())
                    payInPaymentDetailsPayPal.setStatementDescriptor(object.get("StatementDescriptor").getAsString());
                if (object.has("Shipping") && !object.get("Shipping").isJsonNull())
                    payInPaymentDetailsPayPal.setShipping((Shipping) context.deserialize(object.get("Shipping"), Shipping.class));
                if (object.has("LineItems") && !object.get("LineItems").isJsonNull()) {
                    Type listType = new TypeToken<ArrayList<LineItem>>() {
                    }.getType();
                    payInPaymentDetailsPayPal.setLineItems((List<LineItem>) context.deserialize(object.get("LineItems"), listType));
                }
                if (object.has("ShippingPreference") && !object.get("ShippingPreference").isJsonNull()) {
                    payInPaymentDetailsPayPal.setShippingPreference(ShippingPreference.valueOf(object.get("ShippingPreference").getAsString()));
                }
                if (object.has("Reference") && !object.get("Reference").isJsonNull()) {
                    payInPaymentDetailsPayPal.setReference(object.get("Reference").getAsString());
                }
                if (object.has("CancelURL") && !object.get("CancelURL").isJsonNull()) {
                    payInPaymentDetailsPayPal.setCancelUrl(object.get("CancelURL").getAsString());
                }
                if (object.has("PaypalPayerID") && !object.get("PaypalPayerID").isJsonNull()) {
                    payInPaymentDetailsPayPal.setPaypalOrderID(object.get("PaypalPayerID").getAsString());
                }
                if (object.has("BuyerCountry") && !object.get("BuyerCountry").isJsonNull()) {
                    payInPaymentDetailsPayPal.setBuyerCountry(object.get("BuyerCountry").getAsString());
                }
                if (object.has("BuyerFirstname") && !object.get("BuyerFirstname").isJsonNull()) {
                    payInPaymentDetailsPayPal.setBuyerFirstName(object.get("BuyerFirstname").getAsString());
                }
                if (object.has("BuyerLastname") && !object.get("BuyerLastname").isJsonNull()) {
                    payInPaymentDetailsPayPal.setBuyerLastName(object.get("BuyerLastname").getAsString());
                }
                if (object.has("BuyerPhone") && !object.get("BuyerPhone").isJsonNull()) {
                    payInPaymentDetailsPayPal.setBuyerPhone(object.get("BuyerPhone").getAsString());
                }
                if (object.has("PaypalOrderID") && !object.get("PaypalOrderID").isJsonNull()) {
                    payInPaymentDetailsPayPal.setPaypalOrderID(object.get("PaypalOrderID").getAsString());
                }
                if (object.has("Trackings") && !object.get("Trackings").isJsonNull()) {
                    Type listType = new TypeToken<ArrayList<PayPalWebTracking>>() {
                    }.getType();
                    payInPaymentDetailsPayPal.setTrackings((List<PayPalWebTracking>) context.deserialize(object.get("Trackings"), listType));
                }

                payIn.setPaymentDetails(payInPaymentDetailsPayPal);
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
            case WEB:
                PayInExecutionDetailsWeb payInExecutionDetailsWeb = new PayInExecutionDetailsWeb();
                if (object.has("TemplateURL") && !object.get("TemplateURL").isJsonNull())
                    payInExecutionDetailsWeb.setTemplateUrl(object.get("TemplateURL").getAsString());
                if (object.has("Culture") && !object.get("Culture").isJsonNull())
                    payInExecutionDetailsWeb.setCulture(CultureCode.valueOf(object.get("Culture").getAsString()));
                if (object.has("SecureMode") && !object.get("SecureMode").isJsonNull())
                    payInExecutionDetailsWeb.setSecureMode(SecureMode.valueOf(object.get("SecureMode").getAsString()));
                if (object.has("RedirectURL") && !object.get("RedirectURL").isJsonNull())
                    payInExecutionDetailsWeb.setRedirectUrl(object.get("RedirectURL").getAsString());
                if (object.has("ReturnURL") && !object.get("ReturnURL").isJsonNull())
                    payInExecutionDetailsWeb.setReturnUrl(object.get("ReturnURL").getAsString());
                if (object.has("TemplateURLOptions") && !object.get("TemplateURLOptions").isJsonNull())
                    payInExecutionDetailsWeb.setTemplateURLOptions((PayInTemplateURLOptions) context.deserialize(object.get("TemplateURLOptions"), PayInTemplateURLOptions.class));
                payIn.setExecutionDetails(payInExecutionDetailsWeb);
                break;
            default:
                return null;
        }

        return payIn;
    }
}
