package com.epam.pageobject.test;

import com.epam.pageobject.model.User;
import com.epam.pageobject.page.*;
import com.epam.pageobject.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendDraftTest extends BaseTest {
    @Test
    public void sendDraft() {
        User testUser = UserCreator.withCredentialsFromProperty();
                EmailLoginPage emailLoginPage = new EmailLoginPage(driver);
                EmailPage emailPage = emailLoginPage.inputCredentials(testUser);
                ComposeEmailPage composeEmailPage = emailPage.composeEmailFromEmailPage();
                EmailPage emailPageAfterCompose = composeEmailPage.composeEmail(testUser);
                DraftsPage draftsPage = emailPageAfterCompose.openDraftsPageFromEmailPage();
                DraftEmailPage draftEmailPage = draftsPage.openDraftEmailPage();
                AdvertisingPage advertisingPage = draftEmailPage.sendDraft();
                DraftsPage draftsPageAfterSendingDraft = advertisingPage.closeAdvertising();
                Assert.assertTrue(draftsPageAfterSendingDraft.verifyDraftSend() != null, "Draft was not sent");

        }

    }
