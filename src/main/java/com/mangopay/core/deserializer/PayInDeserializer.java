package com.mangopay.core.deserializer;

import com.google.gson.*;
import com.mangopay.core.Billing;
import com.mangopay.core.Money;
import com.mangopay.core.SecurityInfo;
import com.mangopay.core.ShippingAddress;
import com.mangopay.core.enumerations.CardType;
import com.mangopay.core.enumerations.CultureCode;
import com.mangopay.core.enumerations.DirectDebitType;
import com.mangopay.core.enumerations.SecureMode;
import com.mangopay.entities.BankAccount;
import com.mangopay.entities.DebitedBankAccount;
import com.mangopay.entities.PayIn;
import com.mangopay.entities.subentities.*;

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
                break;
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
            case PREAUTHORIZED:
                PayInPaymentDetailsPreAuthorized payInPaymentDetailsPreAuthorized = new PayInPaymentDetailsPreAuthorized();
                if (object.has("PreauthorizationId") && !object.get("PreauthorizationId").isJsonNull())
                    payInPaymentDetailsPreAuthorized.setPreauthorizationId(object.get("PreauthorizationId").getAsString());
                if (object.has("Culture") && !object.get("Culture").isJsonNull())
                    payInPaymentDetailsPreAuthorized.setCulture(CultureCode.valueOf(object.get("Culture").getAsString()));
                payIn.setPaymentDetails(payInPaymentDetailsPreAuthorized);
                break;
            case PAYPAL:
                PayInPaymentDetailsPayPal payInPaymentDetailsPayPal = new PayInPaymentDetailsPayPal();
                if (object.has("ShippingAddress") && !object.get("ShippingAddress").isJsonNull())
                    payInPaymentDetailsPayPal.setShippingAddress((ShippingAddress) context.deserialize(object.get("ShippingAddress"), ShippingAddress.class));
                if (object.has("PaypalBuyerAccountEmail") && !object.get("PaypalBuyerAccountEmail").isJsonNull())
                    payInPaymentDetailsPayPal.setPaypalBuyerAccountEmail(object.get("PaypalBuyerAccountEmail").getAsString());
                payIn.setPaymentDetails(payInPaymentDetailsPayPal);
                break;
            case DIRECT_DEBIT:
                PayInPaymentDetailsDirectDebit payInPaymentDetailsDirectDebit = new PayInPaymentDetailsDirectDebit();
                if (object.has("DirectDebitType") && !object.get("DirectDebitType").isJsonNull())
                    payInPaymentDetailsDirectDebit.setDirectDebitType(DirectDebitType.valueOf(object.get("DirectDebitType").getAsString()));
                if (object.has("MandateId") && !object.get("MandateId").isJsonNull())
                    payInPaymentDetailsDirectDebit.setMandateId(object.get("MandateId").getAsString());
                if (object.has("StatementDescriptor") && !object.get("StatementDescriptor").isJsonNull())
                    payInPaymentDetailsDirectDebit.setStatementDescriptor(object.get("StatementDescriptor").getAsString());
                if (object.has("ChargeDate") && !object.get("ChargeDate").isJsonNull())
                    payInPaymentDetailsDirectDebit.setChargeDate(object.get("ChargeDate").getAsString());
                payIn.setPaymentDetails(payInPaymentDetailsDirectDebit);
                break;
            default:
                return null;
        }
        switch (payIn.getExecutionType()) {
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
                payIn.setExecutionDetails(payInExecutionDetailsWeb);
                break;
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
                payIn.setExecutionDetails(payInExecutionDetailsDirect);
                break;
            case EXTERNAL_INSTRUCTION:
                JsonObject debitedBankAccount = object.get("DebitedBankAccount").getAsJsonObject();
                PayInExecutionDetailsBankingAlias payInExecutionDetailsBankingAlias = new PayInExecutionDetailsBankingAlias(
                        object.get("BankingAliasId").getAsString(),
                        object.get("WireReference").getAsString(),
                        (DebitedBankAccount) context.deserialize(debitedBankAccount, DebitedBankAccount.class)
                );
                payIn.setExecutionDetails(payInExecutionDetailsBankingAlias);
                break;
        }
        return payIn;
    }
}
