package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.awt.windows.WEmbeddedFrame;
import sun.tools.jconsole.inspector.XObject;
import utils.BrowserFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Practice {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test
    public  void test1(){
        //this line shoould be before all findELement methods
        // we can also declare implicit wait in setup method, it will work for all tests, but it is not preferrable
        // we apply it once and it always works
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Dynamic Loading")).click();
// partialLinktext matches only part of the link text
        driver.findElement(By.partialLinkText("Example 2")).click();

        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        //This is for Hello World
     WebElement finishElement= driver.findElement(By.id("finish"));
        System.out.println(finishElement.getText());
    }


    @Test
    public void Test2(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        // a[ contains (text(),'Example 1' ) ]  -- xpath alternative
        driver.findElement(By.partialLinkText("Example 1")).click();
//    click on start button
        driver.findElement(By.tagName("button")).click();

        // we find element first
        //but the problem is the element can be present but not visible

        WebElement usernameInputbox=  driver.findElement(By.id("username"));
        // explicitWait way
        // we create object of WebDriverWait to apply explicit wait
        // we must provide WebDriver object and period of time
        // within this period of time selenium will check every 500 milliseconds
        // if condition is met, no need to wait longer
        // script will continue executing
        WebDriverWait wait= new WebDriverWait(driver,10);
        // how to apply condition
        // in this example we will wait until up tom 10 seconds
        wait.until(ExpectedConditions.visibilityOf(usernameInputbox));

        usernameInputbox.sendKeys("tomsmith");
        WebElement passwordInputbox=  driver.findElement(By.id("pwd"));

        wait.until(ExpectedConditions.visibilityOf(passwordInputbox));
        passwordInputbox.sendKeys("SuperSecretPassword");
        WebElement submit= driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();

        WebElement txt= driver.findElement(By.cssSelector("h4[class='subheader']"));
        wait.until(ExpectedConditions.visibilityOf(txt));
        String actualMessage=txt.getText();
        String expectedMessage="Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertEquals(actualMessage,expectedMessage,"Message is wrong");
        System.out.println(actualMessage);

    }

    @Test
    public void test3(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 5")).click();

        WebDriverWait wait= new WebDriverWait(driver,10);
        WebElement overlayScreen=driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']"));
        // wait until overlayScreen disappear, otherwise we will have issue to click or enter the text
        wait.until(ExpectedConditions.invisibilityOf(overlayScreen));

        WebElement usernameInputbox=  driver.findElement(By.id("username"));

        wait.until(ExpectedConditions.visibilityOf(usernameInputbox));

        usernameInputbox.sendKeys("tomsmith");
        WebElement passwordInputbox=  driver.findElement(By.id("pwd"));

        wait.until(ExpectedConditions.visibilityOf(passwordInputbox));
        passwordInputbox.sendKeys("SuperSecretPassword");
        WebElement submit= driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();

        WebElement txt= driver.findElement(By.cssSelector("h4[class='subheader']"));
        wait.until(ExpectedConditions.visibilityOf(txt));
        String actualMessage=txt.getText();
        String expectedMessage="Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertEquals(actualMessage,expectedMessage,"Message is wrong");
        System.out.println(actualMessage);
    }

    @Test(description = "Fluent wait example")
    public void test4(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 2")).click();
        Wait wait= new FluentWait(driver)
        .withTimeout(Duration.ofSeconds(10))
        .pollingEvery(Duration.ofSeconds(200))
        .ignoring(ElementNotVisibleException.class);
        WebElement message= (WebElement) wait.until(new Function<WebDriver, WebElement>(){
            @Override
            public WebElement apply(WebDriver driver){
                return driver.findElement(By.id("finish"));
            }
        });


    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
