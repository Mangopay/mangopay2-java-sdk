package com.mangopay.entities;

import com.mangopay.core.EntityBase;

/**
 * KYC page entity.
 */
public class KycPage extends EntityBase {

    /**
     * File content.
     *
     * @deprecated Use {@link #getFile()} and {@link #setFile(String)} instead.
     */
    @Deprecated
    public String File;

    public String getFile() {
        return File;
    }

    public void setFile(String file) {
        this.File = file;
    }
}