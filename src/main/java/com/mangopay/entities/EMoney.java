package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Model of a user's e-money entity.
 */
public class EMoney extends EntityBase {

    /**
     * The object owner's UserId
     */
    @SerializedName("UserId")
    private String userId;

    /**
     * The amount of money that has been credited to this user
     */
    @SerializedName("CreditedEMoney")
    private Money creditedEMoney;

    /**
     * The amount of money that has been debited from this user
     */
    @SerializedName("DebitedEMoney")
    private Money debitedEMoney;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Money getCreditedEMoney() {
        return creditedEMoney;
    }

    public void setCreditedEMoney(Money creditedEMoney) {
        this.creditedEMoney = creditedEMoney;
    }

    public Money getDebitedEMoney() {
        return debitedEMoney;
    }

    public void setDebitedEMoney(Money debitedEMoney) {
        this.debitedEMoney = debitedEMoney;
    }

    /**
     * Gets map which property is an object and what type of object.
     *
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {
        HashMap<String, Type> result = new HashMap<>();

        result.put("DebitedEMoney", Money.class);
        result.put("CreditedEMoney", Money.class);

        return result;
    }
}
