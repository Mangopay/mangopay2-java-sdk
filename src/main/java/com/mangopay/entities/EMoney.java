package com.mangopay.entities;

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
    public String UserId;

    /**
     * The amount of money that has been credited to this user
     */
    public Money CreditedEMoney;

    /**
     * The amount of money that has been debited from this user
     */
    public Money DebitedEMoney;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
    }

    public Money getCreditedEMoney() {
        return CreditedEMoney;
    }

    public void setCreditedEMoney(Money creditedEMoney) {
        CreditedEMoney = creditedEMoney;
    }

    public Money getDebitedEMoney() {
        return DebitedEMoney;
    }

    public void setDebitedEMoney(Money debitedEMoney) {
        DebitedEMoney = debitedEMoney;
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
