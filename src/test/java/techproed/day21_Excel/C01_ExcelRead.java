package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {
    @Test
    public void test01() throws IOException {
        //3. satir 1. sutun degerini yazdirin ve degerin "France" oldugunu test edin

        String dosyaYolu = "src/test/java/techproed/resources/Capitals.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        String satir3Sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println(satir3Sutun1);

        assert satir3Sutun1.equals("France");


        //Son satir sayisini bulunuz
        System.out.println("Son satir sayisi : " + workbook.getSheet("Sheet1").getLastRowNum());

        //Kullanılan satır sayısın bulun
        System.out.println("Kullanilan satir sayisi : " + workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
    }

    @Test
    public void test02() throws IOException {
        //Capitals dosyasindaki tum verileri yazdırın
        Map<String , String> capitalsMap = new HashMap<>();
        String dosyaYolu = "src/test/java/techproed/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatirSayisi = workbook.getSheet("Sheet1").getLastRowNum();

        for (int i = 0; i <=sonSatirSayisi; i++) {
            String key = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            capitalsMap.put(key, value);
            //System.out.println(key + "-" + value);
        }
        System.out.println(capitalsMap);
    }
}
