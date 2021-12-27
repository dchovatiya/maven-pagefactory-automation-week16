package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

/**
 * By Dimple Patel
 **/
public class HomePage extends Utility
{
    //Locators navigationMenu, subMenuSummerDresses
    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(linkText = "Sign in")
    WebElement signIn;
    @CacheLookup
    @FindBy(xpath="//div[@id='block_top_menu']/child::ul/child::li")
    List<WebElement> navigationMenu;
    @CacheLookup
    @FindBy(xpath="//ul[@class='submenu-container clearfix first-in-line-xs']//a")
    //@FindBy(xpath="//li[@class='sfHoverForce']//ul[@class='submenu-container clearfix first-in-line-xs']//a")
    //@FindBy(xpath="//li[@class='sfHoverForce']//a")
    //@FindBy(xpath="(//ul)[4]//li//a")
    List<WebElement> subMenuInWomen;

    public void clickOnNavigationMenu(String menuItem)
    {
        for (WebElement menu:navigationMenu) {
            if (menu.getText().trim().equalsIgnoreCase(menuItem)) {
                System.out.println(menu.getText());
                Reporter.log("Click on '" + menuItem + "' link <br>");
                mouseHoverToElement(menu);
                break;
            }
        }
    }
    public void clickOnSubMenu(String subMenuItem) throws InterruptedException {
        for (WebElement menuItem:subMenuInWomen)
        {
            System.out.println(menuItem.getText());
            if (menuItem.getText().trim().equalsIgnoreCase(subMenuItem))
            {
                clickOnElement(menuItem);
                Thread.sleep(2000);
                break;
            }
            Reporter.log("Click on '" + subMenuItem + "' link <br>");
        }
    }
    public void clickOnSignInLink()
    {
        clickOnElement(signIn);
    }


}
