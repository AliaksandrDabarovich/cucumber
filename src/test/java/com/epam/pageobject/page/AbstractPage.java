package com.epam.pageobject.page;

import com.epam.pageobject.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected final String SUBJECT = "WebDriver";
    protected final String BODY = "Text for test";
    protected static Logger log = Logger.getLogger(AbstractPage.class.getName());
    protected String sendField = "Self: WebDriver";

    protected AbstractPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);

    }

    protected WebElement waitForVisibility(WebElement element) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(element));

    }

    protected WebElement waitElement(WebElement webElement) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(webElement));

    }


    public void moveClick(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
         action.moveToElement(element).click().perform();
    }


    public void performActionSendkeys(WebDriver driver, WebElement element, String string) {
        Actions action = new Actions(driver);
        action.click(element).sendKeys(string).perform();
    }

    public String getSubject() {
        return SUBJECT;
    }

    public String getBody() {
        return BODY;
    }

    public String getSendField (){
        return sendField;
    }

}
