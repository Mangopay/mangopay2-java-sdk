package com.mangopay.core;

import java.lang.annotation.*;

/**
 * Marks entity properties that cannot be updated
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NoUpdate { }
