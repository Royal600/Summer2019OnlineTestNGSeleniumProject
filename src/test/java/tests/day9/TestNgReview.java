package tests.day9;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNgReview {
    //whatever is common among tests, can go into @BeforeMethod and @AfterMethod
    //it helps to reduce code duplication

    private  WebDriver driver;
    @BeforeMethod
    public void setup(){
        System.out.println("Before method");
        driver= BrowserFactory.getDriver("chrome");

    }

    @AfterMethod
    public void teardown(){
        System.out.println("After Method");
        driver.quit();
    }

    @Test(description = "verify title of google.com",priority = 2)
    public void tes1(){
        System.out.println("Test 1");
        driver.get("http://google.com");
        String expectedTitle="Google";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title is nor correct");
    }

    //priority will change the order of test execution
    //by default tests are running in alphabetic order
    //lower priority - early execution';
    @Test(description = "Verify title of apple.com",priority = 1)
    public void verifyApplePageTitle(){
        System.out.println("Test 2");
        driver.get("https://apple.com");
        String expectedTitle="Apple";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title is not correct!!!");
        //if assertion failed, line below will not be reachable
        //if assertion passed, you will see message from line below
        System.out.println("Test passed");
    }

    //data provide can supply test with a test a data. Also, it allows to do Data Driven Testing
    //What is this? It's when same test runs multiple times with different test data set
    @DataProvider(name="testData")
    public static Object[][] testData(){
        return new Object[][]{ {"https://www.apple.com/","Apple"},
        {"http://google.com","Google"} };
    }
    @Test(dataProvider = "testData")
    public void testWithDataProvider(String url, String title){
        driver.get(url);
        Assert.assertEquals(driver.getTitle(),title);
    }
}
