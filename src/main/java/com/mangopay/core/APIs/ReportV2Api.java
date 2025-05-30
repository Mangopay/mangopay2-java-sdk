package com.mangopay.core.APIs;

import com.mangopay.core.FilterReportsListV2;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.Report;

import java.util.List;

/**
 * Report V2 (2025) integration
 */
public interface ReportV2Api {
    /**
     * Creates new report.
     *
     * @param report Report details for creation
     * @return Newly-created {@link Report}
     */
    Report create(Report report) throws Exception;

    /**
     * Creates new report.
     *
     * @param idempotencyKey Idempotency key
     * @param report         Report details for creation
     * @return Newly-created {@link Report}
     */
    Report create(String idempotencyKey, Report report) throws Exception;

    /**
     * Gets a report by its unique identifier.
     *
     * @param reportId Unique report identifier
     * @return Corresponding {@link Report}
     */
    Report get(String reportId) throws Exception;

    /**
     * Gets a list of all reports.
     *
     * @param pagination Pagination object
     * @param filters    Filtering object
     * @param sort       Sorting object
     * @return List of matching {@link Report}s
     * @throws Exception
     */
    List<Report> getAll(Pagination pagination, FilterReportsListV2 filters, Sorting sort) throws Exception;

    /**
     * Gets a list of all reports.
     *
     * @return List of {@link Report}s
     * @throws Exception
     */
    List<Report> getAll() throws Exception;
}
