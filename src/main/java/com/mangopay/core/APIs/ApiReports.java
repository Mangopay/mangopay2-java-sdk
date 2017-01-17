package com.mangopay.core.APIs;

import com.mangopay.MangoPayApi;
import com.mangopay.core.*;
import com.mangopay.core.enumerations.ReportType;
import com.mangopay.entities.ReportRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * API for reports.
 */
public class ApiReports extends ApiBase {
    
    /**
     * Instantiates new ApiReports object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiReports(MangoPayApi root) { super(root); }
    
    public ReportRequest create(ReportRequest reportRequest) throws Exception {
        if (reportRequest.ReportType == ReportType.NotSpecified) reportRequest.ReportType = ReportType.TRANSACTIONS;

        return create(null, reportRequest);
    }
    
    public ReportRequest create(String idempotencyKey, ReportRequest reportRequest) throws Exception {
        if (reportRequest.ReportType == ReportType.NotSpecified)  reportRequest.ReportType = ReportType.TRANSACTIONS;

        //ReportRequestTransport reportRequestTransport = ReportRequestTransport.CreateFromBusinessObject(reportRequest);
        //return this.createObject(ReportRequestTransport.class, idempotencyKey, "MethodKey.ReportRequest", reportRequestTransport, reportRequestTransport.ReportType.ToString()).GetBusinessObject();
        return this.createObject(ReportRequest.class, idempotencyKey, "reports_request", reportRequest, reportRequest.ReportType.toString());
    }
    
    public ReportRequest get(String reportId) throws Exception {
        return this.getObject(ReportRequest.class, "reports_get", reportId);
    }
    
    public List<ReportRequest> getAll(Pagination pagination, FilterReportsList filters, Sorting sort) throws Exception {
        if (filters == null) filters = new FilterReportsList();

        List<ReportRequest> result = this.getList(ReportRequest[].class, ReportRequest.class, "reports_get_all", pagination, null, filters.getValues(), sort);

        return result;
    }
    
    public List<ReportRequest> getAll() throws Exception {
        return this.getAll(null, null, null);
    }
}
