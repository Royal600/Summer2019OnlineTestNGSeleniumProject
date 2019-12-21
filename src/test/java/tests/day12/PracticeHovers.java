package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class PracticeHovers {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/hovers");
    }

    @Test(description = "Verify first image")
    public void test1(){
        // create object of actions class to perform actions(drag and drop, context click,
        Actions action = new Actions(driver);
        WebElement image1=driver.findElement(By.cssSelector(".figure:nth-of-type(1)"));
        // just to hover on element, not click
        // build is required when we have more than one action in a chain
        // without perform it will not work
        // moveToElement=hover
        //.perform stands for triggering actions
        action.moveToElement(image1).perform();

        BrowserUtils.wait(3);
        // h5 is grand child of  .figure:nth-of-type(1) this element contains the image
        WebElement text=driver.findElement(By.cssSelector(".figure:nth-of-type(1) h5"));
        String expectedText="name: user1";
        String actualtext=text.getText();
        Assert.assertEquals(actualtext,expectedText,"Text is wrong");
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
