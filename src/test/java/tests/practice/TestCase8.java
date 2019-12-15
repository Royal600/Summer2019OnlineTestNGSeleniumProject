package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase8 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");
        WebElement RegistrationForm= driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a"));
        RegistrationForm.click();
        WebElement UserName=driver.findElement(By.name("phone"));
        UserName.sendKeys("5711234354");
        WebElement text=driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[6]/div/small[2]"));
        String actualResult=text.getText();
        String expectedResult="Phone format is not correct";
       if(expectedResult.equals(actualResult)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test failed");
        }
        driver.close();
    }
}
