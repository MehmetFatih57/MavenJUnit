package techproed.day19_ExtentReports_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class C02_ExtentReport extends TestBase {
    @Test
    public void test01() {
        extentReport("Chrome" , "Amazon Testi");
        extentTest=extentReports.createTest("ExtentReport" , "Test Raporu");
        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasina gidildi");

        //sayfanın resmini alınız
        screenShot();
        extentTest.info("Sayfanin resmi alindi");

        //arama kutusunda iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone" , Keys.ENTER);
        extentTest.info("Arama kutusunda Iphone aratildi");
        extentTest.pass("Sayfa kapatildi");
    }
}
