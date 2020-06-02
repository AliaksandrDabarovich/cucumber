package com.epam.pageobject.test;

import com.epam.pageobject.model.User;
import com.epam.pageobject.page.ComposeEmailPage;
import com.epam.pageobject.page.DraftsPage;
import com.epam.pageobject.page.EmailLoginPage;
import com.epam.pageobject.page.EmailPage;
import com.epam.pageobject.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SavingDraftTest extends BaseTest {

    @Test

    public void saveToDraft (){
        User testUser = UserCreator.withCredentialsFromProperty();
        EmailLoginPage emailLoginPage = new EmailLoginPage();
        EmailPage emailPage = emailLoginPage.inputCredentials(testUser);
        ComposeEmailPage composeEmailPage = emailPage.composeEmailFromEmailPage();
        EmailPage emailPageAfterCompose = composeEmailPage.composeEmail(testUser);
        DraftsPage draftsPage= emailPageAfterCompose.openDraftsPageFromEmailPage();
        Assert.assertTrue(draftsPage.checkEmailInDrafts()!=null, "Email is not saved in drafts");
    }

}
