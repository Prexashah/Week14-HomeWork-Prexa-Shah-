package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ReturningCustomerPage extends Utility {

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;
    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    //Methods
    public void enterEmail(String text) {
        sendTextToElement(email, text);
    }

    public void enterPassword(String text) {
        sendTextToElement(password, text);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }
}
