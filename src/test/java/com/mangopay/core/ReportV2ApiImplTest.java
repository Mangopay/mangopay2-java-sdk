package com.mangopay.core;

import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.entities.Report;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * API ReportsV2 test methods.
 */
public class ReportV2ApiImplTest extends BaseTest {

    @Test
    public void createReportCollectedFees() throws Exception {
        createReport();
    }

    @Test
    public void createReportUserWalletTransactions() throws Exception {
        List<String> columns = new ArrayList<>();
        columns.add("CreationDate");
        columns.add("AuthorId");

        Report report = this.api.getReportV2Api().create(
            new Report()
                .setDownloadFormat("CSV")
                .setReportType("USER_WALLET_TRANSACTIONS")
                .setAfterDate(1740787200)
                .setBeforeDate(1743544740)
                .setFilters(new ReportFilters().setCurrency(CurrencyIso.EUR))
                .setColumns(columns)
        );
        assertNotNull(report);
        assertEquals("PENDING", report.getStatus());
    }

    @Test
    public void getReport() throws Exception {
//        Report report = createReport();
        Report getReport = this.api.getReportV2Api().get("report_01JWG8PW1HBQZBH8YPY14CSXVT");
        assertEquals(getReport.getId(), "report_01JWG8PW1HBQZBH8YPY14CSXVT");
    }

    @Test
    public void getAllReports() throws Exception {
        List<Report> allReports = this.api.getReportV2Api().getAll();
        assertNotNull(allReports);
        assertTrue(allReports.size() > 0);
    }

    private Report createReport() throws Exception {
        Report report = this.api.getReportV2Api().create(
            new Report()
                .setDownloadFormat("CSV")
                .setReportType("COLLECTED_FEES")
                .setAfterDate(1740787200)
                .setBeforeDate(1743544740)
        );
        assertNotNull(report);
        assertEquals("PENDING", report.getStatus());
        return report;
    }

}
