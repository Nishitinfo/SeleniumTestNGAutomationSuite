package Stepdef;

import basicTemplate.browserSelector;
import basicTemplate.utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Hooks extends utils {

    @Before
    public void before() {
        browserSelector.setUp( );
    }

    @After
    public void after() {
        browserSelector.tearDown();
    }


}
