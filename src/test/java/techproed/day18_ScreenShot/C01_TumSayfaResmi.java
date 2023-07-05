package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TumSayfaResmi extends TestBase {
    /*
SCREENSHOT
       Selenium'da tüm ekran görüntüsünü alabilmek için TakesScreenShot arayünden bir obje oluşturup
   driver'a eşitleriz. Arayüzler farklı olduğu için casting yaparız. Ve bu oluşturduğumuz obje ile
   getScreenshotAs methodu ile sayfanın resmini alırız. Almış olduğumuz resmi projemizde nereye kaydedeceksek
   oranın yolunu belirtiriz.
 */
    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        /*
            -Ilk olarak SS aldigimizda nereye kaydetmek istiyorsak oranin yolunu belirtelim
            -Ikinci olarak TakesScreenShot arayuzundan obje olusturunuz
            -Ucuncu olarak FileUtils class'indan copyFile() methodu ile ts objemizi kullanarak getScreenShotAs() methodu ile
              dosya yolunu belirtecegiz
         */

        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot2.png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE) , new File(dosyaYolu));
    }

    @Test
    public void test02() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        /*
            -Ilk olarak SS aldigimizda nereye kaydetmek istiyorsak oranin yolunu belirtelim
            -Ikinci olarak TakesScreenShot arayuzundan obje olusturunuz
            -Ucuncu olarak FileUtils class'indan copyFile() methodu ile ts objemizi kullanarak getScreenShotAs() methodu ile
              dosya yolunu belirtecegiz
         */

        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE) , new File("ScreenShot/screenShot.png"));
    }
    @Test
    public void test03() throws IOException {
        /*
            Kaydettigimiz ekran resmini her seferinde ayni dosya uzerine yazmamasi icin dosya isminden sonra String bir
            degiskene tarih formati atayabiliriz
         */

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        canakkaleGecilmez(2);

        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        /*
            SimpleDateFormat'i kullanarak yeni bir tarih formati olusturup bir String'e assing ederiz. Ve bunu dosya isminden once
            belirtiriz.
         */
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE) , new File(dosyaYolu));
    }

    @Test
    public void test04() throws IOException {
        /*
            Kaydettigimiz ekran resmini her seferinde ayni dosya uzerine yazmamasi icin dosya isminden sonra String bir
            degiskene tarih formati atayabiliriz
         */

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        canakkaleGecilmez(2);

        //Ve ekran görüntüsünü alalım
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }
}
