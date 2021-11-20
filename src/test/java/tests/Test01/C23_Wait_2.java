package tests.Test01;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C23_Wait_2 extends TestBase {

//2. Bir metod olusturun : isEnabled()
//3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
//4. Textbox’in etkin olmadigini(enabled) dogrulayın
//5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
//6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
//7. Textbox’in etkin oldugunu(enabled) dogrulayın.

    @Test
    public void isEnabled(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        Assert.assertFalse(driver.findElement(By.xpath("//input[@type='text']")).isEnabled());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@style='width: 30%;']")).isEnabled());

    }




}
