package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ExcelWrite {
    @Test
    public void test01() throws IOException {
        // Bir "Nüfus" sütunu olusturun
        // baskent nufuslarını excel dosyasına yazınız.
        // (D.C: 1000, Paris:1500, London:1200, Ankara:1300)

        String dosyaYolu = "src/test/java/techproed/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("NUFUS");

        //Excel'de bir hucre olusturmak icin "createCell()" methodu kullanilir.
        //Hucre icine yazdiracagimiz deger icin "setCellValue()" methodu kullanilir
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("1100");
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue("1500");
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue("1200");
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue("1300");

        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        //Datalari bizim class'imizdan Capitals dosyasina gonderecegiz bunun icin "FileOutputStream" objesi olusturmamiz gerekir
        workbook.write(fos);
        //workbook'daki datalari "fos" a yazdik
    }
}
