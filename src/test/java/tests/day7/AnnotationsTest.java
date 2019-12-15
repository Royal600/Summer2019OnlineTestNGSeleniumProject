package tests.day7;

import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsTest {

    // runs only once before all tests
    @BeforeClass
    public void beforeCalss(){
        System.out.println("bEFORE CLASS");
    }
    // runs onlye once after all tests
    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }
    @BeforeMethod
    public void setup(){
        // some code will be running before every test , like test1, test2, test3
        // we can use the method with BeforeMethod annotation
        // runs automatically before every test
        System.out.println("Before Method");
    }

   @AfterMethod
    public void tearDown(){
        System.out.println("AFter Method");
    }

    @Test
    public void Test1(){
        System.out.println("Test 1");
        Assert.assertTrue(5==5);
    }
    @Test
    public void Test2(){
        System.out.println("Test 2");
    }
    @Test
    public void Test3(){
        System.out.println("Test 3");
    }
}
