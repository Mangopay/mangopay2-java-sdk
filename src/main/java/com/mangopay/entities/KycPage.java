package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;

/**
 * KYC page entity.
 */
public class KycPage extends EntityBase {

    /**
     * File content.
     */
    @SerializedName("File")
    private String file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}