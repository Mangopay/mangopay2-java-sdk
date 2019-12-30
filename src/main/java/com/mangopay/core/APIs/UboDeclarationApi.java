package com.mangopay.core.APIs;

import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.Ubo;
import com.mangopay.entities.UboDeclaration;

import java.util.List;


/**
 * Class handling API methods concerning the UBO declaration entity.
 */
public interface UboDeclarationApi {

    /**
     * Creates a new UBO Declaration for an user.
     *
     * @param userId ID of the user
     * @return UboDeclaration instance from the API
     * @throws Exception
     */
    UboDeclaration create(String userId) throws Exception;

    List<UboDeclaration> getAll(String userId, Pagination pagination, Sorting sort) throws Exception;

    /**
     * Gets an UBO Declaration
     *
     * @param userId           ID of the user
     * @param uboDeclarationId ID of the UboDeclaration
     * @return UboDeclaration object
     * @throws Exception
     */
    UboDeclaration get(String userId, String uboDeclarationId) throws Exception;

    /**
     * @param userId           ID of the user
     * @param ubo              Ubo
     * @param uboDeclarationId ID  of the UboDeclaration
     * @return Ubo object
     * @throws Exception
     */
    Ubo createUbo(String userId, String uboDeclarationId, Ubo ubo) throws Exception;

    /**
     * @param userId           ID of the user
     * @param uboDeclarationId ID of the UboDeclaration
     * @param ubo              Ubo
     * @return Ubo object
     * @throws Exception
     */
    Ubo updateUbo(String userId, String uboDeclarationId, Ubo ubo) throws Exception;

    /**
     * @param userId           ID of the user
     * @param uboDeclarationId ID of the UboDeclaration
     * @param uboId            ID of the Ubo
     * @return Ubo object
     * @throws Exception
     */
    Ubo getUbo(String userId, String uboDeclarationId, String uboId) throws Exception;

    /**
     * Updates an UBO Declaration with the status <code>VALIDATION_ASKED</code>.
     *
     * @param userId ID of the user
     * @return UboDeclaration instance
     * @throws Exception
     */
    UboDeclaration submitForValidation(String userId, String uboDeclarationId) throws Exception;

    UboDeclaration get(String uboDeclarationId) throws  Exception;
}
