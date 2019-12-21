package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class Training {

        /*


        //Training Css Selector
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        List<WebElement> buttons=driver.findElements(By.cssSelector("[class='btn btn-primary']"));
        for(WebElement button:buttons){
            button.click();
            BrowserUtils.wait(2);
            WebElement message=driver.findElement(By.cssSelector("#result"));
            System.out.println(message.getText());
        }

        driver.navigate().to("http://practice.cybertekschool.com/registration_form");
        WebElement header=driver.findElement(By.cssSelector(".page-header> h2"));
        System.out.println(header.getText());
        driver.close();

        */


        //Test Ng Practice

        @Test
        public void test(){
            Assert.assertEquals("apple","apple","word is not correct");
    }

    @Test
    public void verifyTitle(){
          WebDriver driver=BrowserFactory.getDriver("chrome");
         driver.get("http://practice.cybertekschool.com/");
         String expectedTitle="Practice";
         String actualtitle=driver.getTitle();
         Assert.assertEquals(actualtitle,expectedTitle,"title is wrong");
         driver.close();
    }



        @Test(description = "is displayed")
        public void verifyHeadingIsDisplayed(){
            WebDriver driver=BrowserFactory.getDriver("chrome");
            driver.get("http://practice.cybertekschool.com/");
           WebElement heading= driver.findElement(By.cssSelector("[class='h1'] span"));
           Assert.assertTrue(heading.isDisplayed());
           driver.close();

        }
}
