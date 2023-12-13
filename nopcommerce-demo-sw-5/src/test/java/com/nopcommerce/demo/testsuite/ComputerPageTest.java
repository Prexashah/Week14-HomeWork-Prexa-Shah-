package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class ComputerPageTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    RegisterPage registerPage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        registerPage = new RegisterPage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();

    }

    @Test
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        //click on computer tab
        homePage.clickOnComputerTab();
        //Verify ComputerText
        Assert.assertEquals(computerPage.verifyComputerTab(), "Computers", "You are not on computer page");


    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //click on computer tab
        homePage.clickOnComputerTab();
        //Click on Desktop Link
        computerPage.clickOnDeskTopLink();
        //Verify "Desktops" text
        Assert.assertEquals(computerPage.verifyDesktopTxt(), "Desktops", "you are not on Desktop page");


    }

    @Test(dataProvider = "productinfo", dataProviderClass = TestData.class,groups = {"regression"})
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {
        // Click on Computer tab
        homePage.clickOnComputerTab();

        // Click on Desktops link
        computerPage.clickOnDeskTopLink();

        //Click on product name "Build your own computer"
        desktopsPage.clickOnBuildYourComputer();

        //   Select processor "processor"
        buildYourOwnComputerPage.selectProcessor(processor);


        // Select RAM "ram"
        buildYourOwnComputerPage.selectRAM(ram);

        //   Select HDD "hdd"
        buildYourOwnComputerPage.selectHDDRadioButton(hdd);

        //   Select OS "os"
        buildYourOwnComputerPage.selectOsRadioCheckBox(os);

        //    Select Software "software"
        buildYourOwnComputerPage.selectSoftwareCheckBox(software);

        //   Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCartBtn();

        //   Verify message "The product has been added to your shopping cart"
        Assert.assertEquals(buildYourOwnComputerPage.verifyTheMessageAddToCart(), "The product has been added to your shopping cart\n" +
                "\n", "The product has not been added to the cart");
    }

}
