package com.mangopay.core.APIs;

import com.mangopay.entities.UboDeclaration;

/**
 * Class handling API methods concerning the UBO declaration entity.
 */
public interface UboDeclarationApi {

    /**
     * Retrieves a UBO declaration.
     *
     * @param id ID of the UBO declaration to retrieve
     * @return UboDeclaration instance from the API
     * @throws Exception
     */
    UboDeclaration get(String id) throws Exception;

    /**
     * Updates a UBO declaration.
     *
     * @param declaration Updated data object
     * @return Updated UBO declaration object
     * @throws Exception
     */
    UboDeclaration update(UboDeclaration declaration) throws Exception;
}
