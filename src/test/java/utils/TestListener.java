package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import base.BaseTest;
import stepdefinitions.Hooks;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    public static ExtentTest test;
    
    @Override
    public void onTestStart(ITestResult result) {

        String testName;

        try {
            // Get scenario name from Cucumber
            testName = result.getParameters()[0].toString();
        } catch (Exception e) {
            // fallback (if not BDD)
            testName = result.getName();
        }

        test = extent.createTest(testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed: " + test.getModel().getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed: " + result.getName());

        Object testClass = result.getInstance();
        WebDriver driver = Hooks.getDriver();

        if (driver != null) {
            String path = ScreenshotUtils.takeScreenshot(driver, result.getName());

            try {
            	test.fail("Screenshot below 👇")
                .addScreenCaptureFromPath(path);  // 🔥 attach screenshot
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // VERY IMPORTANT
    }
}