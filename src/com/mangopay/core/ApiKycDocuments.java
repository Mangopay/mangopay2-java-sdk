package com.mangopay.core;

import com.mangopay.MangoPayApi;
import com.mangopay.entities.KycDocument;
import java.util.List;

/**
 * API for KycDocuments.
 */
public class ApiKycDocuments extends ApiBase {
    
    /**
     * Instantiates new ApiWallets object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance
     */
    public ApiKycDocuments(MangoPayApi root) { super(root); }
    
    /**
     * Gets all KYC documents.
     * @param pagination    Pagination object.
     * @param sorting       Sorting object.
     * @return              Collection of KycDocuments returned from API.
     * @throws Exception
     */
    public List<KycDocument> getAll(Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(KycDocument[].class, KycDocument.class, "kyc_documents_all", pagination, sorting);
    }
    
}
