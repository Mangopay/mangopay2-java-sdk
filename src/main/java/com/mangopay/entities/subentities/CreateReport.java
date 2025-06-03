package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.ReportFilters;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Report entity.
 */
public class CreateReport extends Dto {

    @SerializedName("Tag")
    private String tag;

    /**
     * Download file format.
     */
    @SerializedName("DownloadFormat")
    private String downloadFormat;

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
    private List<String> columns;

    public String getTag() {
        return tag;
    }

    public CreateReport setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public String getDownloadFormat() {
        return downloadFormat;
    }

    public CreateReport setDownloadFormat(String downloadFormat) {
        this.downloadFormat = downloadFormat;
        return this;
    }

    public String getReportType() {
        return reportType;
    }

    public CreateReport setReportType(String reportType) {
        this.reportType = reportType;
        return this;
    }

    public String getSort() {
        return sort;
    }

    public CreateReport setSort(String sort) {
        this.sort = sort;
        return this;
    }

    public long getAfterDate() {
        return afterDate;
    }

    public CreateReport setAfterDate(long afterDate) {
        this.afterDate = afterDate;
        return this;
    }

    public long getBeforeDate() {
        return beforeDate;
    }

    public CreateReport setBeforeDate(long beforeDate) {
        this.beforeDate = beforeDate;
        return this;
    }

    public ReportFilters getFilters() {
        return filters;
    }

    public CreateReport setFilters(ReportFilters filters) {
        this.filters = filters;
        return this;
    }

    public List<String> getColumns() {
        return columns;
    }

    public CreateReport setColumns(List<String> columns) {
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
