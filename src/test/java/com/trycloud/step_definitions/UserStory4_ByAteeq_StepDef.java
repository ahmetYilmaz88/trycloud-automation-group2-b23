package com.trycloud.step_definitions;


import com.trycloud.pages.UserStory4_byAteeq_FilesPage;
import com.trycloud.utility.BrowserUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class UserStory4_ByAteeq_StepDef {

    UserStory4_byAteeq_FilesPage files = new UserStory4_byAteeq_FilesPage();
    List<String> actualText;
    List<String> expectedText;

    @Given("I login as a user5")
    public void i_login_as_a_user() {

        files.goTo();
        BrowserUtil.waitFor(4);
        files.usernameBox.sendKeys("user2");
        files.passwordBox.sendKeys("Userpass123");
        BrowserUtil.waitFor(1);
        files.loginBtn.click();

    }

    @When("I click action-icon from any file on the page")
    public void i_click_action_icon_from_any_file_on_the_page() {

        files.filesTab.click();
        BrowserUtil.waitFor(3);
        files.clickOnEachFileOption();
    }

    @When("choose Add to Favorite option")
    public void choose_option() {

       BrowserUtil.waitFor(2);
        actualText = new ArrayList<>();
        files.addToFavorite_And_getTextOfAddToFav(actualText);
        System.out.println("actualText = " + actualText);

    }

    @When("click Favorites sub-module on the list side")
    public void click_sub_module_on_the_list_side() {

        files.favoritesTab.click();
        BrowserUtil.waitFor(2);

    }

    @Then("verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {

        expectedText = new ArrayList<>();
        files.addedToFavListText(expectedText);
        System.out.println("expectedText = " + expectedText);


        for (String eachFile : expectedText) {
            assertTrue( actualText.get(0).equals( eachFile) || actualText.get(1).equals(eachFile) );


        }
        System.out.println("User Story 4 Passed!");
    }

}




