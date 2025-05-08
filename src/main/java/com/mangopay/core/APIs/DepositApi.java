package com.mangopay.core.APIs;

import com.mangopay.core.FilterPreAuthorizations;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.Deposit;
import com.mangopay.entities.subentities.CreateDeposit;

import java.util.List;

public interface DepositApi {
    Deposit create(CreateDeposit deposit, String idempotencyKey) throws Exception;

    Deposit get(String depositId) throws Exception;

    Deposit cancel(String depositId) throws Exception;

    List<Deposit> getAllForUser(String userId, Pagination pagination, FilterPreAuthorizations filter,
                                Sorting sorting) throws Exception;

    List<Deposit> getAllForCard(String cardId, Pagination pagination, FilterPreAuthorizations filter,
                                Sorting sorting) throws Exception;
}
