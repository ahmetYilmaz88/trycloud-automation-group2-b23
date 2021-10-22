package com.trycloud.utility;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BrowserUtil {


    /**
     * Switches to new window by the exact title. Returns to original window if target title not found
     *
     * @param targetTitle
     */
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }


    /**
     * return a list of string from a list of elements
     *
     * @param list of webelements
     * @return list of string
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }


    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Waits for element matching the locator to be visible on the page
     *
     * @param locator
     * @param timeout
     * @return
     */
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }





    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }



    /**
     * Selects with visibleText
     *
     * @param elementDropdown
     * @param visibleText
     */
    public static void selectByVisibleText(WebElement elementDropdown, String visibleText) {
        Select dropdown = new Select(elementDropdown);
        dropdown.selectByVisibleText(visibleText);

    }

    /**
     * Checks element is displayed
     *
     * @param elements
     * @return
     */
    public static boolean elementIsDisplayed(List<WebElement> elements) {

        for (WebElement element : elements) {
            if (!element.isDisplayed()) {
                System.err.println(element.getText() + " is not displayed");
                return false;
            }
        }
        return true;
    }

    /**
     * Check Element is not Located
     *
     * @param element
     * @return
     */
    public static boolean waitForElementIsNotLocated(WebElement element) {


        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

        try {
            wait.until(ExpectedConditions.visibilityOf(element));

            return true;

        } catch (TimeoutException e) {
            System.err.println("Create Car button does not exist");
        }

        return false;
    }

    /**
     * returns random number between a to b
     *
     * @param a
     * @param b
     * @return
     */
    public static int randomNumber(int a, int b) {
        return new Faker().number().numberBetween(a, b);
    }

    public static boolean getIsCheck(List<WebElement> allCheckboxes,WebElement nextButton){

        boolean flag=true;

        String str="";

        do{

            str= Driver.getDriver().getCurrentUrl();


            for (WebElement checkbox : allCheckboxes) {
                if(!checkbox.isSelected()) {
                    flag = false;
                    break  ;
                }
            }



            nextButton.click();
            BrowserUtil.waitFor(2);

        }while(!Driver.getDriver().getCurrentUrl().equals(str));

        return flag;
    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }




    public  static Map<String ,String> createMapFromTwoListsOfWebElements(List<WebElement> keys, List<WebElement> values){
        //create a map:
        // key as column name,
        // value as cell value

        Map<String,String> rowMap = new LinkedHashMap<>();// map to put keys and values

        //how to get all header as key
        List<String> allHeaders = getElementsText(keys);// List<String> headers

        //how to get all first row and use it as value
        List<String> allFirstRow = getElementsText(values);

        //Grab first header and use it as key , get first row data and use it as value


        for (int columnIndex =0;columnIndex<allHeaders.size();columnIndex++ )
            //go through each column and add column header as key, and cell value as value
            rowMap.put(allHeaders.get(columnIndex), allFirstRow.get(columnIndex));

        return rowMap;
    }
    

}