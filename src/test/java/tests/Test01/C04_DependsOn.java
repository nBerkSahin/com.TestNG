package tests.Test01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class C04_DependsOn {

//https://www.amazon.com/ adresine gidin.
//1. Test : Amazon ana sayfaya gittiginizi test edin
//2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin ve aramanizin gerceklestigini Test edin
//3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $16.83 oldugunu test edin

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void test1(){
        //1. Test : Amazon ana sayfaya gittiginizi test edin
        driver.get("https://www.amazon.com/");

        //1. Test : Amazon ana sayfaya gittiginizi test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon.com"));

    }

    @Test //2. methodu tek başına çalıştırmak istesek bile otomatik olarak 1. method çalışır
                                    //1.method failed olursa 2.method ignore edilir.
    public void test2(){
        //2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin ve aramanizin gerceklestigini Test edin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("Nutella"));

    }

    @Test
    public void test3(){
        //3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $16.83 oldugunu test edin
        System.out.println(driver.findElement(By.xpath("//span[@class='a-size-base']")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='a-size-base']")).getText().contains("20,412"));

    }

    @AfterClass
    public void teardown(){
        driver.close();

    }


}
