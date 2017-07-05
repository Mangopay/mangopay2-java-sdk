package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;

/**
 * Dispute page entity.
 */
public class DisputePage extends EntityBase {

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
