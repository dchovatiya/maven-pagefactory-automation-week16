package com.automation.testsuite;

import com.automation.pages.CreateAccountPage;
import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.pages.SummerDressPage;
import com.automation.testbase.TestBase;
import com.aventstack.extentreports.gherkin.model.Scenario;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * By Dimple Patel
 **/

public class CreateAccountTest extends TestBase
{
    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt()
    {
        homePage=new HomePage();
        signInPage=new SignInPage();
        createAccountPage=new CreateAccountPage();
    }
    //Scenario 4
    @Test(priority=4,groups = {"smoke","regression"})
    public void createANewAccountToBuyItemsFromPersonalAccount()
    {
        homePage.clickOnSignInLink();
        signInPage.enterEmail("dimple123@gmail.com");
        signInPage.clickOnCreateAccount();
        //createAccountPage.getGender("Mrs");
        createAccountPage.allFieldNames("id_gender", "Mrs");
        createAccountPage.allFieldNames("customer_firstname", "Dimple");
        createAccountPage.allFieldNames("customer_lastname", "Patel");
        createAccountPage.allFieldNames("passwd", "patel1234");
        createAccountPage.allFieldNames("days", "26");
        createAccountPage.allFieldNames("months", "November");
        createAccountPage.allFieldNames("years", "1983");
        createAccountPage.allFieldNames("newsletter", "No");
        createAccountPage.allFieldNames("option", "Yes");
        createAccountPage.allFieldNames("firstname", "Dimple");
        createAccountPage.allFieldNames("lastname", "Patel");
        createAccountPage.allFieldNames("company", "Glenwood Ltd");
        createAccountPage.allFieldNames("address1", "397 Street");
        javaExecutorScriptExecuteScriptToPerformScroll();
        createAccountPage.allFieldNames("address2", "Harrow");
        createAccountPage.allFieldNames("city", "Harrow");
        createAccountPage.allFieldNames("city", "London");
        createAccountPage.allFieldNames("id_state", "New York");
        createAccountPage.allFieldNames("postcode", "12456");
        createAccountPage.allFieldNames("id_country", "United States");
        createAccountPage.allFieldNames("phone", "+1254621220");
        createAccountPage.allFieldNames("phone_mobile", "++1254621220");
        createAccountPage.allFieldNames("phone_mobile", "++1254621225");
        createAccountPage.allFieldNames("alias", "My 2st Address");

        // Click on "Register" button
        createAccountPage.clickRegister();

        // Verify message "My Account"
        String myAccountMsg = createAccountPage.textMyAc();
        Assert.assertEquals("My account", myAccountMsg, "Show My account");
    }
}