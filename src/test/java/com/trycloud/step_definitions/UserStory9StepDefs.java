package com.trycloud.step_definitions;

import com.trycloud.pages.FileModuleAccessPage;
import com.trycloud.utility.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserStory9StepDefs {

    FileModuleAccessPage fileAccess = new FileModuleAccessPage();

    @When("Click action-icon from any file on the page")
    public void click_action_icon_from_any_file_on_the_page() {
        fileAccess.filesTab.click();
        BrowserUtil.waitFor(2);
        fileAccess.firstActionIcon.click();
    }
    @When("Click details")
    public void click_details() { fileAccess.detailsOption.click();

    }

    @When("Write a comment inside to the input box")
    public void write_a_comment_inside_to_the_input_box() {
        fileAccess.commentsTabView.click();
        fileAccess.newMessageBar.click();
        BrowserUtil.waitFor(2);
        fileAccess.newMessageBar.sendKeys("ahmet");
    }
    @When("Click the submit button to post it")
    public void click_the_submit_button_to_post_it() {
        fileAccess.newMessageClick.click();
    }
    @Then("Verify the comment is displayed in the comment section.")
    public void verify_the_comment_is_displayed_in_the_comment_section() {
        String expectedResult = "ahmet";
        String actualResult = fileAccess.displayMessage.getText();
        assertEquals(expectedResult,actualResult);
    }


}
