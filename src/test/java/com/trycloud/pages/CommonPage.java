package com.trycloud.pages;

import com.trycloud.utility.Driver;

public class CommonPage {

    public String getPageTitle(){
       return Driver.getDriver().getTitle();
    }


}
