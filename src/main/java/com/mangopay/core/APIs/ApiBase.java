package com.mangopay.core.APIs;

import com.mangopay.MangoPayApi;
import com.mangopay.core.*;
import com.mangopay.core.enumerations.RequestType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Base class for all API classes.
 */
public abstract class ApiBase {

    /**
     * Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    protected MangoPayApi root;

    protected MangoPayApi getRoot() {
        return root;
    }

    /**
     * Array with REST URL and request type.
     */
    private Map<String, String[]> methods = new HashMap<String, String[]>() {{

        put("client_get", new String[]{"/clients/", RequestType.GET.toString()});
        put("client_save", new String[]{"/clients/", RequestType.PUT.toString()});
        put("client_upload_logo", new String[]{"/clients/logo/", RequestType.PUT.toString()});

        put("client_get_wallets_default", new String[]{"/clients/wallets", RequestType.GET.toString()});
        put("client_get_wallets_fees", new String[]{"/clients/wallets/fees", RequestType.GET.toString()});
        put("client_get_wallets_credit", new String[]{"/clients/wallets/credit", RequestType.GET.toString()});
        put("client_get_wallets_default_with_currency", new String[]{"/clients/wallets/%s", RequestType.GET.toString()});
        put("client_get_wallets_fees_with_currency", new String[]{"/clients/wallets/fees/%s", RequestType.GET.toString()});
        put("client_get_wallets_credit_with_currency", new String[]{"/clients/wallets/credit/%s", RequestType.GET.toString()});
        put("client_get_wallet_transactions", new String[]{"/clients/wallets/%s/%s/transactions", RequestType.GET.toString()});
        put("client_get_transactions", new String[]{"/clients/transactions", RequestType.GET.toString()});
        put("client_get_kyc_documents", new String[]{"/KYC/documents", RequestType.GET.toString()});
        put("client_create_bankwire_direct", new String[]{"/clients/payins/bankwire/direct", RequestType.POST.toString()});
        put("client_create_bankaccount_iban", new String[]{"/clients/bankaccounts/iban", RequestType.POST.toString()});
        put("client_create_payout", new String[]{"/clients/payouts", RequestType.POST.toString()});

        put("authentication_base", new String[]{"/clients/", RequestType.POST.toString()});
        put("authentication_oauth", new String[]{"/oauth/token ", RequestType.POST.toString()});

        put("events_all", new String[]{"/events", RequestType.GET.toString()});

        put("hooks_create", new String[]{"/hooks", RequestType.POST.toString()});
        put("hooks_all", new String[]{"/hooks", RequestType.GET.toString()});
        put("hooks_get", new String[]{"/hooks/%s", RequestType.GET.toString()});
        put("hooks_save", new String[]{"/hooks/%s", RequestType.PUT.toString()});

        put("cardregistration_create", new String[]{"/cardregistrations", RequestType.POST.toString()});
        put("cardregistration_get", new String[]{"/cardregistrations/%s", RequestType.GET.toString()});
        put("cardregistration_save", new String[]{"/cardregistrations/%s", RequestType.PUT.toString()});

        put("preauthorization_create", new String[]{"/preauthorizations/card/direct", RequestType.POST.toString()});
        put("preauthorization_get", new String[]{"/preauthorizations/%s", RequestType.GET.toString()});
        put("preauthorization_save", new String[]{"/preauthorizations/%s", RequestType.PUT.toString()});
        put("preauthorization_transactions_get", new String[]{"/preauthorizations/%s/transactions", RequestType.GET.toString()});

        put("card_get", new String[]{"/cards/%s", RequestType.GET.toString()});
        put("card_save", new String[]{"/cards/%s", RequestType.PUT.toString()});
        put("cards_get_by_fingerprint", new String[]{"/cards/fingerprints/%s", RequestType.GET.toString()});
        put("cards_get_transactions", new String[]{"/cards/%s/transactions", RequestType.GET.toString()});
        put("card_get_preauthorization", new String[]{"/cards/%s/preauthorizations", RequestType.GET.toString()});
        put("card_validate", new String[]{"/cards/%s/validate", RequestType.POST.toString()});

        // pay ins URLs
        put("payins_paypal-web_create", new String[]{"/payins/paypal/web/", RequestType.POST.toString()});
        put("payins_card-web_create", new String[]{"/payins/card/web/", RequestType.POST.toString()});
        put("payins_card-direct_create", new String[]{"/payins/card/direct/", RequestType.POST.toString()});
        put("payins_preauthorized-direct_create", new String[]{"/payins/preauthorized/direct/", RequestType.POST.toString()});
        put("payins_bankwire-direct_create", new String[]{"/payins/bankwire/direct/", RequestType.POST.toString()});
        put("payins_directdebit-web_create", new String[]{"/payins/directdebit/web", RequestType.POST.toString()});
        put("payins_get", new String[]{"/payins/%s", RequestType.GET.toString()});
        put("payins_getrefunds", new String[]{"/payins/%s/refunds", RequestType.GET.toString()});
        put("payins_createrefunds", new String[]{"/payins/%s/refunds", RequestType.POST.toString()});
        put("payins_directdebit-direct_create", new String[]{"/payins/directdebit/direct", RequestType.POST.toString()});
        put("payins_applepay-direct_create", new String[]{"/payins/applepay/direct", RequestType.POST.toString()});
        put("payins_googlepay-direct_create", new String[]{"/payins/googlepay/direct", RequestType.POST.toString()});
        put("payin_get_refunds", new String[]{"/payins/%s/refunds", RequestType.GET.toString()});
        put("payins_recurring_registration", new String[]{"/recurringpayinregistrations", RequestType.POST.toString()});
        put("payins_recurring_registration_get", new String[]{"/recurringpayinregistrations/%s", RequestType.GET.toString()});
        put("payins_recurring_registration_put", new String[]{"/recurringpayinregistrations/%s", RequestType.PUT.toString()});
        put("payins_recurring_card_direct", new String[]{"/payins/recurring/card/direct", RequestType.POST.toString()});

        put("payouts_bankwire_create", new String[]{"/payouts/bankwire/", RequestType.POST.toString()});
        put("payouts_bankwire_get", new String[]{"/payouts/bankwire/%s", RequestType.GET.toString()});
        put("payouts_get", new String[]{"/payouts/%s", RequestType.GET.toString()});
        put("payouts_get_refunds", new String[]{"/payouts/%s/refunds", RequestType.GET.toString()});

        put("refunds_get", new String[]{"/refunds/%s", RequestType.GET.toString()});

        put("transfers_create", new String[]{"/transfers", RequestType.POST.toString()});
        put("transfers_get", new String[]{"/transfers/%s", RequestType.GET.toString()});
        put("transfers_getrefunds", new String[]{"/transfers/%s/refunds", RequestType.GET.toString()});
        put("transfers_createrefunds", new String[]{"/transfers/%s/refunds", RequestType.POST.toString()});

        put("users_createnaturals", new String[]{"/users/natural", RequestType.POST.toString()});
        put("users_createlegals", new String[]{"/users/legal", RequestType.POST.toString()});

        put("users_createbankaccounts_iban", new String[]{"/users/%s/bankaccounts/iban", RequestType.POST.toString()});
        put("users_createbankaccounts_gb", new String[]{"/users/%s/bankaccounts/gb", RequestType.POST.toString()});
        put("users_createbankaccounts_us", new String[]{"/users/%s/bankaccounts/us", RequestType.POST.toString()});
        put("users_createbankaccounts_ca", new String[]{"/users/%s/bankaccounts/ca", RequestType.POST.toString()});
        put("users_createbankaccounts_other", new String[]{"/users/%s/bankaccounts/other", RequestType.POST.toString()});

        put("users_savebankaccount", new String[]{"/users/%s/bankaccounts/%s", RequestType.PUT.toString()});

        put("users_get_preauthorizations", new String[]{"/users/%s/preauthorizations", RequestType.GET.toString()});

        put("get_transactions_for_banckaccount", new String[]{"/bankaccounts/%s/transactions", RequestType.GET.toString()});

        put("users_all", new String[]{"/users", RequestType.GET.toString()});
        put("users_allwallets", new String[]{"/users/%s/wallets", RequestType.GET.toString()});
        put("users_allbankaccount", new String[]{"/users/%s/bankaccounts", RequestType.GET.toString()});
        put("users_allcards", new String[]{"/users/%s/cards", RequestType.GET.toString()});
        put("users_alltransactions", new String[]{"/users/%s/transactions", RequestType.GET.toString()});
        put("users_allkycdocuments", new String[]{"/users/%s/KYC/documents", RequestType.GET.toString()});
        put("users_get", new String[]{"/users/%s", RequestType.GET.toString()});
        put("users_getnaturals", new String[]{"/users/natural/%s", RequestType.GET.toString()});
        put("users_getlegals", new String[]{"/users/legal/%s", RequestType.GET.toString()});
        put("users_getbankaccount", new String[]{"/users/%s/bankaccounts/%s", RequestType.GET.toString()});
        put("users_savenaturals", new String[]{"/users/natural/%s", RequestType.PUT.toString()});
        put("users_savelegals", new String[]{"/users/legal/%s", RequestType.PUT.toString()});
        put("users_block_status", new String[]{"/users/%s/blockStatus", RequestType.GET.toString()});
        put("users_regulatory", new String[]{"/users/%s/Regulatory", RequestType.GET.toString()});

        put("users_emoney_year", new String[]{"/users/%s/emoney/%s", RequestType.GET.toString()});
        put("users_emoney_month", new String[]{"/users/%s/emoney/%s/%s", RequestType.GET.toString()});
        put("users_emoney_year_currency", new String[]{"/users/%s/emoney/%s?Currency=%s", RequestType.GET.toString()});
        put("users_emoney_month_currency", new String[]{"/users/%s/emoney/%s/%s?Currency=%s", RequestType.GET.toString()});

        put("wallets_create", new String[]{"/wallets", RequestType.POST.toString()});
        put("wallets_alltransactions", new String[]{"/wallets/%s/transactions", RequestType.GET.toString()});
        put("wallets_get", new String[]{"/wallets/%s", RequestType.GET.toString()});
        put("wallets_save", new String[]{"/wallets/%s", RequestType.PUT.toString()});

        put("users_createkycdocument", new String[]{"/users/%s/KYC/documents/", RequestType.POST.toString()});
        put("users_getkycdocument", new String[]{"/users/%s/KYC/documents/%s", RequestType.GET.toString()});
        put("users_savekycdocument", new String[]{"/users/%s/KYC/documents/%s", RequestType.PUT.toString()});
        put("kyc_page_create", new String[]{"/users/%s/KYC/documents/%s/pages", RequestType.POST.toString()});
        put("kyc_documents_all", new String[]{"/KYC/documents", RequestType.GET.toString()});

        put("kyc_document_get", new String[]{"/KYC/documents/%s", RequestType.GET.toString()});
        put("kyc_document_create_consult", new String[]{"/KYC/documents/%s/consult", RequestType.POST.toString()});

        put("disputes_get", new String[]{"/disputes/%s", RequestType.GET.toString()});
        put("disputes_save_tag", new String[]{"/disputes/%s", RequestType.PUT.toString()});
        put("disputes_save_contest_funds", new String[]{"/disputes/%s/submit", RequestType.PUT.toString()});
        put("disputes_save_close", new String[]{"/disputes/%s/close", RequestType.PUT.toString()});
        put("disputes_get_transactions", new String[]{"/disputes/%s/transactions", RequestType.GET.toString()});
        put("disputes_get_all", new String[]{"/disputes", RequestType.GET.toString()});
        put("disputes_get_for_wallet", new String[]{"/wallets/%s/disputes", RequestType.GET.toString()});
        put("disputes_get_for_user", new String[]{"/users/%s/disputes", RequestType.GET.toString()});
        put("disputes_document_create", new String[]{"/disputes/%s/documents", RequestType.POST.toString()});
        put("disputes_document_page_create", new String[]{"/disputes/%s/documents/%s/pages", RequestType.POST.toString()});
        put("disputes_document_submit", new String[]{"/disputes/%s/documents/%s", RequestType.PUT.toString()});
        put("disputes_document_get", new String[]{"/dispute-documents/%s", RequestType.GET.toString()});
        put("disputes_document_get_for_dispute", new String[]{"/disputes/%s/documents", RequestType.GET.toString()});
        put("disputes_document_get_for_client", new String[]{"/dispute-documents", RequestType.GET.toString()});
        put("disputes_document_create_consult", new String[]{"/dispute-documents/%s/consult", RequestType.POST.toString()});
        put("disputes_repudiation_get", new String[]{"/repudiations/%s", RequestType.GET.toString()});
        put("disputes_repudiation_create_settlement", new String[]{"/repudiations/%s/settlementtransfer", RequestType.POST.toString()});
        put("disputes_pending_settlement", new String[]{"/disputes/pendingsettlement", RequestType.GET.toString()});

        put("settlements_get", new String[]{"/settlements/%s", RequestType.GET.toString()});

        put("repudiation_get_refunds", new String[]{"/repudiations/%s/refunds", RequestType.GET.toString()});

        put("idempotency_response_get", new String[]{"/responses/%s", RequestType.GET.toString()});

        put("mandate_create", new String[]{"/mandates/directdebit/web", RequestType.POST.toString()});
        put("mandate_cancel", new String[]{"/mandates/%s/cancel", RequestType.PUT.toString()});
        put("mandate_get", new String[]{"/mandates/%s", RequestType.GET.toString()});
        put("mandates_get_all", new String[]{"/mandates", RequestType.GET.toString()});
        put("mandates_get_for_user", new String[]{"/users/%s/mandates", RequestType.GET.toString()});
        put("mandates_get_for_bank_account", new String[]{"/users/%s/bankaccounts/%s/mandates", RequestType.GET.toString()});
        put("mandate_get_transactions", new String[]{"/mandates/%s/transactions", RequestType.GET.toString()});

        put("reports_request", new String[]{"/reports/%s", RequestType.POST.toString()});
        put("reports_get_all", new String[]{"/reports", RequestType.GET.toString()});
        put("reports_get", new String[]{"/reports/%s", RequestType.GET.toString()});

        put("reports_wallets_create", new String[]{"/reports/wallets", RequestType.POST.toString()});

        put("banking_alias_create_iban", new String[]{"/wallets/%s/bankingaliases/iban", RequestType.POST.toString()});
        put("banking_alias_deactivate", new String[]{"/bankingaliases/%s", RequestType.PUT.toString()});
        put("banking_alias_get", new String[]{"/bankingaliases/%s", RequestType.GET.toString()});
        put("banking_aliases_get_for_wallet", new String[]{"/wallets/%s/bankingaliases", RequestType.GET.toString()});

        put("ubo_declaration_create", new String[]{"/users/%s/kyc/ubodeclarations", RequestType.POST.toString()});
        put("ubo_declaration_all", new String[]{"/users/%s/kyc/ubodeclarations", RequestType.GET.toString()});
        put("ubo_declaration_submit", new String[]{"/users/%s/kyc/ubodeclarations/%s", RequestType.PUT.toString()});
        put("ubo_declaration_get", new String[]{"/users/%s/kyc/ubodeclarations/%s", RequestType.GET.toString()});
        put("ubo_declaration_get_by_id", new String[]{"/kyc/ubodeclarations/%s", RequestType.GET.toString()});
        put("ubo_create", new String[]{"/users/%s/kyc/ubodeclarations/%s/ubos", RequestType.POST.toString()});
        put("ubo_update", new String[]{"/users/%s/kyc/ubodeclarations/%s/ubos/%s", RequestType.PUT.toString()});
        put("ubo_get", new String[]{"/users/%s/kyc/ubodeclarations/%s/ubos/%s", RequestType.GET.toString()});
    }};

