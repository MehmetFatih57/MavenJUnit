package techproed.ODEV;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class C15_Odev {
    @Test
    public void test01() throws IOException {
        /*
        ODEV1
            1.satirdaki 2.hucreye gidelim ve yazdiralim
            1.satirdaki 2.hucreyi bir string degiskene atayalim ve  yazdiralim
            2.satir 4.cell'in afganistan'in baskenti oldugunu test  edelim
            Satir sayisini bulalim
            Fiziki olarak kullanilan satir sayisini bulun
            Ingilizce Ulke isimleri ve baskentleri bir map olarak  kaydedelim
        */


        //1.satirdaki 2.hucreye gidelim ve yazdiralim
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString());

        //1.satirdaki 2.hucreyi bir string degiskene atayalim ve  yazdiralim
        String birinciSatirIkinciHucre = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(birinciSatirIkinciHucre);

        //2.satir 4.cell'in afganistan'in baskenti oldugunu test edelim
        String ikinciSatirDorduncuSutun = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        Assert.assertEquals("Kabil" , ikinciSatirDorduncuSutun);

        //Satir sayisini bulalim
        int satirSayisi = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(satirSayisi);

        //Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());

        //Ingilizce Ulke isimleri ve baskentleri bir map olarak  kaydedelim
        Map<String , String> baskentler = new LinkedHashMap<>();
        for(int i = 0; i <=satirSayisi ; i++) {
            if(workbook.getSheet("Sayfa1").getRow(i)!=null);
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            baskentler.put(key , value + "\n");
        }
        System.out.println(baskentler);
    }
}
