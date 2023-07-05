package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTest extends TestBase {
    @Test
    public void test01() {

        String filePath = "C:\\Users\\Rog\\Downloads\\b10 all test cases, code.docx";

        try{
            Files.delete(Paths.get(filePath));
        }catch(IOException e) {
            System.out.println("Dosya Bulunamadi ");
        }

        /*
            Dosyayi daha once indirdigimiz icin ve tekrar testi calisirdigimizda yine ayni dosyayi indirecegi icin
            burda dosyayi sildik
         */

        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("(//a)[3]")).click();

        canakkaleGecilmez(2);

        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\Rog\\Downloads\\b10 all test cases, code.docx";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*
        İndirmemizi istediği dosyayı locate edip tıkladık ve dosyamız indirilenler klasörüne indi
        */
        //canakkaleGecilmez(3);//-->Indirme suresini goz onunde bulundurarak bekle koyduk
    }
}
