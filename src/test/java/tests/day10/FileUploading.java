package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.io.File;

public class FileUploading {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test(description = "Verify that file was uploaded")
    public void test1(){
       driver.findElement(By.linkText("File Upload")).click();
       //provide path to the file
        //insert your path to the file into sendKeys() method
        // drag and drop file inside of Intellij and click right click in intellij and choose copy relative path and paste it in sendKeys
        // hold shift and click on file and choose copy path, then switch back slashes\ to forward slashes
       driver.findElement(By.id("file-upload")).sendKeys("C:/Users/Royal Mirzayev/Desktop/fileoploaderror.JPG");
       //click submit
        driver.findElement(By.id("file-submit")).submit(); // or click();
        BrowserUtils.wait(4);
       String expectedFileName="fileoploaderror.JPG";
       String actualFileName=driver.findElement(By.id("uploaded-files")).getText();

     Assert.assertEquals(actualFileName,expectedFileName,"File Name is wrong");
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
