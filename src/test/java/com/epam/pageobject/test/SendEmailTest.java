package com.epam.pageobject.test;

import com.epam.pageobject.model.User;
import com.epam.pageobject.page.*;
import com.epam.pageobject.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendEmailTest extends BaseTest {
    @Test
    public void deliverEmail () {
        User testUser = UserCreator.withCredentialsFromProperty();
        EmailLoginPage emailLoginPage = new EmailLoginPage();
        EmailPage emailPage = emailLoginPage.inputCredentials(testUser);
        ComposeEmailPage composeEmailPage = emailPage.composeEmailFromEmailPage();
        EmailPage emailPageAfterCompose = composeEmailPage.composeEmail(testUser);
        DraftsPage draftsPage= emailPageAfterCompose.openDraftsPageFromEmailPage();
        DraftEmailPage draftEmailPage = draftsPage.openDraftEmailPage();
        AdvertisingPage advertisingPage = draftEmailPage.sendDraft();
        DraftsPage draftsPageAfterSendingDraft = advertisingPage.closeAdvertising();
        SendEmailPage sendEmailPage = draftsPageAfterSendingDraft.openSendEmailPage();
        Assert.assertEquals(sendEmailPage.deliverEmail().getText(), sendField,"Email is not delivered");
        EmailLoginPage emailLoginPageAfterSendEmail = sendEmailPage.logOut();
    }
}
