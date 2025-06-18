package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Address;
import com.mangopay.core.Dto;

public class PayInIntentLineItem extends Dto {
    /**
     * Unique identifier.
     */
    @SerializedName("Id")
    private String id;

    /**
     * Information about the seller involved in the transaction
     */
    @SerializedName("Seller")
    private PayInIntentSeller seller;

    /**
     * The unique identifier of the item
     */
    @SerializedName("Sku")
    private String sku;

    /**
     * The name of the item
     */
    @SerializedName("Name")
    private String name;

    /**
     * The description of the item
     */
    @SerializedName("Description")
    private String description;

    /**
     * The quantity of the item
     */
    @SerializedName("Quantity")
    private Integer quantity;

    /**
     * The cost of the item, excluding tax and discount
     */
    @SerializedName("UnitAmount")
    private Integer unitAmount;

    /**
     * The tax amount applied to the item
     */
    @SerializedName("TaxAmount")
    private Integer taxAmount;

    /**
     * The discount amount applied to the item
     */
    @SerializedName("DiscountAmount")
    private Integer discountAmount;

    /**
     * The item category
     */
    @SerializedName("Category")
    private String category;

    /**
     * Information about the end user’s shipping address
     */
    @SerializedName("ShippingAddress")
    private Address shippingAddress;

    /**
     * The item total amount including tax and discount
     */
    @SerializedName("TotalLineItemAmount")
    private Integer totalLineItemAmount;

    /**
     * The item total canceled amount
     */
    @SerializedName("CanceledAmount")
    private Integer canceledAmount;

    /**
     * The item total captured amount
     */
    @SerializedName("CapturedAmount")
    private Integer capturedAmount;

    /**
     * The item total refunded amount
     */
    @SerializedName("RefundedAmount")
    private Integer refundedAmount;

    /**
     * The item total disputed amount
     */
    @SerializedName("DisputedAmount")
    private Integer disputedAmount;

    /**
     * The item total split amount
     */
    @SerializedName("SplitAmount")
    private Integer splitAmount;

    public PayInIntentSeller getSeller() {
        return seller;
    }

    public PayInIntentLineItem setSeller(PayInIntentSeller seller) {
        this.seller = seller;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public PayInIntentLineItem setSku(String sku) {
        this.sku = sku;
        return this;
    }

    public String getName() {
        return name;
    }

    public PayInIntentLineItem setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PayInIntentLineItem setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public PayInIntentLineItem setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Integer getUnitAmount() {
        return unitAmount;
    }

    public PayInIntentLineItem setUnitAmount(Integer unitAmount) {
        this.unitAmount = unitAmount;
        return this;
    }

    public Integer getTaxAmount() {
        return taxAmount;
    }

    public PayInIntentLineItem setTaxAmount(Integer taxAmount) {
        this.taxAmount = taxAmount;
        return this;
    }

    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public PayInIntentLineItem setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public PayInIntentLineItem setCategory(String category) {
        this.category = category;
        return this;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public PayInIntentLineItem setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    public Integer getTotalLineItemAmount() {
        return totalLineItemAmount;
    }

    public PayInIntentLineItem setTotalLineItemAmount(Integer totalLineItemAmount) {
        this.totalLineItemAmount = totalLineItemAmount;
        return this;
    }

    public Integer getCanceledAmount() {
        return canceledAmount;
    }

    public PayInIntentLineItem setCanceledAmount(Integer canceledAmount) {
        this.canceledAmount = canceledAmount;
        return this;
    }

    public Integer getCapturedAmount() {
        return capturedAmount;
    }

    public PayInIntentLineItem setCapturedAmount(Integer capturedAmount) {
        this.capturedAmount = capturedAmount;
        return this;
    }

    public Integer getRefundedAmount() {
        return refundedAmount;
    }

    public PayInIntentLineItem setRefundedAmount(Integer refundedAmount) {
        this.refundedAmount = refundedAmount;
        return this;
    }

    public Integer getDisputedAmount() {
        return disputedAmount;
    }

    public PayInIntentLineItem setDisputedAmount(Integer disputedAmount) {
        this.disputedAmount = disputedAmount;
        return this;
    }

    public Integer getSplitAmount() {
        return splitAmount;
    }

    public PayInIntentLineItem setSplitAmount(Integer splitAmount) {
        this.splitAmount = splitAmount;
        return this;
    }

    public String getId() {
        return id;
    }

    public PayInIntentLineItem setId(String id) {
        this.id = id;
        return this;
    }
}
