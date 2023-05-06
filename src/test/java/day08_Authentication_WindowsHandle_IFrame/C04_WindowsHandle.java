package day08_Authentication_WindowsHandle_IFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WindowsHandle {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        // driver.close(); // it will only close the last tab instead of all tabs
        // to close all tabs we should use driver.quit();
        // driver.quit() will close all opened tabs
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {

        // go the webpage https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
        Thread.sleep(2000);

        // test that "Opening a new window" text is displyed
        WebElement opiningText = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(opiningText.isDisplayed());
        Thread.sleep(2000);
        // test that the title is "The Internet"

        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
        Thread.sleep(2000);

        // to save first page unique handle value
        String firstPageHandleValue = driver.getWindowHandle();

        // click on "Click Here" Button
        WebElement clickHereButton = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHereButton.click();

        Thread.sleep(2000);

        // test that "New Window" text is diplayed
        WebElement newPageText = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(newPageText.isDisplayed());

        Thread.sleep(2000);


        // test that the first page Url has internet

        driver.switchTo().window(firstPageHandleValue);

        String firstPageUrl= driver.getCurrentUrl();
        String expectedUrlWord = "internet";

        Assert.assertTrue(firstPageUrl.contains(expectedUrlWord));

        Thread.sleep(2000);

    }








}
