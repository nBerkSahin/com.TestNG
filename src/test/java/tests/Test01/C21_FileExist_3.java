package tests.Test01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C21_FileExist_3 extends TestBase {

//1. Tests packagenin altina bir class oluşturun : C05_UploadFile
//2. https://the-internet.herokuapp.com/upload adresine gidelim
//3. chooseFile butonuna basalim
//4. Yuklemek istediginiz dosyayi secelim.
//5. Upload butonuna basalim.
//6. “File Uploaded!” textinin goruntulendigini test edelim.

    @Test
    public void C05_UploadFile() throws InterruptedException {
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3. chooseFile butonuna basalim


        //4. Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = System.getProperty("user.home")+ "/Users/nazmiberksahin/Desktop/flower.jpeg";
        WebElement dosyaYukle = driver.findElement(By.id("file-upload"));

        dosyaYukle.sendKeys(dosyaYolu);

        //5. Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(3000);
        WebElement sonucYazı = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(sonucYazı.isDisplayed());

        //6. “File Uploaded!” textinin goruntulendigini test edelim.

    }



}
