package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BuildYourOwnComputerPage extends Utility {
    @CacheLookup
    @FindBy(id = "product_attribute_1product_attribute_1")
    WebElement selectProcessorDdown;
    @CacheLookup
    @FindBy(id = "product_attribute_2")
    WebElement selectRAM;
    @CacheLookup
    @FindAll({@FindBy(xpath = "(//ul[@class='option-list'])[1]//input[@type='radio']")})
    List<WebElement> hddRadioButtons;

    @CacheLookup
    @FindAll({@FindBy(xpath = "(//ul[@class='option-list'])[2]//input[@type='radio']")})
    List<WebElement> oSRadioButtons;

    @CacheLookup
    @FindAll({@FindBy(xpath = "(//ul[@class='option-list'])[3]/li")})
    List<WebElement> softwareCheckBoxOptions;

    @CacheLookup
    @FindBy(id = "add-to-cart-button-1")
    WebElement addToCartBtn;

    @CacheLookup
    @FindBy(xpath = "//p[@class = 'content']")
    WebElement verifyMessageAddToCart;


    public void selectProcessor(String text) {
        selectByVisibleTextFromDropDown(selectProcessorDdown, text);

    }

    public void selectRAM(String text) {
        selectByVisibleTextFromDropDown(selectRAM, text);
    }


    public void selectHDDRadioButton(String text) {
        for (WebElement option : hddRadioButtons) {
            if (option.getText().equals(text)) {
                option.click();
                break;
            }
        }
    }

    public void selectSoftwareCheckBox(String software) {
        for (WebElement option : softwareCheckBoxOptions) {
            if (option.getText().equals(software)) {
                option.click();
                break;
            }
        }
    }

    public void selectOsRadioCheckBox(String software) {
        for (WebElement option : oSRadioButtons) {
            if (option.getText().equals(software)) {
                option.click();
                break;
            }
        }
    }

    public void clickOnAddToCartBtn() {
        clickOnElement(addToCartBtn);

    }
    public String verifyTheMessageAddToCart(){
        return getTextFromElement(addToCartBtn);

    }
}