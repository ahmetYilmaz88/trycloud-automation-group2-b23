package com.trycloud.pages;

import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.ConfigReader;
import com.trycloud.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserStory6Page_Aykut {

    public UserStory6Page_Aykut() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = " //p/input[@id='user']")
    public WebElement userNameField;

    @FindBy(xpath = " //p/input[@id='password'] ")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginButton;

    @FindBy(xpath = "//ul[@id='appmenu']//a[@href='/index.php/apps/files/']")
    public WebElement fileBtn;

    @FindBy(xpath = "//span[@class='icon icon-add']")
    public WebElement addBtn;

    @FindBy(xpath = "//span[.='New folder']")
    public WebElement createNewFolder;

    @FindBy(id = "view13-input-folder")
    public WebElement writeFolderName;

    //label[@data-action='upload']

    @FindBy(xpath = "//label[@data-action='upload']")
    public WebElement uploadFile;
    //input[@class='icon-confirm']

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement submitFolder;
////tr[@data-file='Test1']

    @FindBy(xpath = "//tr[@data-file='Fenerbahce']")
    public WebElement verifyFolder;

    @FindBy(xpath = "//tr[@data-file='Test1']")
    public WebElement anyFile;

    @FindBy (xpath = "//input[@type='file']")
    public WebElement uploadFileHiddenInput;


    public void goTo() {

        Driver.getDriver().get(ConfigReader.read("url"));

    }
    public void login(String usernameStr,String passwordStr){

        userNameField.sendKeys(usernameStr);
        passwordField.sendKeys(passwordStr);
        loginButton.click();

    }
    public void loginDynamic(String userType){

        userType=userType.replace(" ","_") ;
        String username= ConfigReader.read(userType+"_username");
        String password= ConfigReader.read(userType+"_password");

        login(username, password);

    }
    public boolean VerifyFolder(String folderName){
        boolean result=false;
writeFolderName.sendKeys(folderName);
submitFolder.click();
String folder="//tr[@data-file='"+folderName+"']";
        BrowserUtil.waitFor(4);
WebElement displayedFolder=Driver.getDriver().findElement(By.xpath(folder));
        result=displayedFolder.isDisplayed();
        return result;
    }



    public boolean VerifyFile(String fileName){
        addBtn.click();
        String filePath="C:\\Users\\ekull\\Desktop\\1.PNG";
        String fileInfo="1.PNG";

        BrowserUtil.waitFor(2);
        uploadFileHiddenInput.sendKeys(filePath);
        boolean result=false;
        String folder="//tr[@data-file='"+fileName+"']";
        BrowserUtil.waitFor(4);
        WebElement displayedFolder=Driver.getDriver().findElement(By.xpath(folder));
        result= displayedFolder.isDisplayed();

        return result;
    }


}
