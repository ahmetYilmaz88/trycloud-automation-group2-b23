package com.trycloud.pages;



import com.trycloud.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllModulesPage {
//bgf
    public AllModulesPage(){ PageFactory.initElements(Driver.getDriver(), this); }

    @FindBy(xpath = "//li[ @tabindex='-1']")
    public List<WebElement> allModules;

}

