package tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {
        // if you have exception: cannot load a class
        //that means that package name, does not match with location of the class itself
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        // to maximize browser
        driver.manage().window().maximize();
        driver.get("http://google.com");
        //if we want to navigate to the different page
        driver.navigate().to("http://amazon.com");
        String url=driver.getCurrentUrl();
        System.out.println(url);
        driver.close();
    }
}
