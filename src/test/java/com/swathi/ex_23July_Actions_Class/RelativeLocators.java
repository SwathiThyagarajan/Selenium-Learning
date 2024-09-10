package com.swathi.ex_23July_Actions_Class;

public class RelativeLocators {

    /*
    Relative Locators in Selenium WebDriver are a powerful feature that
    allows you to locate web elements in relation to other elements.
    They were introduced in Selenium 4 and provide more intuitive and human-readable ways
    to locate elements when traditional locators (like ID, XPath, CSS, etc.) are insufficient or cumbersome.

    Basic Syntax
  Relative Locators are accessed using the RelativeLocator class in Selenium.
 You can use methods like above(), below(), toLeftOf(), toRightOf(), and near()
 to locate elements relative to another element.

 Methods and Usage
1. above(): Finds an element that is located above the specified element.
WebElement elementAbove = driver.findElement(RelativeLocator.with(By.tagName("tag")).above(referenceElement));

2. below(): Finds an element that is located below the specified element.
WebElement elementBelow = driver.findElement(RelativeLocator.with(By.tagName("tag")).below(referenceElement));

3. toLeftOf(): Finds an element that is located to the left of the specified element.
WebElement elementLeft = driver.findElement(RelativeLocator.with(By.tagName("tag")).toLeftOf(referenceElement));

4. toRightOf(): Finds an element that is located to the right of the specified element.
WebElement elementRight = driver.findElement(RelativeLocator.with(By.tagName("tag")).toRightOf(referenceElement));

5. near(): Finds an element that is near (within a certain distance of) the specified element.
WebElement elementNear = driver.findElement(RelativeLocator.with(By.tagName("tag")).near(referenceElement));

Benefits of Relative Locators
1. Human-Readable:
Easier to understand what element you’re trying to interact with in the context of the page layout.

2. Robustness:
Can make your test scripts more robust against changes in the DOM,
especially when IDs or classes change but relative positions do not.

3. Simplicity:
Reduces the need for complex XPath or CSS selectors when relative positioning is all that matters.

Relative Locators can make your Selenium tests more readable and maintainable,
 particularly when dealing with complex layouts where elements are positioned in relation to others.


     */
}
