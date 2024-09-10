package com.swathi.ex_16July;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Lab316_XPath {

    @Test
    public void testVerifyFreeTrial(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com");
        System.out.println(driver.getTitle());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

/*  We can get an element using ID, name, class. But if they are not unique or
    When You  don't find id , name or class then we can go with linkText or partial Text
    but linkText or partial Text work with only an anchor/ a tag.
    so, in such cases I can use x path or css selector

          Default Locator Strategy --> ID,  Name, Class - if they are Unique - then Super Good.
           because all of them are very fast

     Xpath or CSS Selector both are used to find a locator.
     You should always find small and efficient Locators.
     UI Automation is all about finding locators.

     1.     Xpath or CSS Selector Strategy
          Which is good, xpath or css Selector?
          Css Selectors -> little fast, Nowdays since more ram - xpath  == css selector
          Xpath -> , css Seelctor -
          For 25000 Test - mixture, it depends - sometimes xpath easy -

         Xpath or Css Selector both do the same thing - they can be converted to each other vice versa
         Css Selector are little fast because
         Css Selector - Css Engine - little fast to find the element. ultimate goal is t find the element 

    2.  What is XPath?
          XPath is a query language.
         for selecting nodes from an XML document.
         HTML -> xml type of document - tag based - language
         you can find all the elements using xpath.
         XPath was defined by the World Wide Web Consortium.W3C
         All the major browsers understand and supports it. W3C is like a supreme court order
         so if W3C says every browser will support xpath then xpath is supported by everyone


    3.     Type of Xpath -> Absolute Xpath (Full Xpath), Relative Xpath (with Query).
           Core Logic of xpath is very simple you can create your own xpath also

    4.     Absolute Xpath - Full Xpath - Type #1
         /html/body/div[2]/div[1]/div[2]/div/div[1]/div/div/div[3]/form[1]/ul/li[1]/div/input

         ex: go to app.vwo website-> right click select Inspect element-> here you can 1st see html
         -> 2nd you can see body in the body we have further divisions. In the div u can find further more div
         here u can find login page, form, Input box.

         You can right-click and copy the full xpath
         /html/body/div[2]/div[1]/div[2]/div/div[1]/div/div/div[3]/form[1]/ul/li[1]/div/input
         It is too long -
         prone to change - any change in div or html - Axpath will not work
         NOBODY USE THIS

    5.    Relative Xpath (with Query)
        Core Logic of xpath is very simple you can create your own xpath also
        Core Logic - //tagName[@attribute='value']
        you have // with tag name directly u can find the tag name.
        ex: I want to find the input box?
        -> below I can find a search box--> type // and then type -> tag name ie; input .
        just by using the tag name input - a simple xpath->
         u can find all the inputs available in the elements tab almost 16 xpath

         Now to make the xpath more specific we can use [] -> these brackets
         Inside the square brackets [] u can mention any attributes
         @ -> represents attribute
         so, attribute type = "email" can be represented as //input[@type="email"]
         attribute = value. Now u can see there are only 4 elements
         out of 4 elements also we can find uniqueness by adding id. consider id as another attribute
         id="js-login-confirm" -> //input[@id"js-login-confirm-email"]

        Selenium -id why should we use the below  xpath ?
         //input[@id="js-login-confirm-email"]
         Answer is we should not use this, when we already have an id don't go with xpath.
         OR
         if u want consistency in your script then u may use xpath everywhere even if ID, class
         or name is present.

         Ex: go to this website -> https://katalon-demo-cura.herokuapp.com
         I want to click on make appointment button, here consider id is not present

     You can find the elements by using the following

1.  By ID
        WebElement btnElement_ID = driver.findElement(By.id("btn-make-appointment"));
2.  By ClassName - if ID is not available. In className spaces will be replaced with dot
        WebElement btnElement_CN = driver.findElement(By.className("btn-lg"));
3.  By Partial Text if Class Name is also not available.
        WebElement btnElement_PTEXT = driver.findElement(By.partialLinkText("Make"));
4.  By using full Link Text
        WebElement btnElement_LTEXT = driver.findElement(By.linkText("Make Appointment"));
5.  By suppose if all of the above 4 are not available. then u can use xpath with href
        WebElement btnElement_AT = driver.findElement(By.xpath("//a[@href='./profile.php#login']"));

6.  By using Tag - we can use Tag but in a screen there may be multiple tags
    we don't know which one it will click
        So, Multiple a tag  - not recommended
        WebElement btnElement_TagName = driver.findElement(By.tagName("a"));
        btnElement_AT.click();


7.        How to find the xpath for username input box ???
        Assume there is no ID, ClassName,  Partial Text.
        Go to the filter bar type -> //input
        we are using input because it is an input box, when u type input u can find multiple input box
        now u can use -> //input[@type="text"] u will find 3 elements it is not unique.
        so, we can use -> //input[@placeholder="Username"] -> this will give u 2 elements.
        Therefore, I can use Index.
        since placeholder="Username" gives 2 elements we will use list.
        List<WebElement> username_element = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        username_element.get(1).sendKeys("John Doe");

    6.   Locator Strategy to find the elements:-
        Go in the below order wise, only if 1 locator is not available go to next one.
     1)   id="txt-username" - Unique
     2)   name="username" - Unique
     3)   class="form-control" - Not Unique - Find multiple - useless
     4)   Link - Partial - Since it is not an A / Anchor Tag , we can't use
     5)   Relative Xpath
          In Relative xpath we have :
          1.  Functions
          2.   Axes
          we can use Multiple Attributes in xpath - to make it unique
     6)   Css Selectors

     Locating Web Elements
To interact with web elements on a webpage, you need to locate them first.
Selenium provides several strategies for locating elements, including:


By ID: driver.findElement(By.id("elementId"))
By Name: driver.findElement(By.name("elementName"))
By Class Name: driver.findElement(By.className("className"))
By Tag Name: driver.findElement(By.tagName("tagName"))
By Link Text: driver.findElement(By.linkText("linkText"))
By Partial Link Text: driver.findElement(By.partialLinkText("partialLinkText"))
By CSS Selector: driver.findElement(By.cssSelector("cssSelector"))
By XPath: driver.findElement(By.xpath("xpathExpression"))



    7.     In the xpath instead of input I can use *
        // represents find and * represents all the nodes
         so if I add * after // it means find all the nodes, tags
         in all the tags find attribute=  Username is present give me that element

                   * vs input which one will be faster
         In the HTML page wherever you see placeholder="Username" find that
              OR if I give you
         In the HTML page in the input box placeholder="Username" find that

         This is slow, we are going to find first all the elements
        List<WebElement> username_element = driver.findElements(By.xpath("//*[@placeholder='Username']"));

        This is fast because here in the input we are finding -> place holder
        List<WebElement> username_element = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        username_element.get(1).sendKeys("John Doe");

    8.    // vs /..
        // -> means in the current html page from all the elements give me
        ex: //input
            //head
            //div
            //atag
            //html

        /..  -> using this you can go upto parent div, ie; u can go up and find which div the element is present
        again if u use /../.. u can go further more up. You can reach upto html



    9.     Xpath Functions:-
         Xpath Function means there are few utilities provided by xpath that we can use.
         The utilities are -> contains(), starts-with() and Text()
         The above 3 are mostly used to handle the dynamic elements
         Where they are useful? - dynamic text or elements
         They are useful when in the attribute value - some constant and some dynamic
         ex: title = "pramod_2323" -> I can find this by using
         1. starts-with -> pramod 2. contains -pramod -> both are Partial Match

         1) contains()
         ex: In Flipkart web homepage I want the element Flipkart -> if I right-click Inspect and see
          it is an image it does not have ID, name, partial text. only details provided is image src, width
          height and title.
          So, to find the locator we can use
         //img[contains(@title,"Flip")]
         here img is a Tag so the logic we are using is -> find img which contains attribute title as Flipkart
           Or I can use Flip
        if I use Flip it is similar to partial link text


        2)  starts-with()
         //img[starts-with(@title,"Flip")]

        3) substring-after
          based on the arguments you can use this

        4) normalize-space
           You can  remove the spaces also ex: title= " pramod "
           here there is space inside the double quotes here we cannot use starts-with it will not work
           we need to use normalize-space.

       5)  Text()
        a[text()="Make Appointment"] - Exact Match


    10.     Multiple Attributes
         we can use Multiple Attributes also, we can mix xpath with AND + OR condition
        Operators - AND & OR
        And Example
        tag_name[@name = 'Name value' and @id = ‘ID value’]
        a[text()="Make Appointment" and contains(@id,"btn-make-appointment")]


        //* means -> Select all the nodes - Select * from all element in html; all elements
        input -> Select all input box - select inputs from all the in html - all inputs.
        input[@title="flipkart"] = select input from all the html where title = flipkart; =1
        input[text()="flipkart"] = select input from all the html where text() = flipkart; =1



    11.     Xpath - Axes
        Go the parent or child when you know about the son.
         Xpath - Axes says if u find 1 element based on it u can find the parent, grandparent, child, sibling

          Xpath - Axes example you can go to awesomeqa.com/xpath/
          here in the body u can find 1 div(division)
          division basically means how they are divided.
          in the division we have vertebrates and invertebrates
          In the vertebrates we have further divisions Fish, Mammals and others
          Mammals has futher moe divisions Herbivore and Carnivore
          In invertebrates we have further divisions Insects and crustaceans

          This is like a family structure
          How to find the mammal ?? we can find it directly by using  class
          //div[@class="Mammal"]

          To find mammal's ancestor div ?
           //div[@class="Mammal"]/ancestor::div

           To find mammal's parent
           //div[@class="Mammal"]/parent::div

         To find mammal's following-sibling
           //div[@class="Mammal"]/following-sibling::div

        To find mammal's child
           //div[@class="Mammal"]/child::div

        To find mammal's descendant
           //div[@class="Mammal"]/descendant::div

           You can use xpath cheat sheet

           xpath Axes are mostly used in the web tables
 */




    }
}
