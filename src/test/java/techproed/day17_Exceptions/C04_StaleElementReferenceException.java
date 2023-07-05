package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C04_StaleElementReferenceException extends TestBase {
    /*
    STALE_ELEMENT_REFERENCE_EXCEPTION
        Bir webelementin sayfayi refresh(yenileme) ya da back-forward yapma sonucunda eskimesi(bayatlamasi)
     durumunda bu exception'i aliriz. Yani driver sayfayi yeniden olustudugunda elementin locate'i ayni
     olmasina ragmen tekrar o elementin locate'ini almamizi ister. Almadigimiz takdirde locate'i eskimis olarak
     gorur ve staleElementReferenceException hatasi verir
     */
    @Test
    public void test01() {
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        canakkaleGecilmez(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //arama kutusunda qa aratalim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));

        driver.navigate().refresh();
      /*
        org.openqa.selenium.StaleElementReferenceException hatası aldık çünkü refresh yaptıktan sonra
        tekrar locate almadık. Dolayısıyla bu hatayı handle edebilmek için refresh yaptıktan sonra
        tekrar locate almalıyız.
 */

        aramaKutusu.sendKeys("qa", Keys.ENTER);//--> aramaKutusu eskidigi icin sendKeys() methodunu kullanamadi

        //sayfa basliginin qa icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }

    @Test
    public void test02() {
        /*
        Bu test methodunda test01 methodundaki staleelementreference hatasini nasil handle ettigimizi
         gosterdik
         */
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        canakkaleGecilmez(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //arama kutusunda qa aratalim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        driver.navigate().refresh();

        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("qa", Keys.ENTER);//--> aramaKutusu eskidigi icin sendKeys() methodunu kullanamadi

        //sayfa basliginin qa icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));

    }

    @Test
    public void test03() {
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        canakkaleGecilmez(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //arama kutusunda qa aratalim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        aramaKutusu.sendKeys("developer",Keys.ENTER);

        driver.navigate().back();

        driver.navigate().forward();
        /*
        org.openqa.selenium.StaleElementReferenceException : back- forward sonrasinda da bu hatayi aldik
         */

        aramaKutusu.sendKeys("qa", Keys.ENTER);

        //sayfa basliginin qa icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }


        @Test
        public void test04() {
            //amazon sayfasına gidelim
            driver.get("https://amazon.com");

            //arama kutusunda iphone aratalım
            WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
            aramaKutusu.sendKeys("iphone",Keys.ENTER);

            //çıkan sonuclardan ilk beşine tıklayıp,her ürünün başlığını konsola yazdıralım
            List<WebElement> urunler = driver.findElements(By.xpath("//*[@class='aok-relative']"));
            for (int i = 0; i < urunler.size() ; i++) {
                urunler.get(i).click();
                canakkaleGecilmez(2);
                System.out.println(driver.getTitle());
                driver.navigate().back();
                canakkaleGecilmez(2);
                if (i==4){
                    break;
                }
                urunler = driver.findElements(By.xpath("//*[@class='aok-relative']"));//S.E.R.E hatasini handle ettik
            }
        }
    }
