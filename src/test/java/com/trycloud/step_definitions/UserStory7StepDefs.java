package com.trycloud.step_definitions;

import com.trycloud.pages.DeleteFile;
import com.trycloud.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserStory7StepDefs {

    DeleteFile deleteFile = new DeleteFile();

    @When("user clicks files module")
    public void userClicksFilesModule() {
        deleteFile.clickFileModule();
    }

    @And("user clicks on actions")
    public void userClicksOnActions() {
        deleteFile.clickActions();
    }

    @Then("selects delete file")
    public void selectsDeleteFile() {
    }
}
