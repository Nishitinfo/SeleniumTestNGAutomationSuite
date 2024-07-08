package stepdef;

import basicTemplate.browserSelector;
import basicTemplate.utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class hooks extends utils {

    @Before
    public void before() throws Exception {
        browserSelector.setUp();
    }

    @After
    public void after() throws Exception {
        browserSelector.tearDown();
    }

    @BeforeTest
    @Parameters("Browser")
    public void beforeTest(String browser) throws Exception {
        browserSelector.LaunchBrowser(browser);
    }

    @AfterTest
    public void afterTest() throws Exception {
        browserSelector.closeBrowser();
    }

}
