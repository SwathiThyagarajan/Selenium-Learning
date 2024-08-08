package com.swathi;

import org.openqa.selenium.edge.EdgeDriver;

public class HelloWorld {

    public static void main(String[] args) {

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://sdet.live"); // run this code to check if it is working
        // driver.get is an API post request to navigate to the URL
        // every command what u will write further it will either be a post, put, get, delete request
        // - which will run on the Browsers
        // so u are not directly communicating with Browsers u are communication through Driver
        // what ever the code we can see here behind the seen there is an API request
        // without writing the code can I directly make an API request to the server
        // trying to do it using postman. here client is postman
        // 1st install Edge Drivers

        // In postman u can create a new collection  Selenium API understand - to understand better


//        EdgeDriver driver = new EdgeDriver();
//   whenever u type  new EdgeDriver() this Selenium manager will check
//   if u have edge driver installed into the system or not
//   if it has already installed it will give the commands to edge driver.
//   and edge driver will give to edge browser.
//   if edge driver is not installed Selenium manager  will install it
//   the moment u add selenium java dependency everything is done behind the scene

        // This done using W3C protocol in selenium 4

/*    While working with any Web page Why is Selenium used
    Selenium is used to search and interact(find the element and interact with the element).


     SearchContext(interface)
     it is the Father and it is an interface.
     it has only two functions
     1.findElements() --> returns List of web elements
     2.findElement() --> returns one web element

     SearchContext is implemented by web driver.
     Web Driver has all the abstract methods.
     abstract means incomplete methods they will go to remote web driver(class).
     Remote Web Driver will give/extends abstract methods to all the web drivers

     what is the functionality of remote.
     Remote has 2 things
     1. JavaScript Executor(interface) it can help u in JavaScripts execution part
     2. Take screenshot(interface) it can help u in take screenshot part

     They both are created in such a way that every one in the web drivers part(different web drivers)
      will follow the same principle

      Interfaces and abstract methods are created to force something on you
 */


    }
}
