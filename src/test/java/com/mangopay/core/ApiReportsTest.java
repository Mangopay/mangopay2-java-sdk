package com.mangopay.core;

import com.mangopay.core.enumerations.ReportType;
import com.mangopay.core.enumerations.SortDirection;
import com.mangopay.entities.ReportRequest;
import java.util.Calendar;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * API Reports test methods.
 */
public class ApiReportsTest extends BaseTest {
    
    @Test
    public void createReport() throws Exception
    {
        ReportRequest reportPost = new ReportRequest();
        reportPost.ReportType = ReportType.TRANSACTIONS;

        ReportRequest report = this.api.Reports.create(reportPost);
        assertNotNull(report);
        assertTrue(report.Id.length() > 0);
    }

    @Test
    public void createFilteredReport() throws Exception
    {
        ReportRequest reportPost = new ReportRequest();
        reportPost.ReportType = ReportType.TRANSACTIONS;
        
        String johnsId = this.getJohn().Id;
        String walletId = this.getJohnsWallet().Id;
        reportPost.Filters = new FilterReports();
        reportPost.Filters.AuthorId = johnsId;
        reportPost.Filters.WalletId = walletId;

        ReportRequest report = this.api.Reports.create(reportPost);
        assertNotNull(report);
        assertNotNull(report.Filters);
        assertNotNull(report.Filters.AuthorId);
        assertEquals(johnsId, report.Filters.AuthorId);
        assertNotNull(report.Filters.WalletId);
        assertEquals(walletId, report.Filters.WalletId);
        assertTrue(report.Id.length() > 0);
    }

    @Test
    public void getReport() throws Exception
    {
        ReportRequest report = this.getJohnsReport();
        ReportRequest getReport = this.api.Reports.get(report.Id);

        assertEquals(getReport.Id, report.Id);
    }
    
    @Test
    public void getReports() throws Exception
    {
        ReportRequest report = this.getNewJohnsReport();
        Pagination pagination = new Pagination(1, 10);
        Sorting sort = new Sorting();
        sort.addField("CreationDate", SortDirection.desc);

        List<ReportRequest> list = this.api.Reports.getAll(pagination, null, sort);

        /*
            Due to concurrent nature of how unit tests are launched, 
            it is not guaranteed that report created in this method
            will be the newest one in the reports list received from
            API. Therefore another solution is needed here, such as
            looking for the report among few the newest ones (here 10).
        */
        int j = -1;
        for (int i = 0; i < list.size(); i++) {
            if (report.Id.equals(list.get(i).Id)) {
                j = i;
                break;
            }
        }
        assertTrue(j > -1);
        
        assertEquals(report.Id, list.get(j).Id);
        assertEquals(pagination.Page, 1);
        assertEquals(pagination.ItemsPerPage, 10);

        FilterReportsList filters = new FilterReportsList();
        filters.AfterDate = list.get(j).CreationDate;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        filters.BeforeDate = c.getTimeInMillis() / 1000;

        list = this.api.Reports.getAll(pagination, filters, sort);

        assertNotNull(list);
        assertTrue(list.isEmpty());

        filters.BeforeDate = filters.AfterDate;
        c.set(Calendar.YEAR, c.get(Calendar.YEAR)-10);
        filters.AfterDate = c.getTimeInMillis() / 1000;

        list = this.api.Reports.getAll(pagination, filters, sort);

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }
    
}
