package com.mangopay.core.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mangopay.entities.PayIn;
import com.mangopay.entities.subentities.*;

import java.lang.reflect.Type;

public class PayInSerializer implements JsonSerializer<PayIn> {


    @Override
    public JsonElement serialize(PayIn src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = SerializedTransaction.getTransactionObject(src, context);
        object.add("CreditedWalletId", context.serialize(src.getCreditedWalletId()));
        object.add("PaymentType", context.serialize(src.getPaymentType()));
        object.add("ExecutionType", context.serialize(src.getExecutionType()));
        object.add("ExecutionDetails", context.serialize(src.getExecutionDetails()));
        switch (src.getPaymentDetails().getClass().getSimpleName()) {
            case "PayInPaymentDetailsBankWire":
                object.add("DeclaredDebitedFunds", context.serialize(((PayInPaymentDetailsBankWire) src.getPaymentDetails()).getDeclaredDebitedFunds()));
                object.add("DeclaredFees", context.serialize(((PayInPaymentDetailsBankWire) src.getPaymentDetails()).getDeclaredFees()));
                object.add("BankAccount", context.serialize(((PayInPaymentDetailsBankWire) src.getPaymentDetails()).getBankAccount()));
                object.add("WireReference", context.serialize(((PayInPaymentDetailsBankWire) src.getPaymentDetails()).getWireReference()));
                object.add("TransactionDetails", context.serialize(((PayInPaymentDetailsBankWire) src.getPaymentDetails()).getTransactionDetails()));
                break;
            case "PayInPaymentDetailsCard":
                object.add("CardType", context.serialize(((PayInPaymentDetailsCard) src.getPaymentDetails()).getCardType()));
                object.add("CardId", context.serialize(((PayInPaymentDetailsCard) src.getPaymentDetails()).getCardId()));
                object.add("StatementDescriptor", context.serialize(((PayInPaymentDetailsCard) src.getPaymentDetails()).getStatementDescriptor()));
                object.add("Shipping", context.serialize(((PayInPaymentDetailsCard) src.getPaymentDetails()).getShipping()));
                object.add("BrowserInfo", context.serialize(((PayInPaymentDetailsCard) src.getPaymentDetails()).getBrowserInfo()));
                object.add("IpAddress", context.serialize(((PayInPaymentDetailsCard) src.getPaymentDetails()).getIpAddress()));
                object.add("Bic", context.serialize(((PayInPaymentDetailsCard) src.getPaymentDetails()).getBic()));
                object.add("BankName", context.serialize(((PayInPaymentDetailsCard) src.getPaymentDetails()).getBankName()));
                object.add("PaymentCategory", context.serialize(((PayInPaymentDetailsCard) src.getPaymentDetails()).getPaymentCategory()));
                break;
            case "PayInPaymentDetailsPreAuthorized":
                object.add("PreauthorizationId", context.serialize(((PayInPaymentDetailsPreAuthorized) src.getPaymentDetails()).getPreauthorizationId()));
                object.add("Culture", context.serialize(((PayInPaymentDetailsPreAuthorized) src.getPaymentDetails()).getCulture()));
                object.add("Shipping", context.serialize(((PayInPaymentDetailsPreAuthorized) src.getPaymentDetails()).getShipping()));
                break;
            case "PayInPaymentDetailsPayPal":
                object.add("ShippingAddress", context.serialize(((PayInPaymentDetailsPayPal) src.getPaymentDetails()).getShippingAddress()));
                object.add("PaypalBuyerAccountEmail", context.serialize(((PayInPaymentDetailsPayPal) src.getPaymentDetails()).getPaypalBuyerAccountEmail()));
                // v2
                object.add("StatementDescriptor", context.serialize(((PayInPaymentDetailsPayPal) src.getPaymentDetails()).getStatementDescriptor()));
                object.add("Shipping", context.serialize(((PayInPaymentDetailsPayPal) src.getPaymentDetails()).getShipping()));
                object.add("LineItems", context.serialize(((PayInPaymentDetailsPayPal) src.getPaymentDetails()).getLineItems()));
                object.add("ShippingPreference", context.serialize(((PayInPaymentDetailsPayPal) src.getPaymentDetails()).getShippingPreference()));
                object.add("Reference", context.serialize(((PayInPaymentDetailsPayPal) src.getPaymentDetails()).getReference()));
                object.add("CancelURL", context.serialize(((PayInPaymentDetailsPayPal) src.getPaymentDetails()).getCancelUrl()));
                object.add("PaypalPayerID", context.serialize(((PayInPaymentDetailsPayPal) src.getPaymentDetails()).getPaypalPayerId()));
                object.add("BuyerCountry", context.serialize(((PayInPaymentDetailsPayPal) src.getPaymentDetails()).getBuyerCountry()));
                object.add("BuyerFirstname", context.serialize(((PayInPaymentDetailsPayPal) src.getPaymentDetails()).getBuyerFirstName()));
                object.add("BuyerLastname", context.serialize(((PayInPaymentDetailsPayPal) src.getPaymentDetails()).getBuyerLastName()));
                object.add("BuyerPhone", context.serialize(((PayInPaymentDetailsPayPal) src.getPaymentDetails()).getBuyerPhone()));
                object.add("PaypalOrderID", context.serialize(((PayInPaymentDetailsPayPal) src.getPaymentDetails()).getPaypalOrderID()));
                object.add("Trackings", context.serialize(((PayInPaymentDetailsPayPal) src.getPaymentDetails()).getTrackings()));
                break;
            case "PayInPaymentDetailsPayconiq":
                object.add("Country", context.serialize(((PayInPaymentDetailsPayconiq) src.getPaymentDetails()).getCountry()));
                break;
            case "PayInPaymentDetailsDirectDebit":
                object.add("DirectDebitType", context.serialize(((PayInPaymentDetailsDirectDebit) src.getPaymentDetails()).getDirectDebitType()));
                object.add("MandateId", context.serialize(((PayInPaymentDetailsDirectDebit) src.getPaymentDetails()).getMandateId()));
                object.add("StatementDescriptor", context.serialize(((PayInPaymentDetailsDirectDebit) src.getPaymentDetails()).getStatementDescriptor()));
                object.add("ChargeDate", context.serialize(((PayInPaymentDetailsDirectDebit) src.getPaymentDetails()).getChargeDate()));
                object.add("Culture", context.serialize(((PayInPaymentDetailsDirectDebit) src.getPaymentDetails()).getCulture()));
                break;
            case "PayInPaymentDetailsApplePay":
                object.add("PaymentData", context.serialize(((PayInPaymentDetailsApplePay) src.getPaymentDetails()).getPaymentData()));
                object.add("StatementDescriptor", context.serialize(((PayInPaymentDetailsApplePay) src.getPaymentDetails()).getStatementDescriptor()));
                break;
            case "PayInPaymentDetailsGooglePay":
                object.add("PaymentData", context.serialize(((PayInPaymentDetailsGooglePay) src.getPaymentDetails()).getPaymentData()));
                object.add("StatementDescriptor", context.serialize(((PayInPaymentDetailsGooglePay) src.getPaymentDetails()).getStatementDescriptor()));
                object.add("Billing", context.serialize(((PayInPaymentDetailsGooglePay) src.getPaymentDetails()).getBilling()));
                break;
            case "PayInPaymentDetailsGooglePayV2":
                object.add("PaymentData", context.serialize(((PayInPaymentDetailsGooglePayV2) src.getPaymentDetails()).getPaymentData()));
                object.add("StatementDescriptor", context.serialize(((PayInPaymentDetailsGooglePayV2) src.getPaymentDetails()).getStatementDescriptor()));
                object.add("Shipping", context.serialize(((PayInPaymentDetailsGooglePayV2) src.getPaymentDetails()).getShipping()));
                object.add("IpAddress", context.serialize(((PayInPaymentDetailsGooglePayV2) src.getPaymentDetails()).getIpAddress()));
                object.add("BrowserInfo", context.serialize(((PayInPaymentDetailsGooglePayV2) src.getPaymentDetails()).getBrowserInfo()));
                object.add("RedirectURL", context.serialize(((PayInPaymentDetailsGooglePayV2) src.getPaymentDetails()).getRedirectUrl()));
                object.add("RedirectURL", context.serialize(((PayInPaymentDetailsGooglePayV2) src.getPaymentDetails()).getReturnUrl()));
                break;
            case "PayInPaymentDetailsMbway":
                object.add("StatementDescriptor", context.serialize(((PayInPaymentDetailsMbway) src.getPaymentDetails()).getStatementDescriptor()));
                object.add("Phone", context.serialize(((PayInPaymentDetailsMbway) src.getPaymentDetails()).getPhone()));
                break;
            case "PayInPaymentDetailsSatispay":
                object.add("StatementDescriptor", context.serialize(((PayInPaymentDetailsSatispay) src.getPaymentDetails()).getStatementDescriptor()));
                object.add("Country", context.serialize(((PayInPaymentDetailsSatispay) src.getPaymentDetails()).getCountry()));
                break;
            case "PayInPaymentDetailsBlik":
                object.add("StatementDescriptor", context.serialize(((PayInPaymentDetailsBlik) src.getPaymentDetails()).getStatementDescriptor()));
                break;
            case "PayInPaymentDetailsMultibanco":
                object.add("StatementDescriptor", context.serialize(((PayInPaymentDetailsMultibanco) src.getPaymentDetails()).getStatementDescriptor()));
                break;
            case "PayInPaymentDetailsKlarna":
                object.add("LineItems", context.serialize(((PayInPaymentDetailsKlarna) src.getPaymentDetails()).getLineItems()));
                object.add("Shipping", context.serialize(((PayInPaymentDetailsKlarna) src.getPaymentDetails()).getShipping()));
                object.add("Billing", context.serialize(((PayInPaymentDetailsKlarna) src.getPaymentDetails()).getBilling()));
                object.add("PaymentMethod", context.serialize(((PayInPaymentDetailsKlarna) src.getPaymentDetails()).getPaymentMethod()));
                object.add("Reference", context.serialize(((PayInPaymentDetailsKlarna) src.getPaymentDetails()).getReference()));
                object.add("Country", context.serialize(((PayInPaymentDetailsKlarna) src.getPaymentDetails()).getCountry()));
                object.add("Culture", context.serialize(((PayInPaymentDetailsKlarna) src.getPaymentDetails()).getCulture()));
                object.add("Phone", context.serialize(((PayInPaymentDetailsKlarna) src.getPaymentDetails()).getPhone()));
                object.add("Email", context.serialize(((PayInPaymentDetailsKlarna) src.getPaymentDetails()).getEmail()));
                object.add("AdditionalData", context.serialize(((PayInPaymentDetailsKlarna) src.getPaymentDetails()).getAdditionalData()));
                break;
            case "PayInPaymentDetailsIdeal":
                object.add("StatementDescriptor", context.serialize(((PayInPaymentDetailsIdeal) src.getPaymentDetails()).getStatementDescriptor()));
                object.add("Bic", context.serialize(((PayInPaymentDetailsIdeal) src.getPaymentDetails()).getBic()));
                object.add("BankName", context.serialize(((PayInPaymentDetailsIdeal) src.getPaymentDetails()).getBankName()));
                break;
            case "PayInPaymentDetailsGiropay":
                object.add("StatementDescriptor", context.serialize(((PayInPaymentDetailsGiropay) src.getPaymentDetails()).getStatementDescriptor()));
                break;
            case "PayInPaymentDetailsBancontact":
                object.add("DeepLinkURL", context.serialize(((PayInPaymentDetailsBancontact) src.getPaymentDetails()).getDeepLinkUrl()));
                object.add("StatementDescriptor", context.serialize(((PayInPaymentDetailsBancontact) src.getPaymentDetails()).getStatementDescriptor()));
                object.add("Recurring", context.serialize(((PayInPaymentDetailsBancontact) src.getPaymentDetails()).getRecurring()));
                break;
            default:
                return null;
        }
        if (src.getExecutionDetails() != null) {
            switch (src.getExecutionDetails().getClass().getSimpleName()) {
                case "PayInExecutionDetailsBankingAlias":
                    object.add("BankingAliasId", context.serialize(((PayInExecutionDetailsBankingAlias) src.getExecutionDetails()).getBankingAliasId()));
                    object.add("WireReference", context.serialize(((PayInExecutionDetailsBankingAlias) src.getExecutionDetails()).getWireReference()));
                    object.add("DebitedBankAccount", context.serialize(((PayInExecutionDetailsBankingAlias) src.getExecutionDetails()).getDebitedBankAccount()));
                    break;
                case "PayInExecutionDetailsDirect":
                    object.add("CardId", context.serialize(((PayInExecutionDetailsDirect) src.getExecutionDetails()).getCardId()));
                    object.add("SecureMode", context.serialize(((PayInExecutionDetailsDirect) src.getExecutionDetails()).getSecureMode()));
                    object.add("SecureModeReturnURL", context.serialize(((PayInExecutionDetailsDirect) src.getExecutionDetails()).getSecureModeReturnUrl()));
                    object.add("SecureModeRedirectURL", context.serialize(((PayInExecutionDetailsDirect) src.getExecutionDetails()).getSecureModeRedirectUrl()));
                    object.add("SecureModeNeeded", context.serialize(((PayInExecutionDetailsDirect) src.getExecutionDetails()).getSecureModeNeeded()));
                    object.add("Billing", context.serialize(((PayInExecutionDetailsDirect) src.getExecutionDetails()).getBilling()));
                    object.add("SecurityInfo", context.serialize(((PayInExecutionDetailsDirect) src.getExecutionDetails()).getSecurityInfo()));
                    object.add("Culture", context.serialize(((PayInExecutionDetailsDirect) src.getExecutionDetails()).getCulture()));
                    object.add("Requested3DSVersion", context.serialize(((PayInExecutionDetailsDirect) src.getExecutionDetails()).getRequested3DSVersion()));
                    break;
                case "PayInExecutionDetailsWeb":
                    object.add("TemplateURL", context.serialize(((PayInExecutionDetailsWeb) src.getExecutionDetails()).getTemplateUrl()));
                    object.add("Culture", context.serialize(((PayInExecutionDetailsWeb) src.getExecutionDetails()).getCulture()));
                    object.add("SecureMode", context.serialize(((PayInExecutionDetailsWeb) src.getExecutionDetails()).getSecureMode()));
                    object.add("RedirectURL", context.serialize(((PayInExecutionDetailsWeb) src.getExecutionDetails()).getRedirectUrl()));
                    object.add("ReturnURL", context.serialize(((PayInExecutionDetailsWeb) src.getExecutionDetails()).getReturnUrl()));
                    object.add("TemplateURLOptions", context.serialize(((PayInExecutionDetailsWeb) src.getExecutionDetails()).getTemplateURLOptions()));
                    break;
                default:
                    return null;
            }
        }
        return object;
    }

}
