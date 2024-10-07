package basicTemplate.configs;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class testNGExtentReports {

    public static ExtentReports report = null;
    public static ExtentSparkReporter htmlReporter = null;
    static ExtentReports extent;
    static boolean update = false;

    public static ExtentReports extentReportGenerator() throws IOException {

        //ReleaseVersionFolderAUtoFetch
//        String folderName = utils.getText("/html/body/div/div[2]/div[1]/div[1]");
//        Path reportPath = Paths.get(System.getProperty("user.dir"), folderName);
//
//        // Step 3: Create the folder if it does not exist
//        if (!Files.exists(reportPath)) {
//            Files.createDirectories(reportPath);
//        }

        String folderName = loadProps.getProperty("Version").replaceAll("[()-+.^:,. ]", "");
        Path reportPath = Paths.get(System.getProperty("user.dir") + "/MRITestExecutionReports/", folderName);
        // Step 3: Create the folder if it does not exist
        if (!Files.exists(reportPath)) {
            Files.createDirectories(reportPath);
        }
        String path = reportPath + "/extentReports/testNGExtentReports/html/extentReport_" + utils.timeStamp() + ".html";
        System.out.println(path);
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
        reporter.config().setReportName("MRI Energy Automation Test Report");
        reporter.config().setDocumentTitle("MRI Energy Automation Test");
        reporter.config().getCss();
        reporter.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");
        String SparkPath = reportPath + "/extentReports/testNGExtentReports/spark/spark_" + utils.timeStamp() + ".html";
        System.out.println(SparkPath);
        ExtentSparkReporter sparkDarkReporter = new ExtentSparkReporter(SparkPath);
        sparkDarkReporter.config().setCss("css-string");
        sparkDarkReporter.config().setDocumentTitle("MRI Energy Automation Test");
        sparkDarkReporter.config().setTimelineEnabled(true);
        sparkDarkReporter.config().setEncoding("utf-8");
        sparkDarkReporter.config().setJs("js-string");
        sparkDarkReporter.config().setProtocol(Protocol.HTTPS);
        sparkDarkReporter.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");
        sparkDarkReporter.config().setReportName("MRI Energy Automation Report");
        sparkDarkReporter.config().setTheme(Theme.DARK);
        sparkDarkReporter.config().getReporter();
        if (extent == null) {
            extent = new ExtentReports();
            extent.setSystemInfo("QA Name ", "Nishit Sheth");
            extent.setSystemInfo("os", "Windows");
            System.out.println("Reporter attached successfully.");

        } else {
            if (!update) {
                // Assuming reporter and extent are initialized earlier
                reporter.config().getReporter();
                extent.attachReporter(reporter);
                sparkDarkReporter.config().getReporter();
                extent.attachReporter(sparkDarkReporter);
                update = true;
            }


        }

        return extent;
    }
}
