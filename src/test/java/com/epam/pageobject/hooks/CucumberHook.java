package com.epam.pageobject.hooks;

import com.epam.pageobject.driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHook {
    @Before
    public void setupDriver(){
        DriverSingleton.getDriverCucumber();
    }
    @After
    public void quitDriver(){
        DriverSingleton.closeDriver();
    }
}
