package tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Training {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
      String actualResult= driver.getTitle();
      String expectedResult= "Google";

      if(actualResult.equals(expectedResult)){
          System.out.println("True");
      }else{
          System.out.println("False");
      }

        driver.quit();
    }
}
