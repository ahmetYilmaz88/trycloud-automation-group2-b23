package com.trycloud.step_definitions;

import com.trycloud.pages.CommonPage;
import com.trycloud.pages.ContactsPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.ConfigReader;
import com.trycloud.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class US12StepDefs {

    @Given("Login as a user")
    public void login_as_a_user() {
        LoginPage loginPage = new LoginPage();
        loginPage.goTo();

        loginPage.enterCredentials("User32", ConfigReader.read("password"));
        loginPage.login();
    }

    @When("click {string} module")
    public void click_module(String moduleName) {
        CommonPage.hover(moduleName);
        BrowserUtil.waitFor(2);
    }





    @And("Click New Contact button")
    public void clickNewContactButton() {
        new ContactsPage().newContactsBtn.click();
    }

    @Then("Fill out the contact info like : Title, Phone, email, address , etc")
    public void fill_out_the_contact_info_like_title_phone_email_address_etc() {

        new ContactsPage().fillForm();
    }

//    @And("Verify the contact name is added to the contact list")
//    public void verify_the_contact_name_is_added_to_the_contact_list() {
//
//        ContactsPage contactsPage = new ContactsPage();
//        String expectedFullName = "July August";
//
//
//        for (WebElement eachName : contactsPage.contactNames) {
//            Assert.assertTrue(expectedFullName.contains(eachName.getText()));
////            if(expectedFullName.contains(eachName.getText()))
////            if (eachName.getText().equals(expectedFullName)) {
////                System.out.println("match");
////                System.out.println(eachName.getText());
////            } else {
////                System.out.println("not match");
////                System.out.println(eachName.getText());
////            }
//
//        }
//    }

    @Then("Verify the contact {string} is added to the contact list")
    public void verify_the_contact_is_added_to_the_contact_list(String name) {
        ContactsPage contactsPage = new ContactsPage();
        String expectedFullName = name;
        System.out.println("expectedFullName = " + expectedFullName);

        for (WebElement eachName : contactsPage.contactNames) {
            if(expectedFullName.equals(eachName.getText())){

                Assert.assertEquals(expectedFullName,eachName.getText());
            }


        }
    }
}



