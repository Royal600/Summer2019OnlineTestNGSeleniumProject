package tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Training {
    public static void main(String[] args)  {

        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");

        BrowserUtils.wait(3);
        driver.navigate().to("https://www.google.com/");

       BrowserUtils.wait(3);
        driver.navigate().back();
        BrowserUtils.wait(3);
        driver.navigate().forward();

          BrowserUtils.wait(3);
        driver.navigate().refresh();
        System.out.println(driver.getPageSource());

    }
}
