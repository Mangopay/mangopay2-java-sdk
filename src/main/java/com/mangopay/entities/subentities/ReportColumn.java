package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;

public class ReportColumn {
    @SerializedName("Name")
    private String Name;

    @SerializedName("IsDefault")
    private Boolean isDefault;

    public String getName() {
        return Name;
    }

    public ReportColumn setName(String name) {
        Name = name;
        return this;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public ReportColumn setDefault(Boolean aDefault) {
        isDefault = aDefault;
        return this;
    }
}
