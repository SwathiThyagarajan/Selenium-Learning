package com.swathi.ex_11July_Selenium;

public class Lab303_TypesOfWebDrivers {
    public static void main(String[] args) {

       // we can create  like this but, grandfather reference it will have only 2 functions

        // SearchContext driver = new EdgeDriver(); // Dynamic Dispatch (RunTime Polymorphism)
        // Possible but two functions, which is not much used.
        //driver.findElement()
        //driver.findElements()
//        While SearchContext driver = new EdgeDriver(); is valid,
//        it’s typically more practical to use a WebDriver reference for broader functionality.


        // WebDriver driver = new EdgeDriver();
        // WebDriver has 12 functions  which are good

        // RemoteWebDriver driver = new EdgeDriver(); we can do this also

//        EdgeDriver driver = new EdgeDriver(); we can do this also

// What is the difference when should I use what??
        // we will have only 3 Scenarios

        // 1. Do want to run on  Chrome or Edge?
//        ChromeDriver driver = new ChromeDriver();
//        EdgeDriver driver2 = new EdgeDriver();


        // 2  Do you want to run on Chrome now then later change to Edge ? -> use WebDriver.
        // WebDriver driver = new ChromeDriver();
        // driver = new EdgeDriver(); 90% of time we will use this



        // 3. do you want to run on multiple browsers? -> use RemoteWebDriver.
        // RemoteWebDriver driver (with GRID) - Advance (Last 2 Sessions)


    }
}
