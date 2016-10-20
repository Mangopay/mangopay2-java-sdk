package com.mangopay.core;

import com.mangopay.core.enumerations.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Filter for KYC documents list.
 */
public class FilterKycDocuments {
    
    public KycStatus Status;
    
    public KycDocumentType Type;

    public Long BeforeDate;

    public Long AfterDate;

    public Map<String, String> getValues()
    {
        HashMap<String, String> result = new HashMap();

        if (Status != null && Status != KycStatus.NotSpecified) result.put("status", Status.toString());
        if (Type != null && Type != KycDocumentType.NotSpecified) result.put("type", Type.toString());
        if (BeforeDate != null) result.put("beforedate", BeforeDate.toString());
        if (AfterDate != null) result.put("afterdate", AfterDate.toString());

        return result;
    }
}
