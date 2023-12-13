package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.ComponentPage;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.Laptops_NotebooksPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TopMenuTest extends BaseTest {

    HomePage homePage;
    DesktopPage desktopPage;
    Laptops_NotebooksPage laptopsNotebooksPage;
    ComponentPage componentPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        laptopsNotebooksPage = new Laptops_NotebooksPage();
        componentPage = new ComponentPage();

    }

    public void selectMenu(String menu) {
        List<WebElement> allTopMenuLinks = homePage.showAllOptionsFromTopNav();
        try {
            for (WebElement link : allTopMenuLinks) {
                if (link.getText().equals(menu)) {
                    link.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            allTopMenuLinks = homePage.showAllOptionsFromTopNav();

        }
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        homePage.mouseHoverAndClickDesktopTab();
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show AllDesktops");
        //1.3 Verify the text ‘Desktops’
        Assert.assertEquals(desktopPage.verifyTheTextDesktops(), "Desktops", "You are not on Desktop page");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.mouseHoverOnLaptopsNoteBooksAndClick();
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals(laptopsNotebooksPage.verifyTheTextDLaptopsAndNoteBooks(), "Laptops & Notebooks",
                "You are not on the laptops and notebooks page");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        homePage.mouseHoverOnComponentsTabAndClick();

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");

        //3.3 Verify the text ‘Components’
        Assert.assertEquals(componentPage.verifyTheTextComponents(), "Components",
                "You are not on the component page");

    }
}
