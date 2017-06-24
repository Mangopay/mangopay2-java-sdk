package com.mangopay.core.APIs;

import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.KycDocument;

import java.util.List;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface KycDocumentApi {
    /**
     * Gets all KYC documents.
     * @param pagination    Pagination object.
     * @param sorting       Sorting object.
     * @return              Collection of KycDocuments returned from API.
     * @throws Exception
     */
    List<KycDocument> getAll(Pagination pagination, Sorting sorting) throws Exception;

    /**
     * Gets KYC document.
     * @param kycDocumentId KYC document identifier.
     * @return              KYC document returned from API.
     * @throws Exception
     */
    KycDocument getKycDocument(String kycDocumentId) throws Exception;
}
