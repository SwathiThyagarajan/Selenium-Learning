package com.swathi.Project_OrangeHRM;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class checkEmployeeCreation {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(edgeOptions);

    }

    @Test(groups = "QA")
    @Description("Testcase Description")
    public void testVerifyEmployeeCreated(){
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // In the above url login using -> Username : Admin , Password : admin123
        // Wait for the username input to be present, ensuring the page is loaded
        WebElement inputUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        inputUsername.sendKeys("Admin");

        // Wait for the password input to be present
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys("admin123");

        // Wait for the login button to be clickable before clicking
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and contains(@class, 'orangehrm-login-button')]")));
        loginButton.click();

        // After clicking login button dashboard page will be loaded here go to PIM click on add.
        // add employee name as pramod dutta and click on save
        // go to pim again and search for pramod dutta click on search icon
        // verify in web table that pramod is present

        WebElement pimLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")));
        pimLink.click();

        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")));
        addButton.click();

        WebElement inputFirstname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='firstName']")));
        inputFirstname.sendKeys("Sachin");

        WebElement inputLastname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='lastName']")));
        inputLastname.sendKeys("Tendulkar");

        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")));
        saveButton.click();

        pimLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")));
        pimLink.click();

        WebElement employeeName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Type for hints...']")));
        employeeName.sendKeys("Sachin Tendulkar");

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
        searchButton.click();

        // Scroll to table and ensure it's visible
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement tableBody = driver.findElement(By.xpath("//div[@class='oxd-table orangehrm-employee-list']"));
        js.executeScript("arguments[0].scrollIntoView(true);", tableBody);
        wait.until(ExpectedConditions.visibilityOf(tableBody));

        // Locate the rows and search for "Rahul Dravid"
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@role='row']"));

        // Debugging output: Print out each row's text to see what's being captured
        for (WebElement row : rows) {
            System.out.println("Row text: " + row.getText());  // Debug output to check row contents
        }

        // Flag to check if employee is found
        String foundEmployeeText = null;

        // Loop through the rows to find "Rahul Dravid"
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("div"));

            // Trim to avoid issues with extra spaces
            String firstName = columns.get(2).getText().trim();  // First Name column
            String lastName = columns.get(3).getText().trim();   // Last Name column

            System.out.println("First Name: " + firstName + ", Last Name: " + lastName);  // Debug output to verify the names

            if (firstName.equals("Rahul") && lastName.equals("Dravid")) {
                foundEmployeeText = firstName + " " + lastName;
                break;
            }
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Assert that "Rahul Dravid" is found in the table
        Assert.assertNotNull(foundEmployeeText, "Employee 'Rahul Dravid' was not found in the table.");
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
