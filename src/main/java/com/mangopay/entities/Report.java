package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.ReportFilters;
import com.mangopay.entities.subentities.ReportColumn;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Report entity.
 */
public class Report extends EntityBase {

    /**
     * The date and time at which the report was generated.
     */
    @SerializedName("ReportDate")
    private long reportDate;

    /**
     * Status of the report.
     * Returned values: PENDING, READY_FOR_DOWNLOAD, FAILED, EXPIRED
     */
    @SerializedName("Status")
    private String status;

    /**
     * The code indicating the result of the operation. This information is mostly used to handle errors or for filtering purposes.
     */
    @SerializedName("ResultCode")
    private String resultCode;

    /**
     * The explanation of the result code.
     */
    @SerializedName("ResultMessage")
    private String resultMessage;

    /**
     * Download file format.
     */
    @SerializedName("DownloadFormat")
    private String downloadFormat;

    /**
     * Download URL.
     */
    @SerializedName("DownloadURL")
    private String downloadUrl;

    /**
     * Type of the report: USER_WALLET_TRANSACTIONS, COLLECTED_FEES
     */
    @SerializedName("ReportType")
    private String reportType;

    /**
     * Sorting.
     */
    @SerializedName("Sort")
    private String sort;

    /**
     * The date and time after which the report’s transaction was created, based on the transaction’s CreationDate.
     */
    @SerializedName("AfterDate")
    private long afterDate;

    /**
     * The date and time before which the report’s transaction was created, based on the transaction’s CreationDate.
     */
    @SerializedName("BeforeDate")
    private long beforeDate;

    /**
     * The filers to apply. The Currency and WalletId cannot be used together.
     */
    @SerializedName("Filters")
    private ReportFilters filters;

    /**
     * The data columns to be included in the report.
     */
    @SerializedName("Columns")
    private List<ReportColumn> columns;

    public long getReportDate() {
        return reportDate;
    }

    public Report setReportDate(long reportDate) {
        this.reportDate = reportDate;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Report setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getResultCode() {
        return resultCode;
    }

    public Report setResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public Report setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
        return this;
    }

    public String getDownloadFormat() {
        return downloadFormat;
    }

    public Report setDownloadFormat(String downloadFormat) {
        this.downloadFormat = downloadFormat;
        return this;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public Report setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
        return this;
    }

    public String getReportType() {
        return reportType;
    }

    public Report setReportType(String reportType) {
        this.reportType = reportType;
        return this;
    }

    public String getSort() {
        return sort;
    }

    public Report setSort(String sort) {
        this.sort = sort;
        return this;
    }

    public long getAfterDate() {
        return afterDate;
    }

    public Report setAfterDate(long afterDate) {
        this.afterDate = afterDate;
        return this;
    }

    public long getBeforeDate() {
        return beforeDate;
    }

    public Report setBeforeDate(long beforeDate) {
        this.beforeDate = beforeDate;
        return this;
    }

    public ReportFilters getFilters() {
        return filters;
    }

    public Report setFilters(ReportFilters filters) {
        this.filters = filters;
        return this;
    }

    public List<ReportColumn> getColumns() {
        return columns;
    }

    public Report setColumns(List<ReportColumn> columns) {
        this.columns = columns;
        return this;
    }

    /**
     * Gets map which property is an object and what type of object.
     *
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {
        Map<String, Type> result = super.getSubObjects();
        result.put("Filters", ReportFilters.class);
        return result;
    }
}
