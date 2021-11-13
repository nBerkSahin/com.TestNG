package tests.Test01;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C12_WindowHandle extends TestBase {

//https://the-internet.herokuapp.com/windows adresine gidin.
//Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
//Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
//Click Here butonuna basın.
//Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
//Sayfadaki textin “New Window” olduğunu doğrulayın.
//Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

    @Test
    public void test(){
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains("Opening a new window"));

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        // 1- window handle ederken ilk adım 1. sayfa açık iken o sayfanın handle değerini alıp bir string e atmak
        String ilkSayfaHandle = driver.getWindowHandle();

        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        // 2- İkinci adım iki sayfa açıldığında her iki sayfanın handle değerini koymak için bir set oluşturup
        //getWindowHandles methodu ile bu değerleri elde etmek
        Set<String> tumWindowHandle = driver.getWindowHandles();

        // 3- Set içerisinde birinci sayfanın handle değerine eşit olmayan handle değerini bulup bir string e atamak
        String ikinciWindowhandle="";
        for (String each:tumWindowHandle
             ) {
            if (!each.equals(ilkSayfaHandle)){
                ikinciWindowhandle=each;
            }
        }

        driver.switchTo().window(ikinciWindowhandle); //pencereler arasında geçiş yapma(switch) metodu

        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("New Window"));

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandle);
        Assert.assertTrue(driver.getTitle().contains("The Internet"));


    }


}
