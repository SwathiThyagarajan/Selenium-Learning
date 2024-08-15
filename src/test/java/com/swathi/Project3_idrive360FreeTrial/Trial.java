package com.swathi.Project3_idrive360FreeTrial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Trial {
@Test
    public void testTrialExpired(){

//        Selenium Mini Project #3
//
//        Open the URL - https://www.idrive360.com/enterprise/login
//        Enter the username, password
//        Verify that Trial is fnished and current URL also
//        Add a logic to add Allure Screen for the Trail end.



    //    <input _ngcontent-evd-c4="" autofocus="" class="id-form-ctrl ng-valid ng-dirty ng-touched" id="username" name="username" type="email">
//  <input _ngcontent-mia-c4="" class="id-form-ctrl ng-valid ng-dirty ng-touched" id="password" maxlength="20" name="password" tabindex="0" type="password">
//  <button _ngcontent-mia-c4="" class="id-btn id-info-btn-frm" id="frm-btn" type="submit">Sign in</button>

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.idrive360.com/enterprise/login");


    WebElement emailInputBox = driver.findElement(By.id("username"));
    emailInputBox.sendKeys("augtest_040823@idrive.com");

    WebElement passwordInputBox = driver.findElement(By.id("password"));
    passwordInputBox.sendKeys("123456");

    WebElement buttonSignIn = driver.findElement(By.id("frm-btn"));
    buttonSignIn.click();
    Assert.assertEquals("Your free trial has expired","Your free trial has expired");
    Assert.assertEquals(driver.getCurrentUrl(),"https://www.idrive360.com/enterprise/login");

    try {
        Thread.sleep(15000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

    driver.quit();


}
}
