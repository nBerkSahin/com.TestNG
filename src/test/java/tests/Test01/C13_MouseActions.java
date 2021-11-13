package tests.Test01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C13_MouseActions extends TestBase {

//2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
//3- Cizili alan uzerinde sag click yapalim
//4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
//5- Tamam diyerek alert’I kapatalim
//6- Elemental Selenium linkine tiklayalim
//7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

@Test
    public void test(){

    //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
    driver.get("https://the-internet.herokuapp.com/context_menu");

    //3- Cizili alan uzerinde sag click yapalim
    Actions actions = new Actions(driver);
    WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));
    actions.contextClick(ciziliAlan).perform();

    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
    Assert.assertTrue(driver.switchTo().alert().getText().contains("You selected a context menu"));

    //5- Tamam diyerek alert’I kapatalim
    driver.switchTo().alert().accept();

    //6- Elemental Selenium linkine tiklayalim
    String ilksayfahandle = driver.getWindowHandle();
    driver.findElement(By.linkText("Elemental Selenium")).click();

    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
    Set<String> windowTumhandle = driver.getWindowHandles();

    String ikinciSayfaHandle="";

    for (String each:windowTumhandle){
        if (!each.equals(ilksayfahandle)){
            ikinciSayfaHandle=each;
        }
    }

    driver.switchTo().window(ikinciSayfaHandle);
    Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Elemental Selenium"));

}

}
