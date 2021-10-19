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


    //@FindBy(xpath = "(//li/a[@aria-label='Photos'])[1]")


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

     @FindBy(xpath = "//ul[@id='sublist-favorites']/li")
     public List<WebElement> allFavoriteFiles;




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
    public WebElement addNewFileBtn;

   @FindBy(xpath = "//*[@id='controls']/div[2]/div[2]/ul/li[1]/label/span[2]")
    public WebElement uploadFileBtn ;


   public void addingNewFile(){
       Actions action =new Actions(Driver.getDriver());
       String filePath="/Users/feruzajonzokova/Desktop/Background_Pictures/background2.webp";

       addNewFileBtn.click();
       BrowserUtil.waitFor(2);
       action.click(uploadFileBtn).pause(2000).sendKeys(filePath).perform();
       BrowserUtil.waitFor(5);



   }





}
