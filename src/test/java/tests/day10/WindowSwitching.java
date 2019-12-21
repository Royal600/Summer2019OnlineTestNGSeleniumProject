package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Set;

public class WindowSwitching {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){
        driver.findElement(By.linkText("New tab")).click();
        // after 4 seconds another website will be in the second window
        // selenium does not switch automatically to the new window
        BrowserUtils.wait(4);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Practice", "Title is wrong");
    }

    @Test(description = "Verify that user is able to see new window")
    public void test2(){
        driver.findElement(By.linkText("New tab")).click();
        // record id of original window, that we opened initially
        String oldWindow=driver.getWindowHandle();
        // after 4 seconds another website will be in the second window
        // selenium does not switch automatically to the new window
        BrowserUtils.wait(4);
        // in the selenium every window has an id. that id calls window handle
        //to read window handle we use method getWindowHandle()
        //after new window was opened , we can get list of all window id's/window handles
        //list- it is a data structure
        //set- is also a data structure like list , but  it does not allow duplicates
        //also you can not easily access anything from there
        //there is no .get() method
        //thats why, we need to loop through the set, to read a data from there
        Set <String> WindowHandles=driver.getWindowHandles();
        //loop through the collection of windows
        for(String windowHandle: WindowHandles){
            // if it is not an old window
            if(!windowHandle.equals(oldWindow)){
                //switch to that window
                driver.switchTo().window(windowHandle);
            }
        }
        //lets verify that title of new window is a Fresh tab
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Fresh tab","Title is wrong");
        //come back to original page
        //we can build a function, that will jump in between windows
        //based on page title, we can determine where to stop
        String pageTitle="Practice";
        for(String windowHandle:WindowHandles){
            // keep jumping from window to window
            driver.switchTo().window(windowHandle);
            //one we found page title, of the window that we need
            if(driver.getTitle().equals(pageTitle)) {
                //just exit
                //stop jumping
                break;
            }
        }
        System.out.println(driver.getTitle());
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
