package com.mangopay.core;

import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.entities.Report;
import com.mangopay.entities.subentities.CreateReport;
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
            new CreateReport()
                .setDownloadFormat("CSV")
                .setReportType("USER_WALLET_TRANSACTIONS")
                .setAfterDate(1740787200)
                .setBeforeDate(1743544740)
                .setFilters(new ReportFilters().setCurrency(CurrencyIso.EUR))
                .setColumns(columns)
        );
        assertNotNull(report);
        assertEquals("PENDING", report.getStatus());
        assertEquals(2, report.getColumns().size());
    }

    @Test
    public void getReport() throws Exception {
        Report report = createReport();
        Report getReport = this.api.getReportV2Api().get(report.getId());
        assertEquals(getReport.getId(), report.getId());
    }

    @Test
    public void getAllReports() throws Exception {
        List<Report> allReports = this.api.getReportV2Api().getAll();
        assertNotNull(allReports);
        assertTrue(allReports.size() > 0);
    }

    @Test
    public void createIntentReport() throws Exception {
        List<String> columns = new ArrayList<>();
        columns.add("Id");
        columns.add("Status");
        columns.add("Amount");
        columns.add("Currency");
        columns.add("FeesAmount");
        columns.add("FeesCurrency");
        columns.add("Type");
        columns.add("PaymentMethod");
        columns.add("BuyerId");
        columns.add("SellerId");

        Report report = this.api.getReportV2Api().create(
            new CreateReport()
                .setDownloadFormat("CSV")
                .setReportType("ECHO_INTENT")
                .setAfterDate(1748782023)
                .setBeforeDate(1753102013)
                .setFilters(
                    new ReportFilters()
                        .setPaymentMethod("PAYPAL")
                        .setStatus("CAPTURED")
                        .setType("PAYIN")
                )
                .setColumns(columns)
        );

        assertNotNull(report);
        assertEquals("PENDING", report.getStatus());
        assertEquals("CSV", report.getDownloadFormat());
        assertEquals(10, report.getColumns().size());
        assertEquals("PAYPAL", report.getFilters().getPaymentMethod());
        assertEquals("CAPTURED", report.getFilters().getStatus());
        assertEquals("PAYIN", report.getFilters().getType());
    }

    @Test
    public void createIntentActionReport() throws Exception {
        List<String> columns = new ArrayList<>();
        columns.add("IntentId");
        columns.add("ExternalProcessingDate");
        columns.add("ExternalProviderReference");
        columns.add("ExternalMerchantReference");
        columns.add("Id");
        columns.add("Status");
        columns.add("Amount");
        columns.add("Currency");
        columns.add("FeesAmount");
        columns.add("FeesCurrency");
        columns.add("Type");
        columns.add("PaymentMethod");
        columns.add("BuyerId");
        columns.add("SellerId");

        Report report = this.api.getReportV2Api().create(
            new CreateReport()
                .setDownloadFormat("CSV")
                .setReportType("ECHO_INTENT_ACTION")
                .setAfterDate(1748782023)
                .setBeforeDate(1753102013)
                .setFilters(
                    new ReportFilters()
                        .setPaymentMethod("PAYPAL")
                        .setStatus("CAPTURED")
                        .setType("PAYIN")
                )
                .setColumns(columns)
        );

        assertNotNull(report);
        assertEquals("PENDING", report.getStatus());
        assertEquals("CSV", report.getDownloadFormat());
        assertEquals(14, report.getColumns().size());
        assertEquals("PAYPAL", report.getFilters().getPaymentMethod());
        assertEquals("CAPTURED", report.getFilters().getStatus());
        assertEquals("PAYIN", report.getFilters().getType());
    }

    @Test
    public void createSettlementReport() throws Exception {
        List<String> columns = new ArrayList<>();
        columns.add("Id");
        columns.add("CreationDate");
        columns.add("FileName");
        columns.add("SettlementCurrency");
        columns.add("Status");
        columns.add("SettledTransactionCount");
        columns.add("UnsettledTransactionCount");
        columns.add("SettledAmount");
        columns.add("DeclaredAmount");
        columns.add("DeficitAmount");

        Report report = this.api.getReportV2Api().create(
            new CreateReport()
                .setDownloadFormat("CSV")
                .setReportType("ECHO_SETTLEMENT")
                .setAfterDate(1748782023)
                .setBeforeDate(1753102013)
                .setFilters(
                    new ReportFilters()
                        .setStatus("RECONCILED")
                        .setExternalProviderName("PAYPAL")
                )
                .setColumns(columns)
        );

        assertNotNull(report);
        assertEquals("PENDING", report.getStatus());
        assertEquals("CSV", report.getDownloadFormat());
        assertEquals(10, report.getColumns().size());
        assertEquals("PAYPAL", report.getFilters().getExternalProviderName());
        assertEquals("RECONCILED", report.getFilters().getStatus());
    }

    @Test
    public void createSplitReport() throws Exception {
        List<String> columns = new ArrayList<>();
        columns.add("Id");
        columns.add("IntentId");
        columns.add("AuthorId");
        columns.add("Currency");
        columns.add("FeesAmount");
        columns.add("FeesCurrency");
        columns.add("Status");
        columns.add("Description");
        columns.add("CreditedWalletId");
        columns.add("DebitedWalletId");
        columns.add("Scheduled");
        columns.add("CreationDate");
        columns.add("ExecutionDate");

        Report report = this.api.getReportV2Api().create(
            new CreateReport()
                .setDownloadFormat("CSV")
                .setReportType("ECHO_SPLIT")
                .setAfterDate(1748782023)
                .setBeforeDate(1753102013)
                .setFilters(
                    new ReportFilters()
                        .setStatus("COMPLETED")
                        .setIntentId("int_0197f975-63f6-714e-8fc6-4451e128170f")
                        .setScheduled(false)
                )
                .setColumns(columns)
        );

        assertNotNull(report);
        assertEquals("PENDING", report.getStatus());
        assertEquals("CSV", report.getDownloadFormat());
        assertEquals(13, report.getColumns().size());
        assertEquals("COMPLETED", report.getFilters().getStatus());
        assertEquals(false, report.getFilters().getScheduled());
    }

    private Report createReport() throws Exception {
        Report report = this.api.getReportV2Api().create(
            new CreateReport()
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
