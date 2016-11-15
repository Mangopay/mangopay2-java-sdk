package com.mangopay.core;
import com.mangopay.core.enumerations.SortDirection;
import com.mangopay.entities.*;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * ApiKycDocuments test methods
 */
public class ApiKycDocumentsTest extends BaseTest {
    
    @Test
    public void getKycDocuments() throws Exception {
        
        List<KycDocument> result = this.api.KycDocuments.getAll(null, null);
        assertNotNull(result);
        assertTrue(result.size() > 0);

        Pagination pagination = new Pagination(1, 2);
        Sorting sort = new Sorting();
        sort.addField("CreationDate", SortDirection.asc);
        result = this.api.KycDocuments.getAll(pagination, sort);
        assertNotNull(result);
        assertTrue(result.size() > 0);

        sort = new Sorting();
        sort.addField("CreationDate", SortDirection.desc);
        List<KycDocument> result2 = this.api.KycDocuments.getAll(pagination, sort);
        assertNotNull(result2);
        assertTrue(result2.size() > 0);

        assertFalse(result.get(0).Id.equals(result2.get(0).Id));        
    }
    
    @Test
    public void getKycDocument() throws Exception {
        KycDocument kycDocument = this.getJohnsKycDocument();
        KycDocument result = this.api.KycDocuments.getKycDocument(kycDocument.Id);

        assertNotNull(result);
        assertTrue(result.Id.equals(kycDocument.Id));
        assertTrue(result.Status == kycDocument.Status);
        assertTrue(result.Type == kycDocument.Type);
    }
}
