package com.swathi.ex_23July_Actions_Class;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class actionsClass8 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(edgeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    }


    @Test(groups = "QA")
    @Description(" Testcase Description ")
    public void testVerifyHoverHoverClick(){
        driver.navigate().to("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
//  Get the handle of the current window
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Before Click" + mainWindowHandle);

      // the moment I click on the view heatmap of 2nd option(variation 1) from above url
        // it will take u to a new window
        // I need to verify the title in the 2nd tab - that it should be job ready automation tester
        // In the elements tab if u go to console if u type -> document.title u will get the title
        // '(3) Job Ready Automation Tester Blueprint with JAVA By Pramod Dutta'

//  click on the view heatmap of 2nd option(variation 1) in mainWindowHandle
        Actions actions = new Actions(driver);
        WebElement heatmapElement = driver.findElement(By.xpath("//*[@data-qa='yedexafobi']"));
        wait.until(ExpectedConditions.elementToBeClickable(heatmapElement));
        actions.moveToElement(heatmapElement).click().perform();

        // Wait for the new window to appear
        wait.until(driver -> driver.getWindowHandles().size() > 1);

        //  once you click on view heatmap now u will have 2 windows
        // Retrieves a set of all window handles opened by the WebDriver session.
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles); // this will print 2 windows main and child

        // if u find Iterator to be difficult u can use for each loop

// Create an iterator to loop through all the window handles
        Iterator<String> iterator = windowHandles.iterator();
        while (iterator.hasNext()) { // Loop through all available window handles
            String childWindow = iterator.next();// Get the next/child window handle from the iterator
// Check if the current window handle is NOT the main window handle
// This is to ensure we are switching to a newly opened window/tab
            if (!mainWindowHandle.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);// Switch the WebDriver's context to the child window

                // Wait until the title is available (non-empty)
                wait.until(driver -> !driver.getTitle().isEmpty());

// Print the title of the child window to the console
// This helps verify that the switch was successful, and you are now interacting with the correct window/tab
                System.out.println(driver.getTitle());
            }
        }// here if we do next it will go to child window, if main window is not equal to child
        // then only switch to child else don't switch


        // what the iterator is doing here assume main window as A and child window as B
/*   Detailed Comments Overview:

1. Iterator Initialization:
  Iterator<String> iterator = windowHandles.iterator();
 This initializes an `Iterator` to iterate through the `Set` of window handles (`windowHandles`).
  An iterator is used to loop through each window handle one by one.

2. While Loop:
  while (iterator.hasNext()) {
This loop continues as long as there are more window handles to process. `iterator.hasNext()`
 checks if there's another window handle available in the sequence.

3.Retrieve the Next Window Handle:=
  String childWindow = iterator.next();
  This retrieves the next window handle from the `Iterator` and assigns it to `childWindow`.
   Each window handle is a unique identifier for an open browser window or tab.

4. Check if the Window is Not the Main Window:
  if (!mainWindowHandle.equalsIgnoreCase(childWindow)) {
   This condition checks if the current `childWindow` handle is different from the `mainWindowHandle`.
  The `equalsIgnoreCase` method is used for case-insensitive comparison,
  though typically `equals` could be used since window handles are unique.

5. Switch to the Child Window:
  driver.switchTo().window(childWindow);
  This switches the WebDriver's focus to the `childWindow`. After this call,
   all subsequent WebDriver commands will operate in the context of this newly focused window or tab.

6. Print the Title of the Child Window:
  System.out.println(driver.getTitle());
   This prints the title of the current window (after switching) to the console.
    It's useful for debugging and verifying that the correct window has been switched to.

This structure is essential when dealing with multiple windows or tabs in automated browser testing,
 ensuring that your test interacts with the correct window.

 */

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
