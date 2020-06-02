package com.epam.pageobject.test;

import com.epam.pageobject.model.User;
import com.epam.pageobject.page.*;
import com.epam.pageobject.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void login () {
        User testUser = UserCreator.withCredentialsFromProperty();
        EmailLoginPage emailLoginPage = new EmailLoginPage();
        EmailPage emailPage = emailLoginPage.inputCredentials(testUser);
        Assert.assertTrue(emailPage.getSentButton() != null, "User is not logged in");
    }

}
