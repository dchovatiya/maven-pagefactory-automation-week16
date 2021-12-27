package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

/**
 * By Dimple Patel
 **/
public class CreateAccountPage extends Utility
{
    public CreateAccountPage()
    {
        PageFactory.initElements(driver,this);
    }
    //To get all ids and names
    //div[@class='account_creation']//@name
    //div[@class='account_creation']//@id

    @FindBy(xpath = "//div[@class='account_creation']//input")
    //div[@class='account_creation']/descendant::div
    List<WebElement> allFields;
    //div[@class='account_creation']//input[class=(contains(text(),'required form-group'))]
    @FindBy(xpath = "//div[@class='radio-inline']//label")
    List<WebElement> twoGender;
    @FindBy(xpath = "//div[@class='account_creation']//select[@class='form-control']")
    List<WebElement> selFields;
    @FindBy(xpath = "//button[@id='submitAccount']")
    WebElement register;
    @FindBy(xpath = "//span[@class='navigation_page']")
    WebElement myAccount;

    public void getGender(String gender)
    {
        for (WebElement gen : twoGender)
        {
            System.out.println(gen.getText());
            if (gen.getText().equalsIgnoreCase(gender)) {
                gen.click();
                break;
            }
        }
    }
    public void allFieldNames(String fieldName, String sendValue)
    {
        //First for each loop for matching type radio and checkbox
        for (WebElement field : allFields)
        {
            if (field.getAttribute("name").trim().equalsIgnoreCase(fieldName))
            {
                if (field.getAttribute("type").equalsIgnoreCase("radio"))
                {
                    for (WebElement gen : twoGender)
                    {
                        if (gen.getText().equalsIgnoreCase(sendValue))
                        {
                            gen.click();
                            break;
                        }
                    }
                } else
                if (field.getAttribute("type").equalsIgnoreCase("checkbox"))
                {
                    if (sendValue.equalsIgnoreCase("Yes"))
                    {
                        field.click();
                    }
                } else {
                    if (!field.getText().trim().equals(sendValue.trim())) {
                        field.clear();
                        field.sendKeys(sendValue);
                    }
                }
                break;
            }
        }
        //Second for each loop for select fields
        for (WebElement selField : selFields) {
            if (selField.getAttribute("name").trim().equalsIgnoreCase(fieldName)) {
                selectByContainsTextFromDropDown(selField, sendValue);
                break;
            }
        }
    }
    public void clickRegister() {
        Reporter.log("Click Register" + register.toString() + "<br>");
        clickOnElement(register);
    }
    public String textMyAc() {
        Reporter.log("Verify Sign Out" + myAccount.toString() + "<br>");
        String myAccountMsg = getTextFromElement(myAccount);
        return myAccountMsg;
    }
}
