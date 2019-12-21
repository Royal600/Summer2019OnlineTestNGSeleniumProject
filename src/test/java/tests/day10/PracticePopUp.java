package tests.day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class PracticePopUp {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test(description = "Click on button 1 and click Ok in POPUP message")
    public void Test1(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        BrowserUtils.wait(2);
        //to deal with popup, we can create object of alert with this
        Alert alert=driver.switchTo().alert();
        alert.accept(); // to click ok
        BrowserUtils.wait(4);
    }

    @Test(description = "Click on button 2 and click Cancel in popup message")
    public void Test2(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        // [2] means second button
        driver.findElement(By.xpath("//button[2]")).click();
        BrowserUtils.wait(3);
        Alert alert=driver.switchTo().alert();
        // print text of popup message
        System.out.println(alert.getText());
        alert.dismiss(); // to click cancel
        BrowserUtils.wait(2);
        // to print the text of Result
       String result= driver.findElement(By.id("result")).getText();
        System.out.println(result);
    }

    @Test(description = "Click on button 3, adn enter some text and click ok")
    public void Test3(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        BrowserUtils.wait(2);
        // we can aslo do it in one line without creating object as above
        driver.switchTo().alert().sendKeys("Funny book");
        BrowserUtils.wait(9);
        driver.switchTo().alert().accept();
        //to print the text of result
        // should be "Java is Fun"
        System.out.println(driver.findElement(By.id("result")).getText());
        BrowserUtils.wait(4);



    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}


