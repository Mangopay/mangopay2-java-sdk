package com.mangopay.core.APIs;

import com.mangopay.entities.Deposit;
import com.mangopay.entities.subentities.CreateDeposit;

public interface DepositApi {
    Deposit create(CreateDeposit deposit, String idempotencyKey) throws Exception;

    Deposit get(String depositId) throws Exception;

    Deposit cancel(String depositId) throws Exception;
}
