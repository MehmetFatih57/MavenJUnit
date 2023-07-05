package techproed.ODEV;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C11_Odev extends TestBase {
    @Test
    public void name() {
        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement sayfa = driver.findElement(By.xpath("//div[@class='signature-pad--body']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(sayfa)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .release()
                .perform();
        canakkaleGecilmez(4);

        //- Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//button[@class='button clear']")).click();

        canakkaleGecilmez(2);

        //- Sayfayi kapatiniz
        driver.quit();
    }
}