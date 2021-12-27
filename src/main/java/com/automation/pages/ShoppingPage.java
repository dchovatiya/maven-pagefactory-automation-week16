package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * By Dimple Patel
 **/
public class ShoppingPage extends Utility
{
    public ShoppingPage()
    {
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//div[@class='right-block']")
    WebElement viewItem;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")  //span[contains(text(),'Add to cart')]
    WebElement addCart;
    @CacheLookup
    @FindBy(xpath = "//div[@class='layer_cart_cart col-xs-12 col-md-6']//span[@class=(contains(text(),'button-container'))]")
    List<WebElement> checkCntBtn;
    //@FindBy(xpath = "//span[@class='ajax_cart_no_product']")
    @CacheLookup
    @FindBy(xpath = "//i[@class='icon-trash']")
    WebElement delQty;
    @CacheLookup
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement chkOut;

    //@FindBy(xpath = "//a[@title='View my shopping cart']")
    //WebElement viewCart;
    @CacheLookup
    @FindBy(xpath = "//p[@class='alert alert-warning']") //p[@class='alert alert-warning']
    WebElement emptyMessage;

    //div[@class='shopping_cart']//span[contains(@class,'ajax_cart_quantity')]
    //div[@class='shopping_cart']//a//@class
    //div[@class='shopping_cart']//a[@class=contains(text(),'ajax_cart')]//span
    //div[@class='shopping_cart']//a[@class=contains(text(),'ajax_cart_quantity')]//span
    //div[@class='layer_cart_cart col-xs-12 col-md-6']
    //div[@class='layer_cart_cart col-xs-12 col-md-6']//span[@class=(contains(text(),'btn btn-default'))]

    public void addToCart() {
        mouseHoverToElement(viewItem);
        addCart.click();
    }
    public void selCheckCntBtn(String button) {
        for (WebElement btn : checkCntBtn) {
            if (btn.getText().trim().equalsIgnoreCase(button)) {
                btn.click();
                break;
            }
        }
    }
    public void addDelCart() {
        delQty.click();
    }
    public String emptyMessage() {
        return emptyMessage.getText();
    }
    public void setChkOut() {
        chkOut.click();
    }
}
