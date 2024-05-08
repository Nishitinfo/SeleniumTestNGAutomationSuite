package basicTemplate;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReporterNG {

    public static ExtentReports report = null;
    public static ExtentSparkReporter htmlReporter = null;
    static ExtentReports extent;

    public static ExtentReports extentReportGenerator() {

        String path = System.getProperty("user.dir") + "/Reports/ExtentReport/extentReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Web Test Results");
        extent = new ExtentReports();
        reporter.config().getReporter();
        extent.attachReporter(reporter);
//        extent.setSystemInfo("QA Manager", "Nishit Sheth");
        extent.setSystemInfo("Tester Name ", "Nishit Sheth");
        extent.setSystemInfo("Build No ", "1.0");
        extent.setSystemInfo("os", "Windows");
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/SparkReport");
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setCss("css-string");
        htmlReporter.config().setDocumentTitle("Automation Test Report");
        htmlReporter.config().setTimelineEnabled(true);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setJs("js-string");
        htmlReporter.config().setProtocol(Protocol.HTTPS);
        htmlReporter.config().setReportName("Automation Report");
        htmlReporter.config().setTheme(Theme.DARK);
        return extent;
    }
}
