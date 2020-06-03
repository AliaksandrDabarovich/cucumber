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

    User testUser;


    @When("the user opens Email page")
    public void openEmailPage() {
        emailLoginPage = new EmailLoginPage();
        emailLoginPage.openEmailPage();

    }

    @When("the user inputs Email and Password")
    public void inputLogin() {
        testUser= new User("aliaksandr.yarkiy@mail.ru","obuchenie2015");
        emailPage = emailLoginPage.inputCredentials(testUser);
    }

    @When("^the user inputs different parameters (.*) and (.*)$")
    public void inputLogin(String email, String password) {
        testUser= new User(email, password);
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
    @When("the user closes Advertising page")
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
    @Then("login is success")
    public void verifyLoginIsSuccess() {
        Assertions.assertThat(emailPage.getSentButton()).isNotNull()
                .overridingErrorMessage("User not logged in");
    }
    @Then("body is correct")
    public void verifyBodyisCorrect() {
        Assertions.assertThat(draftEmailPage.checkBodyField().getText()).isEqualTo(draftEmailPage.getBody())
                .overridingErrorMessage("Incorrect Text in Body");
    }
    @Then("draft is saved")
    public void verifyDraftSaved() {
        Assertions.assertThat(draftsPage.checkEmailInDrafts()).isNotNull()
                .overridingErrorMessage("Email is not saved in drafts");
    }
    @Then("draft is sent")
    public void verifyDraftSent() {
        Assertions.assertThat(draftsPageAfterSendingDraft.verifyDraftSend()).isNotNull()
                .overridingErrorMessage("Draft was not sent");
    }

    @Then("subject is correct")
    public void verifySubjectCorrect() {
        Assertions.assertThat(draftEmailPage.checkSubjectField().getAttribute("value")).isEqualTo(draftEmailPage.getSubject())
                .overridingErrorMessage("Incorrect Subject in the Draft");
    }
    @Then("To is correct")
    public void verifyToCorrect() {
        Assertions.assertThat(draftEmailPage.checkToField().getText()).isEqualTo(testUser.getUsername())
                .overridingErrorMessage("Incorrect Email");
    }










}
