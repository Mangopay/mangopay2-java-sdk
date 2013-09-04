package com.mangopay.core;

/**
 * Class represents pagination information.
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
     * Array with links to navigation. 
     * All values are optional. Format:
     * array(
     *      first => http url
     *      prev => http url
     *      next => http url
     *      last => http url
     * )
     */
    public String[] Links;
    
    
    /**
     * Construct
     */
    public Pagination() {
        this(1, 10);
    }
    
    /**
     * Construct
     * @param page  Page number.
     */
    public Pagination(int page) {
        this(page, 10);
    }
    
    /**
     * Construct
     * @param page          Page number.
     * @param itemsPerPage  Number of items per one page
     */
    public Pagination(int page, int itemsPerPage) {
        this.Links = new String[4];
        this.Page = page;
        this.ItemsPerPage = itemsPerPage;
    }
    
}
