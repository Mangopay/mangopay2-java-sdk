package com.mangopay.core.APIs;

import com.mangopay.core.FilterReportsList;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.ReportRequest;

import java.util.List;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface ReportApi {

    /**
     * Creates new report request.
     *
     * @param reportRequest Report request details for creation
     * @return Newly-created {@link ReportRequest}
     * @throws Exception
     */
    ReportRequest create(ReportRequest reportRequest) throws Exception;

    /**
     * Creates new report request.
     *
     * @param idempotencyKey Idempotency key
     * @param reportRequest  Report request details for creation
     * @return Newly-created {@link ReportRequest}
     * @throws Exception
     */
    ReportRequest create(String idempotencyKey, ReportRequest reportRequest) throws Exception;

    /**
     * Request creation of a report for wallets.
     *
     * @param reportRequest The report request details
     * @return Newly-created wallet report request
     * @throws Exception
     */
    ReportRequest createWalletReport(ReportRequest reportRequest) throws Exception;

    /**
     * Gets a report request by its unique identifier.
     *
     * @param reportId Unique report identifier
     * @return Corresponding {@link ReportRequest}
     * @throws Exception
     */
    ReportRequest get(String reportId) throws Exception;

    /**
     * Gets a list of all report requests.
     *
     * @param pagination Pagination object
     * @param filters    Filtering object
     * @param sort       Sorting object
     * @return List of matching {@link ReportRequest}s
     * @throws Exception
     */
    List<ReportRequest> getAll(Pagination pagination, FilterReportsList filters, Sorting sort) throws Exception;

    /**
     * Gets a list of all report requests.
     *
     * @return List of {@link ReportRequest}s
     * @throws Exception
     */
    List<ReportRequest> getAll() throws Exception;
}
