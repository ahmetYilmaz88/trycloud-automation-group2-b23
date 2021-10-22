package com.trycloud.pages;

import com.trycloud.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TalksModuleAccessPage {

    public TalksModuleAccessPage(){ PageFactory.initElements(Driver.getDriver(), this); }

    @FindBy(xpath = "//*[@id='appmenu']/li[5]/a ")
    public WebElement talksTab;

    @FindBy(xpath = "//*[@id='app-navigation-vue']/div[1]/form/input")
    public WebElement searchBar;

    @FindBy(xpath = "//*[@id='app-content-vue']/div/div[2]/div[3]/div/form/div[3]/div/div")
    public WebElement messageBar;

    @FindBy(xpath = "//*[@id='conversation_sedm7j8z']/div[2]/div[1]/span[1]")
    public WebElement daisyClick;

    @FindBy(xpath = "//*[@id='message_2237']/div/div[1]/div")
    public WebElement messageDisplay;


}

