package com.mangopay.core.APIs;

import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.Hook;

import java.util.List;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface ApiHooks {
    /**
     * Creates new hook.
     * @param hook      Hook instance to be created.
     * @return          Hook instance returned from API.
     * @throws Exception
     */
    Hook create(Hook hook) throws Exception;

    /**
     * Creates new hook.
     * @param idempotencyKey    Idempotency key for this request.
     * @param hook              Hook instance to be created.
     * @return                  Hook instance returned from API.
     * @throws Exception
     */
    Hook create(String idempotencyKey, Hook hook) throws Exception;

    /**
     * Gets hook.
     * @param hookId    Hook identifier.
     * @return          Hook instance returned from API.
     * @throws Exception
     */
    Hook get(String hookId) throws Exception;

    /**
     * Saves hook.
     * @param hook      Hook instance to be saved.
     * @return          Hook instance returned from API.
     * @throws Exception
     */
    Hook update(Hook hook) throws Exception;

    /**
     * Gets all hooks.
     * @param pagination    Pagination.
     * @return              List of Hook instances returned from API.
     * @throws Exception
     */
    List<Hook> getAll(Pagination pagination, Sorting sorting) throws Exception;

    /**
     * Gets all hooks.
     * @return              List of Hook instances returned from API.
     * @throws Exception
     */
    List<Hook> getAll() throws Exception;
}
