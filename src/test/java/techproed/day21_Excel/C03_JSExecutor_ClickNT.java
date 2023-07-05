package techproed.day21_Excel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_JSExecutor_ClickNT extends TestBase {
    /*
        Bir web sayfasında bazı webelementler oluşturulurken JAVASCRIPT kodlarıyla oluşturulmuş olabilir.
    Bu webelementleri handle edebilmek için JavaScriptExecutor arayüzünü kullanmamız gerekir.
    Bir webelement JavaScript kodları ile yazılmamış olsada javaScriptExecutor ile o webelementi handle edebiliriz.
    Normal bildiğimiz methodlardan daha yavaş çalışacağı için bildiğimiz methodlar işimizi görüyorsa onları kullanırız.
    <script> tagi ile oluşturulmuş olan web elementleri de js executor ile handle edebiliriz.
     */

    @Test
    public void test01() {
        //Amazon sayfasina gidiniz
        driver.get("https://amazon.com");
        canakkaleGecilmez(2);

        //sell linkinin resmini alalim
        WebElement selLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(selLinki);

        //Sell linkine js executor kullanarak tiklayiniz
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();" , driver.findElement(By.xpath("//*[.='Sell']")));

        //Basligin sell iceridigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //sayfanin resmini alalim
        screenShot();
    }

    @Test
    public void test02() {
        //Amazon sayfasina gidiniz
        driver.get("https://amazon.com");
        canakkaleGecilmez(2);

        //sell linkinin resmini alalim
        WebElement selLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(selLinki);

        //Sell linkine js executor kullanarak tiklayiniz
        selLinki.click();
         /*
        JS executor ile Webelementin önünde uyarı çıkmasına rağmen webelemente click yaptı çünkü kodlara direk ulaşıyor
        Normal kullandığımız click methodu burda önünde farklı bir element olduğu için ElementClickInterceptedException:
        hatası verdi.Dolayısıyla bu exception ile karşılaştığımızda da js executor ile bunu çözebiliriz
         */

        //Basligin sell iceridigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //sayfanin resmini alalim
        screenShot();
    }

    @Test
    public void test03() {
        //Amazon sayfasina gidiniz
        driver.get("https://amazon.com");
        canakkaleGecilmez(2);

        //sell linkinin resmini alalim
        //driver.findElement(By.xpath("(//span[@class='a-button-inner'])[1]")).click();
        WebElement selLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        canakkaleGecilmez(2);
        webElementResmi(selLinki);

        //Sell linkine js executor kullanarak tiklayiniz
        click(selLinki);//-->Click methodu ile normal click yapmayı denedi fakat olmadı js excutor ile click yaptı

        //Basligin sell iceridigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //sayfanin resmini alalim
        screenShot();
    }
}
