package com.trycloud.step_definitions;

import com.trycloud.pages.UserStory5_Page;
import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UserStory5_StepDef {

   // UserStory5_Page_realOne userPage=new UserStory5_Page_realOne();
    UserStory5_Page userPage =new UserStory5_Page();
    String fileInfo;

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


    int beforeFavNumbers;

    @When("user click action-icon from any file on the page")
    public void user_click_action_icon_from_any_file_on_the_page() {

        beforeFavNumbers= userPage.allFavoriteFiles.size();
        BrowserUtil.waitFor(2);
        int random =BrowserUtil.randomNumber(1,userPage.allFavoriteFiles.size());
       // System.out.println(userPage.allFavoriteFiles.size());
        WebElement sixActionBtn=Driver.getDriver().findElement(By.xpath("//tbody/tr["+random+"]/td[2]/a//span[2]/a[@data-action='menu']"));

        sixActionBtn.click();
        BrowserUtil.waitFor(3);


    }


    @When("user click “Remove from Favorites” option")
    public void user_click_remove_from_favorites_option() {

        userPage.favoriteBtn.click();
        BrowserUtil.waitFor(4);


    }


    @Then("verify that the file is removed from Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_favorites_sub_module_s_table() {

        userPage.favoritesModule.click();
        BrowserUtil.waitFor(3);
        int actualFavNums= userPage.allFavoriteFiles.size();
        Assert.assertTrue(beforeFavNumbers >actualFavNums);


    }



    @When("user click {string} icon on the top")
    public void user_click_icon_on_the_top(String string) {
        userPage.plusFileBtn.click();
        BrowserUtil.waitFor(2);

    }




    @When("user upload a file")
    public void user_upload_a_file() {

        String filePath="/Users/feruzajonzokova/Desktop/Java_Image.png";
        fileInfo="Java_Image.png";

        BrowserUtil.waitFor(4);
        userPage.uploadFile.sendKeys(filePath);
        BrowserUtil.waitFor(5);

    }


    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        Assert.assertTrue(userPage.VerifyFolder(fileInfo));


    }


}
