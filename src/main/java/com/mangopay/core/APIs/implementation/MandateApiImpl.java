package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.MandateApi;
import com.mangopay.core.FilterMandates;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.Mandate;
import com.mangopay.entities.Transfer;

import java.util.List;
import java.util.logging.Filter;

/**
 * API for mandates.
 */
public class MandateApiImpl extends ApiBase implements MandateApi {

    /**
     * Instantiates new MandateApiImpl object.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public MandateApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public Mandate create(Mandate mandate) throws Exception {
        return create(null, mandate);
    }

    @Override
    public Mandate create(String idempotencyKey, Mandate mandate) throws Exception {
        return this.createObject(Mandate.class, idempotencyKey, "mandate_create", mandate);
    }

    @Override
    public Mandate get(String mandateId) throws Exception {
        return this.getObject(Mandate.class, "mandate_get", mandateId);
    }

    /// <summary>Gets all mandates.</summary>
    /// <param name="pagination">Pagination.</param>
    /// <param name="filters">Filters.</param>
    /// <param name="sort">Sort.</param>
    /// <returns>List of Mandate instances returned from API.</returns>

    @Override
    public List<Mandate> getAll(FilterMandates filters, Pagination pagination, Sorting sorting) throws Exception {
        if (filters == null) filters = new FilterMandates();

        return this.getList(Mandate[].class, Mandate.class, "mandates_get_all", pagination, "", filters.getValues(), sorting);
    }

    @Override
    public List<Mandate> getForUser(String userId, FilterMandates filters, Pagination pagination, Sorting sorting) throws Exception {
        if (filters == null) filters = new FilterMandates();

        return this.getList(Mandate[].class, Mandate.class, "mandates_get_for_user", pagination, userId, filters.getValues(), sorting);
    }

    @Override
    public List<Mandate> getForBankAccount(String userId, String bankAccountId, FilterMandates filters, Pagination pagination, Sorting sorting) throws Exception {
        if (filters == null) filters = new FilterMandates();

        return this.getList(Mandate[].class, Mandate.class, "mandates_get_for_bank_account", pagination, userId, bankAccountId, filters.getValues(), sorting);
    }

    @Override
    public Mandate cancel(String mandateId) throws Exception {
        return this.updateObject(Mandate.class, "mandate_cancel", new Mandate(), mandateId);
    }

    @Override
    public List<Transfer> getTransfers(String mandateId) throws Exception {
        return this.getTransfers(mandateId, null, null);
    }

    @Override
    public List<Transfer> getTransfers(String mandateId, Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(Transfer[].class, Transfer.class, "mandate_get_transactions", pagination, mandateId, sorting);
    }

    @Override
    public List<Transfer> getTransfers(String mandateId, Pagination pagination, Sorting sorting, FilterMandates filters) throws Exception {
        if (filters == null) filters = new FilterMandates();
        return this.getList(Transfer[].class, Transfer.class, "mandate_get_transactions", pagination, mandateId, filters.getValues(), sorting);
    }
}
