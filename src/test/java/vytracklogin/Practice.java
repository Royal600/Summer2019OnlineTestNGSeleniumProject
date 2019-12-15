package vytracklogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class Practice {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://app.vytrack.com/user/login");
   //  driver.findElement(By.id("prependedInput")).sendKeys("User 25");

  //   driver.findElement(By.className("span2")).sendKeys("User25");

     driver.findElement(By.name("_username")).sendKeys("User25");

  //  driver.findElement(By.id("prependedInput2")).sendKeys("User12345");
         driver.findElement(By.name("_password")).sendKeys("User12345");



        driver.findElement(By.id("_submit")).click();


    }
}
