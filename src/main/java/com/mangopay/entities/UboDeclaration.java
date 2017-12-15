package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.DeclaredUbo;
import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.UboDeclarationStatus;
import com.mangopay.core.enumerations.UboDeclarationRefusedReasonType;

import java.util.ArrayList;

/**
 * UBO declaration entity.
 */
public class UboDeclaration extends EntityBase {

    /**
     * Owner's user ID.
     * Non-null, cannot be updated after creating declaration.
     */
    @SerializedName("UserId")
    private String userId;

    /**
     * Declaration status.
     */
    @SerializedName("Status")
    private UboDeclarationStatus status;

    /**
     * List of reasons why the declaration was refused.
     */
    @SerializedName("RefusedReasonTypes")
    private ArrayList<UboDeclarationRefusedReasonType> refusedReasonTypes;

    /**
     * Explanation of why the declaration was refused.
     */
    @SerializedName("RefusedReasonMessage")
    private String refusedReasonMessage;

    /**
     * Listed representations of natural users declared as UBOs.
     */
    @SerializedName("DeclaredUBOs")
    private ArrayList<DeclaredUbo> declaredUbos;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UboDeclarationStatus getStatus() {
        return status;
    }

    public void setStatus(UboDeclarationStatus status) {
        this.status = status;
    }

    public ArrayList<UboDeclarationRefusedReasonType> getRefusedReasonTypes() {
        return refusedReasonTypes;
    }

    public void setRefusedReasonTypes(ArrayList<UboDeclarationRefusedReasonType> refusedReasonTypes) {
        this.refusedReasonTypes = refusedReasonTypes;
    }

    public String getRefusedReasonMessage() {
        return refusedReasonMessage;
    }

    public void setRefusedReasonMessage(String refusedReasonMessage) {
        this.refusedReasonMessage = refusedReasonMessage;
    }

    public ArrayList<DeclaredUbo> getDeclaredUbos() {
        return declaredUbos;
    }

    public void setDeclaredUbos(ArrayList<DeclaredUbo> declaredUbos) {
        this.declaredUbos = declaredUbos;
    }

    @Override
    public ArrayList<String> getReadOnlyProperties() {
        ArrayList<String> props = super.getReadOnlyProperties();

        props.add("RefusedReasonTypes");
        props.add("RefusedReasonMessage");

        return props;
    }
}
