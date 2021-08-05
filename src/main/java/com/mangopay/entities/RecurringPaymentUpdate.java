package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Billing;
import com.mangopay.core.Dto;
import com.mangopay.core.EntityBase;
import com.mangopay.core.Shipping;

import java.lang.reflect.Type;
import java.util.Map;

public class RecurringPaymentUpdate extends EntityBase {
    @SerializedName("CardId")
    private String cardId;

    @SerializedName("Billing")
    private Billing billing;

    @SerializedName("Shipping")
    private Shipping shipping;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    @Override
    public Map<String, Type> getSubObjects() {
        Map<String, Type> result = super.getSubObjects();

        result.put("Shipping", Shipping.class);
        result.put("Billing", Billing.class);

        return result;
    }
}
