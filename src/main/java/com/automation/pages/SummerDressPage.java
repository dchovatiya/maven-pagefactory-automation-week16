package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * By Dimple Patel
 **/
public class SummerDressPage extends Utility
{
    //Locators sliderOnLeft,
    public SummerDressPage()
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@id='left_column']//a[2]")
    WebElement endSlider;
    @FindBy(xpath = "//div[@id='layered_price_slider']")
    WebElement sliderWidth;
    public void slider() throws InterruptedException
    {
        Actions actions=new Actions(driver);
        Thread.sleep(3000);
        int width =  sliderWidth.getSize().width;
        System.out.println(width);
        int halfWidth = (width/4)*3;
        actions.dragAndDropBy(endSlider,0-halfWidth,0 ).build().perform();
        Thread.sleep(5000);
    }
}
