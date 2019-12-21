package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Training {
    public static void main(String[] args) {

        /*
           Training ABSOLUTE XPATH LOCATOR

        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://login.nextbasecrm.com/?login=yes");
        driver.findElement(By.className("login-btn")).click();
        BrowserUtils.wait(2);
       WebElement warningMessage= driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div/div[2]"));
        System.out.println(warningMessage.getText());
        driver.close();

         */

        // Training RELATIVE XPATH LOCATOR

        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://login.nextbasecrm.com/?login=yes");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk59@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");

        driver.findElement(By.xpath("//*[@type='submit']")).submit();

        driver.close();

    }
}
