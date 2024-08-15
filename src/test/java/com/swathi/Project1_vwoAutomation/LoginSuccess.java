package com.swathi.Project1_vwoAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class LoginSuccess {

    public void testVwoLoginPositive(){

        /*
    Selenium Project #1

            [Assignment] - Automating the Login Page of VWO.com
    Fetch the locators - https://app.vwo.com/
    Create a Maven project and add TestNG.
    Add the Allure Report (Allure TestNG)
    Automate the two Test cases of VWO.com
    Valid Username and Valid Password
    Verify name on dashboard page.
    Run them and share results.
    Push the code to github.com
    Git repo - ReadMe.md a Screen shot of allure.
    */

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

         //locators
//  <input type="email" class="text-input W(100%)" name="username" id="login-username" data-qa="hocewoqisi" data-gtm-form-interact-field-id="0">
        WebElement validUsername = driver.findElement(By.id("login-username"));
        validUsername.sendKeys("gyan2024@1secmail.com");


//  <input type="password" class="text-input W(100%)" name="password" id="login-password" data-qa="jobodapuxe" data-gtm-form-interact-field-id="1">
        WebElement validPassword = driver.findElement(By.id("login-password"));
        validPassword.sendKeys("App*vwo2024");

//  <button type="submit" id="js-login-btn" class="btn btn--positive btn--inverted W(100%) H(48px) Fz(16px)" onclick="login.login(event)" data-qa="sibequkica">
//									<span class="icon loader hidden" data-qa="zuyezasugu"></span>
//									<span data-qa="ezazsuguuy">Sign in</span>
//								</button>
        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Locate the element using its class name and extract the text
        String TextDashBoard = driver.findElement(By.className("page-sub-title")).getText();
        System.out.println("Dashboard Text: " + TextDashBoard);

// Check if the extracted text contains the expected substring "Ved Vyas"
        if(TextDashBoard.contains("Ved Vyas")){
            System.out.println("Test case Passed");
        } else {
            System.out.println("Test case Failed");
        }


        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();


    }





}