    /**
     * Creates new API instance.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiBase(MangoPayApi root) {
        this.root = root;
    }

    /**
     * Gets the URL of REST Mango Pay API.
     *
     * @param key The method key to get URL of.
     * @return The URL string of given method.
     */
    protected String getRequestUrl(String key) throws Exception {
        String result = "";
        try {
            result = this.methods.get(key)[0];
        } catch (Exception ex) {
            throw new Exception("Unknown method key: " + key);
        }
        return result;
    }

    /**
     * Gets the HTTP request verb.
     *
     * @param key The method key.
     * @return One of the HTTP verbs: GET, PUT or POST.
     */
    protected String getRequestType(String key) {
        return this.methods.get(key)[1];
    }

    /**
     * Creates the Dto instance.
     *
     * @param <T>            Type on behalf of which the request is being called.
     * @param classOfT       Type on behalf of which the request is being called.
     * @param idempotencyKey idempotency key for this request.
     * @param methodKey      Relevant method key.
     * @param entity         Dto instance that is going to be sent.
     * @param entityId       Entity identifier.
     * @param secondEntityId Second entity identifier.
     * @return The Dto instance returned from API.
     * @throws Exception
     */
    protected <T extends Dto, U extends Dto> T createObject(Class<T> classOfT, String idempotencyKey, String methodKey, U entity, String entityId, String secondEntityId) throws Exception {

        String urlMethod;

        if (entityId.length() == 0)
            urlMethod = this.getRequestUrl(methodKey);
        else if (secondEntityId.length() == 0)
            urlMethod = String.format(this.getRequestUrl(methodKey), entityId);
        else
            urlMethod = String.format(this.getRequestUrl(methodKey), entityId, secondEntityId);

        RestTool rest = new RestTool(this.root, true);
        T result = rest.request(classOfT, idempotencyKey, urlMethod, this.getRequestType(methodKey), null, null, entity);

        return result;

    }

