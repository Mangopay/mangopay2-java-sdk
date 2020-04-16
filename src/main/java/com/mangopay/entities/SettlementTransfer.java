package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Settlement transfer entity.
 */
public class SettlementTransfer extends Transfer {
    
    /**
     * The repudiation id of the settlement
     */
    @SerializedName("RepudiationId")
    private String repudiationId;

    public String getRepudiationId() {
      return repudiationId;
    }

    public void setRepudiationId(String repudiationId) {
      this.repudiationId = repudiationId;
    }


}
