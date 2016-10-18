package com.mangopay.entities;

import com.mangopay.core.EntityBase;

/**
 * IdempotencyResponse entity.
 */
public class IdempotencyResponse extends EntityBase {
    
    public String StatusCode;

    public String ContentLength;

    public String ContentType;

    public String Date;

    public Object Resource;
    
    public String RequestURL;
}
