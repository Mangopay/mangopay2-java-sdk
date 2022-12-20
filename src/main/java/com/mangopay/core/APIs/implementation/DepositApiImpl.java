package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.DepositApi;
import com.mangopay.core.enumerations.PaymentStatus;
import com.mangopay.entities.Deposit;
import com.mangopay.entities.subentities.CancelDeposit;
import com.mangopay.entities.subentities.CreateDeposit;

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
        CancelDeposit dto = new CancelDeposit();
        dto.setPaymentStatus(PaymentStatus.CANCELED);

        return this.updateObject(Deposit.class, "deposits_cancel", dto, depositId);
    }
}
