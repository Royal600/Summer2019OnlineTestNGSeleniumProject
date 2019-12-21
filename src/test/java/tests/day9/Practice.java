package tests.day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class Practice {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }



    @Test(description = "Verify Checkboxes")
    public void test1(){
        driver.findElement(By.linkText("Checkboxes")).click();
      WebElement checkbox1= driver.findElement(By.cssSelector("[type='checkbox']:nth-of-type(1)"));
        Assert.assertFalse(checkbox1.isSelected(),"Checkbox1 is selected");
        WebElement checkbox2= driver.findElement(By.cssSelector("[type='checkbox']:nth-of-type(2)"));
       Assert.assertTrue(checkbox2.isSelected(), "Checkbox 2 was not selected");
    }

    @Test
    public void Test2(){
        driver.findElement(By.linkText("Radio Buttons")).click();
        WebElement blueButton = driver.findElement(By.xpath("//*[text()='Blue']/preceding-sibling::input[@type='radio']"));
        Assert.assertTrue(blueButton.isSelected(),"Blue Button is selected");
    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
