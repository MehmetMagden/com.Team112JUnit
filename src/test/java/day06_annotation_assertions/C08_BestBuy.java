package day06_annotation_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_BestBuy {

    //1) Create a class: BestBuy Assertions
    //2) https://www.bestbuy.com/ Go to address A and make the following tests by creating different test methods
    //  ○ Test that the page URL is equal to https://www.bestbuy.com/
    //  ○ titleTest => Test if the page title does not contain "Rest"
    //  ○ logoTest => Test if BestBuy logo displayed
    //○ Francais LinkTest => Test if French link is displayed
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    //  ○ Test that the page URL is equal to https://www.bestbuy.com/
    @Test
    public void test01() {

        driver.get("https://www.bestbuy.com/ ");

        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);
    }

    //  ○ titleTest => Test if the page title does not contain "Rest"
    @Test
    public void test02(){

        String expectedTitleWord ="Rest";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

        Assert.assertFalse(actualTitle.contains(expectedTitleWord));

    }

    //  ○ logoTest => Test if BestBuy logo displayed
    @Test
    public void test03(){

        WebElement bestBuyLogo = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));

        Assert.assertTrue(bestBuyLogo.isDisplayed());

    }

    //○ Francais LinkTest => Test if French link is displayed
    @Test
    public void test04(){

        WebElement francButton = driver.findElement(By.xpath("//button[text()='Français']"));

        Assert.assertTrue(francButton.isDisplayed());


    }
}
