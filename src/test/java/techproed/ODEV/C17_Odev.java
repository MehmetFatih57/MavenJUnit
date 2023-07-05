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
        canakkaleGecilmez(2);

        //çerezi kapat
        WebElement cerez = driver.findElement(By.tagName("tagName.replace(wb-, wb7-);"));
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();" , cerez);
    }
}
