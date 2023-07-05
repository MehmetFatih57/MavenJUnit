package techproed.ODEV;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C12_Odev extends TestBase {
    @Test
    public void test01() {
        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        driver.switchTo().frame(0);

        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        WebElement yesil = driver.findElement(By.xpath("//div[@id='green']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(yesil).moveByOffset(-160, 0).perform();

        WebElement mavi = driver.findElement(By.xpath("//div[@id='blue']"));
        actions.clickAndHold(mavi).moveByOffset(-160, 0).perform();

        canakkaleGecilmez(2);

        //-Sarı olduğunu test edelim
        actions.clickAndHold(yesil).moveByOffset(160, 0).perform();
        WebElement kutu = driver.findElement(By.cssSelector("div#swatch"));
        String sari = kutu.getAttribute("style");
        String atributeName = "background-color: rgb(255, 127, 0);";
        Assert.assertEquals(sari, atributeName);
    }
}
