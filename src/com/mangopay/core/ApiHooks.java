package com.mangopay.core;

import com.mangopay.MangoPayApi;
import com.mangopay.entities.Hook;
import java.util.List;

/**
 * API for Hooks.
 */
public class ApiHooks extends ApiBase {
    
    /**
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance
     */
    public ApiHooks(MangoPayApi root) { super(root); }
    
    /**
     * Creates new hook.
     * @param Hook hook
     * @return Hook Hook object returned from API.
     */
    public Hook create(Hook hook) throws Exception {
        return this.createObject(Hook.class, "hooks_create", hook);
    }
    
    /**
     * Gets hook.
     * @param type $hookId Hook identifier
     * @return \MangoPay\Hook Wallet object returned from API
     */
    public Hook get(String hookId) throws Exception {
        return this.getObject(Hook.class, "hooks_get", hookId);
    }
    
    /**
     * Saves hook.
     * @param type $hook Hook object to save
     * @return \MangoPay\Hook Hook object returned from API
     */
    public Hook update(Hook hook) throws Exception {
        return this.updateObject(Hook.class, "hooks_save", hook);
    }
    
    /**
     * Gets all hooks.
     * @param pagination
     * @return List of Hook objects returned from API.
     * @throws Exception
     */
    public List<Hook> getAll(Pagination pagination) throws Exception {
        return this.getList(Hook[].class, Hook.class, "hooks_all", pagination);
    }
    
    /**
     * Gets all hooks.
     * @return List of Hook objects returned from API.
     * @throws Exception
     */
    public List<Hook> getAll() throws Exception {
        return this.getAll(null);
    }
    
}
