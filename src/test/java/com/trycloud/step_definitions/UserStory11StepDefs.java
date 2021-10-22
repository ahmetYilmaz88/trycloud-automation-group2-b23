package com.trycloud.step_definitions;

import com.trycloud.pages.FileModuleAccessPage;
import com.trycloud.pages.TalksModuleAccessPage;
import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import static org.junit.Assert.assertEquals;

public class UserStory11StepDefs {

    TalksModuleAccessPage talksModule = new TalksModuleAccessPage();


    @When("user click on Talks module")
    public void user_click_on_talks_module() {
        talksModule.talksTab.click();
    }
    @Then("Verify the page title is Talks module’s title")
    public void verify_the_page_title_is_talks_module_s_title() {
        String expectedResult = "Talk - Trycloud";
        assertEquals(expectedResult, Driver.getDriver().getTitle());
    }


    @When("user search a user from search box")
    public void user_search_a_user_from_search_box() {
        talksModule.searchBar.sendKeys("Daisy");
        talksModule.daisyClick.click();
    }

    @When("user write a message")
    public void user_write_a_message() {
        talksModule.messageBar.sendKeys("new message");
        BrowserUtil.waitFor(2);
    }

    @When("user click the submit button")
    public void user_click_the_submit_button() {
        talksModule.messageBar.sendKeys(Keys.ENTER);
    }

    @Then("Verify the message is displayed on the conversation log")
    public void verify_the_message_is_displayed_on_the_conversation_log() {
        String expectedResult = "new message";
        String actualResult = talksModule.messageDisplay.getText();

        assertEquals(expectedResult,actualResult);
    }


}
