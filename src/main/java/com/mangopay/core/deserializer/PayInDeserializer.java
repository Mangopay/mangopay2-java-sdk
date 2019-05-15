package com.mangopay.core.deserializer;

import com.google.gson.*;
import com.mangopay.core.Billing;
import com.mangopay.core.Money;
import com.mangopay.core.SecurityInfo;
import com.mangopay.core.enumerations.CardType;
import com.mangopay.core.enumerations.CultureCode;
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
                if (object.has("CardType"))
                    payInPaymentDetailsCard.setCardType(CardType.valueOf(object.get("CardType").getAsString()));
                if (object.has("CardId"))
                    payInPaymentDetailsCard.setCardId(object.get("CardId").getAsString());
                if (object.has("StatementDescriptor") && !object.get("StatementDescriptor").isJsonNull())
                    payInPaymentDetailsCard.setStatementDescriptor(object.get("StatementDescriptor").getAsString());
                payIn.setPaymentDetails(payInPaymentDetailsCard);
                break;
            default:
                return null;
        }
        switch (payIn.getExecutionType()) {
            case WEB:
                PayInExecutionDetailsWeb payInExecutionDetailsWeb = new PayInExecutionDetailsWeb(
                        object.get("TemplateURL").getAsString(),
                        CultureCode.valueOf(object.get("Culture").getAsString()),
                        SecureMode.valueOf(object.get("SecureMode").getAsString()),
                        object.get("RedirectURL").getAsString(),
                        object.get("ReturnURL").getAsString()
                );
                payIn.setExecutionDetails(payInExecutionDetailsWeb);
                break;
            case DIRECT:
                JsonObject billing = object.get("Billing").getAsJsonObject();
                JsonObject securityInfo = object.get("SecurityInfo").getAsJsonObject();

                PayInExecutionDetailsDirect payInExecutionDetailsDirect = new PayInExecutionDetailsDirect(
                        object.get("CardId").getAsString(),
                        SecureMode.valueOf(object.get("SecureMode").getAsString()),
                        object.get("SecureModeReturnURL").getAsString(),
                        object.get("SecureModeRedirectURL").getAsString(),
                        object.get("SecureModeNeeded").getAsString(),
                        (Billing) context.deserialize(billing, Billing.class),
                        (SecurityInfo) context.deserialize(securityInfo, SecurityInfo.class),
                        CultureCode.valueOf(object.get("Culture").getAsString()));
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
