package techproed.day07_MavenJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        WebElement signin = driver.findElement(By.xpath("//button[@class='signin btn btn-info']"));
        signin.click();

        //3.Login alanine “username” yazdirin
        WebElement login = driver.findElement(By.xpath("//input[@id='user_login']"));
        Thread.sleep(1000);
        login.sendKeys("username" , Keys.TAB , "password" );
        Thread.sleep(2000);

        //ALTERNATIF YOL :))
//      login.sendKeys("username" , Keys.TAB , "password" , Keys.TAB , Keys.TAB , Keys.ENTER);

        //4.Password alanine “password” yazdirin

        //NOT:Password yukarida(3. Soruda username ile birlikte alinmistir...:)
//       WebElement password = driver.findElement(By.cssSelector("#user_password"));
//       password.sendKeys("password");

        //5.Sign in buttonuna tiklayin
        WebElement signIn = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        signIn.click();
        driver.navigate().back();
        Thread.sleep(2000);

        //6.Online Banking'den pay Bills'e git
        WebElement onlineBanking = driver.findElement(By.xpath("(//*[.='Online Banking'])[2]"));
        onlineBanking.click();
        Thread.sleep(2000);

        //7.Pay Bills sayfasina gidin
        driver.findElement(By.cssSelector("#pay_bills_link")).click();
        Thread.sleep(2000);

        //8.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.cssSelector("#sp_amount")).sendKeys("1000" , Keys.TAB);
        Thread.sleep(2000);

        //9.tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.cssSelector("#sp_date")).sendKeys("2020-09-10" , Keys.ENTER);

        //10.Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("#pay_saved_payees")).click();
        Thread.sleep(2000);

        //11.“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement thePaymentWasSuccesfullySubmitted = driver.findElement(By.cssSelector("div#alert_content"));
        if(thePaymentWasSuccesfullySubmitted.getText().equals("The payment was successfully submitted.")){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }
    }
}
