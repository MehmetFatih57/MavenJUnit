package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown {
    /*
        DROPDOWN    -->Alt basliklarin oldugu acilir menu listesidir
        Dropdown'u handle(outomate) etmek icin
            i) Dropdown menuyu ilk olarak locate ederiz
           ii) Select objesi olustururuz
          iii) Select objesinin ddm webelementinin icerigine ve seceneklerine erisim saglamasi icin SELECT sinifina arguman
               olarak locate ettigimiz webelementi koyariz.

          SYNTAX:
               Select select = new Select(ddm webelementi)
         iiii) Select class'i sadece <select> tag'i ile olusturulmus dropdown menulere uygulanabilir
        iiiii) Select objesi dropdown menuyu handle edebilmek icin 3 method kullanir
               -selectByVisibleText() -> Ddm'deki elemente gorunur metin ile ulasmak icin kullanilir
               -selectByIndex() -> Index ile ulasmak icin kullanilir(Index 0(sifir))'dan baslar
               -selectByValue() -> Elementin degeri ile ulasmak icin kullanilir(option tag'larindaki deger(value) ile)
       iiiiii) getOprions() -> Locate ettigimiz ddm'deki tum secenekleri bize verir. (List'e atip loop ile yazdirabiliriz)
      iiiiiii) getFirstSelectedOption() -> Ddm'deki secili kalan secenegi bize verir. Birden fazla secenek secildiyse,
               bu secilenlerin ilkini verir
     iiiiiiii) Ddm'ye sendKeys() methodu ile de ddm menudeki seceneklerden birini kullanarak gonderebiliriz.
     */

    WebDriver driver;

    /*
        Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        -3 farklı test methodu oluşturalım
        1.Method:
        a. Yil,ay,gün dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        2.Method:
        a. Tüm eyalet isimlerini yazdıralım
        3.Method:
        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

 */

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() {
        //  1.Method:
        //        a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil = driver.findElement(By.xpath("(//select)[2]"));
        WebElement ay = driver.findElement(By.xpath("(//select)[3]"));
        WebElement gun = driver.findElement(By.xpath("(//select)[4]"));
        //        b. Select objesi olustur
        Select select = new Select(yil);
        //        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        select.selectByIndex(8);//index 0'dan baslar 2015'secer

        Select select1 = new Select(ay);
        select1.selectByValue("9");//october -> option tag'indaki value attribute degerini aldik

        Select select2 = new Select(gun);
        select2.selectByVisibleText("8");
    }

    @Test
    public void test02() {
        //  2.Method:
        //        a. Tüm eyalet isimlerini yazdıralım
        WebElement eyalet = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(eyalet);
        select.getOptions().forEach(f -> System.out.println(f.getText()));
        //getOptions() methodu ile tum secenekleri yazdirdik

        //2.Yol
        //List<WebElement> eyaletler = driver.findElements(By.cssSelector("#state"));
        //eyaletler.forEach(f -> System.out.println(f.getText()));
    }

    @Test
    public void test03() {
        //  3.Method:
        //        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

        WebElement eyaletler = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(eyaletler);
        String seciliOlanSecenek = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State" , seciliOlanSecenek);
        Assert.assertTrue(seciliOlanSecenek.contains("Select"));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
