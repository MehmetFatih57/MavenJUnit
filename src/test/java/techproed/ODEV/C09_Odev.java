package techproed.ODEV;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class C09_Odev extends TestBase {

    @Test
    public void test01() {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // İkinci emoji öğelerini yazdırınız
        String emojiler = driver.findElement(By.xpath("//div[@class='mdl-tabs__panel is-active']")).getText();
        System.out.println(emojiler);

        // Parent iframe e geri donun
        driver.switchTo().parentFrame();

        // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        driver.findElement(By.xpath("(//input[@class='mdl-textfield__input'])[1]")).
        sendKeys("Merhaba" , Keys.TAB , ":)" , Keys.TAB , "Fatih" , Keys.TAB , "Manti" , Keys.TAB , "Yazilim" ,
        Keys.TAB , "Istanbul" , Keys.TAB , "Bilgisayar" , Keys.TAB , "Ekran" , Keys.TAB , "Vatan" , Keys.TAB , ":))" , Keys.TAB , ":))))" , Keys.TAB);

        // Apply buttonabasiniz
        driver.findElement(By.xpath("(//button)[1]")).click();
    }
}
