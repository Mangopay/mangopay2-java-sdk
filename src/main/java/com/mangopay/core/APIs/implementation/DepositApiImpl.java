package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.DepositApi;
import com.mangopay.core.enumerations.PaymentStatus;
import com.mangopay.entities.Deposit;
import com.mangopay.entities.subentities.CreateDeposit;
import com.mangopay.entities.subentities.UpdateDeposit;

public class DepositApiImpl extends ApiBase implements DepositApi {
    public DepositApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public Deposit create(CreateDeposit deposit, String idempotencyKey) throws Exception {
        return this.createObject(Deposit.class, idempotencyKey, "deposits_create", deposit);
    }

    @Override
    public Deposit get(String depositId) throws Exception {
        return this.getObject(Deposit.class, "deposits_get", depositId);
    }

    @Override
    public Deposit cancel(String depositId) throws Exception {
        UpdateDeposit dto = new UpdateDeposit();
        dto.setPaymentStatus(PaymentStatus.CANCELED);
        return this.updateObject(Deposit.class, "deposits_update", dto, depositId);
    }

    @Override
    public Deposit update(String depositId, PaymentStatus paymentStatus) throws Exception {
        UpdateDeposit dto = new UpdateDeposit();
        dto.setPaymentStatus(paymentStatus);
        return this.updateObject(Deposit.class, "deposits_update", dto, depositId);
    }
}
