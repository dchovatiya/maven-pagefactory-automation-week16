package com.automation.testsuite;

import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.pages.StorePage;
import com.automation.pages.SummerDressPage;
import com.automation.testbase.TestBase;
import com.automation.utility.Utility;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * By Dimple Patel
 **/

public class MapTest extends TestBase
{
    StorePage storePage;
    @BeforeMethod(alwaysRun = true)
    public void inIt()
    {
        storePage=new StorePage();
    }
    //Scenario 5
    @Test(priority=5,groups={"sanity","regression"})
    public void browseOurStorePageAndDragTheMap() throws InterruptedException {
        javaExecutorScriptExecuteScriptToPerformScroll();
        storePage.selectOurStore("Our stores");
        storePage.clickOnOk();
        storePage.moveONMap();
        storePage.setZoomOut();
        Utility.takeScreenShot();
    }
}