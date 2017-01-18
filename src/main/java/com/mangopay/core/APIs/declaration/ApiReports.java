package com.mangopay.core.APIs.declaration;

import com.mangopay.core.FilterReportsList;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.ReportRequest;

import java.util.List;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface ApiReports {
    ReportRequest create(ReportRequest reportRequest) throws Exception;

    ReportRequest create(String idempotencyKey, ReportRequest reportRequest) throws Exception;

    ReportRequest get(String reportId) throws Exception;

    List<ReportRequest> getAll(Pagination pagination, FilterReportsList filters, Sorting sort) throws Exception;

    List<ReportRequest> getAll() throws Exception;
}
