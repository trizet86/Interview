package com.company.Task2;

class Program {
    public static void main(String[] args) {
        Report report = new Report();
        report.calculate();

        report.output(new ReportViewer());
        report.output(new ReportPrinter());
        report.output(new ReportSaver());
    }
}