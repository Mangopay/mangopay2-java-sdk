package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.*;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.declaration.ApiHooks;
import com.mangopay.entities.Hook;
import java.util.List;

/**
 * API for hooks.
 */
public class ApiHooksImpl extends ApiBase implements ApiHooks {
    
    /**
     * Instantiates new ApiHooksImpl object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiHooksImpl(MangoPayApi root) { super(root); }
    
    @Override
    public Hook create(Hook hook) throws Exception {
        return this.create(null, hook);
    }
    
    @Override
    public Hook create(String idempotencyKey, Hook hook) throws Exception {
        return this.createObject(Hook.class, idempotencyKey, "hooks_create", hook);
    }
    
    @Override
    public Hook get(String hookId) throws Exception {
        return this.getObject(Hook.class, "hooks_get", hookId);
    }
    
    @Override
    public Hook update(Hook hook) throws Exception {
        return this.updateObject(Hook.class, "hooks_save", hook);
    }
    
    @Override
    public List<Hook> getAll(Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(Hook[].class, Hook.class, "hooks_all", pagination, sorting);
    }
    
    @Override
    public List<Hook> getAll() throws Exception {
        return this.getAll(null, null);
    }
    
}
