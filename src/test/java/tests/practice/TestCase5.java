package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase5 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");
        WebElement RegistrationForm= driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a"));
        RegistrationForm.click();
        WebElement LastName=driver.findElement(By.name("lastname"));
        LastName.sendKeys("123");
        WebElement text=driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[3]"));
        String actualResult=text.getText();
        String expectedResult="The last name can only consist of alphabetical letters and dash";
        if(actualResult.equals(expectedResult)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.close();
    }
}
