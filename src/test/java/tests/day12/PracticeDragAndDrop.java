package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class PracticeDragAndDrop {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
    }

    @Test(description = "Drag and Drop example")
    public void test1(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        // click on accept cookies
        driver.findElement(By.cssSelector("button[title='Accept Cookies']")).click();
        Actions action= new Actions(driver);

        WebElement smallCircle= driver.findElement(By.id("draggable"));
        WebElement bigCircle=driver.findElement(By.id("droptarget"));
        BrowserUtils.wait(3);
        // it allows to drag and drop
        action.dragAndDrop(smallCircle,bigCircle).perform();
        BrowserUtils.wait(3);


    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
