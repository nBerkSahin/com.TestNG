package tests.Test01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C08_SoftAssertTest_2 {

//1. “https://www.hepsiburada.com/” Adresine gidin
//2. Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
//3. search kutusuna araba yazip arattirin
//4. bulunan sonuc sayisini yazdirin
//5. sonuc yazisinin "araba" icerdigini dogrulayin
//6. Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin

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

        //1. “https://www.hepsiburada.com/” Adresine gidin
        driver.get("https://www.hepsiburada.com/");
        String e1 = driver.getTitle().toString();

        SoftAssert softAssert=new SoftAssert();

        //2. Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
        softAssert.assertTrue(driver.getTitle().contains("Türkiye'nin En Büyük Online Alışveriş Sitesi"));

        //3. search kutusuna araba yazip arattirin
        driver.findElement(By.className("desktopOldAutosuggestTheme-input")).sendKeys("araba"+ Keys.ENTER);

        //4. bulunan sonuc sayisini yazdirin
        System.out.println(driver.findElement(By.xpath("//*[@id=\"SearchResultSummary\"]")).getText());

        //5. sonuc yazisinin "araba" icerdigini dogrulayin
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id=\"SearchResultSummary\"]")).getText().contains("araba"));

        //6. Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin
        softAssert.assertFalse(driver.findElement(By.xpath("//*[@id=\"SearchResultSummary\"]")).getText().contains("oto"));

        softAssert.assertAll();

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
