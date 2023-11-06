package basicTemplate;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class browserSelector extends baseClass {
    public static String brows = loadProps.getProperty("browser");

//@BeforeTest
    public static void setUp() {
        if (brows.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.silentOutput", "true");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            options.addArguments("--test-type");
            options.addArguments("--incognito");
            options.addArguments("--headless");
            options.addArguments("--disable-extensions");
            options.addArguments("disable-infobars");
            options.addArguments("--deleteAll-Cookies");
            driver = new ChromeDriver(options);
            driver.get("https://www.google.com");
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);

        } else if (brows.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options= new EdgeOptions();
            options.addArguments("headless");
            driver = new EdgeDriver(options);
            driver.get("https://www.google.com");
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
        } else if (brows.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get("https://www.google.com");
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
        } else if (brows.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
        } else {
            System.out.println("This Browser is not found in your system.");
        }

    }

    @AfterTest
    public static void tearDown() {
        driver.close();
        driver.quit();

    }


    //For Parallel Execution using Testng XML
    public static void LaunchBrowser(String browser) {


        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.silentOutput", "true");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            options.addArguments("--test-type");
            options.addArguments("--incognito");
            options.addArguments("--headless");
            options.addArguments("--disable-extensions");
            options.addArguments("disable-infobars");
            options.addArguments("--deleteAll-Cookies");
            driver = new ChromeDriver(options);
            driver.get("https://www.google.com");
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);


        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options= new EdgeOptions();
            options.addArguments("headless");
            driver = new EdgeDriver(options);
            driver.get("https://www.google.com");
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get("https://www.google.com");
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);


        } else if (browser.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
        } else {
            System.out.println("This Browser is not found in your system.");
        }

    }
    public static void closeBrowser() {
        driver.close();
        driver.quit();
    }


}
