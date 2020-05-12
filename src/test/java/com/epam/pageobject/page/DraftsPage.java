package com.epam.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftsPage extends AbstractPage {
    @FindBy(xpath = "//span[@class='ll-sj__normal' and text()='WebDriver']")
    WebElement draftName;
    @FindBy(xpath = "//div[@class='llc__item llc__item_correspondent']//span[@title='aliaksandr.yarkiy@mail.ru']")
    WebElement draftLink;
    @FindBy(xpath = "//div[@title='Черновики']")
    WebElement draftPageLoading;
    @FindBy(xpath = "//span[@class='octopus__title' and text()='У вас нет незаконченных']")
    WebElement draftNameAbsence;
    @FindBy(xpath = "//a[@href='/sent/']")
    WebElement sentFolderButton;

    @FindBy(xpath = "//div[@class='llc__content']")
    WebElement divOfDraft;

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement checkEmailInDrafts() {

        return waitElement(By.xpath("//span[@class='ll-sj__normal' and text()='WebDriver']"));

    }

    public DraftEmailPage openDraftEmailPage() {
        waitTillElementClickable(draftLink);
        waitForVisibility(draftLink).click();
        return new DraftEmailPage(driver);
    }

    public WebElement verifyDraftSend() {
        waitTillElementClickable(draftPageLoading);
        return draftNameAbsence;
    }

    public SendEmailPage openSendEmailPage() {
        waitTillElementClickable(sentFolderButton);
        waitForVisibility(sentFolderButton).click();
        return new SendEmailPage(driver);
    }


}
