package com.trycloud.pages;

import com.trycloud.utility.ConfigReader;
import com.trycloud.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteFile {

    @FindBy(xpath = "//a[normalize-space(.)='Files']")
    public WebElement fileImg;

    @FindBy(xpath = "//a[@class='action action-menu permanent']")
    public WebElement actions;

    @FindBy(xpath = "//a[normalize-space(.)='Delete file']")
    public WebElement deleteFile;

    public DeleteFile(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickFileModule(){
        fileImg.click();
    }

    public void clickActions(){
        actions.click();
    }

    public void clickDelete(){
        deleteFile.click();
    }

}
