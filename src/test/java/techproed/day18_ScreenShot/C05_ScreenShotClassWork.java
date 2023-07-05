package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C05_ScreenShotClassWork extends TestBase {
    @Test
    public void test01() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        String techProHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        canakkaleGecilmez(2);

        //sayfanın resmini alalım
        screenShot();

        //Arama bölümünde java aratalım
        driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']")).sendKeys("java" , Keys.ENTER);

        //ve sonuc yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1"));
        webElementResmi(sonucYazisi);

        //Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        canakkaleGecilmez(5);

        //sayfanın resmini alalım
        screenShot();

        //arama bölümde iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone" , Keys.ENTER);

        //ve sonuc yazısının resmini alalım
        WebElement sonucYazisi2 = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        webElementResmi(sonucYazisi2);

        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
        switchToWindow1(0);
        screenShot();

    }
}
