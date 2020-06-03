package com.epam.pageobject.page;


import com.epam.pageobject.model.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ComposeEmailPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='container--ItIg4 size_s--2eBQT size_s--3_M-_']//input[@class='container--H9L5q size_s--3_M-_']")
    WebElement toField;
    @FindBy(xpath = "//div[@class='container--3QXHv']//input[@class='container--H9L5q size_s--3_M-_']")
    WebElement subjectField;
    @FindBy(xpath = "//div[contains (@class, 'cke_editable')]/div[1]")
    WebElement bodyField;
    @FindBy(xpath = "//span[@class='button2 button2_base button2_hover-support js-shortcut']")
    WebElement saveButton;
    @FindBy(xpath = "//button[@title='Закрыть' and @class='container--2lPGK type_base--rkphf color_base--hO-yz']")
    WebElement closeButton;

    public ComposeEmailPage() {
        super();
    }

    public EmailPage composeEmail(User user) {

        waitElement(toField);
        toField.sendKeys(user.getUsername());
        waitElement(subjectField);
        subjectField.sendKeys(SUBJECT);
        waitElement(bodyField);
        performActionSendkeys(driver, bodyField, BODY);
        saveButton.click();
        closeButton.click();
        return new EmailPage();
    }


}
