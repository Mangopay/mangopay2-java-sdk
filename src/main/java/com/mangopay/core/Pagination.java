package com.mangopay.core;

/**
 * Pagination class.
 */
public class Pagination extends Dto {
    
    /**
     * Page number.
     */
    public int Page;
    
    /**
     * Number of items per page.
     */
    public int ItemsPerPage;
    
    /**
     * Number of total pages.
     */
    public int TotalPages;
    
    /**
     * Number of total items.
     */
    public int TotalItems;
    
    /**
     * Four-elements array with links to navigation. 
     * All values are optional. Format:
     * Links[0] -> first,
     * Links[1] -> previous, 
     * Links[2] -> next, 
     * Links[3] -> last.
     */
    public String[] Links;
    
    /**
     * Instantiates new Pagination object.
     */
    public Pagination() {
        this(1, 10);
    }
    
    /**
     * Instantiates new Pagination object.
     * @param page  Page number.
     */
    public Pagination(int page) {
        this(page, 10);
    }
    
    /**
     * Instantiates new Pagination object.
     * @param page          Page number.
     * @param itemsPerPage  Number of items per page.
     */
    public Pagination(int page, int itemsPerPage) {
        this.Links = new String[4];
        this.Page = page;
        this.ItemsPerPage = itemsPerPage;
    }
    
}
