package com.mangopay.core.APIs.implementation;

import com.google.gson.GsonBuilder;
import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.UboDeclarationApi;
import com.mangopay.entities.UboDeclaration;

/**
 * Implementation for the UboDeclarationApi.
 */
public class UboDeclarationApiImpl extends ApiBase implements UboDeclarationApi {

    /**
     * Creates new UboDeclarationApiImpl instance.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    private GsonBuilder gsonBuilder;

    public UboDeclarationApiImpl(MangoPayApi root, GsonBuilder gsonBuilder) {
        super(root);
        this.gsonBuilder = gsonBuilder;
    }

    @Override
    public UboDeclaration get(String id) throws Exception {
        return this.getObject(UboDeclaration.class, "ubo_declaration_get", id);
    }

    @Override
    public UboDeclaration update(UboDeclaration declaration) throws Exception {
        return this.updateObject(UboDeclaration.class, "ubo_declaration_update", declaration);
    }
}
