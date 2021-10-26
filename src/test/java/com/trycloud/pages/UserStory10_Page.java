package com.trycloud.pages;

import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.ConfigReader;
import com.trycloud.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class UserStory10_Page {

    private Object fileModule;

    public UserStory10_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#user")
    public WebElement usernameInputBox ;

    @FindBy(id = "password")
    public WebElement passwordInputBox ;

    @FindBy(id = "submit-form") //>>submit it
    public WebElement loginBtn ;

    @FindBy(xpath = "//ul[@id='appmenu']/li[normalize-space(.)='Files']")

    public WebElement filesModule;

    @FindBy(xpath = "//*[@id='app-settings-header']/button")
    public WebElement settingModule;

    @FindBy(xpath = "//*[@id='files-setting-richworkspace']/label")
    public List<WebElement> anyButtons;

    @FindBy(xpath = "//div[@id='files-setting-richworkspace']/label[.='Show rich workspaces']")
    public WebElement checkbox1;

    @FindBy(xpath = "//div[@id='recommendations-setting-enabled']/label[.='Show recommendations']")
    public WebElement checkbox2;

    @FindBy(xpath = "//div[@id='files-setting-showhidden']/label[.='Show hidden files']")
    public WebElement checkbox3;



    //*[@id="recommendations-setting-enabled"]/label

    @FindBy(xpath = "//*[@id='quota']/a/p")
    public WebElement storageUsage;

    @FindBy(xpath = "//*[@id='controls']/div[2]/a/span[1]")
    public WebElement addFiles;

    @FindBy (xpath = "//input[@type='file']")
    public WebElement uploadFiles;

    @FindBy(xpath = "//*[@id='oc-dialog-fileexists-content']/div/div[2]/div[2]/label")
    public WebElement fileConflict;

    @FindBy(css = "[for='checkbox-allnewfiles']")
    public WebElement newFileCheckBox ;

    @FindBy(xpath = "//*[@id='body-user']/div[9]/div[2]/button[2]")
    public WebElement continueBtn;





    public void goTo(){
        Driver.getDriver().get(ConfigReader.read("url"));
    }


    public void login(String userType){

        if(userType.equalsIgnoreCase("User2")){
            usernameInputBox.sendKeys(ConfigReader.read("userName1"));
        }else if(userType.equalsIgnoreCase("User32")){
            usernameInputBox.sendKeys(ConfigReader.read("userName2"));
        }else if(userType.equalsIgnoreCase("User62")){
            usernameInputBox.sendKeys(ConfigReader.read("userName3"));
        }else{//usertype==User92
            usernameInputBox.sendKeys(ConfigReader.read("userName4"));
        }

        BrowserUtil.waitFor(2);
        passwordInputBox.sendKeys(ConfigReader.read("password"));

        BrowserUtil.waitFor(2);

        loginBtn.submit();
    }


    public void clickLoginButton(String module){

        BrowserUtil.waitFor(2);
        String moduleLocator="(//li/a[@aria-label='"+module+"'])[1]";
        WebElement moduleOption=Driver.getDriver().findElement(By.xpath(moduleLocator));

        new Actions( Driver.getDriver()).click(moduleOption).perform();
        BrowserUtil.waitFor(3);
    }

}