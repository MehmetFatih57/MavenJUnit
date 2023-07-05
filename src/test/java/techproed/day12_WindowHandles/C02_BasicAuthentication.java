package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.TestBase;

import static io.netty.util.internal.SystemPropertyUtil.contains;

public class C02_BasicAuthentication extends TestBase {
    @Test
    public void test01() {
        //Aşağıdaki bilgileri kullanarak authentication yapınız:
        //Url: https://the-internet.herokuapp.com/basic_auth
        //Username: admin
        //Password: admin
        //Başarılı girişi doğrulayın.
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        canakkaleGecilmez(3);

        //Congratulations! yazisinin ciktigini dogrulayin
        assert driver.findElement(By.xpath("//p")).getText().contains("Congratulations!");

        //Elemental Selenium yazisina tiklayalim
        driver.findElement(By.xpath("(//a)[2]")).click();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());//-->Acilan yeni pencereye gectik

        //Basligin "Elemental Selenium" oldugunu dogrulayin
        System.out.println(driver.getTitle());

        //String SayfaExpectedTitle = "Elemental Selenium";
        Assert.assertNotEquals(driver.getTitle() , contains("Elemental Selenium"));

        //DDM'den java secelim
        WebElement ddm=driver.findElement(By.cssSelector("select[name='fields[programming_language]']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Java");
    }
}
