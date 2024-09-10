package com.swathi.ex_23July_Actions_Class;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class actionsClass6 {

    WebDriver driver;


    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        //    edgeOptions.addArguments("--start-maximized");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(edgeOptions);

    }


    @Test(groups = "QA")
    @Description(" Testcase Description ")
    public void testDragAndDrop(){

        driver.navigate().to("https://the-internet.herokuapp.com/drag_and_drop");
        //        driver.manage().window().maximize();

        //    Drag And Drop is a pre-built function in actions class

        Actions actions = new Actions(driver);

        WebElement dragFrom = driver.findElement(By.id("column-a"));
        WebElement dropTo = driver.findElement(By.id("column-b"));

        // This is one way of doing DragAndDrop
//        actions .dragAndDrop(dragFrom,dropTo).perform();

        // here in DragAndDrop no need to use .build()..perform() you can directly use .perform()
        // because .perform() behind the scene does .build().perform();

        // 2 nd way of doing DragAndDrop
        actions.clickAndHold(dragFrom).moveToElement(dropTo).release(dropTo).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // File upload option -- Interview Question
//  Selenium can handle the file uploading only if the element is an inputBox with type="file"
//  any other type of file selenium cannot handle

        driver.navigate().to("https://awesomeqa.com/selenium/upload.html");
        WebElement uploadFileInputBox = driver.findElement(By.id("fileToUpload"));
//        uploadFileInputBox.sendKeys("D:\\INTELLiJ_Workspace\\LearningSELENIUM\\src\\test\\java\\com\\swathi\\toUpload.txt");
//        driver.findElement(By.name("submit")).click();

        // In sendKeys to upload a file create a text file with name as toUpload.txt
        // copy the absolute path of the file--> D:\INTELLiJ_Workspace\LearningSELENIUM\src\test\java\com\swathi\toUpload.txt
        // paste it in sendKeys
        // If u don't want to use absolute path u can use directory
        String dir = System.getProperty("user.dir"); // dir is directory
        System.out.println(dir); // this will give the path till here -> D:\INTELLiJ_Workspace\LearningSELENIUM
        // so now along with this I can use
        uploadFileInputBox.sendKeys(dir+"\\src\\test\\java\\com\\swathi\\toUpload.txt");
        driver.findElement(By.name("submit")).click();


        // How to verify Download File ??
        // Download File can be Checked by the ChromeOption

        // Problem - Download a file and check in the dir if that is present.
        // ChromeOptions -> dir(Doc)
        // filename.doc ->  /User/pramod/Download/chrome
        // file exist - T




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
