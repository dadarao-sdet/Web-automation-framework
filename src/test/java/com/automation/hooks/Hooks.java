package com.automation.hooks;

import com.automation.driver.DriverFactory;
import com.automation.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initializeDriver();
    }

    @After
    public void tearDown() {

        boolean closeBrowser =
                Boolean.parseBoolean(ConfigReader.getProperty("close.browser"));

        if (closeBrowser) {
            DriverFactory.quitDriver();
        }
    }
}