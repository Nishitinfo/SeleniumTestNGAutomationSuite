package basicTemplate;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class browserSelector extends baseClass {
    public static String brows = loadProps.getProperty("Browser");
    public static String URL = loadProps.getProperty("URL");
    public static boolean Recording = Boolean.parseBoolean(loadProps.getProperty("RecordingMode"));
    public static boolean Screenshot = Boolean.parseBoolean(loadProps.getProperty("ScreenshotsMode"));


    public static void setUp() throws Exception {
        if (brows.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.silentOutput", "true");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.setAcceptInsecureCerts(true);
            options.addArguments("--test-type");
            options.addArguments("--incognito");
            options.addArguments("--headless");
            options.addArguments("--disable-extensions");
            options.addArguments("disable-infobars");
            options.addArguments("--deleteAll-Cookies");
            driver = new ChromeDriver(options);
            driver.get(URL);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            if (Recording) {
                recording.ScreenCapturing();
            }

        } else if (brows.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.setAcceptInsecureCerts(true);
//            options.addArguments("headless");
            options.addArguments("--remote-allow-origins=*");
            driver = new EdgeDriver(options);
            driver.get(URL);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            if (Recording) {
                recording.ScreenCapturing();
            }
        } else if (brows.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new FirefoxDriver();
            driver.get(URL);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            if (Recording) {
                recording.ScreenCapturing();
            }
        } else if (brows.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
            driver.get(URL);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            if (Recording) {
                recording.ScreenCapturing();
            }
        } else {
            System.out.println("This Browser is not found in your system.");
        }

    }


    public static void tearDown() throws Exception {
        if (Recording) {
            recording.StopCapturing();
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
            options.addArguments("--headless");
            options.addArguments("--disable-extensions");
            options.addArguments("disable-infobars");
            options.addArguments("--deleteAll-Cookies");
            driver = new ChromeDriver(options);
            driver.get(URL);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            if (Recording) {
                recording.ScreenCapturing();
            }

        } else if (brows.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.setAcceptInsecureCerts(true);
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("headless");
//            driver = new EdgeDriver(options);
            driver.get(URL);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            if (Recording) {
                recording.ScreenCapturing();
            }
        } else if (brows.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("headless");
            driver = new FirefoxDriver();
            driver.get(URL);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            if (Recording) {
                recording.ScreenCapturing();
            }

        } else if (brows.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        } else {
            System.out.println("This Browser is not found in your system.");
        }

    }

    public static void closeBrowser() throws Exception {
        if (Recording) {
            recording.StopCapturing();
        }
        driver.close();
        driver.quit();
    }


}
