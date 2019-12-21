package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Practice {
    private WebDriver driver;

    @BeforeMethod
    public void  setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/frames");
    }

    @Test(description = "Iframe example")
    public void Test1(){
        driver.findElement(By.linkText("iFrame")).click();
        // since element  inside a frame , element is not visible for selenium
        //without switching to the frame
        // we can switch to frame  based on id , name, index ( starting from 0), WebElement
        driver.switchTo().frame("mce_0_ifr");

        // without  switching , we can not see inner  html document
        // which one to use ? id, name, index, webElement?
        //1. id or name
        //2. webelement driver.findElement(By.cssselector("iframe[class='some_frame']"));
        //3. index [iframe1, iframe2, iframe3..]

        WebElement inputArea=driver.findElement(By.id("tinymce"));
        String expectedText="Your content goes here.";
        String actualText= inputArea.getText();
        Assert.assertEquals(actualText,expectedText,"Text is Wrong");
        BrowserUtils.wait(2);

        inputArea.clear(); //  to delete text

        BrowserUtils.wait(2);

        inputArea.sendKeys("Java is life");

        BrowserUtils.wait(2);

        // to exit from the frame
        driver.switchTo().defaultContent();

    }

    @Test(description = "Nested frames")
    // in case of nested frames
    // we must  switch to first frame --> then again to another frame, that is inside
    // -- html
    // --frame #1
    // -- frame #2
    public void test2(){
        driver.findElement(By.linkText("Nested Frames")).click();
        // switch to frame based on webelement
        driver.switchTo().frame(driver.findElement(By.cssSelector("[name='frame-bottom']")));
        // the reason why we are switching here
        // is because content that is inside a frame is not visible for selenium
        // it is like when you are on the first floor
        // trying to find what is on second floor
        WebElement content=driver.findElement(By.tagName("body"));
        System.out.println(content.getText());

        driver.switchTo().defaultContent(); // to exit from all frames , got to first floor

        driver.switchTo().frame("frame-top"); // second floor

        driver.switchTo().frame("frame-left"); // third floor

        WebElement content3=driver.findElement(By.tagName("body"));
        System.out.println(content3.getText()+" 3rd floor");


    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
