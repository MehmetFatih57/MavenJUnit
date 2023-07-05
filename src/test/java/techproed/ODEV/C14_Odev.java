package techproed.ODEV;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class C14_Odev extends TestBase {
    @Test
    public void test01() {
        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim
        List<WebElement> sayilar=driver.findElements(By.xpath("(//span[@class='btn btn-outline-primary'])[position()<11]"));
        System.out.println(sayilar.size());
        int sayiIndex=0;

        List<WebElement> islemler = driver.findElements(By.xpath("//span[@class='operator btn btn-outline-success']"));
        Random random2 = new Random();
        int islemindex = random2.nextInt(islemler.size());
        WebElement islem=islemler.get(islemindex);

        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j < 2; j++) {
                Random random1=new Random();
                sayiIndex=random1.nextInt(sayilar.size());
                sayilar.get(sayiIndex).click();
            }
            //random 4 işlemden birini yaptıralım
            if (i<1) {
                islem.click();
            }
        }
        String sonucYazisi = driver.findElement(By.xpath("//*[@class='screen']")).getText();
        System.out.println(sonucYazisi);
        String[] split = sonucYazisi.split("[-+x÷]");

        String stringRakam1 = split[0];
        double doubleRakam1 = Double.parseDouble(stringRakam1);
        System.out.println("doubleRakam1 = " + doubleRakam1);

        String stringRakam2 = split[1];
        double doubleRakam2 = Double.parseDouble(stringRakam2);
        System.out.println("doubleRakam2 = " + doubleRakam2);

        driver.findElement(By.xpath("//span[@class='btn btn-outline-warning']")).click();//enter tuşuna bastık

        //Sonucu konsola yazdırıp

        double sonuc=0;

        if (islem.getText().equals("+")){
            sonuc =doubleRakam1 + doubleRakam2;
        }else if (islem.getText().equals("-")){
            sonuc =doubleRakam1 - doubleRakam2;
        }else if (islem.getText().equals("x")){
            sonuc =doubleRakam1 * doubleRakam2;
        }else if (islem.getText().equals("÷")){
            sonuc =doubleRakam1 / doubleRakam2;

        }
        System.out.println(sonuc);

        WebElement sonucKutusu = driver.findElement((By.xpath("//*[text()="+sonuc+"]")));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(sonucKutusu));
        //Sonucun doğrulamasını yapalım
        Assert.assertEquals(""+sonuc,sonucKutusu.getText());
    }
}
