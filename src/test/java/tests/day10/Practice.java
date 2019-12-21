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

public class Practice {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test
    public void test1(){
        driver.findElement(By.linkText("New tab")).click();
        BrowserUtils.wait(3);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Practice","Title is Wrong");
    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
