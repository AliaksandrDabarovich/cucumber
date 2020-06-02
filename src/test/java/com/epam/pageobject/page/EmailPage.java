package com.epam.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EmailPage extends AbstractPage {


    @FindBy(xpath = "//a[@href='/sent/']")
    private WebElement sentButton;
    @FindBy(xpath = "//a[contains(@class, 'compose-button')]")
    private WebElement composeButton;
    @FindBy(xpath = "//a[@href='/drafts/']")
    private WebElement draftsButton;
    @FindBy(xpath = "//div[contains(@class, 'compose-dropdown')]")
    private WebElement actionButton;

    @FindBy(xpath = "//span[contains(text(),'Написать себе')]")
    WebElement letterToHimself;


    public EmailPage(WebDriver driver) {
        super(driver);
    }
    public EmailPage() {
        super();
    }

    public WebElement getSentButton() {
        return waitForVisibility(sentButton);
    }

    public ComposeEmailPage composeEmailFromEmailPage() {
        waitForVisibility(composeButton).click();
        return new ComposeEmailPage(driver);
    }

    public DraftsPage openDraftsPageFromEmailPage() {
        moveClick(driver, draftsButton);
        return new DraftsPage(driver);
    }

    public ActionPage openAction() {
        waitForVisibility(actionButton);
        actionButton.click();
        ActionFactory actionFactory = new ProposalCallFactory();
        Action action = actionFactory.createAction();
        action.act();
        waitForVisibility(letterToHimself).click();
        return new ActionPage(driver);
    }
    public ActionPage openDecoratorAction() {
        waitForVisibility(actionButton);
        actionButton.click();
        Action action = new ActionDecorator(new CustomAction());
        action.act();
        waitForVisibility(letterToHimself).click();
        return new ActionPage(driver);
    }

    public boolean isUserLoggedIn(){
        waitForVisibility(sentButton);
        return  sentButton != null;
    }


}
