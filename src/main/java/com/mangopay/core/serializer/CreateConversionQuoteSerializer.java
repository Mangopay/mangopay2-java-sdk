package com.mangopay.core.serializer;

import com.google.gson.*;
import com.mangopay.core.Money;
import com.mangopay.entities.CreateConversionQuote;

import java.lang.reflect.Type;

public class CreateConversionQuoteSerializer implements JsonSerializer<CreateConversionQuote> {

    /**
     * For creating a Conversion Quote, the Money.Amount fields needs to be sent as NULL in some cases
     */
    @Override
    public JsonElement serialize(CreateConversionQuote src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new Gson().toJsonTree(src, typeOfSrc).getAsJsonObject();

        Money debitedFunds = src.getDebitedFunds();
        Money creditedFunds = src.getCreditedFunds();

        if (debitedFunds != null && creditedFunds != null) {
            // as per API docs: the DebitedFunds.Amount is required if CreditedFunds.Amount is null
            if (debitedFunds.getAmount() == 0 && creditedFunds.getAmount() != 0) {
                JsonObject debitedFundsObj = object.getAsJsonObject("DebitedFunds");
                debitedFundsObj.addProperty("Amount", (String) null);
                object.add("DebitedFunds", debitedFundsObj);
            }

            // as per API docs: the CreditedFunds.Amount is required if DebitedFunds.Amount is null
            if (debitedFunds.getAmount() != 0 && creditedFunds.getAmount() == 0) {
                JsonObject creditedFundsObj = object.getAsJsonObject("CreditedFunds");
                creditedFundsObj.addProperty("Amount", (String) null);
                object.add("CreditedFunds", creditedFundsObj);
            }
        }

        return object;
    }
}
