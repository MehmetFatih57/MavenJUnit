package techproed.ODEV;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class C05_Odev {

    WebDriver driver;

    @Before
    public void before()  {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
    }


    @Test
    public void test01() {

        //2.Sign in butonuna basin
        driver.findElement(By.cssSelector("button[id='signin_button']")).click();

        //3.Login kutusuna “username” yazin
        driver.findElement(By.cssSelector("input#user_login")).sendKeys("username");

        //4.Password kutusuna “password.” yazin
        driver.findElement(By.cssSelector("#user_password")).sendKeys("password");

        //5.Sign in tusuna basin(not: navigate.Back yapınız)
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();
        driver.navigate().refresh();

        //6.Pay Bills sayfasina gidin
        driver.findElement(By.cssSelector("#onlineBankingMenu")).click();
        driver.findElement(By.cssSelector("#pay_bills_link")).click();

        //7.“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[@href='#ui-tabs-3']")).click();

        //8.“Currency” drop down menusunden Eurozone’u secin
        WebElement option= driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(option);
        select.selectByVisibleText("Eurozone (euro)");

        //9.“amount” kutusuna bir sayi girin
        driver.findElement(By.cssSelector("#pc_amount")).sendKeys("24");

        //10.“US Dollars” in secilmedigini test edin
        Assert.assertFalse(driver.findElement(By.cssSelector("#pc_inDollars_true")).isSelected());

        //11.“Selected currency” butonunu secin
        driver.findElement(By.cssSelector("#pc_inDollars_false")).click();

        //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.cssSelector("#pc_calculate_costs")).click();
        driver.findElement(By.xpath("(//input[@class='btn btn-primary'])[2]")).click();

        //“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        Assert.assertTrue(driver.findElement(By.cssSelector("div#alert_content")).isDisplayed());

    }
}