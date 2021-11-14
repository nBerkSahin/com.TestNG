package tests.Test01;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C18_KeyboardActions_3 extends TestBase {

//1- "http://webdriveruniversity.com/Actions" sayfasina gidin
//2- Hover over Me First" kutusunun ustune gelin
//3- Link 1" e tiklayin
//4- Popup mesajini yazdirin
//5- Popup'i tamam diyerek kapatin
//6- “Click and hold" kutusuna basili tutun
//7-“Click and hold" kutusunda cikan yaziyi yazdirin
//8- “Double click me" butonunu cift tiklayin

    @Test
    public void test(){
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("//*[@class='dropbtn'][1]")).click();
        driver.findElement(By.xpath("//*[@class='list-alert'][1]")).click();

        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6- “Click and hold" kutusuna basili tutun
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='click-box'][1]")));
        actions.clickAndHold().perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//*[@id='click-box'][1]")).getText());

        //8- “Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.xpath("//*[@id='double-click']"))).perform();
    }
}