    /**
     * Creates the Dto instance.
     *
     * @param <T>            Type on behalf of which the request is being called.
     * @param classOfT       Type on behalf of which the request is being called.
     * @param idempotencyKey idempotency key for this request.
     * @param methodKey      Relevant method key.
     * @param entity         Dto instance that is going to be sent.
     * @param entityId       Entity identifier.
     * @return The Dto instance returned from API.
     * @throws Exception
     */
    protected <T extends Dto, U extends Dto> T createObject(Class<T> classOfT, String idempotencyKey, String methodKey, U entity, String entityId) throws Exception {
        return createObject(classOfT, idempotencyKey, methodKey, entity, entityId, "");
    }

    /**
     * Creates the Dto instance.
     *
     * @param <T>            Type on behalf of which the request is being called.
     * @param classOfT       Type on behalf of which the request is being called.
     * @param idempotencyKey idempotency key for this request.
     * @param methodKey      Relevant method key.
     * @param entity         Dto instance that is going to be sent.
     * @return The Dto instance returned from API.
     * @throws Exception
     */
    protected <T extends Dto, U extends Dto> T createObject(Class<T> classOfT, String idempotencyKey, String methodKey, U entity) throws Exception {
        return createObject(classOfT, idempotencyKey, methodKey, entity, "");
    }

