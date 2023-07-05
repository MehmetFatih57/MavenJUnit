package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C03_Alerts extends TestBase {
    @Test
    public void test01() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");

        //Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[2]")).click();
        canakkaleGecilmez(2);
        //Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
        System.out.println("Alert uzerindeki yazi : " + getTextAlert());//-->TestBase class'ında oluşturmuş olduğumuz method
        Assert.assertEquals("You clicked a button",getTextAlert());
        canakkaleGecilmez(2);
        //Ve alert'ü kapatalım
        acceptAlert();//-->TestBase class'ında oluşturmuş olduğumuz method
    }

    @Test
    public void test02() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");

        //On button click, confirm box will appear karsisindaki buttona basalim
        driver.findElement(By.xpath("(//button)[4]")).click();
        canakkaleGecilmez(2);

        //Cikan alertte iptal'e basalim
        dismissAlert();

        //Sonuc yazisinda You selected Cancel yazdigini dogrulayalim
        String sonucYazisi = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals("You selected Cancel" , sonucYazisi);
    }

    @Test
    public void test03() {
        driver.get("https://demoqa.com/alerts");
        //On button click, prompt box will appear karsisindaki butona tiklayalim
        driver.findElement(By.xpath("(//button)[5]")).click();
        canakkaleGecilmez(2);
        //cikan alerte ismimizi girelim
        sendKeysAlert("Fatih");
        canakkaleGecilmez(2);
        acceptAlert();
        //ismi girdigimizi dogrulayalim.
        String sonucYazisi = driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(sonucYazisi.contains("Fatih"));
    }
}
