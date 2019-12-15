package tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;


public class MyFirstSeleniumScript {
    public static void main(String[] args) {
        //we have to setup webdriver based on the browser that we gonna use
        // old way of configuring webdriver
        //System.setProperty("webdriver.chrome.driver", "/path/chromedriver");
        //better way to setup webdriver
        //because any platform and any version is available in one line of code
        WebDriverManager.chromedriver().setup();
        //we need to create an object of appropriate class
        ChromeDriver driver = new ChromeDriver();
        //let's open google.com
        //.get() method allows to open some website
        driver.get("http://google.com");

        //Test1. Verify that title of the page is a "Google"
        //to read the page title, there is method .getTitle()
        String actualResult = driver.getTitle();
        String expectedResult = "Google";
        if(actualResult.equals(expectedResult)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
        // to close the browser
        driver.close();
    }
}
