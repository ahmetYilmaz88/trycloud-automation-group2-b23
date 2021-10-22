package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPageUS9And11;
import com.trycloud.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class LoginStepDefsUS9And11 {
    LoginPageUS9And11 loginPageUS9And11 = new LoginPageUS9And11();

    @When("Navigate to login page")
    public void navigate_to_login_page() {
        loginPageUS9And11.goTo();
    }
    @When("Enter valid username and password")
    public void enter_valid_username_and_password() {
        loginPageUS9And11.login(4);
    }
    @When("Click login button")
    public void click_login_button() {
        loginPageUS9And11.loginBtn.click();
    }
    @Then("Verify user on the dashboard")
    public void verify_user_on_the_dashboard() {
        assertEquals("Dashboard - Trycloud", Driver.getDriver().getTitle());
    }

}
