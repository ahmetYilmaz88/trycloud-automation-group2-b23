package com.trycloud.step_definitions;

import com.trycloud.pages.UserStory03Page;
import com.trycloud.utility.BrowserUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserStory3StepDefs {


    UserStory03Page userStory03Page = new UserStory03Page();

    @Given("user is at the dashboard page")
    public void user_is_at_the_dashboard_page() {
        userStory03Page.goTo();
        userStory03Page.enterCredentials("User32","Userpass123");
        userStory03Page.login();
    }

    @When("user click the files module")
    public void user_click_the_files_module() {
        userStory03Page.clickFiles();
    }

    @Then("page title should be “Files - Trycloud”")
    public void page_title_should_be_files_trycloud() {

        String expectedTitle= "Files - Trycloud";
        String actualTitle= userStory03Page.getTitle();

        assertEquals(expectedTitle,actualTitle);
    }

    @Given("user is at the Trycloud page")
    public void user_is_at_the_trycloud_page() {
        userStory03Page.goTo();
        userStory03Page.enterCredentials("User32","Userpass123");
        userStory03Page.login();
        userStory03Page.clickFiles();
        BrowserUtil.waitFor(3);
    }

    @When("user click the checkbox of the table")
    public void user_click_the_checkbox_of_the_table() {
        userStory03Page.checkAllCheckBoxes();
        BrowserUtil.waitFor(3);
    }

    @Then("all the files should be selected")
    public void all_the_files_should_be_selected() {

        assertTrue(userStory03Page.getIsCheck() );
        BrowserUtil.waitFor(2);

  /**   System.out.println("userStory03Page.getIsCheck() = "+ userStory03Page.getIsCheck());  */

    }




}


