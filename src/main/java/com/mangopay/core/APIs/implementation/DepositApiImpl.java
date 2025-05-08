package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.DepositApi;
import com.mangopay.core.FilterPreAuthorizations;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.core.enumerations.PaymentStatus;
import com.mangopay.entities.Deposit;
import com.mangopay.entities.subentities.CancelDeposit;
import com.mangopay.entities.subentities.CreateDeposit;

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
        CancelDeposit dto = new CancelDeposit();
        dto.setPaymentStatus(PaymentStatus.CANCELED);

        return this.updateObject(Deposit.class, "deposits_cancel", dto, depositId);
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
