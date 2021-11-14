package tests.Test01;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C20_FileExist_2 extends TestBase {

//2. Iki tane metod oluşturun : isExist() ve downloadTest()
//3. downloadTest () metodunun icinde aşağıdaki testi yapalim:
//   - https://the-internet.herokuapp.com/download adresine gidelim.
//   - code.txt dosyasını indirelim
//4. Ardından isExist() methodunda dosyanın başarıyla indirilip indirilmediğini test edelim


    @Test (priority = 2)
    public void isExist(){
    //4. Ardından isExist() methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = System.getProperty("user.home") + "/Downloads/NewDoc.txt";
        System.out.println(dosyaYolu);
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test (priority = 1)
    public void downloadTest(){
    //   - https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

    //   - code.txt dosyasını indirelim
        driver.findElement(By.linkText("NewDoc.txt")).click();
    }



}
