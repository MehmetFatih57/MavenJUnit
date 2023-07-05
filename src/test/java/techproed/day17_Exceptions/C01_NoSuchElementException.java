package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void test01() {
        /*
        NO_SUCH_ELEMENT_EXCEPTION
            -Bir webelementin locate'ini yanlis aldigimizda, elementi bulamayacagi icin bu
            exception'i aliriz
         */

        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //arama kutusunda qa aratalim
        driver.findElement(By.xpath("//input[@id='selementor-search-form-9f26725']")).sendKeys("qa" , Keys.ENTER);
        /*normal locate'imiz input[@id='elementor-search-form-9f26725'] bu sekilde iken NoSuchElementException alabilmek icin
         locate'i bozduk //input[@id='selementor-search-form-9f26725'] ve exception'i aldigimizi gorduk.  Dolayisiyla bu
         hatayi handle edebilmek icin duzgun locate almamiz gerekiyor. Webelement bir iframe icinde olabilir, bir butona tikladigimizda yeni bir
        pencere acilabilir yada alert cikabilir bu gibi durumlarda da nosuchelementexception aliriz
        */
        //sayfa basliginin qa icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }

    @Test
    public void test02() {
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //arama kutusunda qa aratalim
        driver.findElement(By.cssSelector("//input[@id='elementor-search-form-9f26725']")).sendKeys("qa" , Keys.ENTER);
        /*normal locate'imiz input[@id='elementor-search-form-9f26725'] bu sekilde iken NoSuchElementException alabilmek icin
         locate'i bozduk //input[@id='selementor-search-form-9f26725'] ve exception'i aldigimizi gorduk.  Dolayisiyla bu
         hatayi handle edebilmek icin duzgun locate almamiz gerekiyor
        */

         /*
            org.openqa.selenium.InvalidSelectorException: xpath ile aldığımız bir webelementin locate'ini
            cssSelector locator ile kullanırsak bu exception'ı alırız. Dolayısıyla bunu handle etmek için
            doğru locator'ı kullanmamız gerekir.
        */

        //sayfa basliginin qa icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }
}
