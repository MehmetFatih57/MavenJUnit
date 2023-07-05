package techproed.ODEV;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C02_Exercise extends TestBase {
    @Test
    public void test01() {
        //  ...Exercise2...
        //  1-driver olusturalim
        //  2-java class'imiza chromedriver.exe'yi tanitalim
        //  3-driver'in tum ekrani kaplamasini saglayalim
        //  4-driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
        //    söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
        //  5-"sahibinden.com" adresine gidelim
        driver.get("https://sahibinden.com");
        String handleSahibinden=driver.getWindowHandle();
        //  6-bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
        String baslik=driver.getTitle();
        String url=driver.getCurrentUrl();
        //  7-title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(baslik.contains("Oto"));
        Assert.assertFalse(url.contains("Oto"));
        //  8-Ardindan "gittigidiyor.com" adresine gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://hepsiburada.com");
        String handleGittigidiyor=driver.getWindowHandle();
        //  9-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini
        //    kontrol edelim
        assert driver.getTitle().contains("Sitesi");
        //  10-Bi onceki web sayfamiza geri donelim
        driver.switchTo().window(handleSahibinden);
        //  11-sayfayi yenileyelim
        driver.navigate().refresh();
        //  12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.switchTo().window(handleGittigidiyor);
        driver.close();
        //  13-En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();
    }
}
