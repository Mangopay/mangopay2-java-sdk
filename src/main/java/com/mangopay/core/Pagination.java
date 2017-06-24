package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

/**
 * Pagination class.
 */
public class Pagination extends Dto {

    /**
     * Page number.
     */
    @SerializedName("Page")
    private int page;

    /**
     * Number of items per page.
     */
    @SerializedName("ItemsPerPage")
    private int itemsPerPage;

    /**
     * Number of total pages.
     */
    @SerializedName("TotalPages")
    private int totalPages;

    /**
     * Number of total items.
     */
    @SerializedName("TotalItems")
    private int totalItems;

    /**
     * Four-elements array with links to navigation.
     * All values are optional. Format:
     * Links[0] {@literal -> } first,
     * Links[1] {@literal -> } previous,
     * Links[2] {@literal -> } next,
     * Links[3] {@literal -> } last.
     */
    @SerializedName("Links")
    private String[] links;

    /**
     * Instantiates new Pagination object.
     */
    public Pagination() {
        this(1, 10);
    }

    /**
     * Instantiates new Pagination object.
     *
     * @param page Page number.
     */
    public Pagination(int page) {
        this(page, 10);
    }

    /**
     * Instantiates new Pagination object.
     *
     * @param page         Page number.
     * @param itemsPerPage Number of items per page.
     */
    public Pagination(int page, int itemsPerPage) {
        this.links = new String[4];
        this.page = page;
        this.itemsPerPage = itemsPerPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public String[] getLinks() {
        return links;
    }

    public void setLinks(String[] links) {
        this.links = links;
    }
}
