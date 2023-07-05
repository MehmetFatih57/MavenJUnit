package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class C02_Alerts extends TestBase {
      /*
            Eger bir sayfadaki bir buttona tikladigimizda bir uyari penceresi cikiyorsa ve bu cikan pencereye sag click  yapip
            locate alamiyorsak, bu bir Js Alert'tur.
            Js Alert'u handle edebilmek icin driver'imizi o pencereye gecirmemeiz gerekir. Bunun icin; driver objemizi kullanarak
            swichTo() methoduyla alert() methodunu kullanarak js alert'e gecir yapmis oluruz.
            accept() ya da dismiss() methodlariyla js Alert'u onaylar ya da iptal ederek kapatiriz

            @IGNORE:Calismasini istemedigimiz test'in basina yazariz
         */

    @Test
    public void acceptAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //Bir metod olusturun: acceptAlert
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
        canakkaleGecilmez(3);
        driver.switchTo().//geçmek için kullanılan method
                alert().//alert'e geçiş yapar
                accept();//çıkan alert'te ok yada tamam butonuna tıklar
        canakkaleGecilmez(2);
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).getText().equals("You successfully clicked an alert"));
    }

    @Test //@Ignore Calismasini istemedigimiz test notasyonundan sonra (@Test) @Ignore notasyonu kullanırız
    public void dismissAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        canakkaleGecilmez(3);
        //Bir metod olusturun: dismissAlert
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
        canakkaleGecilmez(2);
        driver.switchTo().alert().dismiss();
        Assert.assertFalse(driver.findElement(By.xpath("//p[@id='result']")).getText().contains("You successfully clicked an alert"));
    }

    @Test
    public void sendKeysAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //Bir metod olusturun: sendKeysAlert
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
        canakkaleGecilmez(2);
        driver.switchTo().alert().sendKeys("Fatih" + Keys.ENTER);
        driver.switchTo().alert().accept();
        canakkaleGecilmez(2);
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).getText().contains("Fatih"));
    }
}