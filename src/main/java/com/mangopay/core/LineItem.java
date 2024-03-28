package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

public class LineItem extends Dto{
    /**
     * Item name
     */
    @SerializedName("Name")
    private String name;

    /**
     * Quantity of item bought
     */
    @SerializedName("Quantity")
    private Integer quantity;

    /**
     * The item cost
     */
    @SerializedName("UnitAmount")
    private Integer unitAmount;

    /**
     * The item tax. Not mandatory.
     */
    @SerializedName("TaxAmount")
    private Integer taxAmount;

    /**
     * A consistent and unique reference for the seller. It can be:
     * - The user ID created on MANGOPAY for the seller
     * - Or the firstname and lastname of the seller
     */
    @SerializedName("Description")
    private String description;

    @SerializedName("Category")
    private String category;

    public LineItem(String name, Integer quantity, Integer unitAmount, Integer taxAmount, String description) {
        this.name = name;
        this.quantity = quantity;
        this.unitAmount = unitAmount;
        this.taxAmount = taxAmount;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public LineItem setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public LineItem setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Integer getUnitAmount() {
        return unitAmount;
    }

    public LineItem setUnitAmount(Integer unitAmount) {
        this.unitAmount = unitAmount;
        return this;
    }

    public Integer getTaxAmount() {
        return taxAmount;
    }

    public LineItem setTaxAmount(Integer taxAmount) {
        this.taxAmount = taxAmount;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public LineItem setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public LineItem setCategory(String category) {
        this.category = category;
        return this;
    }
}
