package com.trycloud.pages;

import com.trycloud.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {


    public CommonPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"appmenu\"]/li//span")
    public List<WebElement> allModuleNames;

    @FindBy(xpath = "//*[@id=\"appmenu\"]/li//span")
    public List<WebElement> allModules;

    public void clickModule(String moduleName) {

        Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//span[normalize-space(.)='"+moduleName+"']/.."));
    }

    public static void hover(String moduleName) {
        WebElement module = Driver.getDriver().findElement(By.xpath("//*[@id=\"appmenu\"]/li//span[normalize-space(.)='"+moduleName+"']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(module).click().perform();

    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).click().perform();
    }




    public String getPageTitle(){
       return Driver.getDriver().getTitle();
    }








}
