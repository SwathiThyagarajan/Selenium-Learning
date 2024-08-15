package com.swathi.ex_13July;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab313 {

    @Test
    public void testVwoLoginNegative() {


        //        **Project #1 - TC ( Negative) - Invalid username, pass - Error message**
//
//        1. Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
//        2. **Find the Email id** and enter the email as admin@admin.com
//        3. **Find the pass inputbox** and enter passwrod as admin.
//        4. Find and Click on the submit button
//        5. Verify that the error message is shown "Your email, password, IP address or location did not match"
//


/*   In VWO Login page the no. of elements present are
   1. Enter email address box  -> this is an Input Box
   2. Enter password box  -> this is an Input Box
   3. click on sign in box -> this is a Button
   when u enter invalid login ID and password and click on sign in now u will have 4 elements
   1. ERROR MESSAGE BOX -> your email ID, password, IP address or location did not match
   2.Enter email address box
   3. Enter password box
   4. click on sign in box

   we have 1 verification text, 2 Input box and 1 button

   every html element always has some kind of attribute or behaviour

*/


        // How to find the Element

        // this is what u will find in Inspect - element tab.
        // when u hover-hover on the email ID box it will show the input elements in network tab

        // email ID
        // <input
        // type="email"
        // class="text-input W(100%)"
        // name="username"
        // id="login-username"
        // data-qa="hocewoqisi"
        // > --> this is end of input box
// above is an input box with 5 elements

        //    <input type="password" class="text-input W(100%)" name="password" id="login-password" data-qa="jobodapuxe" data-gtm-form-interact-field-id="2">

//   <button type="submit" id="js-login-btn" class="btn btn--positive btn--inverted W(100%) H(48px) Fz(16px)" onclick="login.login(event)" data-qa="sibequkica">
//									<span class="icon loader hidden" data-qa="zuyezasugu"></span>
//									<span data-qa="ezazsuguuy">Sign in</span>
//								</button>

//  <div class="notification-box-description" id="js-notification-box-msg" data-qa="rixawilomi">Your email, password, IP address or location did not match</div>

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");


        // **Find the Email id** and enter the email as admin@admin.com
        WebDriver driver = new EdgeDriver(options);
        driver.get("https://app.vwo.com");// open the website
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());// printing the title of the page
        Assert.assertEquals(driver.getTitle(), "Login - VWO");// I can add some assertions also
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        // checking my current URL while doing login function

        // the above will give u web element, web element is also a class
        WebElement emailInputBox = driver.findElement(By.id("login-username"));// By is a class in selenium
        // Next what I want to do after getting the element, u can click on the element, using send keys u can send data
        emailInputBox.sendKeys("admin@admin.com"); // send keys function will help to send something

        WebElement passwordInputBox = driver.findElement(By.id("login-password"));
        passwordInputBox.sendKeys("admin");

        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click(); // I must select click

        // when u do the above steps in login page there is a 3 secs delay so add a Thread.sleep and verify the error message
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Verify the error messsage
  //      WebElement errorMessage  = driver.findElement(By.id("js-notification-box-msg"));
         WebElement errorMessage = driver.findElement(By.className("notification-box-description")); // I can use class name also in BY. function
         Assert.assertEquals(errorMessage.getText(),"Your email, password, IP address or location did not match");
         // now I want to assert the error message


        // we are using Thread.sleep so, we can see the results if not it will immediately quit
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}
