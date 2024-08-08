package com.swathi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeTest {

        public static void main(String[] args) {
            // Set the path to the Edge WebDriver executable
            System.setProperty("webdriver.edge.driver", "C:\\Users\\admin\\Downloads\\edgedriver_win64 (1)");

            // Initialize EdgeDriver
            WebDriver driver = new EdgeDriver();

            // Open a website
            driver.get("https://app.vwo.com");

            // Perform actions with the driver

            // Close the browser
            driver.quit();
        }
    }


