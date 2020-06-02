package com.epam.pageobject.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        tags = "@smoke",
        glue = "com.epam.pageobject",
        features = "classpath:features")

public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
