package techproed.ODEV;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C10_Odev extends TestBase {
    @Test
    public void test() {
        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over  Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement ddm=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(ddm).perform();

        // 3- Link 1" e tiklayin
        WebElement link=driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"));
        link.click();

        // 4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        // 5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        // 6- “Click and hold" kutusuna basili tutun
        WebElement clickHold=driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickHold).perform();

        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickHold.getText());

        // 8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
        WebElement doubleClick=driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(doubleClick).perform();

        String actualClass=doubleClick.getAttribute("class");
        String expectedClass="div-double-click double";
        Assert.assertEquals(actualClass , expectedClass);
    }
}
