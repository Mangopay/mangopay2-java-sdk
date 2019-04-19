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

    /**
     * Date of when the report was requested.
     */
    @SerializedName("ReportDate")
    private long reportDate;

    /**
     * Status of the report.
     */
    @SerializedName("Status")
    private ReportStatus status;

    /**
     * Download file format.
     */
    @SerializedName("DownloadFormat")
    private DownloadReportFormat downloadFormat;

    /**
     * Download URL.
     */
    @SerializedName("DownloadURL")
    private String downloadUrl;

    /**
     * Callback URL.
     */
    @SerializedName("CallbackURL")
    private String callbackUrl;

    /**
     * type of the report.
     */
    @SerializedName("ReportType")
    private ReportType reportType;

    /**
     * Sorting.
     */
    @SerializedName("Sort")
    private String sort;

    /**
     * If true, the report will be limited to the first few lines.
     */
    @SerializedName("Preview")
    private boolean preview;

    /**
     * Filters for the report list results.
     */
    @SerializedName("Filters")
    private FilterReports filters;

    /**
     * Columns to be included in the report.
     * Allowed values: "Alias", "BankAccountId", "BankWireRef", "CardId",
     * "CardType", "country", "Culture", "Currency", "DeclaredDebitedFundsAmount",
     * "DeclaredDebitedFundsCurrency", "DeclaredFeesAmount",
     * "DeclaredFeesCurrency", "ExecutionType", "ExpirationDate", "PaymentType",
     * "PreauthorizationId", "WireReference".
     */
    @SerializedName("Columns")
    private List<String> columns;

    /**
     * Request's result code.
     */
    @SerializedName("ResultCode")
    private String resultCode;

    /**
     * Request's result message.
     */
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
