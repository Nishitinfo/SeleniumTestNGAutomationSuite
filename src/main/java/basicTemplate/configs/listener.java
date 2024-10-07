package basicTemplate.configs;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.IOException;


public class listener extends utils implements ITestListener {
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    ExtentReports extent = testNGExtentReports.extentReportGenerator();
    ExtentTest test;

    public listener() throws IOException {
    }


    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }


    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Successful");
    }


    public void onTestFailure(ITestResult result) {

        try {
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName()));
            extentTest.get().log(Status.FAIL, "Test Failed");
            extentTest.get().fail(result.getThrowable());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

    }


    public void onTestSkipped(ITestResult result) {
        try {
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName()));
            extentTest.get().skip(result.getTestName());
            extentTest.get().log(Status.SKIP, "Test Skipped");
        } catch (IOException | AWTException e) {
            e.printStackTrace();
        }
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        try {
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName()));
            extentTest.get().fail(result.getThrowable());
            extentTest.get().log(Status.WARNING, "testFailedButWithinSuccessPercentage");
        } catch (IOException | AWTException e) {
            e.printStackTrace();
        }
    }


    public void onTestFailedWithTimeout(ITestResult result) {
        try {
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName()));
            extentTest.get().fail(result.getThrowable());
            extentTest.get().log(Status.WARNING, "TimeOut");
        } catch (IOException | AWTException e) {
            e.printStackTrace();
        }
    }


    public void onStart(ITestContext context) {

    }


    public void onFinish(ITestContext context) {
        extent.flush();
    }

}

