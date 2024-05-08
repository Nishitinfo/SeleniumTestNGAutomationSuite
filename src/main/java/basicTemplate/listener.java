package basicTemplate;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.IOException;


public class listener extends utils implements ITestListener {
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    ExtentReports extent = extentReporterNG.extentReportGenerator();
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

        extentTest.get().fail(result.getThrowable());
        Object obj = result.getInstance();
        Class<?> cl = result.getTestClass().getRealClass();

        try {
            driver = (WebDriver) cl.getDeclaredField("driver").get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String name = getScreenShotPath(result.getName());
            extentTest.get().addScreenCaptureFromPath(name);
//            extentTest.get().addScreenCaptureFromBase64String(getScreenBase64(result.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        try {
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName()),result.getMethod().getMethodName());
        } catch (IOException | AWTException e) {
            e.printStackTrace();
        }
    }


    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Skipped");
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }


    public void onTestFailedWithTimeout(ITestResult result) {

    }


    public void onStart(ITestContext context) {

    }


    public void onFinish(ITestContext context) {
        extent.flush();
    }

}

