package com.trycloud.pages;

import com.trycloud.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileModuleAccessPage {

    public FileModuleAccessPage(){ PageFactory.initElements(Driver.getDriver(), this); }

    @FindBy(xpath = "//*[@id='appmenu']/li[2]")
    public WebElement filesTab;

    @FindBy(xpath = "(//span/a[@class='action action-menu permanent'])[1]")
    public WebElement firstActionIcon;

    @FindBy(xpath = "//span[.='Details']")
    public WebElement detailsOption;

    @FindBy(xpath = "//*[@id='commentsTabView']/span")
    public WebElement commentsTabView;

    @FindBy(xpath = "//*[@id='commentsTabView']/div[1]/form/div[1]")
    public WebElement newMessageBar;

    @FindBy(xpath = "//*[@id='commentsTabView']/div[1]/form/input")
    public WebElement newMessageClick;


    @FindBy(xpath = "//*[@id='commentsTabView']/div[1]/form/div[1]")
    public WebElement displayMessage;
}
