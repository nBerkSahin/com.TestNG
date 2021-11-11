package tests.Test01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C06_SoftAssertion {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void test(){
        driver.get("https://www.amazon.com");

        //öncelikle başta nesne oluşturulur
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(driver.getCurrentUrl().contains("amazon"),"url amazon içermiyor");

        softAssert.assertTrue(driver.getTitle().contains("amazon"),"title amazon içermiyor");
        System.out.println("assertion failed olduğu halde bu satır çalışır");

        WebElement aramakutus = driver.findElement(By.id("twotabsearchtextbox"));
        aramakutus.sendKeys("java"+ Keys.ENTER);
        WebElement aa = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal'][1]"));
        softAssert.assertTrue(aa.getText().contains("Java"), "il urun java icerior");

        //assertall fonk. ile bitirilir
        softAssert.assertAll();
        //assertionlar pass olsada olmasada assertAll'a kadar tum satırlar calısır
        //ama eger tetstlerden bir tanesi bile faild ise assertAll dan sonrası çalışmaz
        System.out.println("Bu satır çalışmayacak");

    }



}
