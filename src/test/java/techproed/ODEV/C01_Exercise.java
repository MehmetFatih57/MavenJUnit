package techproed.ODEV;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Exercise {
                                        // ...Exercise1...

    // Create a new class under Q1 create main method
    public static void main(String[] args) throws InterruptedException {
        // Set Path
        WebDriverManager.chromedriver();
        // Create chrome driver
        WebDriver driver = new ChromeDriver();
        // Maximize the window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Open google home page https://www.google.com/.
        driver.get("https://www.google.com");
        Thread.sleep(2000);

        // On the same class, Navigate to amazon home page https://www.amazon.com/
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);

        //Navigate back to google
        driver.navigate().back();
        Thread.sleep(2000);

        // Navigate forward to amazon
        driver.navigate().forward();
        Thread.sleep(2000);

        // Refresh the page
        driver.navigate().refresh();
        Thread.sleep(2000);

        // Close/Quit the browser
        driver.close();

        // And last step : print "all ok" on console
        System.out.println("Tamam");

    }
}

