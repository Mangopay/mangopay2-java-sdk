package com.mangopay.core;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.enumerations.BusinessType;
import com.mangopay.core.enumerations.Sector;

public class PlatformCategorization {

    @SerializedName("BusinessType")
    private BusinessType businessType;
    @SerializedName("Sector")
    private Sector sector;
}
