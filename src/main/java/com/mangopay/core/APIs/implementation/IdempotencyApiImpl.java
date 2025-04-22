package com.mangopay.core.APIs.implementation;

import com.google.gson.GsonBuilder;
import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.IdempotencyApi;
import com.mangopay.core.deserializer.PayOutDeserializer;
import com.mangopay.core.serializer.PayOutSerializer;
import com.mangopay.entities.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * API for idempotency.
 */
public class IdempotencyApiImpl extends ApiBase implements IdempotencyApi {
    /**
     * Instantiates new IdempotencyApiImpl object.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public IdempotencyApiImpl(MangoPayApi root, GsonBuilder gsonBuilder) {
        super(root);

        gsonBuilder.registerTypeAdapter(PayOut.class, new PayOutSerializer());
        gsonBuilder.registerTypeAdapter(PayOut.class, new PayOutDeserializer());
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
            sourceUrl = String.format(sourceUrl, "[0-9a-zA-Z_]+", "[0-9a-zA-Z_]+");
            sourceUrl = sourceUrl.replace("/", "\\/");

            Pattern ex = Pattern.compile(sourceUrl);
            Matcher matcher = ex.matcher(response.getRequestUrl());
            if (matcher.find()) {
                targetType = entry.getValue();
                break;
            }
        }

        if (targetType == null)
            return;

        response.setResource(root.getGson().fromJson(root.getGson().toJson(response.getResource()), targetType));
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
            put("payins_directdebit-direct_create", PayIn.class);
            put("payouts_bankwire_create", PayOut.class);
            put("payouts_bankwire_get", PayOut.class);
            put("transfers_createrefunds", Refund.class);
            put("transfers_create", Transfer.class);
            put("users_createnaturals", UserNatural.class);
            put("users_createlegals", UserLegal.class);
            put("users_createlegals_sca", UserLegalSca.class);
            put("users_createnaturals_sca", UserNaturalSca.class);
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
