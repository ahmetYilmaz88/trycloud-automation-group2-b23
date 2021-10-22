package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.utility.BrowserUtil;
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
        BrowserUtil.waitFor(30);

    }

    @Then("Verify user on the {string}")
    public void verifyUserOnThe(String expectedTitle) {
        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());
    }



    @When("user enter valid username invalid password")
    public void user_enter_valid_username_invalid_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("message “Wrong username or password.” should be displayed")
    public void message_wrong_username_or_password_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}