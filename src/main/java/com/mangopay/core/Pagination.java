package com.mangopay.core;

/**
 * Pagination class.
 */
public class Pagination extends Dto {

    /**
     * Page number.
     *
     * @deprecated Use {@link #getPage()} and {@link #setPage(int)} instead.
     */
    @Deprecated
    public int Page;

    /**
     * Number of items per page.
     *
     * @deprecated Use {@link #getItemsPerPage()} and {@link #setItemsPerPage(int)} instead.
     */
    @Deprecated
    public int ItemsPerPage;

    /**
     * Number of total pages.
     *
     * @deprecated Use {@link #getTotalPages()} and {@link #setTotalPages(int)} instead.
     */
    @Deprecated
    public int TotalPages;

    /**
     * Number of total items.
     *
     * @deprecated Use {@link #getTotalItems()} and {@link #setTotalItems(int)} instead.
     */
    @Deprecated
    public int TotalItems;

    /**
     * Four-elements array with links to navigation.
     * All values are optional. Format:
     * Links[0] {@literal -> } first,
     * Links[1] {@literal -> } previous,
     * Links[2] {@literal -> } next,
     * Links[3] {@literal -> } last.
     *
     * @deprecated Use {@link #getLinks()} and {@link #setLinks(String[])} instead.
     */
    @Deprecated
    public String[] Links;

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
        this.Links = new String[4];
        this.Page = page;
        this.ItemsPerPage = itemsPerPage;
    }

    public int getPage() {
        return Page;
    }

    public void setPage(int page) {
        this.Page = page;
    }

    public int getItemsPerPage() {
        return ItemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.ItemsPerPage = itemsPerPage;
    }

    public int getTotalPages() {
        return TotalPages;
    }

    public void setTotalPages(int totalPages) {
        this.TotalPages = totalPages;
    }

    public int getTotalItems() {
        return TotalItems;
    }

    public void setTotalItems(int totalItems) {
        this.TotalItems = totalItems;
    }

    public String[] getLinks() {
        return Links;
    }

    public void setLinks(String[] links) {
        this.Links = links;
    }
}
