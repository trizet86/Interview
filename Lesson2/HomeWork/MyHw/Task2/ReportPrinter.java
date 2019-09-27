package com.company.Task2;

import java.util.*;

class ReportPrinter implements ReportOutput {

    @Override
    public void out(List<ReportItem> reportItems) {
        System.out.println("Output to printer");
        for (ReportItem item : reportItems) {
            System.out.format("printer %s - %f \n\r", item.getDescription(), item.getAmount());
        }
    }
}