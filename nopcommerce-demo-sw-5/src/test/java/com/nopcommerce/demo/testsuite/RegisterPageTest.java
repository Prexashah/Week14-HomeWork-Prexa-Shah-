package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegisterPageTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    RegisterPage registerPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        registerPage = new RegisterPage();
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //Click on RegisterLink
        homePage.clickOnRegisterLink();
        //verify the Register text
        Assert.assertEquals(registerPage.verifyRegisterText(), "Register",
                "User is not on RegisterPage");
    }

    @Test
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        //Click on RegisterLink
        homePage.clickOnRegisterLink();
        //Click on Register Button to Verify MandatoryField, verify all the errors
        registerPage.clickOnRegisterButton();
        //Verify the error message "First name is required"
        Assert.assertEquals(registerPage.verifyErrorMessageFirstNameIsRequired(), "First name is required.", "Incorrect message");
        //Verify the error message "Last name is required"
        Assert.assertEquals(registerPage.verifyErrorMessageLastNameIsRequired(), "Last name is required.", "Incorrect message");
        //Verify the error message "Email is required"
        Assert.assertEquals(registerPage.verifyErrorMessageEmailNameIsRequired(), "Email is required.", "Incorrect Message");
        //Verify the error message "Password is Required"
        Assert.assertEquals(registerPage.verifyErrorMessagePasswordIsRequired(), "Password is required.", "Incorrect message");
        //Verify the error message "Password is Required"
        Assert.assertEquals(registerPage.verifyErrorMessageConfirmPasswordIsRequired(), "Password is required.", "Incorrect message");

    }

    @Test
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        //Click on Register Link
        homePage.clickOnRegisterLink();
        //Select gender "Female
        registerPage.clickOnFemaleRadioBtn();
        //Enter FirstName
        registerPage.enterFirstName("Elson");
        //lastName
        registerPage.enterLastName("Varkey");
        //select day
        registerPage.selectDayFromDropDown("19");
        //select month
        registerPage.selectMonthFromDropDown("August");
        //select year
        registerPage.selectYearFromDropDown("1980");

        //Generate a random email
        Random random = new Random();
        int ranNumber = random.nextInt(1000);
        String ranString = String.format("%03d", ranNumber);
        String randomEmail = ranString + "ltester65@gmail.com";
        //Email
        registerPage.enterEmail("ltester69@gmail.com");
        //Password
        registerPage.enterPassword("abcd1234");
        //Confirm Password
        registerPage.enterConfirmPassword("abcd1234");
        //Click on RegisterButton
        registerPage.clickOnRegisterButton();
        //Verify the message "Your Registration Completed
        Assert.assertEquals(registerPage.verifyYourRegistrationCompleted(), "Your registration completed",
                "User is not Registered");


    }

}
