package techproed.day21_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import techproed.utilities.TestBase;

public class C03_JSExecutor_Click extends TestBase {
    /*
        Eger bir web sayfasinin HTML kodlari tamamen ya da kismen JavaScript kullanilarak olusturulduysa o sayfayla
        etkilesimde bulunmak icin standart WebDriver komutlari yetersiz kalabilir.

        Bu durumda sayfa ile etkilesime gecebilmek icin JavaScriptExecuter arayuzunu kullanmak gerekir.
        JavaScriptExecuter arayuzu sayfaya dogrudan erisebilir

        Ancak mumkunse WebDriver'in sundugu standart yontemlerle sayfala etkilesime gecmek her zamand aha iyidir
        Cunku JavaScript kullanimi sayfanin daha yavas yuklenmesine neden olabilir
     */

    @Test
    public void test01() {
        // https://amazon.com sayfasina gidin
        driver.get("https://amazon.com");

        //returns kismina tiklayin
        driver.findElement(By.xpath("//a[@id='nav-orders']"));//.click();

        /*
            Ilgili webElementin HTML kodu , JavaScript kullanilarak olusturulduysa standart WebDriver komutu olan click()
            yetersiz kalabilir. Boyle durumlarda JavaScriptExecuter kullanilarak sayfa ile etkilesime gecilebilir
         */
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();" , driver.findElement(By.xpath("//a[@id='nav-orders']")));

        click(driver.findElement(By.xpath("//a[@id='nav-orders']")));
    }
}
