package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class Practice3 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Dropdown")).click();
    }


    @Test(description = "Select Option 2 from dropdown")
    public void test1(){
        WebElement dropdown=driver.findElement(By.id("dropdown"));
        Select select= new Select(dropdown);
        select.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Option 2");
    }


    @Test
    public void test2(){
        WebElement state=driver.findElement(By.id("state"));
       Select select= new Select (state);
       List <WebElement> states = select.getOptions();
       for(WebElement each :states){
           System.out.println(each.getText());
       }
    }

    @Test
    public void test3(){

        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
         //  <option value="MD">Maryland</option>
        // we can use tes, value or index for selection
        select.selectByValue( "MD" );
        BrowserUtils.wait(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Maryland");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
