package com.mangopay.core.enumerations;

/**
 * Status of a report.
 */
public enum ReportStatus {

    /**
     * Not specified.
     */
    NotSpecified,

    /**
     * Report is pending.
     */
    PENDING,

    /**
     * Report has expired.
     */
    EXPIRED,

    /**
     * Report creation failed.
     */
    FAILED,

    /**
     * Report is ready to download.
     */
    READY_FOR_DOWNLOAD
}
