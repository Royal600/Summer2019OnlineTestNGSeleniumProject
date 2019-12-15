package tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.security.Key;

public class Training {
    public static void main(String[] args) {

        WebDriver driver=BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        BrowserUtils.wait(2);
        WebElement sendInput= driver.findElement(By.name("email"));
     //   System.out.println(sendInput.getAttribute("pattern"));
        BrowserUtils.wait(2);
        sendInput.sendKeys("random@gmail.com");
        // IMPORTANT!!! We have to use value keyword to get that text
        System.out.println(sendInput.getAttribute("value"));
        WebElement submitButton=driver.findElement(By.id("form_submit"));
        submitButton.submit();

        driver.close();

    }
}
