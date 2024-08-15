package com.swathi.Project2_CURAppointment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Make_Appointment {

    @Test
    public void testMakeAppointment(){

        //    Selenium Project#2 - Mini Project
//
//    open the url - https://katalon-demo-cura.herokuapp.com/
//    click on the make appoinment button
//    verify that url changes - assert
//            time.sleep(3)
//    enter the username, password
//    next page verify the current url
//    make appoinment text on the web page.

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com");


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement buttonMakeAppointment = driver.findElement(By.id("btn-make-appointment"));
        buttonMakeAppointment.click();

        // Verify that the URL changes after clicking the "Make Appointment" button
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");


//  <a id="btn-make-appointment" href="./profile.php#login" class="btn btn-dark btn-lg">Make Appointment</a>
//  <input type="text" class="form-control" id="txt-username" name="username" placeholder="Username" value="" autocomplete="off">
//  <input type="password" class="form-control" id="txt-password" name="password" placeholder="Password" value="" autocomplete="off">
//  <button id="btn-login" type="submit" class="btn btn-default">Login</button>
//  <h2>Make Appointment</h2>

        WebElement emailInputBox = driver.findElement(By.id("txt-username"));
        emailInputBox.sendKeys("John Doe");

        WebElement passwordInputBox = driver.findElement(By.id("txt-password"));
        passwordInputBox.sendKeys("ThisIsNotAPassword");

        WebElement buttonLogin = driver.findElement(By.id("btn-login"));
        buttonLogin.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
        Assert.assertEquals("Make Appointment","Make Appointment");
        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();



    }

}
