package com.epam.pageobject.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendEmailPage extends AbstractPage {
    @FindBy(xpath = "//span[@class='ll-sj__normal' and text()='Self: WebDriver']")
    WebElement sentEmailTitle;

    @FindBy(xpath = "//a[@title='выход']")
    WebElement logOutButton;


    public SendEmailPage() {
        super();
    }

    public WebElement deliverEmail() {
        return waitForVisibility(sentEmailTitle);
    }

    public EmailLoginPage logOut() {
        logOutButton.click();
        return new EmailLoginPage();
    }


}
