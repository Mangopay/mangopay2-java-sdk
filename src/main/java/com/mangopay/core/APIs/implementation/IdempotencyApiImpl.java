package com.mangopay.core.APIs.implementation;

import com.google.gson.JsonParser;
import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.ApiIdempotency;
import com.mangopay.core.RestTool;
import com.mangopay.entities.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * API for Idempotency.
 */
public class IdempotencyApiImpl extends ApiBase implements ApiIdempotency {
    /**
     * Instantiates new IdempotencyApiImpl object.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public IdempotencyApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public IdempotencyResponse get(String idempotencyKey) throws Exception {
        IdempotencyResponse response = this.getObject(IdempotencyResponse.class, "idempotency_response_get", idempotencyKey);

        instantiateResourceObject(response);

        return response;
    }

    private void instantiateResourceObject(IdempotencyResponse response) throws Exception {
        Class<?> targetType = null;
        Map<String, Class<?>> map = getMapForResource();

        for (Map.Entry<String, Class<?>> entry : map.entrySet()) {
            //Class<? extends Object> value = entry.getValue();

            String sourceUrl = super.getRequestUrl(entry.getKey());
            sourceUrl = String.format(sourceUrl, "[0-9a-zA-Z]+", "[0-9a-zA-Z]+");
            sourceUrl = sourceUrl.replace("/", "\\/");

            Pattern ex = Pattern.compile(sourceUrl);
            Matcher matcher = ex.matcher(response.getRequestURL());
            if (matcher.find()) {
                targetType = entry.getValue();
                break;
            }
        }

        if (targetType == null)
            return;

        // create instance
        RestTool rt = new RestTool(root, true);
        response.setResource(rt.castResponseToEntity(targetType, new JsonParser().parse((String)response.getResource()).getAsJsonObject()));
    }

    private Map<String, Class<?>> getMapForResource() {
        return new HashMap<String, Class<?>>() {{
            put("preauthorization_create", CardPreAuthorization.class);
            put("hooks_create", Hook.class);
            put("cardregistration_create", CardRegistration.class);
            put("payins_card-web_create", PayIn.class);
            put("payins_card-direct_create", PayIn.class);
            put("payins_createrefunds", Refund.class);
            put("payins_preauthorized-direct_create", PayIn.class);
            put("payins_bankwire-direct_create", PayIn.class);
            put("payins_directdebit-web_create", PayIn.class);
            put("payins_directdebit-direct_create", Mandate.class);
            put("payouts_bankwire_create", PayOut.class);
            put("transfers_createrefunds", Refund.class);
            put("transfers_create", Transfer.class);
            put("users_createnaturals", UserNatural.class);
            put("users_createlegals", UserLegal.class);
            put("users_createkycdocument", KycDocument.class);
            put("users_createbankaccounts_iban", BankAccount.class);
            put("users_createbankaccounts_gb", BankAccount.class);
            put("users_createbankaccounts_us", BankAccount.class);
            put("users_createbankaccounts_ca", BankAccount.class);
            put("users_createbankaccounts_other", BankAccount.class);
            put("wallets_create", Wallet.class);
            put("disputes_document_create", DisputeDocument.class);
            put("disputes_repudiation_create_settlement", SettlementTransfer.class);
            put("mandate_create", Mandate.class);
            put("client_create_bankwire_direct", PayIn.class);
            put("banking_alias_create_iban", BankingAlias.class);
        }};
    }
}
