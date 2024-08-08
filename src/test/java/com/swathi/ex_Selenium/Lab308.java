package com.swathi.ex_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab308 {


    @Test
    public void testVWOLoginTitle(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        //driver.get("app.vwo.com"); // http mandatory if not it will not work
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");

        driver.quit();// always do quit in last


    }
}
