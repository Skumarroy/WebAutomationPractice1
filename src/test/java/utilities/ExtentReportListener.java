package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ExtentReportListener implements ITestListener {

    private ExtentSparkReporter sparkReporter;
    private ExtentReports extent;
    private ExtentTest test;
    private static WebDriver driver;  // Declare WebDriver instance

    @Override
    public void onStart(ITestContext context) {
        // Create a directory for reports
        File reportsDirectory = new File(System.getProperty("user.dir") + "/reports");
        if (!reportsDirectory.exists()) {
            reportsDirectory.mkdir();
        }

        // Create directory for screenshots within the reports directory
        File screenshotDirectory = new File(reportsDirectory, "screenshots");
        if (!screenshotDirectory.exists()) {
            screenshotDirectory.mkdir();
        }

        // Set up the ExtentSparkReporter
        sparkReporter = new ExtentSparkReporter(reportsDirectory + "/myReport.html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Automation Test Results");
        sparkReporter.config().setReportName("Test Execution Report");

        // Attach the reporter to ExtentReports instance
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("ComputerName", "LocalHost");
        extent.setSystemInfo("OS", "Windows 10");
        extent.setSystemInfo("TesterName", "Sanjeet");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Test Case PASSED is " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test Case FAILED is " + result.getName());
        test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());

        // Capture screenshot on test failure
        if (driver != null) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
            if (screenshotPath != null) {
                test.fail("Screenshot of failure:",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else {
                test.log(Status.FAIL, "Failed to capture screenshot due to IOException or invalid driver state.");
            }
        } else {
            test.log(Status.FAIL, "Driver is not initialized, cannot capture screenshot.");
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test Case SKIPPED is " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // Writes everything to the log file
    }

    // Setter for WebDriver, call this from your test base class
    public static void setDriver(WebDriver driver) {
        ExtentReportListener.driver = driver;
    }
}
