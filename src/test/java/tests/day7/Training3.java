package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class Training3 {
    private WebDriver driver;

    @BeforeMethod
    public void setDrivEr(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }

    @Test
    public void verifyButton1(){
        driver.findElement(By.cssSelector("[onclick='button1()']")).click();
       String actualResult= driver.findElement(By.cssSelector("[class='col-4 col-md-4'] p")).getText();
       String expectedResult="Clicked on button one!";
        Assert.assertEquals(actualResult,expectedResult,"Result does not match");

    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
