package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DesktopsPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "(//a[text() = 'Build your own computer'])[2]")
    WebElement clickOnBuildYourComputer;
    public void clickOnBuildYourComputer(){
        clickOnElement(clickOnBuildYourComputer);
    }
}
