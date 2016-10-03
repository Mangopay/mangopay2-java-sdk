package com.mangopay.entities;

import com.mangopay.core.Address;
import com.mangopay.core.EntityBase;
import com.mangopay.core.FilterReports;
import com.mangopay.core.Sorting;
import com.mangopay.core.enumerations.DownloadReportFormat;
import com.mangopay.core.enumerations.ReportType;
import com.mangopay.core.enumerations.ReportStatus;
import com.mangopay.core.enumerations.SortDirection;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Report request entity.
 */
public class ReportRequest extends EntityBase {
    
    public ReportRequest()
    {
        DownloadFormat = DownloadReportFormat.CSV;
        Filters = new FilterReports();
        ReportType = ReportType.TRANSACTIONS;
        
        Sorting s = new Sorting();
        s.addField("CreationDate", SortDirection.asc);
        
        Sort = s.getFields();
    }
    
    public long ReportDate;

    public ReportStatus Status;

    public DownloadReportFormat DownloadFormat;

    public String DownloadURL;

    public String CallbackURL;

    public ReportType ReportType;

    public String Sort;

    public boolean Preview;

    public FilterReports Filters;

    public List<String> Columns;

    public String ResultCode;

    public String ResultMessage;
    
    /**
     * Gets map which property is an object and what type of object.
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {
        
        Map<String, Type> result = super.getSubObjects();
        
        result.put("Filters", FilterReports.class);
        
        return result;
    }
}
