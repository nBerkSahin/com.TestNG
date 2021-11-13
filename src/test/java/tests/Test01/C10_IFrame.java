package tests.Test01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C10_IFrame {

//https://the-internet.herokuapp.com/iframe adresine gidin.
//“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
//Text Box’a “Merhaba Dunya!” yazin.
//TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void iFrame(){
        //https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("An iFrame containing"));

        //Text Box’a “Merhaba Dunya!” yazin.
        driver.switchTo().frame("mce_0_ifr");
        WebElement ee = driver.findElement(By.xpath("//*[@id='tinymce']"));
        ee.clear();
        ee.sendKeys("Mehaba Dünya");

        //TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
        driver.switchTo().defaultContent();//En ustteki frame’e cikmak icin kullanilir
        Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).getText().contains("Elemental Selenium"));
    }



}
