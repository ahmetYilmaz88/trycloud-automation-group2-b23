package com.trycloud.pages;

import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.ConfigReader;
import com.trycloud.utility.Driver;
import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UserStory03Page {

    @FindBy(xpath = "//input[@id='user']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginBtn;

    @FindBy(xpath = "//li[@data-id='files']")
    public WebElement filesButton;

    @FindBy(xpath = "//label[@for='select_all_files']")
    public WebElement allCheckBox;

    @FindBy(xpath = " //tr[contains(@class,'selected')]")
    public List<WebElement> allCheckBoxChecked;




    public UserStory03Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void goTo(){
        Driver.getDriver().get(ConfigReader.read("url"));
    }

    public void enterCredentials(String username, String password){
        usernameInput.click();
        usernameInput.sendKeys(username);
        BrowserUtil.waitFor(2);
        passwordInput.click();
        passwordInput.sendKeys(password);

    }

    public void login(){

        loginBtn.click();
        BrowserUtil.waitFor(3);
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickFiles(){
        filesButton.click();
    }

    public String getTitle(){
      return   Driver.getDriver().getTitle();
   }

    public void checkAllCheckBoxes(){

        allCheckBox.click();


   }

    public  boolean getIsCheck(){

        boolean result=true;

        for (WebElement eachBox : allCheckBoxChecked) {
            if(!eachBox.isDisplayed()){
                BrowserUtil.waitFor(2);
                result = false;
            }

        }

        return result;
    }



}








