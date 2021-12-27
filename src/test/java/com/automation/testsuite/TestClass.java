package com.automation.testsuite;

import com.automation.pages.HomePage;
import com.automation.pages.ShoppingPage;
import com.automation.pages.SignInPage;
import com.automation.pages.SummerDressPage;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * By Dimple Patel
 **/

public class TestClass extends TestBase
{
    HomePage homePage;
    SummerDressPage summerDressPage;
    ShoppingPage shoppingPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt()
    {
        homePage=new HomePage();
        summerDressPage=new SummerDressPage();
        shoppingPage=new ShoppingPage();
    }
    //Scenario 1
    @Test(priority = 1,groups={"smoke","regression"})
    public void userShouldAddAndDeleteItemsFromTheCart() throws InterruptedException {
        shoppingPage.addToCart();
        shoppingPage.setChkOut();
        shoppingPage.addDelCart();
        Thread.sleep(2000);
        String expectedMessage = "Your shopping cart is empty.";
        String actualMessage = shoppingPage.emptyMessage();
        Assert.assertEquals(expectedMessage, actualMessage, "Your shopping cart is empty not displayed");
    }
    //Scenario 2
    @Test(priority=2,groups={"sanity","regression"})
    public void verifyUserCanViewAnItemFromSummerCollection() throws InterruptedException
    {
        homePage.clickOnNavigationMenu("WOMEN");
        homePage.clickOnSubMenu("Summer Dresses");
    }
    //Scenario 3
    @Test(priority=3,groups = {"sanity","regression"})
    public void verifyTheSearchResultsByChangingThePriceRangeWithSlider() throws InterruptedException
    {
        homePage.clickOnNavigationMenu("WOMEN");
        homePage.clickOnSubMenu("Summer Dresses");
        summerDressPage.slider();
    }
}