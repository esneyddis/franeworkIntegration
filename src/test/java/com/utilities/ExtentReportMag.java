package com.utilities;


import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportMag {

     private static ExtentReports extent;

     public static ExtentReports getInstance() {
         if (extent == null) {
             extent = new ExtentReports(System.getProperty("user.dir") + "/src/test/resources/reports/extentReport.html");
         }
         return extent;
     }
}
