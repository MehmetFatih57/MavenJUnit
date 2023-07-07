package techproed.ODEV;

import org.junit.Test;
import org.openqa.selenium.*;
import techproed.utilities.TestBase;

import static java.sql.DriverManager.getDriver;

public class C17_Odev extends TestBase{
    @Test
    public void test01() {
        //https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE git
        driver.get("https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE");

        //çerezi kapat
        SearchContext searchContext = driver.findElement(By.xpath("//cmm-cookie-banner[@class='hydrated']")).getShadowRoot();
        searchContext.findElement(By.className("button")).click();
    }
}
