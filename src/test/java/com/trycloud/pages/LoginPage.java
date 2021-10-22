package com.trycloud.pages;

import com.trycloud.utility.ConfigReader;
import com.trycloud.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    @FindBy(xpath = "//input[@id='user']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginBtn;

    @FindBy(xpath = "//div/input[@value='Logging in ...']")
    public WebElement loaderMask;

    @FindBy(xpath = "//p[normalize-space(.)='Wrong username or password.']")
    public WebElement loginFailedMsg;

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void goTo(){
        Driver.getDriver().get(ConfigReader.read("url"));
    }

    public void enterCredentials(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(ConfigReader.read("password"));

    }

    public void enterInvalidCredentials(String username, String Invalidpassword){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(ConfigReader.read("invalidPassword"));

    }

    public void login(){
        loginBtn.click();
    }

    public String displayWarningMsg(){
        waitForVisibility(By.xpath("//p[normalize-space(.)='Wrong username or password.']"),20);
        return loginFailedMsg.getText();

    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }



}
