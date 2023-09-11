package com.mangopay.core.deserializer;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.mangopay.core.*;
import com.mangopay.core.enumerations.CardType;
import com.mangopay.core.enumerations.CultureCode;
import com.mangopay.core.enumerations.DirectDebitType;
import com.mangopay.core.enumerations.SecureMode;
import com.mangopay.entities.BankAccount;
import com.mangopay.entities.DebitedBankAccount;
import com.mangopay.entities.PayIn;
import com.mangopay.entities.subentities.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PayInDeserializer implements JsonDeserializer<PayIn> {

    @Override
    public PayIn deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();
        PayIn payIn = new Gson().fromJson(object.toString(), PayIn.class);
        if (payIn.getPaymentType() == null)
            return null;
        switch (payIn.getPaymentType()) {
            case BANK_WIRE:
                PayInPaymentDetailsBankWire payInDetails = new PayInPaymentDetailsBankWire();
                if (object.has("DeclaredDebitedFunds") && !object.get("DeclaredDebitedFunds").isJsonNull())
                    payInDetails.setDeclaredDebitedFunds((Money) context.deserialize(object.get("DeclaredDebitedFunds"), Money.class));
                if (object.has("DeclaredFees") && !object.get("DeclaredFees").isJsonNull())
                    payInDetails.setDeclaredFees((Money) context.deserialize(object.get("DeclaredFees"), Money.class));
                if (object.has("BankAccount") && !object.get("BankAccount").isJsonNull())
                    payInDetails.setBankAccount((BankAccount) context.deserialize(object.get("BankAccount"), BankAccount.class));
                if (object.has("WireReference") && !object.get("WireReference").isJsonNull())
                    payInDetails.setWireReference(object.get("WireReference").getAsString());

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
                // v2
                if (object.has("StatementDescriptor") && !object.get("StatementDescriptor").isJsonNull())
                    payInPaymentDetailsPayPal.setStatementDescriptor(object.get("StatementDescriptor").getAsString());
                if (object.has("Shipping") && !object.get("Shipping").isJsonNull())
                    payInPaymentDetailsPayPal.setShipping((Shipping) context.deserialize(object.get("Shipping"), Shipping.class));
                if (object.has("LineItems") && !object.get("LineItems").isJsonNull()) {
                    Type listType = new TypeToken<ArrayList<LineItem>>(){}.getType();
                    payInPaymentDetailsPayPal.setLineItems((List<LineItem>) context.deserialize(object.get("LineItems"), listType));
                }
                payIn.setPaymentDetails(payInPaymentDetailsPayPal);
                break;
            case PAYCONIQ:
                PayInPaymentDetailsPayconiq payInPaymentDetailsPayconiq = new PayInPaymentDetailsPayconiq();
                if (object.has("ExpirationDate") && !object.get("ExpirationDate").isJsonNull())
                    payInPaymentDetailsPayconiq.setExpirationDate(object.get("ExpirationDate").getAsString());
                if (object.has("DebitedWalletId") && !object.get("DebitedWalletId").isJsonNull())
                    payInPaymentDetailsPayconiq.setDebitedWalletId(object.get("DebitedWalletId").getAsString());
                if (object.has("DeepLinkURL") && !object.get("DeepLinkURL").isJsonNull())
                    payInPaymentDetailsPayconiq.setDeepLinkUrl(object.get("DeepLinkURL").getAsString());
                payIn.setPaymentDetails(payInPaymentDetailsPayconiq);
                break;
            case APPLEPAY:
                PayInPaymentDetailsApplePay payInPaymentDetailsApplePay = new PayInPaymentDetailsApplePay();
                if (object.has("PaymentData") && !object.get("PaymentData").isJsonNull()) {
                    payInPaymentDetailsApplePay.setPaymentData((PaymentData) context.deserialize(object.get("PaymentData"), PaymentData.class));
                }
                if (object.has("StatementDescriptor") && !object.get("StatementDescriptor").isJsonNull()) {
                    payInPaymentDetailsApplePay.setStatementDescriptor(object.get("StatementDescriptor").getAsString());
                }
                payIn.setPaymentDetails(payInPaymentDetailsApplePay);
                break;
            case GOOGLEPAY:
                PayInPaymentDetailsGooglePay payInPaymentDetailsGooglePay = new PayInPaymentDetailsGooglePay();
                if (object.has("PaymentData") && !object.get("PaymentData").isJsonNull()) {
                    payInPaymentDetailsGooglePay.setPaymentData((PaymentData) context.deserialize(object.get("PaymentData"), PaymentData.class));
                }
                if (object.has("StatementDescriptor") && !object.get("StatementDescriptor").isJsonNull()) {
                    payInPaymentDetailsGooglePay.setStatementDescriptor(object.get("StatementDescriptor").getAsString());
                }
                if (object.has("Billing") && !object.get("Billing").isJsonNull())
                    payInPaymentDetailsGooglePay.setBilling((Billing) context.deserialize(object.get("Billing"), Billing.class));
                payIn.setPaymentDetails(payInPaymentDetailsGooglePay);
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
                if (object.has("Culture") && !object.get("Culture").isJsonNull())
                    payInPaymentDetailsDirectDebit.setCulture(CultureCode.valueOf(object.get("Culture").getAsString()));
                payIn.setPaymentDetails(payInPaymentDetailsDirectDebit);
                break;
            case MBWAY:
                PayInPaymentDetailsMbway payInPaymentDetailsMbway = new PayInPaymentDetailsMbway();
                if (object.has("StatementDescriptor") && !object.get("StatementDescriptor").isJsonNull())
                    payInPaymentDetailsMbway.setStatementDescriptor(object.get("StatementDescriptor").getAsString());
                if (object.has("Phone") && !object.get("Phone").isJsonNull())
                    payInPaymentDetailsMbway.setPhone(object.get("Phone").getAsString());
                payIn.setPaymentDetails(payInPaymentDetailsMbway);
                break;
            case SATISPAY:
                PayInPaymentDetailsSatispay payInPaymentDetailsSatispay = new PayInPaymentDetailsSatispay();
                if (object.has("StatementDescriptor") && !object.get("StatementDescriptor").isJsonNull())
                    payInPaymentDetailsSatispay.setStatementDescriptor(object.get("StatementDescriptor").getAsString());
                if (object.has("Country") && !object.get("Country").isJsonNull())
                    payInPaymentDetailsSatispay.setCountry(object.get("Country").getAsString());
                payIn.setPaymentDetails(payInPaymentDetailsSatispay);
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
                if (object.has("TemplateURLOptions") && !object.get("TemplateURLOptions").isJsonNull())
                    payInExecutionDetailsWeb.setTemplateURLOptions((PayInTemplateURLOptions) context.deserialize(object.get("TemplateURLOptions"), PayInTemplateURLOptions.class));
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
                if (object.has("Requested3DSVersion") && !object.get("Requested3DSVersion").isJsonNull())
                    payInExecutionDetailsDirect.setRequested3DSVersion(object.get("Requested3DSVersion").getAsString());
                if (object.has("Applied3DSVersion") && !object.get("Applied3DSVersion").isJsonNull())
                    payInExecutionDetailsDirect.setApplied3DSVersion(object.get("Applied3DSVersion").getAsString());
                if (object.has("RecurringPayinRegistrationId") && !object.get("RecurringPayinRegistrationId").isJsonNull())
                    payInExecutionDetailsDirect.setRecurringPayinRegistrationId(object.get("RecurringPayinRegistrationId").getAsString());
                payIn.setExecutionDetails(payInExecutionDetailsDirect);
                break;
            case EXTERNAL_INSTRUCTION:
                PayInExecutionDetailsBankingAlias payInExecutionDetailsBankingAlias = new PayInExecutionDetailsBankingAlias();
                if (object.has("BankingAliasId") && !object.get("BankingAliasId").isJsonNull())
                    payInExecutionDetailsBankingAlias.setBankingAliasId(object.get("BankingAliasId").getAsString());
                if (object.has("WireReference") && !object.get("WireReference").isJsonNull())
                    payInExecutionDetailsBankingAlias.setWireReference(object.get("WireReference").getAsString());
                if (object.has("DebitedBankAccount") && !object.get("DebitedBankAccount").isJsonNull())
                    payInExecutionDetailsBankingAlias.setDebitedBankAccount(
                            (DebitedBankAccount) context.deserialize(object.get("DebitedBankAccount"), DebitedBankAccount.class)
                    );

                payIn.setExecutionDetails(payInExecutionDetailsBankingAlias);
                break;
            default:
                return null;
        }
        return payIn;
    }
}
