package tests.Test01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C16_KeyboardActions extends TestBase {

//2- https://www.amazon.com sayfasina gidelim
//3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
//4- aramanin gerceklestigini test edin

    @Test
    public void test(){
        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        WebElement aramakutus = driver.findElement(By.id("twotabsearchtextbox"));

        Actions actions = new Actions(driver);

        // I.WAY
//        actions.click(aramakutus).perform();
//        actions.sendKeys("samsung").perform();
//        actions.keyDown(Keys.SHIFT).perform();
//        actions.sendKeys("a").perform();
//        actions.keyUp(Keys.SHIFT).perform();
//        actions.sendKeys("71").perform();
//        actions.sendKeys(Keys.ENTER).perform();

        //II.WAY
        actions.click(aramakutus)
                .sendKeys("samsung ")
                .sendKeys(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER).perform();

        //4- aramanin gerceklestigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']")).getText().contains("samsung a71"));

    }

}
