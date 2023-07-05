package techproed.ODEV;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_Odev {

    /*
        ●https://www.amazon.com/ adresine gidin.
-Test 1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
oldugunu test edin
-Test 2
1.Kategori menusunden Books secenegini secin
2.Arama kutusuna Java yazin ve aratin
3.Bulunan sonuc sayisini yazdirin
4.Sonucun Java kelimesini icerdiginitestedin
     */

    WebDriver driver;

    @Before
    public void before()  {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.amazon.com/ adresine gidin.
        driver.get("https://amazon.com");
    }

    @Test
    public void Test01() {
        //-Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
        WebElement katagori=driver.findElement(By.xpath("//select[@title='Search in']"));
        Select select=new Select(katagori);
        Assert.assertTrue(select.getOptions().size()==45);
    }

    @Test
    public void test02() {

        //-Test 2
        // 1.Kategori menusunden Books secenegini secin
        WebElement katagori=driver.findElement(By.xpath("//select[@title='Search in']"));
        Select select=new Select(katagori);
        select.selectByVisibleText("Books");
        // 2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        // 3.Bulunan sonuc sayisini yazdirin
        WebElement sonuc=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String[] sonucYazısı=sonuc.getText().split(" ");
        // 4.Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(sonuc.getText().contains("Java"));
    }
}
