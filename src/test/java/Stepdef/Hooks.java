package Stepdef;

import basicTemplate.browserSelector;
import basicTemplate.utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks extends utils {

    @Before
    public void before() throws Exception {
        browserSelector.setUp( );
    }

    @After
    public void after() throws Exception {
        browserSelector.tearDown();
    }


}