    /**
     *
     * @param classOfT Type on behalf of which the request is being called.
     * @param methodKey Relevant method key.
     * @param args Arguments that will be set on the method
     * @param <T>  Type on behalf of which the request is being called.
     * @return The Dto instance returned from API.
     * @throws Exception
     */
    protected <T extends Dto> T getObject(Class<T> classOfT, String methodKey, Object... args) throws Exception {
        String urlMethod = String.format(this.getRequestUrl(methodKey), args);

        RestTool rest = new RestTool(this.root, true);
        T response = rest.request(classOfT, null, urlMethod, this.getRequestType(methodKey));

        return response;
    }

    /**
     * Gets the array of Dto instances from API.
     *
     * @param <T>        Type on behalf of which the request is being called.
     * @param classOfT   Type on behalf of which the request is being called.
     * @param methodKey  Relevant method key.
     * @param pagination Pagination object.
     * @param entityId   Entity identifier.
     * @param filter     Collection of key-value pairs of filter parameters.
     * @param sorting    Sorting instance.
     * @return The array of Dto instances returned from API.
     * @throws Exception
     */
    protected <T extends Dto> List<T> getList(Class<T[]> classOfT, Class<T> classOfTItem, String methodKey, Pagination pagination, String entityId, String secondEntityId, Map<String, String> filter, Sorting sorting) throws Exception {

        String urlMethod = "";

        if (entityId != null && entityId.length() > 0 && secondEntityId != null && secondEntityId.length() > 0)
            urlMethod = String.format(this.getRequestUrl(methodKey), entityId, secondEntityId);
        else if (entityId != null && entityId.length() > 0)
            urlMethod = String.format(this.getRequestUrl(methodKey), entityId);
        else
            urlMethod = this.getRequestUrl(methodKey);

        if (pagination == null) {
            pagination = new Pagination();
        }

        Map<String, String> additionalUrlParams = new HashMap<>();

        if (filter != null) {
            additionalUrlParams.putAll(filter);
        }

        if (sorting != null) {
            additionalUrlParams.putAll(sorting.getSortParameter());
        }

        RestTool rest = new RestTool(this.root, true);

        return rest.requestList(classOfT, classOfTItem, urlMethod, this.getRequestType(methodKey), null, pagination, additionalUrlParams);

    }

