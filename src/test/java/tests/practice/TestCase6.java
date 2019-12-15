package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase6 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");
        WebElement RegistrationForm= driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a"));
        RegistrationForm.click();
        WebElement UserName=driver.findElement(By.name("username"));
        UserName.sendKeys("user");
        WebElement text=driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[3]/div/small[2]"));
        String actualResult= text.getText();
        String expectedResult="The username must be more than 6 and less than 30 characters long";
        if(actualResult.equals(expectedResult)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        BrowserUtils.wait(2);
        driver.close();
    }
}
