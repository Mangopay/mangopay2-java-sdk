package com.mangopay.entities;

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

    /**
     * @deprecated Use {@link #getReportDate()} and {@link #setReportDate(long)} instead.
     */
    @Deprecated
    public long ReportDate;

    /**
     * @deprecated Use {@link #getStatus()} and {@link #setStatus(ReportStatus)} instead.
     */
    @Deprecated
    public ReportStatus Status;

    /**
     * @deprecated Use {@link #getDownloadFormat()} and {@link #setDownloadFormat(DownloadReportFormat)} instead.
     */
    @Deprecated
    public DownloadReportFormat DownloadFormat;

    /**
     * @deprecated Use {@link #getDownloadURL()} and {@link #setDownloadURL(String)} instead.
     */
    @Deprecated
    public String DownloadURL;

    /**
     * @deprecated Use {@link #getCallbackURL()} and {@link #setCallbackURL(String)} instead.
     */
    @Deprecated
    public String CallbackURL;

    /**
     * @deprecated Use {@link #getReportType()} and {@link #setReportType(ReportType)} instead.
     */
    @Deprecated
    public ReportType ReportType;

    /**
     * @deprecated Use {@link #getSort()} and {@link #setSort(String)} instead.
     */
    @Deprecated
    public String Sort;

    /**
     * @deprecated Use {@link #isPreview()} and {@link #setPreview(boolean)} instead.
     */
    @Deprecated
    public boolean Preview;

    /**
     * @deprecated Use {@link #getFilters()} and {@link #setFilters(FilterReports)} instead.
     */
    @Deprecated
    public FilterReports Filters;

    /**
     * @deprecated Use {@link #getColumns()} and {@link #setColumns(List)} instead.
     */
    @Deprecated
    public List<String> Columns;

    /**
     * @deprecated Use {@link #getResultCode()} and {@link #setResultCode(String)} instead.
     */
    @Deprecated
    public String ResultCode;

    /**
     * @deprecated Use {@link #getResultMessage()} and {@link #setResultMessage(String)} instead.
     */
    @Deprecated
    public String ResultMessage;

    public ReportRequest() {
        this.DownloadFormat = DownloadReportFormat.CSV;
        this.Filters = new FilterReports();
        this.ReportType = TRANSACTIONS;

        Sorting s = new Sorting();
        s.addField("CreationDate", SortDirection.asc);

        this.Sort = s.getFields();
    }

    public long getReportDate() {
        return ReportDate;
    }

    public void setReportDate(long reportDate) {
        this.ReportDate = reportDate;
    }

    public ReportStatus getStatus() {
        return Status;
    }

    public void setStatus(ReportStatus status) {
        this.Status = status;
    }

    public DownloadReportFormat getDownloadFormat() {
        return DownloadFormat;
    }

    public void setDownloadFormat(DownloadReportFormat downloadFormat) {
        this.DownloadFormat = downloadFormat;
    }

    public String getDownloadURL() {
        return DownloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        this.DownloadURL = downloadURL;
    }

    public String getCallbackURL() {
        return CallbackURL;
    }

    public void setCallbackURL(String callbackURL) {
        this.CallbackURL = callbackURL;
    }

    public ReportType getReportType() {
        return ReportType;
    }

    public void setReportType(ReportType reportType) {
        this.ReportType = reportType;
    }

    public String getSort() {
        return Sort;
    }

    public void setSort(String sort) {
        this.Sort = sort;
    }

    public boolean isPreview() {
        return Preview;
    }

    public void setPreview(boolean preview) {
        this.Preview = preview;
    }

    public FilterReports getFilters() {
        return Filters;
    }

    public void setFilters(FilterReports filters) {
        this.Filters = filters;
    }

    public List<String> getColumns() {
        return Columns;
    }

    public void setColumns(List<String> columns) {
        this.Columns = columns;
    }

    public String getResultCode() {
        return ResultCode;
    }

    public void setResultCode(String resultCode) {
        this.ResultCode = resultCode;
    }

    public String getResultMessage() {
        return ResultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.ResultMessage = resultMessage;
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
