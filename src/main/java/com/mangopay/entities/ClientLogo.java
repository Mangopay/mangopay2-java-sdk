package com.mangopay.entities;

import com.mangopay.core.EntityBase;

/**
 * Client logo container.
 */
public class ClientLogo extends EntityBase {

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
