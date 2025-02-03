package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.KycDocumentApi;
import com.mangopay.core.DocumentPageConsult;
import com.mangopay.core.FilterKycDocuments;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.KycDocument;

import java.util.List;

/**
 * API for KycDocuments.
 */
public class KycDocumentApiImpl extends ApiBase implements KycDocumentApi {
    
    /**
     * Instantiates new KycDocumentApiImpl object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance
     */
    public KycDocumentApiImpl(MangoPayApi root) {
        super(root);
    }
    
    @Override
    public List<KycDocument> getAll(Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(KycDocument[].class, KycDocument.class, "kyc_documents_all", pagination, sorting);
    }

    @Override
    public List<KycDocument> getAll(Pagination pagination, FilterKycDocuments filter, Sorting sorting) throws Exception {
        return this.getList(KycDocument[].class, KycDocument.class, "kyc_documents_all", pagination, null, null, filter.getValues(), sorting);
    }
    
    @Override
    public KycDocument getKycDocument(String kycDocumentId) throws Exception {
        return this.getObject(KycDocument.class, "kyc_document_get", kycDocumentId);
    }

    @Override
    public List<DocumentPageConsult> createKycDocumentConsult(String kycDocumentId) throws Exception {
        return this.getList(DocumentPageConsult[].class, DocumentPageConsult.class, "kyc_document_create_consult", null, kycDocumentId);
    }
}
