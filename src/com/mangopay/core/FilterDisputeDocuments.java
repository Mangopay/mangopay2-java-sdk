package com.mangopay.core;

import com.mangopay.core.enumerations.DisputeDocumentStatus;
import com.mangopay.core.enumerations.DisputeDocumentType;
import java.util.HashMap;
import java.util.Map;

/**
 * Filter for dispute documents list.
 */
public class FilterDisputeDocuments extends Dto {
    
    /**
     * Dispute document status.
     */
    public DisputeDocumentStatus Status;
    
    /**
     * Dispute document type.
     */
    public DisputeDocumentType Type;
    
    /**
     * Start date in Unix format: return only dispute documents that have CreationDate BEFORE this date.
     */
    public Long BeforeDate;
    
    /**
     * End date in Unix format: return only dispute documents that have CreationDate AFTER this date.
     */
    public Long AfterDate;
    
    /**
     * Gets map of fields and values.
     * @return Collection of field name-field value pairs.
     */
    @Override
    public Map<String, String> getValues() {
        HashMap<String, String> result = new HashMap<>();
        
        if (Status != null) result.put("Status", Status.toString());
        if (Type != null) result.put("Type", Type.toString());
        if (BeforeDate != null) result.put("BeforeDate", Long.toString(BeforeDate));
        if (AfterDate != null) result.put("AfterDate", Long.toString(AfterDate));
        
        return result;
    }
}
