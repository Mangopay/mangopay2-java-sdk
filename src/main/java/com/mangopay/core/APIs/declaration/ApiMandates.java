package com.mangopay.core.APIs.declaration;

import com.mangopay.core.FilterMandates;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.Mandate;

import java.util.List;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface ApiMandates {
    /**
     * Creates new mandate.
     * @param mandate   Mandate instance to be created.
     * @return          Mandate instance returned from API.
     * @throws Exception
     */
    Mandate create(Mandate mandate) throws Exception;

    /**
     * Creates new mandate.
     * @param idempotencyKey    Idempotency key for this request.
     * @param mandate           Mandate instance to be created.
     * @return                  Mandate instance returned from API.
     * @throws Exception
     */
    Mandate create(String idempotencyKey, Mandate mandate) throws Exception;

    /**
     * Gets mandate.
     * @param mandateId     Mandate identifier.
     * @return              Mandate instance returned from API.
     * @throws Exception
     */
    Mandate get(String mandateId) throws Exception;

    /**
     * Gets all mandates.
     * @param filters       Filters.
     * @param pagination    Pagination.
     * @param sorting       Sorting.
     * @return              List of Mandate instances returned from API.
     * @throws Exception
     */
    List<Mandate> getAll(FilterMandates filters, Pagination pagination, Sorting sorting) throws Exception;

    /**
     * Gets mandates for user.
     * @param userId        User identifier.
     * @param filters       Filters.
     * @param pagination    Pagination.
     * @param sorting       Sorting.
     * @return              List of Mandate instances returned from API.
     * @throws Exception
     */
    List<Mandate> getForUser(String userId, FilterMandates filters, Pagination pagination, Sorting sorting) throws Exception;

    /**
     * Gets mandates for bank account.
     * @param userId            User identifier.
     * @param bankAccountId     Bank account identifier.
     * @param filters           Filters.
     * @param pagination        Pagination.
     * @param sorting           Sorting.
     * @return                  List of Mandate instances returned from API.
     * @throws Exception
     */
    List<Mandate> getForBankAccount(String userId, String bankAccountId, FilterMandates filters, Pagination pagination, Sorting sorting) throws Exception;

    /**
     * Cancels mandate.
     * @param mandateId     Mandate identifier.
     * @return              Mandate instance returned from API.
     * @throws Exception
     */
    Mandate cancel(String mandateId) throws Exception;
}
