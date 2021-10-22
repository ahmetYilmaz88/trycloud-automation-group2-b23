package com.trycloud.pages;

import com.trycloud.utility.ConfigReader;
import com.trycloud.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserStory14Page {

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div[1]/a/span")
    public WebElement magnifier_icon;


    @FindBy(xpath = "//*[@id=\"header-menu-unified-search\"]/div[2]/div/form/input[1]")
    public WebElement existing_user;

    @FindBy(xpath = "//*[@id=\"header-menu-unified-search\"]/div[2]/ul/li[1]/a/span/h3/span")
    public WebElement verifying_existingUser;

    public UserStory14Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

public void goTo(){
        Driver.getDriver().get(ConfigReader.read("url")    );
}





}
