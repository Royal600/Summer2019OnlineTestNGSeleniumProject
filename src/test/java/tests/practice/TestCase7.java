package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase7 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");
        WebElement RegistrationForm= driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a"));
        RegistrationForm.click();
        WebElement UserName=driver.findElement(By.name("email"));
        UserName.sendKeys("testers@email");
        WebElement text1=driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/small[2]"));
        WebElement text2=driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/small[3]"));
        String actualResult= text1.getText();
        String actualResult1=text2.getText();
        String actualResult2=text1.getText()+text2.getText();
        String expectedResult= "email address is not a validEmail format is not correct";
        if(expectedResult.equals(actualResult2)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.close();

    }
}
