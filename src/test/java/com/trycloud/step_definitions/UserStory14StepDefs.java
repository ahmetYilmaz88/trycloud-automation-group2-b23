package com.trycloud.step_definitions;


import com.trycloud.pages.UserStory14Page;

import com.trycloud.utility.BrowserUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class UserStory14StepDefs {

   UserStory14Page userStory14Page = new UserStory14Page();

    @When("Click magnifier icon on the right top")
    public void click_magnifier_icon_on_the_right_top()  {
        // Write code here that turns the phrase above into concrete actions
     userStory14Page.magnifier_icon.click();
     BrowserUtil.waitFor(2);


    }
    @And("Search any existing file\\/folder\\/user name")
    public void search_any_existing_file_folder_user_name() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        userStory14Page.existing_user.sendKeys("Lin");
    BrowserUtil.waitFor(2);

    }
    @Then("Verify the app displays the expected result option")
    public void verify_the_app_displays_the_expected_result_option() {
        // Write code here that turns the phrase above into concrete actions
     String expectedResult = "Lin Himed";
     String actualResult = userStory14Page.verifying_existingUser.getText();

     assertEquals(expectedResult,actualResult);

    }
}
