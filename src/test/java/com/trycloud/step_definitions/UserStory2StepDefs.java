package com.trycloud.step_definitions;
import com.trycloud.pages.LoginPage;
import com.trycloud.pages.AllModulesPage;
import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserStory2StepDefs {

    AllModulesPage accessAllModules = new AllModulesPage();
    @Then("Verify the user see the following modules")
    public void verify_the_user_see_the_following_modules(List<String> expectedModuleName) {
        List<String> actualModuleName = new ArrayList<>();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(accessAllModules.allModules.get(0)).perform();
        actualModuleName = (BrowserUtil.getElementsText(accessAllModules.allModules));
        assertEquals(expectedModuleName,actualModuleName);

    }

}
