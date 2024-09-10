package com.swathi.ex_23July_Actions_Class;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionClass2 {

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
    public void testVerifySpiceJet(){
        driver.navigate().to("https://www.spicejet.com/");

        // I want to click on from InputBox in the website
        // this is the web element
        // <input autocapitalize="sentences" autocomplete="on" autocorrect="on"
        // class="css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu" dir="auto" spellcheck="false"
        // type="text" data-focusable="true" value="Delhi (DEL)" style="font-family: inherit;
        // text-overflow: ellipsis;">
        // I cannot use above as xpath because here value="Delhi (DEL)" this will be changing
        // based on the location
        // so, I can go up and find the data-testid="to-testID-origin"
        // under this div only from inputBox is there. it is a custom attribute

        // 1st go to --> //div[@data-testid="to-testID-origin"]
        // 2nd in that go to div
        // 3rd go to another div inside it
        // 4th go to input
        // xpath -->  //div[@data-testid="to-testID-origin"]/div/div/input

        WebElement FromPlace = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/input"));
//        source.sendKeys();// u cannot directly send the keys here we need to use actions
        Actions actions = new Actions(driver);
        actions.moveToElement(FromPlace).click().build().perform();
        actions.moveToElement(FromPlace).click().sendKeys("BLR").build().perform();

        WebElement destination = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-destination\"]/div/div//input"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(destination).click().build().perform();
        actions1.moveToElement(destination).sendKeys("DEL").build().perform();
}

    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}