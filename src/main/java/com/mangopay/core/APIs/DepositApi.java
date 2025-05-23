package com.mangopay.core.APIs;

import com.mangopay.core.FilterPreAuthorizations;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.core.FilterTransactions;
import com.mangopay.core.enumerations.PaymentStatus;
import com.mangopay.entities.Deposit;
import com.mangopay.entities.Transaction;
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

    /**
     * This method allows you to take one of two actions against a deposit preauthorization, in both cases provided
     * that no preauthorized pay-ins have been made to capture funds:
     * <p>- Cancel it manually by setting the PaymentStatus to CANCEL. A canceled deposit preauthorization can’t
     * be used for any further action.</p>
     * <p>- Request a no-show by setting the PaymentStatus to NO_SHOW_REQUESTED. If successful, the PaymentStatus NO_SHOW
     * indicates that you can use the Create a Deposit Preauthorized PayIn complement endpoint
     * to capture additional funds.</p>
     *
     * @param depositId     The deposit identifier
     * @param paymentStatus The new PaymentStatus
     * @return The updated Deposit
     * @throws Exception
     */
    Deposit update(String depositId, PaymentStatus paymentStatus) throws Exception;

    /**
     * Gets transactions for a Deposit.
     *
     * @param depositId  Deposit identifier.
     * @param pagination Pagination object.
     * @param filter     Object to filter data.
     * @return Transactions for deposit returned from API.
     * @throws Exception
     */
    List<Transaction> getTransactions(String depositId, Pagination pagination, FilterTransactions filter, Sorting sorting) throws Exception;
}