    protected <T extends Dto> List<T> getList(Class<T[]> classOfT, Class<T> classOfTItem, String methodKey, Pagination pagination, String entityId, Map<String, String> filter, Sorting sorting) throws Exception {
        return getList(classOfT, classOfTItem, methodKey, pagination, entityId, null, filter, sorting);
    }

    /**
     * Gets the array of Dto instances from API.
     *
     * @param <T>        Type on behalf of which the request is being called.
     * @param classOfT   Type on behalf of which the request is being called.
     * @param methodKey  Relevant method key.
     * @param pagination Pagination object.
     * @param entityId   Entity identifier.
     * @param sorting    Sorting object.
     * @return The array of Dto instances returned from API.
     * @throws Exception
     */
    protected <T extends Dto> List<T> getList(Class<T[]> classOfT, Class<T> classOfTItem, String methodKey, Pagination pagination, String entityId, Sorting sorting) throws Exception {
        return getList(classOfT, classOfTItem, methodKey, pagination, entityId, null, null, sorting);
    }

    /**
     * Gets the array of Dto instances from API.
     *
     * @param <T>        Type on behalf of which the request is being called.
     * @param classOfT   Type on behalf of which the request is being called.
     * @param methodKey  Relevant method key.
     * @param pagination Pagination object.
     * @param entityId   Entity identifier.
     * @return The array of Dto instances returned from API.
     * @throws Exception
     */
    protected <T extends Dto> List<T> getList(Class<T[]> classOfT, Class<T> classOfTItem, String methodKey, Pagination pagination, String entityId) throws Exception {
        return getList(classOfT, classOfTItem, methodKey, pagination, entityId, null, null, null);
    }

