package tests.Test01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C22_Wait extends TestBase {

//2. Iki tane metod olusturun : implicitWait() , explicitWait()
//    Iki metod icin de asagidaki adimlari test edin.
//3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
//4. Remove butonuna basin.
//5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
//6. Add buttonuna basin
//7. It’s back mesajinin gorundugunu test edin

    @Test
    public void implicitWait(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@type='button'][1]")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        SoftAssert softAssert = new SoftAssert();

        WebElement sonucYazısı = driver.findElement(By.xpath("//p[@id='message']"));
        softAssert.assertTrue(sonucYazısı.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement yazi = driver.findElement(By.xpath("//*[@id='message']"));
        softAssert.assertTrue(yazi.isDisplayed());

        softAssert.assertAll();

    }

    @Test
    public void explicitWait(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@type='button'][1]")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver,20);

        // expilicitly wait'i istersek locate işlemi ile birlikte tek satırda yapabliriz

        WebElement yaziLocate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(yaziLocate.isDisplayed());

        // veya once locate edip uygun method kullanarak beklemeyi yaptirabiliriz
        // ancak bu test icin once webelement'i olusturmak anlamsiz olur
        // cunku biz wait i;lemini zaten o webelement olussun diye yapiyoruz
        // wait olmadan o element olmaz , o element olmadan da sectigimiz method caismaz
        /*
        WebElement sonucYazisi=driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(sonucYazisi));
        Assert.assertTrue(sonucYazisi.isDisplayed());
        */

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackLocate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsBackLocate.isDisplayed());

    }


}
