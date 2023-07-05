package techproed.ODEV;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_Odev {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement ddm=driver.findElement(By.xpath("//select[@title='Search in']"));
        Select select=new Select(ddm);
        select.getOptions().forEach(t-> System.out.println(t.getText()));
        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
        System.out.println("*********************************************************************");

        for (int i = 1; i < 5; i++) {
            List<WebElement> options=select.getOptions();
            options.get(i).click();
            System.out.println(driver.getTitle());
        }
        // Not: Select Class'ı kullanalım
    }
}
