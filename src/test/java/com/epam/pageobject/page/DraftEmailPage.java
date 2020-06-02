package com.epam.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftEmailPage extends AbstractPage {
    @FindBy(xpath = "//div[contains (@class, 'container--3B3Lm status_base--wsRcM')]//span[contains (@class,'text')]")
    WebElement toFieldDraft;

    @FindBy(xpath = "//div[@class='container--3QXHv']//input[@class='container--H9L5q size_s--3_M-_']")
    WebElement subjectFieldDraft;

    @FindBy(xpath = "//div[contains (@class,'class')]/div[1]")
    WebElement bodyFieldDraft;

    @FindBy(xpath = "//span[contains(@class,'button2 button2_base button2_primary')]")
    WebElement sendButton;


    public DraftEmailPage() {

        super();
    }

    public WebElement checkToField() {

        return waitForVisibility(toFieldDraft);
    }

    public WebElement checkSubjectField() {

        return waitForVisibility(subjectFieldDraft);
    }

    public WebElement checkBodyField() {

        return waitForVisibility(bodyFieldDraft);
    }

    public AdvertisingPage sendDraft() {
        waitForVisibility(sendButton).click();
        return new AdvertisingPage();
    }

}
