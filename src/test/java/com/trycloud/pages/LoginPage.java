package com.trycloud.pages;
import com.trycloud.utility.ConfigReader;
import com.trycloud.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){ PageFactory.initElements(Driver.getDriver(), this); }

    @FindBy(xpath = "//input[@id='user']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginBtn;

    @FindBy(xpath = "//div/input[@value='Logging in ...']")
    public WebElement loaderMask;

    @FindBy(xpath = "//p[normalize-space(.)='Wrong username or password.']")
    public WebElement loginFailedMsg;

    public void goTo(){
        Driver.getDriver().navigate().to( ConfigReader.read("url") );
    }

    public void login(int usernameNum) {

        if(usernameNum >=1 && usernameNum <=4){
            username.sendKeys(ConfigReader.read("username" + usernameNum));
            password.sendKeys(ConfigReader.read("password"));
        }else{
            throw new RuntimeException("Out of range");
        }
    }

}


