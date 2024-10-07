package hooks;

import basicTemplate.configs.browserSelector;
import basicTemplate.configs.utils;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class hooks extends utils {

    @BeforeAll
    public static void before() throws Exception {
        browserSelector.setUp();
    }

    @AfterAll
    public static void after() throws Exception {
        browserSelector.tearDown();
    }


    @BeforeClass
    @Parameters("Browsers")
    public void launchBrowser(String Browser) throws Exception {
        browserSelector.LaunchBrowser(Browser);
    }

    @AfterClass
    public void closeBrowser() throws Exception {

        browserSelector.closeBrowser();

    }

}
