package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class BitrixLogin {
    public static void main(String[] args) {
        //left side is a reference variable to reuse this object
        //object can be created and used without reference variable
        //but it is gonna be impossible to use that object more than once
        WebDriver driver= BrowserFactory.getDriver("chrome");
        // go to Bitrix
        driver.get("https://login.nextbasecrm.com/?login=yes");
        //enter email
        //helpdesk59@cybertekschool.com
        //UserUser
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("");
        //enter password
        // * matches any element(any tag name)
        //it is better to specify tag name,
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("UserUser");
        // click on login button
        driver.findElement(By.xpath("//input[starts-with(@value, 'Log')]"));
        String abc="d";
        abc.contains("");
        driver.quit();

    }
}
