package techproed.day16_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;

import static io.netty.util.internal.SystemPropertyUtil.contains;

public class C01_ExplicitWait extends TestBase {
    /*
        SELENIUM WAIT:
            IMPLICITLY WAIT --> Driver'i olusturduktan sonra sayfadaki tum webelementleri etkilesime girebilmesi icin belirtmis
                                oldugumuz max. (Durations.ofSecond(20)) sure kadar bekler
            EXPLICIT WAIT / WebDriverWait --> Bir webelemwnt'in sayfa yuklendikten sonra etkilesime girebilmesi icin max.
                                belirtmis oldugumuz sure kadar default (varsayilan) olarak yarim saniyelik araliklarla bekler.
                                Ornegin bir  webelemente tikladik ve bir alert'un cikmasi zaman alabilir , internet
                                yogunlundan ya da sayfanin performansindan kaynakli bu sureyi normalde kullandigimiz
                                Thread.sleep() ile de cozebiliriz fakat testimizi her calistirdigimizda
                                Thread.sleep() icin kac saniye beklemesi gerektigini kestiremeyebiliriz. Bu gibi durumlar icin
                                explicit wait kullaniriz
            EXPLICIT WAIT / FluentWait --> Bir webelemwnt'in sayfa yuklendikten sonra etkilesime girebilmesi icin max.
                                belirtmis oldugumuz sure kadar bizim belirttigimiz araliklarda (saniye/salise) bekler

            SYNTAX:
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));//--> max. 20 saniye belirttik
                wait.until(ExpectedConditions.visibilityOf(helloWorldText));

     */

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        canakkaleGecilmez(6);

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));

        //Locate'ini aldığımız helloWorldText webelementini görünür olana kadar explicit wait ile bekleyeceğim
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(20));//-->max. 0 saniye belirttik
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));
        //visibilityOf() methoduyla gorunur olana kadar bekler

        Assert.assertEquals("Hello World!",helloWorldText.getText());

    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        canakkaleGecilmez(6);

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = new WebDriverWait(driver , Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));

        //Locate'ini aldığımız helloWorldText webelementini görünür olana kadar explicit wait ile bekleyeceğim

        //visibilityOf() methoduyla gorunur olana kadar bekler

        Assert.assertEquals("Hello World!",helloWorldText.getText());
    }

    @Test
    public void test03() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        canakkaleGecilmez(6);

        //Hello World! Yazının sitede oldugunu test et
        new WebDriverWait(driver , Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));

        //Locate'ini aldığımız helloWorldText webelementini görünür olana kadar explicit wait ile bekleyeceğim

        //visibilityOf() methoduyla gorunur olana kadar bekler

        Assert.assertEquals("Hello World!", driver.findElement(By.xpath("(//h4)[2]")).getText());
    }

    @Test
    public void test04() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        canakkaleGecilmez(6);

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));

        //Locate'ini aldığımız helloWorldText webelementini görünür olana kadar explicit wait ile bekleyeceğim
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(20));//-->max. 0 saniye belirttik
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='loading']")));
        //invisibilityOfElementLocated() methodu ile loading webelementi kaybolana kadar bekler

        Assert.assertEquals("Hello World!",helloWorldText.getText());
    }
}
