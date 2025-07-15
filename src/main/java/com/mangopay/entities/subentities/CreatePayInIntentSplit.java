package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.entities.PayInIntentSplit;

import java.util.List;

public class CreatePayInIntentSplit extends EntityBase {
    @SerializedName("Splits")
    private List<PayInIntentSplit> splits;

    public List<PayInIntentSplit> getSplits() {
        return splits;
    }

    public CreatePayInIntentSplit setSplits(List<PayInIntentSplit> splits) {
        this.splits = splits;
        return this;
    }
}
