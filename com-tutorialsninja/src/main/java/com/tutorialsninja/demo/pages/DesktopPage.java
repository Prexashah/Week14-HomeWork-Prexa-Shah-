package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * 3.DashboardPage - Dashboard text Locator
 *  and create appropriate methods for it.
 */
public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement selectNameZToA;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement selectNameAToZ;

    @CacheLookup
    @FindBy(xpath = "//div[@class='details']//h2[@class='product-title']/a")
    WebElement verifyProductsDescendingOrder;


    @CacheLookup
    @FindBy(xpath = "(//button[@class='currency-select btn btn-link btn-block'])[2]")
    WebElement clickOnSterlingPound;
    @CacheLookup
    @FindAll({@FindBy(xpath = "//div[@class='caption']")})
    List<WebElement> productsList;

    @CacheLookup
    @FindBy(xpath = "//h2[text() = 'Desktops']")
    WebElement verifyDesktopTxt;

    @CacheLookup
    @FindAll({@FindBy(xpath = "//div[@class='caption']/h4")})
    List<WebElement> allDesktopProducts;

    public void selectSortByPositionNameZToA(String text) {
        selectByVisibleTextFromDropDown(selectNameZToA, text);
    }

    public List<WebElement> sortElement() {
        return productsList;

    }

    public void clickOnSterlingPoundDropDown() {
        mouseHoverToElementAndClick(clickOnSterlingPound);
    }

    public void selectSortByPositionNameAToZ(String text) {

        selectByVisibleTextFromDropDown(selectNameAToZ, text);
    }

    public String verifyTheTextDesktops() {
        return getTextFromElement(verifyDesktopTxt);

    }
    public List<WebElement> getAllProducts() {
        return allDesktopProducts;
    }
}
