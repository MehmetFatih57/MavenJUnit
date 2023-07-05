package techproed.ODEV;

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

public class C03_Odev {

    WebDriver driver;

    @Before
    public void before()  {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //●https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void Test01() {

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement optionAll = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(optionAll);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        bekle(3);

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        bekle(4);
        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //4.Tüm dropdown değerleri(value) yazdırın
        select.getOptions().forEach(t-> System.out.println(t.getText()));
        //5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //False yazdırın.
        //List<WebElement> boyut=driver.findElements(By.xpath("//select[@id='dropdown']"));
        if(select.getOptions().size()==4){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
}
    }
}