package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Laptops_NotebooksPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[text() = 'Laptops & Notebooks']")
    WebElement verifyDesktopTxt;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement selectPriceHighToLow;

    @CacheLookup
    @FindBy(xpath = "//a[text() = 'MacBook']")
    WebElement clickOnMacbook;



    public String verifyTheTextDLaptopsAndNoteBooks(){
        return getTextFromElement(verifyDesktopTxt);
    }
    public void selectPriceHighToLow(String text){
        selectByVisibleTextFromDropDown(selectPriceHighToLow,text);
    }
    public void clickOnMacBook(){
        clickOnElement(clickOnMacbook);
    }

}
