package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;

/**
 * Client logo container.
 */
public class ClientLogo extends EntityBase {

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
