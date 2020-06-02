package com.epam.pageobject.test;

import com.epam.pageobject.model.User;
import com.epam.pageobject.page.*;
import com.epam.pageobject.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BodyFieldDraftTest extends BaseTest {
    @Test
    public void verifyBodyFieldInDraft (){
            User testUser = UserCreator.withCredentialsFromProperty();
            EmailLoginPage emailLoginPage = new EmailLoginPage();
            EmailPage emailPage = emailLoginPage.inputCredentials(testUser);
            ComposeEmailPage composeEmailPage = emailPage.composeEmailFromEmailPage();
            EmailPage emailPageAfterCompose = composeEmailPage.composeEmail(testUser);
            DraftsPage draftsPage = emailPageAfterCompose.openDraftsPageFromEmailPage();
            DraftEmailPage draftEmailPage = draftsPage.openDraftEmailPage();
            Assert.assertEquals(draftEmailPage.checkBodyField().getText(), draftEmailPage.getBody(), "Incorrect Text in Body");

    }
}
