package tests.Test01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_Priority {

//    1.amazon ana sayfa
//    2.apple ana sayfa
//    3.facebook ana sayfa
//    4.title ları al

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test (priority = 1)
    public void amazonTest(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());

    }
    @Test(priority = 3)
    public void appleTest(){
        driver.get("https://www.apple.com");
        System.out.println(driver.getTitle());

    }

    @Test(priority = 2)
    public void faceTest(){
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());

    }


    @AfterMethod
    public void tearDown(){
        driver.close();

    }


}
