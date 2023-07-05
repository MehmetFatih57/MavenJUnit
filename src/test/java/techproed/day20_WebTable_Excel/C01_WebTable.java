package techproed.day20_WebTable_Excel;

import com.aventstack.extentreports.ExtentReports;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C01_WebTable extends TestBase {

    /*
        WEBTABLE;
            <table> tagi ile baslar
                <thead> basliklar icin bu tag ile devam eder
                    <tr> basliklarin satiri
                    <th> table head
                        <td> basliktaki veriler
                    <tbody> basliklar altindaki verileri temsil eder
                            <tr> table row(satir)
                                <td> table data(tablodaki veri)
     */
    @Test
    public void test01() {
//      https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

//      Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo 1");
        System.out.println(table1.getText());

//      Task 2 : 3. Satır verilerini yazdırın
        WebElement ucuncuSatir = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("2. SORU");
        System.out.println(ucuncuSatir.getText());

//      Task 3 : Son satırın verilerini yazdırın
        WebElement sonSatir = driver.findElement(By.xpath("(//table)[1]//tr[4]"));
        System.out.println("3. SORU");
        System.out.println(sonSatir.getText());


        /*
            last()--> methodu istenilene gore son satir ya da sutun bilgilerini verir
         */


//      Task 4 : 5. Sütun verilerini yazdırın
        List<WebElement> sutunVerileri = table1.findElements(By.xpath(".//td[5]"));
        System.out.println();
        for (WebElement list : sutunVerileri) {
            System.out.println();
            System.out.println("4. SORU : " + list.getText());
        }

        System.out.println();

        //    Task 5 : 3. Satırdaki 1. ve 2. sütun bilgilerini yazdırınız
        System.out.println("**********************************");
        List<WebElement> ucuncuSatirr = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position()>=1 and position()<=2]"));
        ucuncuSatirr.forEach(t -> System.out.print(t.getText() + "\t"));

        System.out.println();

//      Task 6 : Iki parametreli bir Java metodu oluşturalım: printData
        printData(2, 3);

        //3. satir 2. sütun bilgisinin Jack olup olmadığını doğrulayın
        printData(3, 2);


//      Parameter 1 = satır numarası
//      Parameter 2 = sütun numarası
//      printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.

        extentReports = new ExtentReports();
        extentReports.flush();
    }

    public void printData(int satir, int sutun) {
        System.out.println("6. SORU");
        System.out.println(driver.findElement(By.xpath("html//body//div[2]//div[1]//table[1]//tr[" + satir + "]//td[" + sutun + "]")).getText());
    }

    @Test
    public void test02() {
        extentReport("Chrome", "WebTable");
        extentTest = extentReports.createTest("WebTable", "Test Raporu");
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.info("Sayfaya gidildi");
        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo 1");
        System.out.println(table1.getText());
        extentTest.info("Tablo1 yazdırıldı");
        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement ucuncuSatir = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("*********************************************");
        System.out.println(ucuncuSatir.getText());
        extentTest.info("3. Satir verileri yazdirildi");
        //    Task 3 : Son satırın verilerini yazdırın
        WebElement sonSatir = driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));
        //last() --> istenilene göre son satir yada sütün bilgilerini verir
        System.out.println("1. Tablo Son Satir Bilgileri : " + sonSatir.getText());
        extentTest.info("Son satir verileri yazdırıldı");
        //    Task 4 : 5. Sütun verilerini yazdırın
        System.out.println("**********************************");
        WebElement besinciBaslik = driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        System.out.println(besinciBaslik.getText());//-->5. sütun başlığı
        List<WebElement> besinciSutun = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        besinciSutun.forEach(t -> System.out.println(t.getText()));
        extentTest.info("5. Sütun verileri yazdırıldı");
        //    Task 5 : 3. Satırdaki 1. ve 2. sütun bilgilerini yazdırınız
        System.out.println("**********************************");
        List<WebElement> ucuncuSatirr = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position()>=1 and position()<=2]"));
        ucuncuSatirr.forEach(t -> System.out.print(t.getText() + "\t"));
        extentTest.info("3. Satırdaki 1. ve 2. sütun bilgilerini yazdırıldı");
        //    Task 6 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
        System.out.println();
        //WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr[2]//td[3]"));//fbach@yahoo.com
        System.out.println(printData1(2, 3));
        extentTest.info("2. satir 3 sütun bilgileri yazdırıldı");

        //3. satir 2. sütun bilgisinin Jack olup olmadığını doğrulayın
        printData1(3, 2);
        String actualData = printData1(3, 2);
        String expectedData = "Jack";
        Assert.assertNotEquals(expectedData, actualData);
        extentTest.fail("3. satir 2. Sütun bilgisinin Jason olduğu görüldü");
        extentTest.pass("Sayfa Kapatıldı");
        extentReports.flush();
    }

    private String printData1(int satir, int sutun) {
        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr[" + satir + "]//td[" + sutun + "]"));
        return satirSutun.getText();
    }
}
