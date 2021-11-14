package tests.Test01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C17_KeyboardActions_2 extends TestBase {

//2- https://html.com/tags/iframe/ sayfasina gidelim
//3- video’yu gorecek kadar asagi inin
//4- videoyu izlemek icin Play tusuna basin
//5- videoyu calistirdiginizi test edin

    @Test
    public void test() throws InterruptedException {
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe");

        //3- video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //4- videoyu izlemek icin Play tusuna basin
        WebElement iFrame=driver.findElement(By.className("lazy-loaded"));
        driver.switchTo().frame(iFrame);

        WebElement playtusu=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        actions.click(playtusu).perform();
        Thread.sleep(4000);

        //5- videoyu calistirdiginizi test edin
        Assert.assertFalse(playtusu.isDisplayed());


    }
}
