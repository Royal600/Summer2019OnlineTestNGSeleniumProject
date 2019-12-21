package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class Practice2 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Checkboxes")).click();
    }

    @Test
    public void Test1() {
        List<WebElement> checkboxes=driver.findElements(By.cssSelector("[type='checkbox']"));
        for(WebElement each: checkboxes){
            if(!each.isSelected() && each.isEnabled()){
                each.click();
                System.out.println("Checkbox is clicked: ");
            }else{
                System.out.println("Checkbox was not clicked: ");
            }
        }

    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
