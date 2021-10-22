package com.trycloud.pages;


import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Arrays;
import java.util.List;


public class UserStory4_byAteeq_FilesPage {

    @FindBy(xpath = "//input[@id='user']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;

    @FindBy(id = "submit-form")
    public WebElement loginBtn;

    @FindBy(xpath = "//ul[@id='appmenu']/li[2]")
    public WebElement filesTab;

    @FindBy(xpath = "//*[@id='fileList']/tr[7]/td[2]/a/span[3]/a[2]/span[1]")
     public WebElement tripleDots1;

    @FindBy(xpath = "//*[@id='fileList']/tr[9]/td[2]/a/span[3]/a[2]/span[1]")
     public WebElement tripleDots2;

    @FindBy(xpath = "//*[@id='fileList']/tr[7]/td[2]/div/ul/li[3]")
    public WebElement addToFavorite1;

    @FindBy(xpath = "//*[@id='fileList']/tr[9]/td[2]/div/ul/li[3]")
    public WebElement addToFavorite2;

    @FindBy(xpath = "//a[contains(text(),'Favorites')]")
    public WebElement favoritesTab;

    @FindBy(xpath = "//*[@id=\"fileList\"]/tr[7]/td[2]/a/span[1]/span[1]")
    public WebElement selectedFileText1;

    @FindBy(xpath = "//*[@id=\"fileList\"]/tr[9]/td[2]/a/span[1]/span[1]")
     public WebElement selectedFileText2;


   public UserStory4_byAteeq_FilesPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    public void goTo() {
        Driver.getDriver().get("http://qa2.trycloud.net/index.php/login");
    }


    public void clickOnEachFileOption( ){

        List<WebElement> eachFile = Driver.getDriver().findElements(By.xpath("//*[@id=\"fileList\"]/tr/td[2]/a/span[3]/a[2]/span[1]"));

        for (int i = 0; i <= eachFile.size()-1; i++) {
            eachFile.get(i).click();
            BrowserUtil.waitFor(1);
            eachFile.get(i).click();
        }
    }

    public void addToFavorite_And_getTextOfAddToFav (List<String> actualText){

        BrowserUtil.waitFor(3);
        tripleDots2.click();
        actualText.addAll(Arrays.asList(selectedFileText2.getText()));
        BrowserUtil.waitFor(2);
        addToFavorite2.click(); // add to favorite
        BrowserUtil.waitFor(3);

        actualText.addAll(Arrays.asList(selectedFileText1.getText()));
        tripleDots1.click();
        BrowserUtil.waitFor(2);
        addToFavorite1.click();
        BrowserUtil.waitFor(3);
    }

    public void addedToFavListText(List<String> expectedText){

        List<WebElement> files = Driver.getDriver().findElements(By.xpath("//*[@id=\"fileList\"]/tr/td[1]/a/span[1]/span[1]"));

        for (WebElement eachFile : files) {
            expectedText.add(eachFile.getText());

        }

    }



}
