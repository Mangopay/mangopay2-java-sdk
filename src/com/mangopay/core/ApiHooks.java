package com.mangopay.core;

import com.mangopay.MangoPayApi;
import com.mangopay.entities.Hook;
import java.util.List;

/**
 * API for hooks.
 */
public class ApiHooks extends ApiBase {
    
    /**
     * Instantiates new ApiHooks object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiHooks(MangoPayApi root) { super(root); }
    
    /**
     * Creates new hook.
     * @param Hook      Hook instance to be created.
     * @return          Hook instance returned from API.
     * @throws Exception
     */
    public Hook create(Hook hook) throws Exception {
        return this.createObject(Hook.class, "hooks_create", hook);
    }
    
    /**
     * Gets hook.
     * @param hookId    Hook identifier.
     * @return          Hook instance returned from API.
     * @throws Exception
     */
    public Hook get(String hookId) throws Exception {
        return this.getObject(Hook.class, "hooks_get", hookId);
    }
    
    /**
     * Saves hook.
     * @param hook      Hook instance to be saved.
     * @return          Hook instance returned from API.
     * @throws Exception
     */
    public Hook update(Hook hook) throws Exception {
        return this.updateObject(Hook.class, "hooks_save", hook);
    }
    
    /**
     * Gets all hooks.
     * @param pagination    Pagination.
     * @return              List of Hook instances returned from API.
     * @throws Exception
     */
    public List<Hook> getAll(Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(Hook[].class, Hook.class, "hooks_all", pagination, sorting);
    }
    
    /**
     * Gets all hooks.
     * @return              List of Hook instances returned from API.
     * @throws Exception
     */
    public List<Hook> getAll() throws Exception {
        return this.getAll(null, null);
    }
    
}
