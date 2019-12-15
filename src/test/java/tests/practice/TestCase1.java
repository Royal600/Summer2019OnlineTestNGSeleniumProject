package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase1 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");
        WebElement xpath = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[43]/a"));
        xpath.click();
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Royal Mirzayev");
        WebElement email =driver.findElement(By.name("email"));
        email.sendKeys("royalmirzayev0@gmail.com");
        BrowserUtils.wait(2);
        WebElement signUp= driver.findElement(By.className("radius"));
        signUp.click();
        String expectedResult="Thank you for signing up. Click the button below to return to the home page.";
       WebElement actualResult= driver.findElement(By.name("signup_message"));
      String actualTesultmsg=  actualResult.getText();
        if(expectedResult.equals(actualTesultmsg)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test Failed");
        }
        boolean homeButtonVisible = driver.findElement(By.id("wooden_spoon")).isDisplayed();
        System.out.println(homeButtonVisible);


        driver.close();




    }
}
