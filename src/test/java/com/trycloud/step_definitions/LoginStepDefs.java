package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.utility.Driver;
import com.trycloud.utility.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();

    @When("Navigate to login page")
    public void navigate_to_login_page() {
        loginPage.goTo();
    }
    @When("Enter valid username and password")
    public void enter_valid_username_and_password() {
        loginPage.login(4);
    }
    @When("Click login button")
    public void click_login_button() {
        loginPage.loginBtn.click();
    }
    @Then("Verify user on the dashboard")
    public void verify_user_on_the_dashboard() {
        assertEquals("Dashboard - Trycloud", Driver.getDriver().getTitle());
    }

}