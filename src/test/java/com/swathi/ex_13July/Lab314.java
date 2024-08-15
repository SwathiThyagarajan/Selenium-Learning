package com.swathi.ex_13July;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab314 {


    @Test
    public void testVwoLoginNegative() {
        //        **Project #1 - TC ( Negative) - Invalid username, pass - Error message**
//
//        1. Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
//        2. **Find the Email id** and enter the email as admin@admin.com
//        3. **Find the pass inputbox** and enter passwrod as admin123.
//        4. Find and Click on the submit button
//        5. Verify that the error message is shown "Your email, password, IP address or location did not match"

/*   I have copy pasted all these from Elements Tab from app.vwo screen
     <input type="email" class="text-input W(100%)" name="username" id="login-username" data-qa="hocewoqisi" data-gtm-form-interact-field-id="0">
    <input type="password" class="text-input W(100%)" name="password" id="login-password" data-qa="jobodapuxe" data-gtm-form-interact-field-id="1">
    <button type="submit" id="js-login-btn" class="btn btn--positive btn--inverted W(100%) H(48px) Fz(16px)" onclick="login.login(event)" data-qa="sibequkica">
									<span class="icon loader hidden" data-qa="zuyezasugu"></span>
									<span data-qa="ezazsuguuy">Sign in</span>
								</button>
	<div class="notification-box-description" id="js-notification-box-msg" data-qa="rixawilomi">Your email, password, IP address or location did not match</div>



 */

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

        WebElement passwordInputBox = driver.findElement(By.id("login-password"));
        passwordInputBox.sendKeys("admin123");

        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement errorMessage = driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(errorMessage.getText(),"Your email, password, IP address or location did not match");


        // after verification, I want to test another element also in app.vwo.com -> start a free trial
//  <a href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
//  class="text-link" data-qa="bericafeqo">Start a free trial</a>
      //  Start a free trial --> this is the link text

        // here there is no id and name then how to test the element?
        // ctrl+f on class name in inspect-> element tab and try to find it.
        // If u try to find text link You can see there are more than 6 elements
        // so class is also not unique, we do not have class and id also
        // In such cases we must use link text and partial link text.
        // But this only works with -> a tag/ anchor tag

//        WebElement freeTrialLink = driver.findElement(By.linkText("Start a free trial"));
        // when you are not able to find the full link text you can use partial link text
        WebElement freeTrialLink = driver.findElement(By.partialLinkText("Start a free"));
        freeTrialLink.click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        driver.quit();


    }
}
