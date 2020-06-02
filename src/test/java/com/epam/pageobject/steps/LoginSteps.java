package com.epam.pageobject.steps;

import com.epam.pageobject.driver.DriverSingleton;
import com.epam.pageobject.model.User;
import com.epam.pageobject.page.EmailLoginPage;
import com.epam.pageobject.page.EmailPage;
import com.epam.pageobject.service.UserCreator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;


public class LoginSteps {

    private EmailLoginPage emailLoginPage = new EmailLoginPage(DriverSingleton.getDriver());
    private EmailPage emailPage = new EmailPage(DriverSingleton.getDriver());

    User testUser = new User("aliaksandr.yarkiy@mail.ru","obuchenie2015");


    @When("the user opens Email page")
    public void openEmailPage() {
        emailLoginPage.openEmailPage();

    }

    @When("the user inputs Email and Password")
    public void inputLogin() {
        emailLoginPage.inputCredentialsCucumber(testUser).click();
    }



    @Then("login is successfull")
    public void verifyLoginIsSuccessfull() {
        Assertions.assertThat(emailPage.isUserLoggedIn())
        .overridingErrorMessage("User not logged in")
        .isTrue();
    }
}
