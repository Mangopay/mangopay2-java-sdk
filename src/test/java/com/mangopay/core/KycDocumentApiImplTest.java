package com.mangopay.core;

import com.mangopay.core.enumerations.SortDirection;
import com.mangopay.entities.KycDocument;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * KycDocumentApiImpl test methods
 */
public class KycDocumentApiImplTest extends BaseTest {

    @Test
    public void getKycDocuments() throws Exception {

        List<KycDocument> result = this.api.getKycDocumentApi().getAll(null, null);
        assertNotNull(result);
        assertTrue(result.size() > 0);

        Pagination pagination = new Pagination(1, 2);
        Sorting sort = new Sorting();
        sort.addField("CreationDate", SortDirection.asc);
        result = this.api.getKycDocumentApi().getAll(pagination, sort);
        assertNotNull(result);
        assertTrue(result.size() > 0);

        sort = new Sorting();
        sort.addField("CreationDate", SortDirection.desc);
        List<KycDocument> result2 = this.api.getKycDocumentApi().getAll(pagination, sort);
        assertNotNull(result2);
        assertTrue(result2.size() > 0);

        assertFalse(result.get(0).getId().equals(result2.get(0).getId()));
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
}
