package com.epam.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActionPage extends AbstractPage {
    @FindBy (xpath = "//div[@class='container--3QXHv']//input[@class='container--H9L5q size_s--3_M-_']")
    WebElement subject;

    public ActionPage (){
        super();
    }

    public WebElement checkAction(){
        return waitElement(subject);
    }

}
