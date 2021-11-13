package tests.Test01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C15_MouseActions_3 extends TestBase {

//1- https://www.amazon.com/ adresine gidelim
//2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
//3- “Create a list” butonuna basalim
//4- Acilan sayfada “Your Lists” yazisi oldugunu test edelim

    @Test
    public void test() throws InterruptedException {
        //1- https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
        WebElement liste = driver.findElement(By.xpath("//span[.='Hello, Sign in']"));
        Actions actions = new Actions(driver);

        actions.moveToElement(liste).perform();
        Thread.sleep(5000);

        //3- “Create a list” butonuna basalim
        driver.findElement(By.xpath("//span[.='Create a List']")).click();


        Assert.assertTrue(driver.findElement(By.id("my-lists-tab")).getText().contains("Your Lists"));

    }
}
