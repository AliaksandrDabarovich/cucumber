package com.epam.pageobject.hooks;

import com.epam.pageobject.driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHook {
    public static final String PNG_FILE_EXTENSION = "image/png";


    @After
    public void takeScreenshot (Scenario scenario){
        scenario.write(DriverSingleton.getDriver().getCurrentUrl());
        byte[] screenshot = ((TakesScreenshot)DriverSingleton.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, PNG_FILE_EXTENSION, scenario.getName());

    }

}
