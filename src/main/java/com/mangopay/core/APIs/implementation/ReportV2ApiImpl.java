package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.ReportV2Api;
import com.mangopay.core.FilterReportsListV2;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.Report;

import java.util.List;

/**
 * API for reports V2 (2025)
 */
public class ReportV2ApiImpl extends ApiBase implements ReportV2Api {

    public ReportV2ApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public Report create(Report report) throws Exception {
        return create(null, report);
    }

    @Override
    public Report create(String idempotencyKey, Report report) throws Exception {
        return this.createObject(Report.class, idempotencyKey, "reports_create", report);
    }

    @Override
    public Report get(String reportId) throws Exception {
        return this.getObject(Report.class, "reports_get_v2", reportId);
    }

    @Override
    public List<Report> getAll(Pagination pagination, FilterReportsListV2 filters, Sorting sort) throws Exception {
        if (filters == null) {
            filters = new FilterReportsListV2();
        }
        return this.getList(Report[].class, Report.class, "reports_get_all_v2", pagination, null, filters.getValues(), sort);
    }

    @Override
    public List<Report> getAll() throws Exception {
        return getAll(null, null, null);
    }
}
