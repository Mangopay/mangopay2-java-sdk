package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.FilterReports;
import com.mangopay.core.Sorting;
import com.mangopay.core.enumerations.DownloadReportFormat;
import com.mangopay.core.enumerations.ReportStatus;
import com.mangopay.core.enumerations.ReportType;
import com.mangopay.core.enumerations.SortDirection;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import static com.mangopay.core.enumerations.ReportType.TRANSACTIONS;

/**
 * Report request entity.
 */
public class ReportRequest extends EntityBase {

    @SerializedName("ReportDate")
    private long reportDate;

    @SerializedName("Status")
    private ReportStatus status;

    @SerializedName("DownloadFormat")
    private DownloadReportFormat downloadFormat;

    @SerializedName("DownloadURL")
    private String downloadUrl;

    @SerializedName("CallbackURL")
    private String callbackUrl;

    @SerializedName("ReportType")
    private ReportType reportType;

    @SerializedName("Sort")
    private String sort;

    @SerializedName("Preview")
    private boolean preview;

    @SerializedName("Filters")
    private FilterReports filters;

    @SerializedName("Columns")
    private List<String> columns;

    @SerializedName("ResultCode")
    private String resultCode;

    @SerializedName("ResultMessage")
    private String resultMessage;

    public ReportRequest() {
        this.downloadFormat = DownloadReportFormat.CSV;
        this.filters = new FilterReports();
        this.reportType = TRANSACTIONS;

        Sorting s = new Sorting();
        s.addField("CreationDate", SortDirection.asc);

        this.sort = s.getFields();
    }

    public long getReportDate() {
        return reportDate;
    }

    public void setReportDate(long reportDate) {
        this.reportDate = reportDate;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public DownloadReportFormat getDownloadFormat() {
        return downloadFormat;
    }

    public void setDownloadFormat(DownloadReportFormat downloadFormat) {
        this.downloadFormat = downloadFormat;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public boolean isPreview() {
        return preview;
    }

    public void setPreview(boolean preview) {
        this.preview = preview;
    }

    public FilterReports getFilters() {
        return filters;
    }

    public void setFilters(FilterReports filters) {
        this.filters = filters;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    /**
     * Gets map which property is an object and what type of object.
     *
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {

        Map<String, Type> result = super.getSubObjects();

        result.put("Filters", FilterReports.class);

        return result;
    }
}
