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

public class JSExecutorOrPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        JavascriptExecutor js=(JavascriptExecutor) driver;
        for(int i=0;i<10;i++) {
            js.executeScript("window.scrollBy(0,500)");
            BrowserUtils.wait(1);
        }
        BrowserUtils.wait(3);
    }

    @Test(description = "Scrolling with Js Executor to specific element")
    public void test2(){
        driver.get("http://practice.cybertekschool.com/large");
        WebElement link=driver.findElement(By.linkText("Cybertek School"));
        BrowserUtils.wait(2);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        //this script must scroll, until link element is not visible
        //arguments[0] = means first webelement after comma (link)
        //arguments it is an array of webelements  after comma
        //arguments[0] = link web element, it can be any element
        js.executeScript("arguments[0].scrollIntoView(true)",link);
        BrowserUtils.wait(2);
    }

    @Test(description = " Click with Js Executor")
    public void test3(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        //Example 1 is a beginning of the phrase <a href='http:'>Example 1.....</a>
        WebElement link1=driver.findElement(By.partialLinkText("Example 1"));
            BrowserUtils.wait(3);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        //arguments[0] = link1 web element
        //whenever regular selenium methods are not working, I use js executor
        //or for scrolling
        //arguments[0].click() is an alternative for link1.click()
        js.executeScript("arguments[0].click()", link1);
        BrowserUtils.wait(2);
        //document.getElementsByName('full_name')[0].setAttribute('value','My name')
    }

    @Test(description = "Enter text with JS executor")
    public void test4(){
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement name=driver.findElement(By.name("full_name"));
        WebElement email=driver.findElement(By.name("email"));
        WebElement submit=driver.findElement(By.name("wooden_spoon"));

        JavascriptExecutor js=(JavascriptExecutor) driver;
        //setAttribute('value','John Smitt') , it is the same as the name.sendKeys("John Smitt")
        BrowserUtils.wait(3);
        js.executeScript("arguments[0].setAttribute('value', 'John Smitt')" , name) ;
        BrowserUtils.wait(3);
        js.executeScript("arguments[0].setAttribute('value', 'aadaded@email.com')" , email) ;
        BrowserUtils.wait(3);
        js.executeScript("arguments[0].click()" , submit) ;
        BrowserUtils.wait(3);





    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
