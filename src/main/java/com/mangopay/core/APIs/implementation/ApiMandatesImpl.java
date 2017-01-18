package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.*;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.declaration.ApiMandates;
import com.mangopay.entities.Mandate;
import java.util.List;

/**
 * API for mandates.
 */
public class ApiMandatesImpl extends ApiBase implements ApiMandates {
    
    /**
     * Instantiates new ApiMandatesImpl object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiMandatesImpl(MangoPayApi root) { super(root); }
    
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
}
