package techproed.day19_ExtentReports_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReport extends TestBase {
    /*
            EXTENTREPORT:
                i)ExtentReport(aventstack) kullanabilmek icin oncelikle mvn adresinden 4.0.9 versiyon numarali dependency'i pom.xml
                  dosyamiza ekleriz.
               ii)ExtentReports class'indan class seviyesinde obje olustururuz
              iii)ExtentHtmlReporter class'indan class seviyesinde obje olustururuz
             iiii)ExtentTest class'indan class seviyesinde obje olustururuz

         ExtentReport diyince aklimiza 3 class gelmeli!!! ==> ExtentReports, ExtentHtmlReporter, ExtentTest

         Testlerimiz bittiginde bizden bir rapor istenebilir. Karsimizdaki teknik terimleri bilmeyebilir ama Extent Class' larini kullanrak
         testle ilgili bilgileri rapora ekleyebiliriz
         */
    ExtentReports extentReports;//-->Raporlamayi baslatmak icin kullanilan class
    ExtentHtmlReporter extentHtmlReporter;//-->Raporu HTML formatinda duzenler
    ExtentTest extentTest;//-->Test adimlarina eklemek istedigimiz bilgileri bu class'ile olustururuz
    @Test
    public void test01() {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/extentReports/extentReport" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);//-->HTML formatinda raporlamayi baslatacak

        //Raporada gozukmesini istedigimiz bilgiler icin
        extentReports.setSystemInfo("Browser" , "Chrome");
        extentReports.setSystemInfo("Tester" , "Mehmet Fatih");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("57. Bolge :)");

        extentTest = extentReports.createTest("ExtentTest" , "Test Raporu");
        //amazon sayfasina gidelim
        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasina gidildi");

        //Basligin amazon icerdigini test edelim
        assert driver.getTitle().contains("Amazon");
        extentTest.info("Basligin amazon icerdigi test edildi");

        //arama kutusunda iphine aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone" , Keys.ENTER);
        extentTest.info("Arama kutusunda Iphone aratildi");

        //sonuc yazisini konsola yazdiralim
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Sonuc Yazisi = " + sonucYazisi.getText());
        extentTest.info("Sonuc Yazisi konsola yazdirildi");
        extentTest.pass("Sayfa kapatildi");
        /*
                extentTest objesi ile info methodunu kullanarak her step'de ne yaptigimiz ile alakali bilgi yazabiliriz
            testimizin en sonunda testin bittigini ifade eden pass() methodu ile testimiz ile alakali son bilgiyi
            ekleyebiliriz
                Ve son olarak actions daki perform methodu gibi extentReport ile flush() methodu kullanarak raporu
                sonlandiririz
         */
        extentReports.flush();//-->bu methodu kullanmazsak raporumuz olusmaz
    }
}
