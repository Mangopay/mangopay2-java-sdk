package com.mangopay.core;

import com.mangopay.core.enumerations.SortDirection;
import com.mangopay.entities.KycDocument;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * KycDocumentApiImpl test methods
 */
public class KycDocumentApiImplTest extends BaseTest {

    @Test
    public void getKycDocuments() throws Exception {
        KycDocument kycDocument = this.getJohnsKycDocument();
        FilterKycDocuments filter = new FilterKycDocuments();
        filter.setAfterDate(kycDocument.getCreationDate() - 10);
        filter.setBeforeDate(kycDocument.getCreationDate() + 10);

        List<KycDocument> result = this.api.getKycDocumentApi().getAll(null, filter, null);
        assertNotNull(result);
        assertTrue(result.size() > 0);

        Pagination pagination = new Pagination(1, 2);
        Sorting sort = new Sorting();
        sort.addField("CreationDate", SortDirection.asc);
        result = this.api.getKycDocumentApi().getAll(pagination, filter, sort);
        assertNotNull(result);
        assertTrue(result.size() > 0);

        sort = new Sorting();
        sort.addField("CreationDate", SortDirection.desc);
        List<KycDocument> result2 = this.api.getKycDocumentApi().getAll(pagination, filter, sort);
        assertNotNull(result2);
        assertTrue(result2.size() > 0);
    }

    @Test
    public void getKycDocument() throws Exception {
        KycDocument kycDocument = this.getJohnsKycDocument();
        KycDocument result = this.api.getKycDocumentApi().getKycDocument(kycDocument.getId());

        assertNotNull(result);
        assertTrue(result.getId().equals(kycDocument.getId()));
        assertTrue(result.getStatus() == kycDocument.getStatus());
        assertTrue(result.getType() == kycDocument.getType());
    }

    @Test
    public void createKycDocumentConsult() throws Exception {
        KycDocument document = getJohnsKycDocument();
        List<DocumentPageConsult> pageConsults = api.getKycDocumentApi().createKycDocumentConsult(document.getId());

        assertNotNull(pageConsults);
    }
}
