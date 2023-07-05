package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExists {
    @Test
    public void test01() {
        /*
            Bir web sitesini test ettigimizde download islemi ypildigi zaman dosyanin bilgisayarimiza inip inmedigini kontrol
            etmek varligini dogrulayabilmek icin ya da bilgisayarimizdaki herhangi bir dosyanin varligini dogrulayabilmek icin;
                Files class'indan exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
            dosyanin varligini test edebiliriz. --> Files.exists(Paths.get(dosyaYolu))
            Dolayisiyla bu isleme baslamadan once varligini test edecegimiz dosyanin yolunu String bir degiskene assign ederiz.

            NOT:
            Windows10 surumlerinden once ki surumler icin pratik olarak dosya yolu almak istersek yolunu almak istedigimiz
            dosyanin uzerine gelip shift+sag click basarak yol olarak kopyala secenegi ile dosya yolunu kopyalayabiliriz
         */

        String dosyaYolu = "C://Users//Rog//Desktop//New Text Document.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//-->Dosya varsa "True" yoksa "False" doner
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test02() {
        String dosyaYolu2 = "C:\\Users\\Rog\\Desktop\\8.txt";
        //-->"C" den once ve en sondaki cift tirnaktan once /" olmayacak
        System.out.println(Files.exists(Paths.get(dosyaYolu2)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));
    }
    @Test
    public void test03() throws InterruptedException {
     /*
        Bir server'da farkli isletim sistemleri ile ayni anda dosya varligini test etmek istedigimiz zaman, daha dinamik
        olmasi acisindan System.getProoerty("os.name") bu sekilde isletim sistemini alir
        her isletim sisteminin kullanici yolu farkli olacagindan System.getProperty("user.home") bilgisayarimizdaki
        kullanici yolunu bu sekilde alip String bir degiskene farkliYol ismi ile System.getProperty("user.home") atayarak
        her seferinde farkli yollari almayla ugrasmamiz oluruz. Dosya diyelim ki masa ustunde ve her isletim sisteminde
        bize ayni yolu verecegi icin bunu da ortak yol olarak bir String'e assing ederiz.
      */

        String isletimSistemiAdi = System.getProperty("os.name");//--> Isletim sisteminin adini verir
        System.out.println(isletimSistemiAdi);

        //System.out.println(System.getProperty("user.home"));

        String kullaniciYoluAdi = System.getProperty("user.home");//-->Bilgisayarimizdaki kullanici yolunu verir
        System.out.println(kullaniciYoluAdi);

        String farkliYol = "";

        System.out.println(isletimSistemiAdi);
        System.out.println(System.getProperty("user.home"));//-->Bilgisayarımızdaki kullanıcı yolunu verir
        if (isletimSistemiAdi.contains("Win")){
            farkliYol = System.getProperty("user.home");//-->Windows 10/-->C:\Users\Lenovo
        }else if (isletimSistemiAdi.contains("mac")){
            farkliYol = "/Users/aycapolatkamali";//-->Mac işletim sistemi yolu
        }
        String ortakYol = "/Desktop//New Text Document.txt";
        String dosyaYolu = farkliYol+ortakYol;
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        try{
            Files.delete(Paths.get(dosyaYolu));//-->Bu sekilde belirtmis oldugumuz dosyayi sileriz
        }catch(IOException e) {
            System.out.println("Dosya Bulunamadi ");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));//-->Sildigimiz icin assertFalse kullandik
        Thread.sleep(3000);

        //Sildigimiz dosya isminde yeni bir dosya olusturalim
        try {
            Files.createFile(Paths.get(dosyaYolu));//-->Belirtmis oldugumuz dosyayi tekrar olusturduk
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
            Her seferinde test ettigimiz sayfada download islemi yapiliyorsa gereksiz dosya kalabaligini onlemek icin
            yukardaki delete islemini kullanabiliriz
         */
    }

    @Test
    public void test04() {
        /*
            Yukaridaki methodlarda bilgisayarimizdaki dosya yolunun varligini Files.exists() methodu ile test etmistik.
            Ayni islemi asagidaki ornekteki gibi File class'indan obje olusturarak da yapabiliriz
         */
        String dosyaYolu = "C://Users//Rog//Desktop//New Text Document.txt";
        File file = new File(dosyaYolu);
        System.out.println(new File(dosyaYolu).exists());
        Assert.assertTrue(file.exists());
        file.delete();
    }
}
