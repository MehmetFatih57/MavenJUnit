package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    @Test
    public void test01() {
        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Uc saniye bekle
        canakkaleGecilmez(3);

        //Basligin Bootcamp icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Bootcamp"));
    }
}