    /**
     * Gets the array of Dto instances from API.
     *
     * @param <T>        Type on behalf of which the request is being called.
     * @param classOfT   Type on behalf of which the request is being called.
     * @param methodKey  Relevant method key.
     * @param pagination Pagination object.
     * @return The array of Dto instances returned from API.
     * @throws Exception
     */
    protected <T extends Dto> List<T> getList(Class<T[]> classOfT, Class<T> classOfTItem, String methodKey, Pagination pagination) throws Exception {
        return getList(classOfT, classOfTItem, methodKey, pagination, "", null);
    }

    /**
     * Gets the array of Dto instances from API.
     *
     * @param <T>        Type on behalf of which the request is being called.
     * @param classOfT   Type on behalf of which the request is being called.
     * @param methodKey  Relevant method key.
     * @param pagination Pagination object.
     * @param sorting    Sorting object.
     * @return The array of Dto instances returned from API.
     * @throws Exception
     */
    protected <T extends Dto> List<T> getList(Class<T[]> classOfT, Class<T> classOfTItem, String methodKey, Pagination pagination, Sorting sorting) throws Exception {
        return getList(classOfT, classOfTItem, methodKey, pagination, "", sorting);
    }

    /**
     * Saves the Dto instance.
     *
     * @param <T>       Type on behalf of which the request is being called.
     * @param classOfT  Type on behalf of which the request is being called.
     * @param methodKey Relevant method key.
     * @param entity    Dto instance that is going to be sent.
     * @return The Dto instance returned from API.
     * @throws Exception
     */
    protected <T extends Dto, U extends Dto> T updateObject(Class<T> classOfT, String methodKey, U entity) throws Exception {
        return updateObject(classOfT, methodKey, entity, "", "");
    }

