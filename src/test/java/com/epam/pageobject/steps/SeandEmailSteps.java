package com.epam.pageobject.steps;

import com.epam.pageobject.model.User;
import com.epam.pageobject.page.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class SeandEmailSteps {
    private EmailLoginPage emailLoginPage;
    private EmailPage emailPage;
    private ComposeEmailPage composeEmailPage;
    private EmailPage emailPageAfterCompose;
    private DraftsPage draftsPage;
    private DraftEmailPage draftEmailPage;
    private AdvertisingPage advertisingPage;
    private DraftsPage draftsPageAfterSendingDraft;
    private SendEmailPage sendEmailPage;

    User testUser = new User("aliaksandr.yarkiy@mail.ru", "obuchenie2015");


    @When("the user opens Email page")
    public void openEmailPage() {
        emailLoginPage = new EmailLoginPage();
        emailLoginPage.openEmailPage();

    }

    @When("the user inputs Email and Password")
    public void inputLogin() {
        emailPage = emailLoginPage.inputCredentials(testUser);
    }

    @When("the user opens Compose Email")
    public void composeEmail() {
        composeEmailPage = emailPage.composeEmailFromEmailPage();
    }

    @When("the user opens Email page after composing")
    public void openEmailPageAfterComposing() {
        emailPageAfterCompose = composeEmailPage.composeEmail(testUser);
    }

    @When("the user opens Drafts page")
    public void openDraftsPage() {
        draftsPage = emailPageAfterCompose.openDraftsPageFromEmailPage();
    }

    @When("the user opens Draft Email page")
    public void openDraft() {
        draftEmailPage = draftsPage.openDraftEmailPage();
    }
    @When("the user sends Draft")
    public void sendDraft() {
        advertisingPage = draftEmailPage.sendDraft();
    }
    @When("the user opens Draft after sending Draft")
    public void openDraftAfterSending() {
        advertisingPage = draftEmailPage.sendDraft();
    }
    @When("the user opens closes Advertising page")
    public void closeAdvertisingPage() {
        draftsPageAfterSendingDraft = advertisingPage.closeAdvertising();
    }
    @When("the user opens Send Email page Advertising page")
    public void openSendEmailPage() {
        sendEmailPage = draftsPageAfterSendingDraft.openSendEmailPage();
    }
    @Then("email is sent")
            public void verifyEmailSend(){
        Assertions.assertThat(sendEmailPage.deliverEmail().getText()).isEqualTo(sendEmailPage.getSendField()) .overridingErrorMessage("Email is not delivered");
    }


}
