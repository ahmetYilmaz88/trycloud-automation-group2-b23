package com.trycloud.pages;

import com.github.javafaker.Faker;
import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactsPage {

    public ContactsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[contains(normalize-space(.),'New contact')]")
    public WebElement newContactsBtn;

    @FindBy(xpath = "//span[@title='All contacts']")
    public WebElement allContacts;

    @FindBy(xpath = "//input[@id='contact-fullname']")
    public WebElement fullNameBox;

    @FindBy(xpath = "//input[@inputmode='tel'][@type='text']")
    public WebElement phoneInput;

    @FindBy(xpath = "//input[@inputmode='email'][@type='text']")
    public WebElement emailInput;

    @FindBy(xpath = "(//div[@class='property__label'])[1]")
    public WebElement postOfficeBox;

//    @FindBy(xpath = "(//div[@class='property__label'])[2]")
//    public WebElement addressBox;

    @FindBy(xpath = "(//div[@class='property__label'])[4]")
    public WebElement postalCodeBox;

    @FindBy(xpath = "(//div[@class='property__label'])[5]")
    public WebElement cityBox;

    @FindBy(xpath = "(//div[@class='property__label'])[6]")
    public WebElement stateBox;

    @FindBy(xpath = "(//div[@class='property__label'])[7]")
    public WebElement countryBox;

    @FindBy(xpath = "//div[@class='app-content-list-item-line-one']")
    public List<WebElement> contactNames;






    public void fillForm() {
        Faker faker=new Faker();

        fullNameBox.click();
        fullNameBox.sendKeys("July November");
        BrowserUtil.waitFor(3);
        phoneInput.sendKeys(faker.phoneNumber().cellPhone());
        emailInput.sendKeys(faker.internet().emailAddress());
        BrowserUtil.waitFor(3);

    }






}
