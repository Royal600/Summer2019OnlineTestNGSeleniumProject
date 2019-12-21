package tests.day7;

import org.testng.Assert;
import org.testng.annotations.*;

public class Training2 {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method");
    }


    @Test
    public void test1(){
        System.out.println("Test1");
        Assert.assertTrue(5==5);
    }
    @Test
    public void tes2(){
        System.out.println("Test2");
    }
    @Test
    public void test3(){
        System.out.println("Test3");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
}
