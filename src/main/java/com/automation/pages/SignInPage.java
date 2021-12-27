package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * By Dimple Patel
 **/
public class SignInPage extends Utility
{
    public SignInPage() {
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(css="#email_create")
    WebElement emailField;
    @CacheLookup
    @FindBy(css="#SubmitCreate")
    WebElement createAnAccBtn;
    public void enterEmail(String email)
    {
        sendTextToElement(emailField,email);
    }
    public void clickOnCreateAccount()
    {
        clickOnElement(createAnAccBtn);
    }
}
