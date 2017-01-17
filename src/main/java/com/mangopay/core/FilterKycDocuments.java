package com.mangopay.core;

import com.mangopay.core.enumerations.KycDocumentType;
import com.mangopay.core.enumerations.KycStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Filter for KYC documents list.
 */
public class FilterKycDocuments {

    /**
     * @deprecated Use {@link #getStatus()} and {@link #setStatus(KycStatus)} instead.
     */
    @Deprecated
    public KycStatus Status;

    /**
     * @deprecated Use {@link #getType()} and {@link #setType(KycDocumentType)} instead.
     */
    @Deprecated
    public KycDocumentType Type;

    /**
     * @deprecated Use {@link #getBeforeDate()} and {@link #setBeforeDate(Long)} instead.
     */
    @Deprecated
    public Long BeforeDate;

    /**
     * @deprecated Use {@link #getAfterDate()} and {@link #setAfterDate(Long)} instead.
     */
    @Deprecated
    public Long AfterDate;

    public KycStatus getStatus() {
        return Status;
    }

    public void setStatus(KycStatus status) {
        this.Status = status;
    }

    public KycDocumentType getType() {
        return Type;
    }

    public void setType(KycDocumentType type) {
        this.Type = type;
    }

    public Long getBeforeDate() {
        return BeforeDate;
    }

    public void setBeforeDate(Long beforeDate) {
        this.BeforeDate = beforeDate;
    }

    public Long getAfterDate() {
        return AfterDate;
    }

    public void setAfterDate(Long afterDate) {
        this.AfterDate = afterDate;
    }

    public Map<String, String> getValues() {
        HashMap<String, String> result = new HashMap();

        if (Status != null && Status != KycStatus.NotSpecified) result.put("status", Status.toString());
        if (Type != null && Type != KycDocumentType.NotSpecified) result.put("type", Type.toString());
        if (BeforeDate != null) result.put("beforedate", BeforeDate.toString());
        if (AfterDate != null) result.put("afterdate", AfterDate.toString());

        return result;
    }
}
