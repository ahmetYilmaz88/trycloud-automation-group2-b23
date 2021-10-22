package com.trycloud.step_definitions;

import com.trycloud.pages.CommonPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utility.ConfigReader;
import com.trycloud.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class UserStory1StepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("user Navigate to login page")
    public void user_navigate_to_login_page() {
        loginPage.goTo();

    }

    @When("user enter valid {string} and {string}")
    public void userEnterValidAnd(String username, String password) {

        loginPage.enterCredentials(username,password);
    }

    @When("click login button")
    public void click_login_button() {
       loginPage.login();

    }

    @Then("Verify user on the {string}")
    public void verifyUserOnThe(String expectedTitle) {
        String actualPageTitle = new CommonPage().getPageTitle();
        Assert.assertEquals(expectedTitle,actualPageTitle);
    }


    @When("user enter valid {string} invalid {string}")
    public void userEnterInvalidInvalid(String username, String invalidPassword) {
        loginPage.enterInvalidCredentials(username,invalidPassword);

    }


    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String expectedMsg) {

        Assert.assertEquals(expectedMsg,loginPage.displayWarningMsg());

    }
}
