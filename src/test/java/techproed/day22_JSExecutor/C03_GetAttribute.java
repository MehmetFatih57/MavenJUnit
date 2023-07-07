package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_GetAttribute extends TestBase {
    @Test
    public void test01() {
        //  https://www.carettahotel.com/ a gidiniz
        driver.get("https://www.carettahotel.com/");
        canakkaleGecilmez(2);
        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        canakkaleGecilmez(2);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        canakkaleGecilmez(2);
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();

        //  Tarih kısmını JS ile locate ediniz.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //WebElement date = (WebElement) js.executeScript("return document.getElementById('checkin_date')");
        WebElement date = (WebElement) js.executeScript("return document.querySelector(\"input[id='checkin_date']\")");
        /*
            Java Script kodlariyla yazilmis webelementleri bizim bildigimiz findElement() methoduyla locate edemeyebiliriz
            js executor kullanarak ister html ister java script ile yazilmis olsun bir webelementin locatini js executor
            ile alabiliriz. Yukaridaki ornekte sayfadaki tarih webelementini js executor ile locate ettik
         */
        date.clear();//-->Silme islemi yaptik
        date.sendKeys("5/10/2023");


        // Date webelemetinin Attribute degerlerini yazdiralim
        String idAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').id").toString();
        String typeAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').type").toString();
        String nameAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').name").toString();
        String valueAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').value").toString();
        System.out.println("id Attribute Degeri : " + idAttributeDegeri);
        System.out.println("type Attribute Degeri : " + typeAttributeDegeri);
        System.out.println("name Attribute Degeri : " + nameAttributeDegeri);
        System.out.println("value Attribute Degeri : " + valueAttributeDegeri);
        /*
            Js executor ile attribute degerlerini yazdirabilmek icin js ile locate ettigimiz webelementin sonuna yukaridaki
            ornekteki gibi hangi attributun degerini yazdirmak istersek sonuna attribute adini yazariz
         */
    }

    @Test
    public void test02() {
        //https://www.priceline.com/ adresine gidiniz
        driver.get("https://www.priceline.com/");

        //Submit butonunun rengini Kirmizi yazınız
        WebElement buton = driver.findElement(By.xpath("//*[text()='Find Your Hotel']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.color='red';" , buton);
    }
}
