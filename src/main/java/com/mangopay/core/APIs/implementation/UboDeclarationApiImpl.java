package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.UboDeclarationApi;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.core.enumerations.UboDeclarationStatus;
import com.mangopay.entities.Ubo;
import com.mangopay.entities.UboDeclaration;
import com.mangopay.entities.User;

import java.util.List;

/**
 * Implementation for the UboDeclarationApi.
 */
public class UboDeclarationApiImpl extends ApiBase implements UboDeclarationApi {

    /**
     * Creates new UboDeclarationApiImpl instance.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public UboDeclarationApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public UboDeclaration create(String userId) throws Exception {
        return this.createObject(UboDeclaration.class,null,"ubo_declaration_create",null,userId);
    }

    @Override
    public List<UboDeclaration> getAll(String userId, Pagination pagination, Sorting sort) throws Exception {
        return this.getList(UboDeclaration[].class,UboDeclaration.class,"ubo_declaration_all", pagination,userId,sort);
    }

    @Override
    public UboDeclaration get(String userId, String uboDeclarationId) throws Exception {
        return this.getObject(UboDeclaration.class,"ubo_declaration_get",userId,uboDeclarationId);
    }

    @Override
    public Ubo createUbo(String userId,String uboDeclarationId, Ubo ubo) throws Exception {
        return this.createObject(Ubo.class,"","ubo_create",ubo,userId,uboDeclarationId);
    }

    @Override
    public Ubo updateUbo(String userId, String uboDeclarationId, Ubo ubo) throws Exception {
        return this.updateObject(Ubo.class,"ubo_update",ubo,userId,uboDeclarationId);
    }

    @Override
    public Ubo getUbo(String userId, String uboDeclarationId, String uboId) throws Exception {
        return this.getObject(Ubo.class,"ubo_get",uboDeclarationId,uboId);
    }

    @Override
    public UboDeclaration submitForValidation(String userId, String uboDeclarationId) throws Exception {
       UboDeclaration uboDeclaration=new UboDeclaration();
       uboDeclaration.setId(uboDeclarationId);
       uboDeclaration.setStatus(UboDeclarationStatus.VALIDATION_ASKED);
       return this.updateObject(UboDeclaration.class,"ubo_declaration_submit",uboDeclaration,userId);
    }

}
