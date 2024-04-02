package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;

public class PayPalWebTracking extends EntityBase {

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

    public PayPalWebTracking setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        return this;
    }

    public String getCarrier() {
        return carrier;
    }

    public PayPalWebTracking setCarrier(String carrier) {
        this.carrier = carrier;
        return this;
    }

    public boolean isNotifyBuyer() {
        return notifyBuyer;
    }

    public PayPalWebTracking setNotifyBuyer(boolean notifyBuyer) {
        this.notifyBuyer = notifyBuyer;
        return this;
    }
}
