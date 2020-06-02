package com.epam.pageobject.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static WebDriver driver;
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();


    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    webDriverThreadLocal.set(driver);
                    break;
                }
                case "chrome": {
//                                        WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    webDriverThreadLocal.set(driver);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Input correct driver");
                }
            }
            driver.manage().window().maximize();
        }
        return webDriverThreadLocal.get();
    }


    public static WebDriver getDriverCucumber() {

        if (null == driver) {
            driver = new ChromeDriver();
            webDriverThreadLocal.set(driver);
            driver.manage().window().maximize();
        }
        return webDriverThreadLocal.get();

    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
        webDriverThreadLocal.remove();
    }

}
