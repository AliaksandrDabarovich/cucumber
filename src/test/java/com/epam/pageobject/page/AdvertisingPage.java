package com.epam.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdvertisingPage extends AbstractPage {
    @FindBy(xpath = "//span[@class='button2 button2_has-ico button2_close button2_pure button2_clean button2_short button2_hover-support']")
    WebElement closeDraftsButton;

    public AdvertisingPage() {
        super();
    }

    public DraftsPage closeAdvertising() {
        waitForVisibility(closeDraftsButton).click();
        return new DraftsPage();
    }
}
