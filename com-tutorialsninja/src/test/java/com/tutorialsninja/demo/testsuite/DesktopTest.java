package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.DesktopsProductsPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import com.tutorialsninja.demo.testdata.TestData;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopTest extends BaseTest {

    HomePage homePage;
    DesktopPage desktopPage;
    DesktopsProductsPage desktopsProductsPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        desktopsProductsPage = new DesktopsProductsPage();
        shoppingCartPage = new ShoppingCartPage();

    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        // 1.1 Mouse hover on Desktops Tab. and click
        homePage.mouseHoverAndClickDesktopTab();
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        homePage.clickOnShowAllDesktops();
        //1.3 Verify the text ‘Desktops’
        // 1.4 Verify the Product will arrange in Descending order.
        List<WebElement> beforeSorting = desktopPage.sortElement();
        ArrayList<String> beforeFilter = new ArrayList<>();
        for (WebElement i : beforeSorting) {
            beforeFilter.add(i.getText());
        }
        Collections.sort(beforeFilter, String.CASE_INSENSITIVE_ORDER);
        Collections.reverse(beforeFilter);
        desktopPage.selectSortByPositionNameZToA("Name (Z - A)");

        //after sorting
        List<WebElement> afterSorting = desktopPage.sortElement();
        ArrayList<String> afterFilter = new ArrayList<>();
        for (WebElement i : afterSorting) {
            afterFilter.add(i.getText());
        }
        System.out.println(afterFilter);


        Assert.assertEquals(beforeFilter, afterFilter, "not Sorted as per requirement");


    }

    @Test(dataProvider = "productInfo", dataProviderClass = TestData.class, groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully(String product, String qty,
                                                             String successMessage, String productName, String model, String total) {

        //2.1 Mouse hover on Currency Dropdown and click
        homePage.mouseHoverOnCurrencyAndClick();
        //2.2 Mouse hover on £Pound Sterling and click
        desktopPage.clickOnSterlingPoundDropDown();
        //2.3 Mouse hover on Desktops Tab.
        homePage.mouseHoverAndClickDesktopTab();
        //2.4 Click on “Show All Desktops”
        homePage.clickOnShowAllDesktops();
        //2.5 Select Sort By position "Name: A to Z"
        desktopPage.selectSortByPositionNameAToZ("Name (A - Z)");
        //2.6 Select product <product>
        List<WebElement> allProducts = desktopPage.getAllProducts();
        for (WebElement element : allProducts) {
            if (element.getText().equalsIgnoreCase(product)) {
                System.out.println("Matching product: " + element.getText());//debug purpose
                element.click();
                break;
            }
        }

        //desktopsPage.selectProduct(product);
        //  desktopsPage.selectAProductInDesktop(product);

//        2.7 Enter Qty <qty> using Select class.
        desktopsProductsPage.enterQuantity(qty);

//        2.8 Click on “Add to Cart” button
        desktopsProductsPage.clickOnAddToCartButton();

//        2.9 Verify the Message <successMessage>
        Assert.assertTrue(desktopsProductsPage.getProductAddedSuccessMessageText().contains(successMessage), "success message is not displayed correctly. ");
        //Assert.assertEquals(desktopsProductsPage.getProductAddedSuccessMessageText(), successMessage, "success message is not displayed correctly. ");

//        2.10 Click on link “shopping cart” display into success message
        desktopsProductsPage.clickOnShoppingCartLinkInSuccessMessage();

//        2.11 Verify the text "Shopping Cart"
        Assert.assertTrue(shoppingCartPage.getShoppingCartHeadingText().contains("Shopping Cart"));

//        2.12 Verify the Product name <productName>
        Assert.assertEquals(shoppingCartPage.getProductNameText(), productName, "Product name does not match.");

//        2.13 Verify the Model <model>
        Assert.assertEquals(shoppingCartPage.getModelNameText(), model, "Incorrect model name in shopping cart.");

//        2.14 Verify the Total <total>
        Assert.assertEquals(shoppingCartPage.getTotalText(), total, "Total is incorrect.");

    }


}


