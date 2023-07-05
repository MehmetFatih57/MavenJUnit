package techproed.ODEV;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Odev {
    //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //Before methodunda http://www.google.com adresine gidin
    @Before
    public void setUp() throws Exception {
        driver.get("http://www.google.com");

    }

    //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void theGodFather() {
    driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("The God Father" , Keys.ENTER);
        WebElement theGodFather = driver.findElement(By.cssSelector("div#result-stats"));
        String [] sonucYazisi = theGodFather.getText().split(" ");
        System.out.println(sonucYazisi[1]);
    }

    //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void lordOfTheRings() {
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Lord Of The Rings" , Keys.ENTER);
        WebElement lordOfTheRings = driver.findElement(By.cssSelector("div#result-stats"));
        String [] sonucYazisi1 = lordOfTheRings.getText().split(" ");
        System.out.println(sonucYazisi1[1]);
    }

    //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void killBill() {
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Kill Bill" , Keys.ENTER);
        WebElement killBill = driver.findElement(By.cssSelector("div#result-stats"));
        String [] sonucYazisi2 = killBill.getText().split(" ");
        System.out.println(sonucYazisi2[1]);
    }

    //After method'u ile başlıkları yazdırınız
    @After
    public void tearDown() throws Exception {
        System.out.println(driver.getTitle());
    }
    //AfterClass ile browser'ı kapatınız

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}
