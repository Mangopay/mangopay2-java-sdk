package com.mangopay.core;

import com.mangopay.core.enumerations.ReportType;
import com.mangopay.core.enumerations.SortDirection;
import com.mangopay.entities.ReportRequest;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * API Reports test methods.
 */
public class ReportApiImplTest extends BaseTest {

    @Test
    public void createReport() throws Exception {
        ReportRequest reportPost = new ReportRequest();
        reportPost.setReportType(ReportType.TRANSACTIONS);

        ReportRequest report = this.api.getReportApi().create(reportPost);
        assertNotNull(report);
        assertTrue(report.getId().length() > 0);
    }

    @Test
    public void createFilteredReport() throws Exception {
        ReportRequest reportPost = new ReportRequest();
        reportPost.setReportType(ReportType.TRANSACTIONS);

        String johnsId = this.getJohn().getId();
        String walletId = this.getJohnsWallet().getId();
        reportPost.setFilters(new FilterReports());
        reportPost.getFilters().setAuthorId(johnsId);
        reportPost.getFilters().setWalletId(walletId);

        ReportRequest report = this.api.getReportApi().create(reportPost);
        assertNotNull(report);
        assertNotNull(report.getFilters());
        assertNotNull(report.getFilters().getAuthorId());
        assertEquals(johnsId, report.getFilters().getAuthorId());
        assertNotNull(report.getFilters().getWalletId());
        assertEquals(walletId, report.getFilters().getWalletId());
        assertTrue(report.getId().length() > 0);
    }

    @Test
    public void createWalletReport() throws Exception {
        ReportRequest reportRequest = new ReportRequest();

        ReportRequest report = this.api.getReportApi().createWalletReport(reportRequest);

        assertNotNull(report);
        assertEquals(report.getReportType(), ReportType.WALLETS);
    }

    @Test
    public void getReport() throws Exception {
        ReportRequest report = this.getJohnsReport();
        ReportRequest getReport = this.api.getReportApi().get(report.getId());

        assertEquals(getReport.getId(), report.getId());
    }

    @Test
    public void getReports() throws Exception {
        ReportRequest report = this.getNewJohnsReport();
        Pagination pagination = new Pagination(1, 10);
        Sorting sort = new Sorting();
        sort.addField("CreationDate", SortDirection.desc);

        List<ReportRequest> list = this.api.getReportApi().getAll(pagination, null, sort);

        /*
            Due to concurrent nature of how unit tests are launched, 
            it is not guaranteed that report created in this method
            will be the newest one in the reports list received from
            API. Therefore another solution is needed here, such as
            looking for the report among few the newest ones (here 10).
        */
        int j = -1;
        for (int i = 0; i < list.size(); i++) {
            if (report.getId().equals(list.get(i).getId())) {
                j = i;
                break;
            }
        }
        assertTrue(j > -1);

        assertEquals(report.getId(), list.get(j).getId());
        assertEquals(pagination.getPage(), 1);
        assertEquals(pagination.getItemsPerPage(), 10);

        FilterReportsList filters = new FilterReportsList();
        filters.setAfterDate(list.get(j).getCreationDate());
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        filters.setBeforeDate(c.getTimeInMillis() / 1000);

        list = this.api.getReportApi().getAll(pagination, filters, sort);

        assertNotNull(list);
        assertTrue(list.isEmpty());

        filters.setBeforeDate(filters.getAfterDate());
        c.set(Calendar.YEAR, c.get(Calendar.YEAR) - 10);
        filters.setAfterDate(c.getTimeInMillis() / 1000);

        list = this.api.getReportApi().getAll(pagination, filters, sort);

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

}
