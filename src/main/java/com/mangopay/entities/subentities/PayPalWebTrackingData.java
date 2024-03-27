package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

public class PayPalWebTrackingData extends Dto {

    /**
     * The shipment’s tracking number provided by the carrier.
     */
    @SerializedName("TrackingNumber")
    private String trackingNumber;
    /**
     * The carrier for the shipment. Use the country-specific version of the carrier if it exists,
     * otherwise use its global version.
     * Returned values: One of the carriers supported by PayPal.
     */
    @SerializedName("Carrier")
    private String carrier;
    /**
     * If true, sends an email notification to the PaypalBuyerAccountEmail containing the TrackingNumber and Carrier,
     * which allows the end user to track their shipment with the carrier.
     * Default value: false
     */
    @SerializedName("NotifyBuyer")
    private boolean notifyBuyer;

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public boolean isNotifyBuyer() {
        return notifyBuyer;
    }

    public void setNotifyBuyer(boolean notifyBuyer) {
        this.notifyBuyer = notifyBuyer;
    }
}
