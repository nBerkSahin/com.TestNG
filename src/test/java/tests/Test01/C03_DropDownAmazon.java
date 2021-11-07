package tests.Test01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C03_DropDownAmazon {

//https://www.amazon.com/ adresine gidin.
//- Test 1
//Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
//-Test 2
//1. Kategori menusunden Books secenegini secin
//2. Arama kutusuna Java yazin ve aratin
//3. Bulunan sonuc sayisini yazdirin
//4. Sonucun Java kelimesini icerdigini test edin

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        driver.get("https://www.amazon.com/ ");
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select nesne = new Select(dropdown);
        List<WebElement> tumopsiyonlar = nesne.getOptions();

        for (WebElement each:tumopsiyonlar){
            System.out.println(each.getText());
        }
//Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        System.out.println(tumopsiyonlar.size());

    }


    @Test
    public void test2(){
        driver.get("https://www.amazon.com/ ");

//1. Kategori menusunden Books secenegini secin
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select nesne = new Select(dropdown);
        nesne.selectByIndex(5);
        //System.out.println(nesne.getFirstSelectedOption().getText());

//2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

//3. Bulunan sonuc sayisini yazdirin
        WebElement aa = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        System.out.println(aa.getText());
//4. Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(aa.getText().contains("Java"));

    }

}
