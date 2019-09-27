package com.company.Task2;

import java.util.List;

public class ReportSaver implements ReportOutput {

    @Override
    public void out(List<ReportItem> reportItems) {
        System.out.println("Output to file");
        for (ReportItem item : reportItems) {
            System.out.format("file %s - %f \n\r", item.getDescription(), item.getAmount());
        }
    }
}
