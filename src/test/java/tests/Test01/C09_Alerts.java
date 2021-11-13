package tests.Test01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C09_Alerts {

//https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
//Bir metod olusturun: acceptAlert
//1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
//Bir metod olusturun: dismissAlert
//2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
//Bir metod olusturun: sendKeysAlert
//3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void acceptALert(){
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        String ss = driver.switchTo().alert().getText();    //getText() => Uyarıdaki(alert) mesajı almak için.
        System.out.println(ss);

        driver.switchTo().alert().accept(); //accept() => Bir uyarıda(alert) OK'ı tıklamakla aynı.

        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("You successfully clicked an alert"));

    }

    @Test
    public void dismissAlert(){
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        driver.switchTo().alert().dismiss(); //dismiss() => Bir uyarıda(alert) Cancel'ı tıklamakla aynı.

        Assert.assertFalse(driver.findElement(By.id("result")).getText().contains("successfuly"));

    }

    @Test
    public void sendKeysAlert(){
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        driver.switchTo().alert().sendKeys("Berk"); //sendKeys(“Text”) => Uyarı(alert) text kutusuna text göndermek için

        driver.switchTo().alert().accept();

        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("Berk"));

    }

    @AfterClass
    public void teardown(){
        driver.close();
    }

}
