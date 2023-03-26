package com.demo.action;

import com.demo.dao.ReportDao;
import com.demo.ds.FormattedReport;
import com.demo.ds.Report;
import com.demo.format.ReportFormatter;
import com.demo.provider.ReportProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComplexAction {

    @Autowired
    private ReportProvider reportProvider;
    @Autowired
    private ReportFormatter reportFormatter;
    @Autowired
    private ReportDao reportDao;

    public void takeAction() {
        Report report = reportProvider.provide();
        FormattedReport formattedReport =reportFormatter.formattedReport(report);
        reportDao.save(formattedReport);
    }

}
