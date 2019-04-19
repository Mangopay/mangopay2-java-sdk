package com.mangopay.core;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.enumerations.KycDocumentType;
import com.mangopay.core.enumerations.KycStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Filter for KYC documents list.
 */
public class FilterKycDocuments {

    @SerializedName("Status")
    private KycStatus status;

    @SerializedName("type")
    private KycDocumentType type;

    @SerializedName("BeforeDate")
    private Long beforeDate;

    @SerializedName("AfterDate")
    public Long afterDate;

    public KycStatus getStatus() {
        return status;
    }

    public void setStatus(KycStatus status) {
        this.status = status;
    }

    public KycDocumentType getType() {
        return type;
    }

    public void setType(KycDocumentType type) {
        this.type = type;
    }

    public Long getBeforeDate() {
        return beforeDate;
    }

    public void setBeforeDate(Long beforeDate) {
        this.beforeDate = beforeDate;
    }

    public Long getAfterDate() {
        return afterDate;
    }

    public void setAfterDate(Long afterDate) {
        this.afterDate = afterDate;
    }

    public Map<String, String> getValues() {
        HashMap<String, String> result = new HashMap();

        if (status != null && status != KycStatus.NotSpecified) result.put("status", status.toString());
        if (type != null && type != KycDocumentType.NotSpecified) result.put("type", type.toString());
        if (beforeDate != null) result.put("beforedate", beforeDate.toString());
        if (afterDate != null) result.put("afterdate", afterDate.toString());

        return result;
    }
}
