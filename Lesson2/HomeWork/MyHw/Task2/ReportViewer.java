package com.company.Task2;

import java.util.List;

public class ReportViewer implements ReportOutput {

    @Override
    public void out(List<ReportItem> reportItems) {
        System.out.println("Output to monitor");
        for (ReportItem item : reportItems) {
            System.out.format("monitor %s - %f \n\r", item.getDescription(), item.getAmount());
        }
    }
}
