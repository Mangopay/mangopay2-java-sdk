package com.mangopay.core.APIs;

import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.Refund;
import com.mangopay.entities.Repudiation;

import java.util.List;

/**
 * Created by cosmin on 17-11-2017.
 */
public interface RepudiationApi {
    /**
     * Gets repudiation.
     *
     * @param repudiationId Repudiation identifier.
     * @return Repudiation instance returned from API.
     * @throws Exception
     */
    Repudiation getRepudiation(String repudiationId) throws Exception;

    /**
     * Get first page of repudiation's refunds
     *
     * @param repudiationId Repudiation identifier.
     * @return Collection of repudiation refunds
     * @throws Exception
     */
    List<Refund> getRefunds(String repudiationId) throws Exception;

    /**
     * Get a page of repudiation's refunds
     *
     * @param repudiationId Repudiation identifier.
     * @param pagination    Pagination object
     * @param sorting       Sorting object
     * @return Collection of repudiation refunds
     * @throws Exception
     */
    List<Refund> getRefunds(String repudiationId, Pagination pagination, Sorting sorting) throws Exception;
}
