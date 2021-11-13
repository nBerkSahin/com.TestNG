package tests.Test01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C14_MouseActions_2 extends TestBase {

//1- https://demoqa.com/droppable adresine gidelim
//2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
//3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test(){

        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement dragElement = driver.findElement(By.id("draggable"));
        WebElement dropElement = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(dragElement,dropElement).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedYazısı = driver.findElement(By.xpath("//*[text()='Dropped!']"));

        String actualDroppedyazisi=droppedYazısı.getText();
        String expectedDroppedYazısı="Dropped!";

        Assert.assertEquals(actualDroppedyazisi,expectedDroppedYazısı);

    }

}
