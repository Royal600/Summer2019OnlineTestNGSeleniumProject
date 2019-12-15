package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase3 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        WebElement MultipleButtons = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[33]/a"));
        MultipleButtons.click();
        BrowserUtils.wait(3);
        WebElement Button1=driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/button[1]"));
        Button1.click();
        String expectedResult="Clicked on button one!";
        WebElement text= driver.findElement(By.id("result"));
        String actualResult=text.getText();
        if(expectedResult.equals(actualResult)){
            System.out.println("Test Passed");
        } else{
            System.out.println("Test Failed");
        }
       BrowserUtils.wait(2);
        driver.close();


    }
}
