package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.DepositApi;
import com.mangopay.core.FilterPreAuthorizations;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.core.FilterTransactions;
import com.mangopay.core.enumerations.PaymentStatus;
import com.mangopay.entities.Deposit;
import com.mangopay.entities.Transaction;
import com.mangopay.entities.subentities.CreateDeposit;
import com.mangopay.entities.subentities.UpdateDeposit;

import java.util.List;


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

    @Override
    public List<Transaction> getTransactions(String depositId, Pagination pagination, FilterTransactions filter, Sorting sorting) throws Exception {
        if (filter != null) {
            return this.getList(Transaction[].class, Transaction.class, "deposits_get_transactions", pagination, depositId, filter.getValues(), sorting);
        }
        return this.getList(Transaction[].class, Transaction.class, "deposits_get_transactions", pagination, depositId, null, sorting);
    }

    @Override
    public List<Deposit> getAllForUser(String userId, Pagination pagination, FilterPreAuthorizations filter,
                                       Sorting sorting) throws Exception {
        return this.getList(Deposit[].class, Deposit.class, "deposits_get_all_for_user", pagination, userId,
            filter != null ? filter.getValues() : null, sorting);
    }

    @Override
    public List<Deposit> getAllForCard(String cardId, Pagination pagination, FilterPreAuthorizations filter,
                                       Sorting sorting) throws Exception {
        return this.getList(Deposit[].class, Deposit.class, "deposits_get_all_for_card", pagination, cardId,
            filter != null ? filter.getValues() : null, sorting);
    }
}
