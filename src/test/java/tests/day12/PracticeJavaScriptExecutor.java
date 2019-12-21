package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class PracticeJavaScriptExecutor {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
    }

    @Test(description = "Scrolling with Java Script")
    public void test1(){
       driver.get("http://practice.cybertekschool.com/infinite_scroll");

        JavascriptExecutor js= (JavascriptExecutor) driver;

        for(int i=0; i<10; i++) {
            js.executeScript("window.scrollBy(0,500);");
            BrowserUtils.wait(1);
        }
        BrowserUtils.wait(5);
    }

    @Test(description = "Scrolling with JSExecutor to specific element")
    public void test2(){
        driver.get("http://practice.cybertekschool.com/large");
        WebElement link=driver.findElement(By.linkText("Cybertek School"));
        BrowserUtils.wait(2);
        JavascriptExecutor js= (JavascriptExecutor)driver;

        // this script must scroll, until link element is not visible
        // once link element is visible, it will stop scrolling
        //arguments[0] = means first webelement after comma (link)

        js.executeScript("arguments[0].scrollIntoView(true)",link);
    }

    @Test(description = "click with JSExecutor")
    public void test3(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        // var btn1= document.getElementsByTagName('a')[1];
        // btn1.click()
        WebElement link1=driver.findElement(By.partialLinkText("Example 1"));
        BrowserUtils.wait(2);

        JavascriptExecutor js =(JavascriptExecutor)driver;
        // arguments[0]= link1 web element
        // whenever regular selenium methods are not working, we use JSExecutor or for scrolling
        // it is alternative way
        js.executeScript("arguments[0].click()",link1);
        BrowserUtils.wait(2);

    }

    @Test(description = "Enter text with JS Executor")
    public void test4(){
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement name=driver.findElement(By.name("full_name"));
        WebElement email= driver.findElement(By.name("email"));
        WebElement submit=driver.findElement(By.name("wooden_spoon"));


        JavascriptExecutor js= (JavascriptExecutor)driver;
        BrowserUtils.wait(2);
        js.executeScript(" arguments[0].setAttribute('value', 'John Smitt') ",name);
        BrowserUtils.wait(2);

        js.executeScript(" arguments[0].setAttribute('value','sdmnwd@gmail.com') ", email);
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].click()",submit);


    }




    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
