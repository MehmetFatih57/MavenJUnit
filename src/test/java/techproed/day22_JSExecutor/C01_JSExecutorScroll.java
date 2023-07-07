package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_JSExecutorScroll extends TestBase {
    /*
        Actions class'indaki gibi js executor ile de sayfada scroll islemi yapabiliriz. Bir webelementi locate edip o
        webelement gorunur olana kadar scroll yapabiliriz.
        "arguments[0].scrollIntoView(true);" , Webelement --> Bu script kodu ile belirtmis oldugumuz webelemente scroll
        yapariz
     */

    @Test
    public void test01() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        canakkaleGecilmez(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weOffer = driver.findElement(By.xpath("(//span[@class='thim-color'])[2]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", weOffer);
        canakkaleGecilmez(2);
        screenShot();

        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFree = driver.findElement(By.xpath("//*[.='Enroll Free Course']"));
        js.executeScript("arguments[0].scrollIntoView(true);", enrollFree);
        canakkaleGecilmez(2);
        screenShot();

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs = driver.findElement(By.xpath("(//h3)[17]"));
        js.executeScript("arguments[0].scrollIntoView(true);", whyUs);
        canakkaleGecilmez(2);
        screenShot();

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFreeEF = driver.findElement(By.xpath("//*[.='Enroll Free Course']"));
        js.executeScript("arguments[0].scrollIntoView(true);", enrollFreeEF);
        canakkaleGecilmez(2);
        screenShot();

        //Sayfayı en alta scroll yapalım
        js.executeScript("arguments[0].scrollIntoView(true);", enrollFreeEF);
        canakkaleGecilmez(2);
        screenShot();

        //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        //Sayfayi en üste scroll yapalım
        WebElement enUst = driver.findElement(By.xpath("//input[@type='search']"));
        js.executeScript("arguments[0].scrollIntoView(true)", enUst);
        canakkaleGecilmez(2);
        screenShot();

        //js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    @Test
    public void test02() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        canakkaleGecilmez(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,2000)");//--> x=0,y=2000 pixel olarak bir noktaya scroll yapar
    }

    @Test
    public void test03() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        canakkaleGecilmez(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weOffer = driver.findElement(By.xpath("(//span[@class='thim-color'])[2]"));
        jsScrollWE(weOffer);
        canakkaleGecilmez(2);
        screenShot();

        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFree = driver.findElement(By.xpath("//*[.='Enroll Free Course']"));
        jsScrollWE(enrollFree);
        canakkaleGecilmez(2);
        screenShot();

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs = driver.findElement(By.xpath("(//h3)[17]"));
        jsScrollWE(whyUs);
        canakkaleGecilmez(2);
        screenShot();

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFreeEF = driver.findElement(By.xpath("//*[.='Enroll Free Course']"));
        jsScrollWE(enrollFreeEF);
        canakkaleGecilmez(2);
        screenShot();

        //Sayfayı en alta scroll yapalım
        scrollEnd();
        canakkaleGecilmez(2);
        screenShot();

        //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        //Sayfayi en üste scroll yapalım
        scrollHome();
        canakkaleGecilmez(2);
        screenShot();

        //js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
}
