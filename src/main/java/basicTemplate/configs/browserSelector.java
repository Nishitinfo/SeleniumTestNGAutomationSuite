package basicTemplate.configs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class browserSelector extends base {
    public static String brows = loadProps.getProperty("Browser");
    public static String URL = loadProps.getProperty("URL");
    public static boolean Recording = Boolean.parseBoolean(loadProps.getProperty("RecordingMode"));
    public static boolean Screenshot = Boolean.parseBoolean(loadProps.getProperty("ScreenshotsMode"));
    public static boolean headless = Boolean.parseBoolean(loadProps.getProperty("HeadlessMode"));

    public static void setUp() throws Exception {
        if (brows.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.silentOutput", "true");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.setAcceptInsecureCerts(true);
            options.addArguments("--test-type");
            options.addArguments("--incognito");
            if (headless) {
                options.addArguments("--headless");
            }
            options.addArguments("--disable-extensions");
            options.addArguments("disable-infobars");
            options.addArguments("--deleteAll-Cookies");

            Path videoDir = Paths.get(System.getProperty("user.dir") + "/MRITestExecutionReports/" + loadProps.getProperty("Version").replaceAll("[()-+.^:, ]", "") + "/recordings/");
            if (!Files.exists(videoDir)) {
                Files.createDirectories(videoDir);
            }
            driver = new ChromeDriver(options);
            driver.get(URL);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            if (Recording && !headless) {
                recoder.ScreenCapturing();
            }
            utils.version();

        } else if (brows.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.setAcceptInsecureCerts(true);
            if (headless) {
                options.addArguments("--headless");
            }

            options.addArguments("--remote-allow-origins=*");

            Path videoDir = Paths.get(System.getProperty("user.dir") + "/MRITestExecutionReports/" + loadProps.getProperty("Version").replaceAll("[()-+.^:, ]", "") + "/recordings/");
            if (!Files.exists(videoDir)) {
                Files.createDirectories(videoDir);
            }
            driver = new EdgeDriver(options);
            driver.get(URL);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            if (Recording && !headless) {
                recoder.ScreenCapturing();
            }
            utils.version();
        } else if (brows.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--remote-allow-origins=*");

            Path videoDir = Paths.get(System.getProperty("user.dir") + "/MRITestExecutionReports/" + loadProps.getProperty("Version").replaceAll("[()-+.^:, ]", "") + "/recordings/");
            if (!Files.exists(videoDir)) {
                Files.createDirectories(videoDir);
            }
            driver = new FirefoxDriver();
            driver.get(URL);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            if (Recording && !headless) {
                recoder.ScreenCapturing();
            }
            utils.version();
        } else if (brows.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();

            Path videoDir = Paths.get(System.getProperty("user.dir") + "/MRITestExecutionReports/" + loadProps.getProperty("Version").replaceAll("[()-+.^:, ]", "") + "/recordings/");
            if (!Files.exists(videoDir)) {
                Files.createDirectories(videoDir);
            }
            driver = new OperaDriver();
            driver.get(URL);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            if (Recording && !headless) {
                recoder.ScreenCapturing();
            }
            utils.version();
        } else {
            System.out.println("This Browser is not found in your system.");
        }

    }


    public static void tearDown() throws Exception {
        if (Recording && !headless) {
            recoder.StopCapturing();
        }

        driver.close();
        driver.quit();

    }


    //For Parallel Execution using Testng XML

    public static void LaunchBrowser(String brows) throws Exception {
        if (brows.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.silentOutput", "true");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--test-type");
            options.addArguments("--incognito");
            if (headless) {
                options.addArguments("--headless");
            }
            options.addArguments("--disable-extensions");
            options.addArguments("disable-infobars");
            options.addArguments("--deleteAll-Cookies");

            Path videoDir = Paths.get(System.getProperty("user.dir") + "/MRITestExecutionReports/" + loadProps.getProperty("Version").replaceAll("[()-+.^:, ]", "") + "/recordings/");
            if (!Files.exists(videoDir)) {
                Files.createDirectories(videoDir);
            }
            driver = new ChromeDriver(options);
            driver.get(URL);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            if (Recording && !headless) {
                recoder.ScreenCapturing();
            }
            utils.version();
        } else if (brows.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.setAcceptInsecureCerts(true);
            options.addArguments("--remote-allow-origins=*");
            if (headless) {
                options.addArguments("--headless");
            }

            Path videoDir = Paths.get(System.getProperty("user.dir") + "/MRITestExecutionReports/" + loadProps.getProperty("Version").replaceAll("[()-+.^:, ]", "") + "/recordings/");
            if (!Files.exists(videoDir)) {
                Files.createDirectories(videoDir);
            }
            driver = new EdgeDriver(options);
            driver.get(URL);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            if (Recording && !headless) {
                recoder.ScreenCapturing();
            }
            utils.version();
        } else if (brows.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("headless");

            Path videoDir = Paths.get(System.getProperty("user.dir") + "/MRITestExecutionReports/" + loadProps.getProperty("Version").replaceAll("[()-+.^:, ]", "") + "/recordings/");
            if (!Files.exists(videoDir)) {
                Files.createDirectories(videoDir);
            }
            driver = new FirefoxDriver();
            driver.get(URL);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            if (Recording && !headless) {
                recoder.ScreenCapturing();
            }
            utils.version();
        } else if (brows.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();

            Path videoDir = Paths.get(System.getProperty("user.dir") + "/MRITestExecutionReports/" + loadProps.getProperty("Version").replaceAll("[()-+.^:, ]", "") + "/recordings/");
            if (!Files.exists(videoDir)) {
                Files.createDirectories(videoDir);
            }
            driver = new OperaDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        } else {
            System.out.println("This Browser is not found in your system.");
        }

    }

    public static void closeBrowser() throws Exception {
        if (Recording && !headless) {
            recoder.StopCapturing();
        }
        driver.close();
        driver.quit();
    }


}
