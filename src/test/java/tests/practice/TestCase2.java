package tests.practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class TestCase2 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");
        List<WebElement> totalLists=driver.findElements(By.className("list-group-item"));
        System.out.println("Number of listed examples are: "+totalLists.size());
        driver.close();
    }
}
