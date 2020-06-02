package com.epam.pageobject.page;


import com.epam.pageobject.driver.DriverSingleton;
import com.epam.pageobject.model.User;
import com.epam.pageobject.util.JSUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EmailLoginPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private static final String EMAIL_URL = "http://mail.ru";
    @FindBy(xpath = "//*[@id='mailbox:login']")
    private WebElement inputEmailField;
    @FindBy(css = "input.o-control")
    private WebElement inputPasswordButton;
    @FindBy(id = "mailbox:password")
    private WebElement inputPasswordField;
    @FindBy(xpath = "//input[@class='o-control']")
    private WebElement inputEnterButton;


    public EmailLoginPage(WebDriver driver) {
        super(driver);
    }
    public EmailLoginPage() {
        super();
    }

    public void openEmailPage() {
        DriverSingleton.getDriverCucumber().get(EMAIL_URL);

    }

    public EmailPage inputCredentials(User user) {

        waitForVisibility(inputEmailField);
        JSUtils.highlightElement(driver, inputEmailField);
        performActionSendkeys(driver, inputEmailField, user.getUsername());
        inputPasswordButton.click();
        waitForVisibility(inputPasswordField);
        JSUtils.highlightElement(driver, inputPasswordField);
        inputPasswordField.sendKeys(user.getPassword());
        JSUtils.clickJavascript(driver, inputEnterButton);
        logger.info("User logged in");
        return new EmailPage(driver);
    }
    public WebElement inputCredentialsCucumber(User user) {

        waitForVisibility(inputEmailField);
        JSUtils.highlightElement(driver, inputEmailField);
        performActionSendkeys(driver, inputEmailField, user.getUsername());
        inputPasswordButton.click();
        waitForVisibility(inputPasswordField);
        JSUtils.highlightElement(driver, inputPasswordField);
        inputPasswordField.sendKeys(user.getPassword());
        return inputEnterButton;
    }


}
