package techproed.ODEV;

import com.aventstack.extentreports.ExtentReports;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C13_Odev extends TestBase {
        @Test
        public void test01 () {
            //ÖDEV
            extentReport("Browser", "Chrome");
            extentTest = extentReports.createTest("ExtentTest", "test raporu");

            driver.get("D:Projelerim\\B151MavenJUnit\\testOutput\\extentReports\\extentReport_12_48_56_27062023.html");
            extentTest.info("Rapora Gidildi");

            canakkaleGecilmez(3);

            //Başlığın Extent Report olduğunu test edelim
            Assert.assertEquals("Extent Report", driver.getTitle());
            extentTest.info("Başlığın Extent Report Olduğu Test Edildi");

            canakkaleGecilmez(2);

            //Rapor temasını dark yapalım
            driver.findElement(By.xpath("(//i[@class='material-icons'])[1]")).click();
            extentTest.info("Rapor Temasi Dark Yapildi");

            canakkaleGecilmez(2);

            //Tum Sayfanin Ekran Goruntusunu Alin
            screenShot();
            extentTest.info("Ekran Goruntusu Alindi");

            canakkaleGecilmez(2);

            //Dashboard bölümüne gidip tabloyu yazdırınız
            driver.findElement(By.xpath("(//i[@class='material-icons'])[3]")).click();
            System.out.println(driver.findElement(By.xpath("(//tbody)[3]")).getText());
            extentTest.info("Dashboard Bolumune Gidildi Ve Tablo Yazdirildi");

            canakkaleGecilmez(2);

            //Tester'ın "isminiz" olduğunu doğrulayalım
            String expectedName = driver.findElement(By.xpath("(//tbody)[3]//tr[3]//td[2]")).getText();
            String actualName = "Mehmet Fatih";
            Assert.assertEquals(actualName , expectedName);
            extentTest.info("Tester'ın Ismi Doğrulandi ");

            canakkaleGecilmez(2);

            //Tum Sayfanin Ekran Goruntusunu Alin
            screenShot();
            extentTest.info("Ekran Goruntusu Alindi");

            //Sayfayı kapatalım
            driver.close();
            extentTest.pass("Sayfa Kapatildi");
            extentReports.flush();
        }
    }

