package com.epam.pageobject.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftsPage extends AbstractPage {
    @FindBy(xpath = "//span[@class='ll-sj__normal' and text()='WebDriver']")
    WebElement draftName;
    @FindBy(xpath = "//div[@class='llc__item llc__item_correspondent']//span[@title='aliaksandr.yarkiy@mail.ru']")
    WebElement draftLink;
    @FindBy(xpath = "//div[text()='Черновики']")
    WebElement draftPageLoading;
    @FindBy(xpath = "//span[@class='octopus__title' and text()='У вас нет незаконченных']")
    WebElement draftNameAbsence;
    @FindBy(xpath = "//a[@href='/sent/']")
    WebElement sentFolderButton;

    @FindBy(xpath = "//div[@class='llc__content']")
    WebElement divOfDraft;

    public DraftsPage() {
        super();
    }

    public WebElement checkEmailInDrafts() {

        return waitElement(draftName);

    }

    public DraftEmailPage openDraftEmailPage() {
        waitElement(draftLink);
        waitForVisibility(draftLink).click();
        return new DraftEmailPage();
    }

    public WebElement verifyDraftSend() {
        waitElement(draftPageLoading);
        return draftNameAbsence;
    }

    public SendEmailPage openSendEmailPage() {
        waitElement(sentFolderButton);
        waitForVisibility(sentFolderButton).click();
        return new SendEmailPage();
    }


}
