package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;
  
    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
            reporter.config().setReportName("Automation Report");
            reporter.config().setDocumentTitle("Test Execution Report");
        }
        return extent;
    }
}