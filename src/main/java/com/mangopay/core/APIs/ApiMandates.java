package com.mangopay.core.APIs;

import com.mangopay.MangoPayApi;
import com.mangopay.core.*;
import com.mangopay.entities.Mandate;
import java.util.List;

/**
 * API for mandates.
 */
public class ApiMandates extends ApiBase {
    
    /**
     * Instantiates new ApiMandates object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiMandates(MangoPayApi root) { super(root); }
    
    /**
     * Creates new mandate.
     * @param mandate   Mandate instance to be created.
     * @return          Mandate instance returned from API.
     * @throws Exception
     */
    public Mandate create(Mandate mandate) throws Exception {
        return create(null, mandate);
    }

    /**
     * Creates new mandate.
     * @param idempotencyKey    Idempotency key for this request.
     * @param mandate           Mandate instance to be created.
     * @return                  Mandate instance returned from API.
     * @throws Exception
     */
    public Mandate create(String idempotencyKey, Mandate mandate) throws Exception {
        return this.createObject(Mandate.class, idempotencyKey, "mandate_create", mandate);
    }

    /**
     * Gets mandate.
     * @param mandateId     Mandate identifier.
     * @return              Mandate instance returned from API.
     * @throws Exception
     */
    public Mandate get(String mandateId) throws Exception {
        return this.getObject(Mandate.class, "mandate_get", mandateId);
    }

    /// <summary>Gets all mandates.</summary>
    /// <param name="pagination">Pagination.</param>
    /// <param name="filters">Filters.</param>
    /// <param name="sort">Sort.</param>
    /// <returns>List of Mandate instances returned from API.</returns>

    /**
     * Gets all mandates.
     * @param filters       Filters.
     * @param pagination    Pagination.
     * @param sorting       Sorting.
     * @return              List of Mandate instances returned from API.
     * @throws Exception
     */
    public List<Mandate> getAll(FilterMandates filters, Pagination pagination, Sorting sorting) throws Exception {
        if (filters == null) filters = new FilterMandates();

        return this.getList(Mandate[].class, Mandate.class, "mandates_get_all", pagination, "", filters.getValues(), sorting);
    }

    /**
     * Gets mandates for user.
     * @param userId        User identifier.
     * @param filters       Filters.
     * @param pagination    Pagination.
     * @param sorting       Sorting.
     * @return              List of Mandate instances returned from API.
     * @throws Exception
     */
    public List<Mandate> getForUser(String userId, FilterMandates filters, Pagination pagination, Sorting sorting) throws Exception {
        if (filters == null) filters = new FilterMandates();

        return this.getList(Mandate[].class, Mandate.class, "mandates_get_for_user", pagination, userId, filters.getValues(), sorting);
    }

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
    public List<Mandate> getForBankAccount(String userId, String bankAccountId, FilterMandates filters, Pagination pagination, Sorting sorting) throws Exception {
        if (filters == null) filters = new FilterMandates();
            
        return this.getList(Mandate[].class, Mandate.class, "mandates_get_for_bank_account", pagination, userId, bankAccountId, filters.getValues(), sorting);
    }

    /**
     * Cancels mandate.
     * @param mandateId     Mandate identifier.
     * @return              Mandate instance returned from API.
     * @throws Exception
     */
    public Mandate cancel(String mandateId) throws Exception {
        return this.updateObject(Mandate.class, "mandate_cancel", new Mandate(), mandateId);
    }
}