    /**
     * Saves the Dto instance.
     *
     * @param <T>       Type on behalf of which the request is being called.
     * @param classOfT  Type on behalf of which the request is being called.
     * @param methodKey Relevant method key.
     * @param entity    Dto instance that is going to be sent.
     * @param entityId  Entity identifier.
     * @return The Dto instance returned from API.
     * @throws Exception
     */
    protected <T extends Dto, U extends Dto> T updateObject(Class<T> classOfT, String methodKey, U entity, String entityId) throws Exception {
        return updateObject(classOfT, methodKey, entity, entityId, "");
    }

    /**
     * Saves the Dto instance.
     *
     * @param <T>            Type on behalf of which the request is being called.
     * @param classOfT       Type on behalf of which the request is being called.
     * @param methodKey      Relevant method key.
     * @param entity         Dto instance that is going to be sent.
     * @param entityId       Entity identifier.
     * @param secondEntityId Second entity identifier.
     * @return The Dto instance returned from API.
     * @throws Exception
     */
    protected <T extends Dto, U extends Dto> T updateObject(Class<T> classOfT, String methodKey, U entity, String entityId, String secondEntityId) throws Exception {
        if (entity instanceof EntityBase) {
            String urlMethod;

            if (secondEntityId.length() > 0) {
                urlMethod = String.format(this.getRequestUrl(methodKey), entityId, secondEntityId);
            } else if (entityId.length() > 0) {
                urlMethod = String.format(this.getRequestUrl(methodKey), entityId, ((EntityBase) entity).getId());
            } else {
                urlMethod = String.format(this.getRequestUrl(methodKey), ((EntityBase) entity).getId());
            }

            RestTool rest = new RestTool(this.root, true);
            return rest.request(classOfT, null, urlMethod, this.getRequestType(methodKey), null, null, entity);
        } else {
            return null;
        }
    }

    /**
     * Saves the Dto instance.
     *
     * @param <T>            Type on behalf of which the request is being called.
     * @param classOfT       Type on behalf of which the request is being called.
     * @param methodKey      Relevant method key.
     * @param entity         Dto instance that is going to be sent.
     * @param entityId       Entity identifier.
     * @param secondEntityId Second entity identifier.
     * @param thirdEntityId  Third entity identifier.
     * @return The Dto instance returned from API.
     * @throws Exception
     */
    protected <T extends Dto, U extends Dto> T updateObject(Class<T> classOfT, String methodKey, U entity, String entityId, String secondEntityId, String thirdEntityId) throws Exception {
        if (entity instanceof EntityBase) {
            String urlMethod;
            if (thirdEntityId.length() > 0) {
                urlMethod = String.format(this.getRequestUrl(methodKey), entityId, secondEntityId, thirdEntityId);
            } else if (secondEntityId.length() > 0) {
                urlMethod = String.format(this.getRequestUrl(methodKey), entityId, secondEntityId);
            } else {
                urlMethod = String.format(this.getRequestUrl(methodKey), ((EntityBase) entity).getId());
            }

            RestTool rest = new RestTool(this.root, true);
            return rest.request(classOfT, null, urlMethod, this.getRequestType(methodKey), null, null, entity);
        } else {
            return null;
        }
    }
}
