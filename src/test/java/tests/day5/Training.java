package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Training {
    public static void main(String[] args) {

        /*
         Training ID locator

        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement button =driver.findElement(By.id("disappearing_button"));
        button.click();
        WebElement result=driver.findElement(By.id("result"));
        System.out.println(result.getText());
        driver.close();

         */

        /*
        // Training NAME Locator
        WebDriver driver=BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.findElement(By.name("full_name")).sendKeys("Royal Mirzayev");
        driver.findElement(By.name("email")).sendKeys("random@gmail.com");
        driver.findElement(By.name("wooden_spoon")).submit();
        driver.quit();

         */

        /*

        // Training CLASSNAME locator
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement className= driver.findElement(By.className("h3"));

        System.out.println(className.getText());

        driver.close();

         */

        /*


        // Training TAGNAME Locator

        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.findElement(By.name("full_name")).sendKeys("Royal Mirzayev");
        driver.findElement(By.name("email")).sendKeys("random@gmail.com");
        driver.findElement(By.name("wooden_spoon")).submit();
        WebElement subheader= driver.findElement(By.tagName("h3"));
        System.out.println(subheader.getText());
        driver.quit();

         */

        // Training LINKTEXT locator

        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        WebElement autocomplete= driver.findElement(By.linkText("Autocomplete"));
        autocomplete.click();
        BrowserUtils.wait(3);
        driver.close();

    }
}
