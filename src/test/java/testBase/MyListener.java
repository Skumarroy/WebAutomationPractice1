package testBase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {


    public void onStart(ITestContext context) {
        System.out.println("Test Execution started -------");//one time
    }

    public void onTestStart(ITestResult result) {

        System.out.println("Test started -------");//multiple time every start of test method
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed -------");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed -------");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped -------");
    }

    public void onFinish(ITestContext context) {
        System.out.println("All Test execution finished -------");
    }

}
