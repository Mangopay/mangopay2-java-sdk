package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

import java.util.List;

public class VirtualAccountAvailabilities extends Dto {

    @SerializedName("Collection")
    private List<VirtualAccountAvailability> collection;

    @SerializedName("UserOwned")
    private List<VirtualAccountAvailability> userOwned;

    public VirtualAccountAvailabilities(List<VirtualAccountAvailability> collection, List<VirtualAccountAvailability> userOwned) {
        this.collection = collection;
        this.userOwned = userOwned;
    }

    public List<VirtualAccountAvailability> getCollection() {
        return collection;
    }

    public VirtualAccountAvailabilities setCollection(List<VirtualAccountAvailability> collection) {
        this.collection = collection;
        return this;
    }

    public List<VirtualAccountAvailability> getUserOwned() {
        return userOwned;
    }

    public VirtualAccountAvailabilities setUserOwned(List<VirtualAccountAvailability> userOwned) {
        this.userOwned = userOwned;
        return this;
    }
}
