package com.trycloud.step_definitions;

import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.ConfigReader;
import com.trycloud.utility.Driver;
import com.trycloud.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.logging.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    // we can set up hook class that contains
    //methods that run before each scenario and after each scenario
    //or even when we learn tags

    @Before
    public void setupDriver() {

        // set up implicit wait
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // you can add maximize browser if you want to do it
        // Driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {

        // check if scenario failed or not
        if(scenario.isFailed()){
            //this is how we take screenshot in selenium
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","what ever we want");

        }

        Driver.closeBrowser();
    }
}




//package com.trycloud.step_definitions;
//import com.trycloud.utility.Driver;
//import com.trycloud.utility.Driver;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//import java.util.concurrent.TimeUnit;
//
//public class Hooks {
//    //
//    @Before("@ui")
//    public void setUpDriver(){
//        System.out.println("This is from @Before inside Hook class");
//        // set up implicit wait
//        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }
//
//
//
//    @After("@ui")
//    public void tearDown(Scenario scenario){
//        System.out.println("THIS IS FROM @After inside Hooks class");
//
//        if(scenario.isFailed()){
//            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver() ;
//            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
//            // this is the line to attach screenshot to scenario
//            scenario.attach(screenshot,"image/png",scenario.getName());
//        }
//
//        Driver.closeBrowser();
//
//    }
//
//
//}
