package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessFully() {
        //Click on Login link
        homePage.clickOnLoginLink();
        //Verify that "Welcome,Please Sign In!" message display
        Assert.assertEquals(loginPage.verifyWelcomeMsg(), "Welcome, Please Sign In!", "You are not at login page");

    }

    @Test
    public void verifyTheErrorMessageWithInValidCredentials() {
        //Click on LoginLink
        homePage.clickOnLoginLink();
        //Enter EmailId
        loginPage.enterEmailId("ltester123@gmail.com");
        //Enter Password
        loginPage.enterPassword("abcd1234");
        //click on login Button
        loginPage.clickOnLoginBtn();
        Assert.assertEquals(loginPage.verifyErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found", "The user has login successfully");
    }

    @Test
    public void verifyThatUserShouldLoginSuccessFullyWithValidCredentials() {
        //click on login link
        homePage.clickOnLoginLink();
        //enter Email ID
        loginPage.enterEmailId("ltester585@gmail.com");
        //enterPassword
        loginPage.enterPassword("abcd1234");
        //click on login button
        loginPage.clickOnLoginBtn();
        Assert.assertEquals(homePage.verifyThatLogOutLinkIsDisplay(), "Log out", "User is not register");


    }

    @Test
    public void verifyThatUserShouldLogOutSuccessFully() {
        //Click on login link
        homePage.clickOnLoginLink();
        //enter Email ID
        loginPage.enterEmailId("ltester55@gmail.com");
        //enterPassword
        loginPage.enterPassword("abcd1234");
        //click on login button
        loginPage.clickOnLoginBtn();
        //click on Logout Button
        homePage.clickOnLogOutLink();
        Assert.assertEquals(homePage.verifyThatLoginLinkIsDisplay(), "Log in", "User is not on HomePage");
    }

}
