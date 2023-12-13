package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class MyAccountTest extends BaseTest {
    HomePage homePage;
    DesktopPage desktopPage;
    Laptops_NotebooksPage laptopsNotebooksPage;
    ComponentPage componentPage;
    MacBookPage macBookPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;
    RegisterPage registerPage;
    LoginPage loginPage;
    YourAccountCreatedPage yourAccountCreatedPage;
    LogOutPage logOutPage;
    ReturningCustomerPage returningCustomerPage;
    AccountPage accountPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        laptopsNotebooksPage = new Laptops_NotebooksPage();
        macBookPage = new MacBookPage();
        shoppingCartPage = new ShoppingCartPage();
        checkoutPage = new CheckoutPage();
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
        yourAccountCreatedPage = new YourAccountCreatedPage();
        logOutPage = new LogOutPage();
        returningCustomerPage = new ReturningCustomerPage();
        accountPage = new AccountPage();
    }

    //  1.1 create method with name "selectMyAccountOptions" it has one parameter name
////        "option" of type string
////        1.2 This method should click on the options whatever name is passed as parameter.
////        (Hint: Handle List of Element and Select options)
    public void selectMyAccountOptions(String option) {
        List<WebElement> allMyAccountOptions = homePage.getMyAccountOptions();
        for (WebElement e : allMyAccountOptions) {
            if (e.getText().equalsIgnoreCase(option)) {
                e.click();
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        // 1.1 Click on My Account Link.
        homePage.clickOnMyAccountLink();
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        selectMyAccountOptions("Register");
        // 1.3 Verify the text “Register Account”
        Assert.assertEquals(registerPage.getRegisterPageHeadingText(), "Register Account", "you are navigate To Wrong page.");

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        homePage.clickOnMyAccountLink();
        //2.2Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”
        Assert.assertEquals(loginPage.getReturningCustomerHeadingText(), "Returning Customer", "Navigated To Wrong page.");

    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        homePage.clickOnMyAccountLink();

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        // 3.3 Enter First Name
        registerPage.enterFirstName("Maria");
        // 3.4 Enter Last Name
        registerPage.enterLastName("Roshan");

//        3.5 Enter Email
        Random random = new Random();
        int number = random.nextInt(1000);
        String randomString = String.format("%03d", number);
        String randomEmail = randomString + "ltester@gmail.com";
        registerPage.enterEmail(randomEmail);

//        3.6 Enter Telephone
        registerPage.enterPhone("0775544889");

//        3.7 Enter Password
        registerPage.enterPassword("Abcd123");

//        3.8 Enter Password Confirm
        registerPage.enterConfirmPassword("Abcd123");

//        3.9 Select Subscribe Yes radio button
        registerPage.clickOnNewsLetterRadioButton("Yes");

//        3.10 Click on Privacy Policy check box
        registerPage.clickOnPrivacyPolicyCheckBox();

//        3.11 Click on Continue button
        registerPage.clickOnContinueButton();

//        3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(yourAccountCreatedPage.getRegisterSuccessMessageText(), "Your Account Has Been Created!", "Registraion successful message incorrect.");

//        3.13 Click on Continue button
        yourAccountCreatedPage.clickOnContinueButton();

//        3.14 Click on My Account Link.
        homePage.clickOnMyAccountLink();

//        3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

//        3.16 Verify the text “Account Logout”
        Assert.assertEquals(logOutPage.getLogOutHeadingText(), "Account Logout", "LogOut page heading is incorrect.");

//        3.17 Click on Continue button
        logOutPage.clickOnContinueButton();

    }

    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {

        // 4.1 Click on My Account Link.
        homePage.clickOnMyAccountLink();

//        4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

//        4.3 Enter Email address
        returningCustomerPage.enterEmail("ltester1@gmail.com");

//        4.5 Enter Password
        returningCustomerPage.enterPassword("Abcd123");

//        4.6 Click on Login button
        returningCustomerPage.clickOnLoginButton();

//        4.7 Verify text “My Account”
        Assert.assertEquals(accountPage.getMyAccountHeadingText(), "My Account", "Did ot navigate to My Account page.");

//        4.8 Click on My Account Link.
        homePage.clickOnMyAccountLink();


//        4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

//        4.10 Verify the text “Account Logout”
        logOutPage.getLogOutHeadingText();

//        4.11 Click on Continue button
        logOutPage.clickOnContinueButton();
    }

}

