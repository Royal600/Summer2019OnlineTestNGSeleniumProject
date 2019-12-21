package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class Practice {
    private WebDriver driver;

   @BeforeMethod
    public void setup(){
        driver=BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
       driver.findElement(By.linkText("Radio Buttons")).click();

   }

    @Test(description = "Verify Blue Button is Selected")
    public void Test1(){
        WebElement bluebutton= driver.findElement(By.id("blue"));
        Assert.assertTrue(bluebutton.isSelected());

    }

    @Test(description = "Verify Red Button is not selected")
    public void Test2(){
      WebElement redButton= driver.findElement(By.id("red"));
      Assert.assertFalse(redButton.isSelected());
    }


      @Test(description = "GreenButton is not clickable")
      public void Test3(){
       WebElement greenButton=driver.findElement(By.id("green"));
       Assert.assertFalse(greenButton.isEnabled());
   }

   @Test(description = "Click on all radio buttons")
   public void Test4(){
       List<WebElement> buttons=driver.findElements(By.cssSelector("input[type='radio']"));
       for(WebElement each:buttons){
           if(each.isEnabled() && !each.isSelected()){
               each.click();
               System.out.println("Button clicked: " + each.getAttribute("id"));

           }else{
               System.out.println("Button is not clicked: "+each.getAttribute("id"));
           }
           BrowserUtils.wait(1);
       }
   }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
