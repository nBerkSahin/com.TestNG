package tests.Test01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C02_DropDown {

//https://the-internet.herokuapp.com/dropdown adresine gidin.
//1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
//2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
//3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
//4.Tüm dropdown değerleri(value) yazdırın
//5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void tests(){
        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select nesne = new Select(dropdown);
        nesne.selectByIndex(1);
        System.out.println(nesne.getFirstSelectedOption().getText());

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        nesne.selectByValue("2");
        System.out.println(nesne.getFirstSelectedOption().getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        nesne.selectByVisibleText("Option 1");
        System.out.println(nesne.getFirstSelectedOption().getText()); //Menüde ne seçiliyse onu yazdırır

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> tumopsiyonlar = nesne.getOptions();
        for (WebElement each:tumopsiyonlar
             ) {
            System.out.println(each.getText());
        }

        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        System.out.println(tumopsiyonlar.size());
        if (tumopsiyonlar.size()==4){
            System.out.println("true");
        }else System.out.println("false");
    }


}
