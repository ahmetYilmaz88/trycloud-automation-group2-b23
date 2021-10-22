package com.trycloud.step_definitions;

import com.trycloud.pages.UserStory5_Page;
import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;


import static org.junit.Assert.*;

public class UserStory5_StepDefs {

    UserStory5_Page userPage=new UserStory5_Page();
    @Given("user at the homepage")
    public void user_at_the_homepage() {
        userPage.goTo();
        BrowserUtil.waitFor(2);
        userPage.login("User2");
        BrowserUtil.waitFor(2);
        String expectedTitle="Dashboard - Trycloud";
        String actualTitle= Driver.getDriver().getTitle().trim();

         assertEquals(expectedTitle,actualTitle);


    }



    @When("user click {string} module")
    public void user_click_module(String string) {

        userPage.clickModules(string);
        BrowserUtil.waitFor(2);

    }



    @When("user click action-icon from any file on the page")
    public void user_click_action_icon_from_any_file_on_the_page() {
     userPage.firstFileInfo();
     BrowserUtil.waitFor(2);
     userPage.firstActionBtn.click();
     BrowserUtil.waitFor(2);

    }


    @When("user click “Remove from Favorites” option")
    public void user_click_remove_from_favorites_option() {

     if(userPage.removeFromFavorite.getText().equalsIgnoreCase("Remove from favorites")){
         userPage.removeFromFavorite.click();
         BrowserUtil.waitFor(3);
     }

    }


    @Then("verify that the file is removed from Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_favorites_sub_module_s_table() {

        Assert.assertTrue(userPage.verifyingFileRemoved());

    }



    @When("user click {string} icon on the top")
    public void user_click_icon_on_the_top(String string) {
        System.out.println("Not working yet");
    }



    @Then("user click {string}")
    public void user_click(String string) {
        Actions action =new Actions(Driver.getDriver());
        String filePath="Desktop/SDET_Picture.jpeg";
        action.click(userPage.uploadFileBtn).pause(2000).sendKeys(filePath).perform();
        BrowserUtil.waitFor(5);
    }



    @When("user upload a file")
    public void user_upload_a_file() {



    }


    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {


    }



}
