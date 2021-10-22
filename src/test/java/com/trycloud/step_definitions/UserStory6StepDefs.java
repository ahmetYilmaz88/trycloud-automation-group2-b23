package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.pages.UserStory6Page_Aykut;
import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserStory6StepDefs {
    UserStory6Page_Aykut userStory6Page_aykut=new UserStory6Page_Aykut();

    @Given("User is at the home page")
    public void user_is_at_the_home_page() {
        LoginPage loginPage=new LoginPage();
        loginPage.goTo();
    }
    @When("login as a user")
    public void login_as_a_user() {

        userStory6Page_aykut.login(ConfigReader.read("userName1"),ConfigReader.read("password"));
    }
    @When("click the “+” icon on top")
    public void click_the_icon_on_top() {

        userStory6Page_aykut.fileBtn.click();

        BrowserUtil.waitFor(3);
    }
    @When("click “New Folder”")
    public void click_new_folder() {

        userStory6Page_aykut.addBtn.click();
        userStory6Page_aykut.createNewFolder.click();

    }
    @Then("write a folder name click and verify the folder is displayed on the page")
    public void write_a_folder_name_click_and_verify_the_folder_is_displayed_on_the_page() {

        Assert.assertTrue(userStory6Page_aykut.VerifyFolder("taktikmaktikyokBAMBAMBAM"));

    }
    @When("click upload file")
    public void click_upload_file() {

        userStory6Page_aykut.anyFile.click();
    }
    @Then("upload and verify file")
    public void upload_and_verify_file() {


        userStory6Page_aykut.VerifyFile("1.PNG");

    }

}
