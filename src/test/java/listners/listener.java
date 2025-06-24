package listners;

import basicTemplate.configs.loadProps;
import basicTemplate.configs.testNGExtentReports;
import basicTemplate.configs.utils;
import basicTemplate.jira.jiraClient;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class listener extends utils implements ITestListener {

    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    ExtentReports extent = testNGExtentReports.extentReportGenerator();
    ExtentTest test;

    String passCommentText = loadProps.getProperty("PassComment") + loadProps.getProperty("Version");
    String failCommentText = loadProps.getProperty("FailedComment") + loadProps.getProperty("Version");

    public listener() throws IOException {
    }

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "✅ Test Passed");

        String issueKey = getDynamicIssueKey(result);
        if (issueKey != null) {
            jiraClient.handleTestCaseResultSmart(
                    issueKey,
                    "Automation Test Passed - " + result.getMethod().getMethodName(),
                    passCommentText,
                    null,
                    false
            );
        }
    }

    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        // Get driver instance
        Object obj = result.getInstance();
        Class<?> cl = result.getTestClass().getRealClass();
        try {
            driver = (WebDriver) cl.getDeclaredField("driver").get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        File screenshotFile = null;
        try {
            screenshotFile = new File(getScreenShotPath(result.getName()));
            extentTest.get().addScreenCaptureFromPath(screenshotFile.getAbsolutePath());
        } catch (IOException | AWTException e) {
            e.printStackTrace();
        }

        // Jira bug handling
        String issueKey = getDynamicIssueKey(result);
        String summary = "Automation Test Failed - " + result.getMethod().getMethodName();
        String description = result.getThrowable() != null ?
                result.getThrowable().toString().replace("\"", "'").replace("\n", "\\n") : "No stack trace";

        if (issueKey != null) {
            jiraClient.handleTestCaseResultSmart(
                    issueKey,
                    summary,
                    description,
                    screenshotFile,
                    true
            );
        } else {
            jiraClient.createBug(summary,description,screenshotFile);
            System.out.println("⚠️ No JIRA IssueKey provided or mapped. Creating New Jira Issue");
        }
    }

    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "⚠️ Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    public void onStart(ITestContext context) {}

    public void onFinish(ITestContext context) {
        extent.flush();
    }

    // 🚀 Get issueKey dynamically
    private String getDynamicIssueKey(ITestResult result) {
        // Option 1: use test name mapping (you can also read from a properties file or tag)
        String methodName = result.getMethod().getMethodName();

        switch (methodName) {
            case "Failed_login":
                return "SCRUM-2";
            case "login":
                return "SCRUM-16";
            // add more mappings
            default:
                return null; // fallback to config
        }
    }
}
