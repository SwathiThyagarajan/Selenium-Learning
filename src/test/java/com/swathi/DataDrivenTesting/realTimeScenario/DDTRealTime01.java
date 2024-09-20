package com.swathi.DataDrivenTesting.realTimeScenario;

import com.swathi.DataDrivenTesting.ExcelReader_AllScenarios;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class DDTRealTime01 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Using an if-else block to handle both positive and negative test cases
    @Test(dataProvider = "loginData")
    public void testDataDriven(String email, String password, String expectedResult) {

        driver.navigate().to("https://app.vwo.com");
        WebElement emailID = driver.findElement(By.id("login-username"));
        emailID.clear();
        emailID.sendKeys(email);
        WebElement passwordElement = driver.findElement(By.id("login-password"));
        passwordElement.clear();
        passwordElement.sendKeys(password);
        driver.findElement(By.id("js-login-btn")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // If expected result is valid, we will verify that "Login Test" is available
        if (expectedResult.equalsIgnoreCase("Valid")) {
            // Add explicit wait to ensure element is present and visible
            WebElement LoginTestElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='lufexuloga']")));
            String text = LoginTestElement.getText();
            System.out.println(text);
            Assert.assertEquals(text, "Login Test");
        }
        // If it is invalid, we will verify the JS notification
        else if (expectedResult.equalsIgnoreCase("InValid")) {
            WebElement error_message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-notification-box-msg")));
            Assert.assertTrue(error_message.isDisplayed());
            Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");
        }
    }

    // we have hard coded the data here we can replace this with Excel file
    // DataProvider for test cases
//    @DataProvider(name = "loginData")
//    public Object[][] testData() {
//        return new Object[][]{
//                {"LogintestPositive@1secmail.comi", "App*vwo2024", "InValid"}, // Invalid case
//                {"LogintestPositive@1secmail.com", "App*vwo2024", "Valid"}    // Valid case
//        };
//    }
// we have hard coded the data above we can replace this with Excel file
    // so 1st create an Excel resource file under test under directory
    // and in resources create an Excel file and name it as RealTestData
    // assume u already have an Excel file with data in your system and just paste it in resource folder
    // and name it as RealTestData

    @DataProvider(name = "loginData")
    public String[][] testDataExcel() throws IOException {
        String testDataFile = "src/test/resources/RealTestData.xlsx";
        ExcelReader_AllScenarios excelReader = new ExcelReader_AllScenarios(testDataFile);
        String[][] data  = excelReader.getDataFromSheet(testDataFile,"LoginData");
        return data;
        // in real time what ever reading part is there they all will be put in utilities

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}



