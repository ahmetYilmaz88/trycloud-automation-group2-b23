package com.trycloud.step_definitions;

import com.trycloud.pages.UserStory10_Page;
import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserStory10_StepDefs {

    UserStory10_Page userPage =new UserStory10_Page();
    String fileInfo;
    String storage1;
    String storage2;


    @Given("user on the login page")
    public void user_at_the_loginpage(){

        BrowserUtil.waitFor(2);
        BrowserUtil.waitFor(2);
        String expectedTitle="Dashboard - Trycloud";
        String actualTitle= Driver.getDriver().getTitle().trim();

        assertEquals(expectedTitle,actualTitle);

    }
    @When("User click file module")
    public void userClickFileModule() {

        userPage.filesModule.click();
    }




    @When("Click Settings on the left bottom corner")
    public void click_settings_on_the_left_bottom_corner() {
        userPage.settingModule.click();
    }

    @Then("Verify user can click any checkboxes") //Verify user can click any checkboxes
    public void verify_user_can_click_any_checkboxes() {
        for (WebElement anyButton : userPage.anyButtons) {
            if(anyButton.isSelected()){
                anyButton.click();
                assertTrue(anyButton.isSelected());
                BrowserUtil.waitFor(2);
            }
        }
    }

    @When("Check the current storage usage")
    public void check_the_current_storage_usage() {
        storage1 = userPage.storageUsage.getText().substring(0,userPage.storageUsage.getText().indexOf(" "));
    }




    @When("Upload a file")
    public void upload_a_file() {
        userPage.addFiles.click();

        String filePath = "/Users/ahmetyilmaz/Desktop/InterviewPrep.pdf";


        BrowserUtil.waitFor(4);
        userPage.uploadFiles.sendKeys(filePath);
        BrowserUtil.waitFor(2);
        if(userPage.fileConflict.isDisplayed()){
            BrowserUtil.waitFor(2);
            userPage.newFileCheckBox.click();
            BrowserUtil.waitFor(2);
            userPage.continueBtn.click();
        }


        BrowserUtil.waitFor(5);

    }
    @When("Refresh the page")
    public void refresh_the_page() {
        Driver.getDriver().getCurrentUrl();
        Driver.getDriver().navigate().refresh();

    }
    @Then("Verify the storage usage is increased")
    public void verify_the_storage_usage_is_increased() {
        storage2 = userPage.storageUsage.getText().substring(0,userPage.storageUsage.getText().indexOf(" "));

        BrowserUtil.waitFor(10);
        assertTrue(Integer.parseInt(storage1) < Integer.parseInt(storage2));
        BrowserUtil.waitFor(10);
    }
}