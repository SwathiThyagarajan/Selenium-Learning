package com.swathi.ex_23July;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab330_SVG {

/*
Problem # Flipkart.com

1. Go to ->  www.flipkart.com/
2. Click on Electronics > PowerBank > PowerBank > Click on the High to LOW
3. Print the title of first Highest Price PowerBank

*/

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(edgeOptions);

    }

    @Test(groups = "QA")
    @Description(" Testcase Description ")
    public void testVerifySVG() {
        driver.navigate().to("https://www.flipkart.com/");

        WebElement electronicsMenu = driver.findElement(By.xpath("//*[text()='Electronics']"));
        electronicsMenu.click();

        WebElement powerBankLink = driver.findElement(By.xpath("//a[text()='Powerbank']"));
        powerBankLink.click();
//  The XPath expression //a[text()='Powerbank'] is designed
//  to select an <a> (anchor) element that has the exact text content "Powerbank".


        WebElement highToLowOption = driver.findElement(By.xpath("//*[text()='Price -- High to Low']"));
        highToLowOption.click();


        // 4. Print the title of the first highest priced PowerBank
        WebElement firstHighestPricePowerBank =driver.findElement(By.xpath("//a[@title='Ambrane 90000 mAh 300 W Power Bank']"));
        // or        //(By.xpath("(//a[@class='_1fQZEK'])[1]//div[@class='_4rR01T']")));
        String powerBankTitle = firstHighestPricePowerBank.getText();
        System.out.println("Title of the first highest priced PowerBank: " + powerBankTitle);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(firstHighestPricePowerBank));



//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement electronicsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Electronics']")));
//        electronicsMenu.click();
//
//        WebElement powerBankLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Powerbank']")));
//        powerBankLink.click();
//
//        WebElement highToLowOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Price -- High to Low']")));
//        highToLowOption.click();
//
//        // Wait for the first highest priced PowerBank element to be visible
//        WebElement firstHighestPricePowerBank = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='_1fQZEK'])[1]//div[@class='_4rR01T']")));
//        String powerBankTitle = firstHighestPricePowerBank.getText();
//        System.out.println("Title of the first highest priced PowerBank: " + powerBankTitle);



    }

    @AfterTest
    public void closeBrowser() {

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();


    }
}