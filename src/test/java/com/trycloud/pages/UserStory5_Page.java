package com.trycloud.pages;

import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.ConfigReader;
import com.trycloud.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserStory5_Page {


    public UserStory5_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

   @FindBy(css = "#user")
   public WebElement usernameInputBox ;

    @FindBy(id = "password")
    public WebElement passwordInputBox ;

    @FindBy(id = "submit-form") //>>submit it
    public WebElement loginBtn ;


    public void goTo(){
        Driver.getDriver().get(ConfigReader.read("url"));
    }


    public void login(String userType){

        if(userType.equalsIgnoreCase("User2")){
            usernameInputBox.sendKeys(ConfigReader.read("username1"));
        }else if(userType.equalsIgnoreCase("User32")){
            usernameInputBox.sendKeys(ConfigReader.read("username2"));
        }else if(userType.equalsIgnoreCase("User62")){
            usernameInputBox.sendKeys(ConfigReader.read("username3"));
        }else{//usertype==User92
            usernameInputBox.sendKeys(ConfigReader.read("username4"));
        }

        BrowserUtil.waitFor(2);
        passwordInputBox.sendKeys(ConfigReader.read("password"));

        BrowserUtil.waitFor(2);

        loginBtn.submit();
    }


    //@FindBy(xpath = "(//li/a[@aria-label='Photos'])[1]")
   //more bla bla

    public void clickModules(String module){

        BrowserUtil.waitFor(2);
        String moduleLocator="(//li/a[@aria-label='"+module+"'])[1]";
        WebElement moduleOption=Driver.getDriver().findElement(By.xpath(moduleLocator));

        new Actions( Driver.getDriver()).click(moduleOption).perform();
        BrowserUtil.waitFor(3);

    }




    @FindBy(xpath = "//*[@id='fileList']/tr[1]/td[2]/a/span[3]/a[2]/span[1]")
    public WebElement firstActionBtn;

    @FindBy(xpath ="//*[@id='fileList']/tr[1]/td[2]/a/span[1]/span")
    public WebElement firstFileInfo ;

    @FindBy(xpath = "//*[@id='fileList']/tr[1]/td[2]/div/ul/li[3]/a/span[2]")
    public WebElement removeFromFavorite;

     public String firstFileInfo(){

         String fileInfo=firstFileInfo.getText();

         return fileInfo;
     }



    @FindBy(xpath = "//a[@class='nav-icon-favorites svg']")
    public WebElement favoritesBtn ;

    @FindBy(xpath = "//tbody/tr/td[2]/div/ul/li[3]//span[2]")
    public WebElement favoriteBtn ;

     @FindBy(xpath = "//ul[@id='sublist-favorites']/li")
     public List<WebElement> allFavoriteFiles;

    @FindBy(xpath = "//a[@class='nav-icon-favorites svg']")
    public WebElement favoritesModule ;


     public boolean  verifyingFileRemoved(){
         boolean result=false;
         favoritesBtn.click();
         BrowserUtil.waitFor(3);
         for(WebElement eachFavoriteFile : allFavoriteFiles){

             if(eachFavoriteFile.getText().equalsIgnoreCase(firstFileInfo())){
                 result=true;
             }
         }

        return  result;
     }




    @FindBy(xpath = "//div/a/span[@class='icon icon-add']")
    public WebElement plusFileBtn;


    @FindBy (xpath = "//input[@type='file']")
    public WebElement uploadFileHiddenInput;


    @FindBy(css = "#file_upload_start")
    public WebElement uploadFile;


    @FindBy(xpath = "//div/h2[@class='oc-dialog-title']")
    public WebElement fileConflict;

    @FindBy(css = "[for='checkbox-allnewfiles']")
    public WebElement newFileCheckBox ;

    @FindBy(xpath = "//*[@id=\"body-user\"]/div[9]/div[2]/button[2]")
    public WebElement continueBtn;


    public boolean VerifyFolder(String folderName){
        boolean result=false;
        String folder="//tr[@data-file='"+folderName+"']";
        BrowserUtil.waitFor(4);
        WebElement displayedFolder=Driver.getDriver().findElement(By.xpath(folder));
        result= displayedFolder.isDisplayed();

        return result;
    }









}
