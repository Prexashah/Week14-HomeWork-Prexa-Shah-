package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaptopsAndNotebooksTest extends BaseTest {
    HomePage homePage;
    DesktopPage desktopPage;
    Laptops_NotebooksPage laptopsNotebooksPage;
    ComponentPage componentPage;
    MacBookPage macBookPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        laptopsNotebooksPage = new Laptops_NotebooksPage();
        macBookPage = new MacBookPage();
        shoppingCartPage = new ShoppingCartPage();
        checkoutPage = new CheckoutPage();
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverOnLaptopsNoteBooksAndClick();
        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.showAllLaptopsAndNoteBooks();
        //1.3 Select Sort By "Price (High > Low)"
        laptopsNotebooksPage.selectPriceHighToLow("Price (High > Low)");

        //1.4 Verify the Product price will arrange in High to Low order.

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.mouseHoverOnLaptopsNoteBooksAndClick();
        //2.2 Click on “Show All Laptops & Notebooks”
        homePage.showAllLaptopsAndNoteBooks();
        //2.3 Select Sort By "Price (High > Low)"
        laptopsNotebooksPage.selectPriceHighToLow("Price (High > Low)");
        //2.4 Select Product “MacBook”
        laptopsNotebooksPage.clickOnMacBook();
        //2.5 Verify the text “MacBook”
        Assert.assertEquals(macBookPage.verifyTxtMacBook(), "MacBook", "You have selected incorrect product");
        //2.6 Click on ‘Add To Cart’ button
        macBookPage.clickOnAddToCart();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        // Assert.assertEquals(macBookPage.verifyMessageYouHaveAddedMacBookToYourCart(),"Success: You have added MacBook to your shopping cart!",
        //   "Product has not been added to cart");

        //2.8 Click on link “shopping cart” display into success message
        macBookPage.clickOnShoppingCart();
        //2.9 Verify the text "Shopping Cart"
        Assert.assertEquals(shoppingCartPage.verifyTxtShoppingCartMsg(), "Shopping Cart  (0.00kg)",
                " you are not on shoppingCart page");
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals(shoppingCartPage.verifyProductMacBook(), "MacBook", "Incorrect Product");
        //2.11 Change Quantity "2"
        shoppingCartPage.updateQuantity("2");
        //2.12 Click on “Update” Tab
        shoppingCartPage.clickOnUpdateTab();
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertEquals(shoppingCartPage.verifyTextSuccessYouHaveModifiedYourShoppingCart(), "Success: You have modified your shopping cart!", "Your cart is not updated");
        //2.14 Verify the Total £737.45
        Assert.assertEquals(shoppingCartPage.verifyTotal(), "£737.45", "Incorrect Total");
        //2.15 Click on “Checkout” button
        shoppingCartPage.clickOnCheckOutButton();
        //2.16 Verify the text “Checkout”
        Assert.assertEquals(checkoutPage.verifyCheckoutMsg(), "Checkout", "you are not on checkout page");
        //2.17 Verify the Text “New Customer”
        Assert.assertEquals(checkoutPage.verifyTheTextNewCustomer(), "New Customer", "you are not on checkout page");
        // 2.18 Click on “Guest Checkout” radio button
        checkoutPage.clickOnRadioButton("Guest Checkout");
        //  2.19 Click on “Continue” tab
        checkoutPage.clickOnContinueButton();
        //2.20 Fill the mandatory fields
        checkoutPage.enterFirstName("Maria");
        checkoutPage.enterLastName("Roshan");
        checkoutPage.enterPassword("abcd123");
        checkoutPage.enterConfirmPassword("abcd123");
        checkoutPage.enterEmail("ltester@gmailcim");
        checkoutPage.enterPhone("07755446699");
        checkoutPage.enterAddress("1 chapel street");
        checkoutPage.enterCity("London");
        checkoutPage.enterPostCode("pr1 5hr");
        checkoutPage.selectCountryFromDropDown("United Kingdom");
        checkoutPage.selectRegionOrStateFromDropDown("Cardiff");
        // 2.21 Click on “Continue” Button
        checkoutPage.clickOnContinueButtonForBilling();
        // 2.22 Add Comments About your order into text area
        checkoutPage.enterCommentsAboutOrder("Please send via NextDay Delivery ");

        // 2.23 Check the Terms & Conditions check box
        checkoutPage.clickOnCheckBox();

        //  2.24 Click on “Continue” button
        checkoutPage.clickOnContinueButtonInPaymentMethod();
        //2.25 Verify the message “Warning: Payment method required!”
        Assert.assertEquals(checkoutPage.getWarningMessageText(), "Warning: Payment method required!",
                "Incorrect warning message.");


    }
}