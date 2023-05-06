package day08_Authentication_WindowsHandle_IFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_NewWindow {

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

        // go to the amazon.com
        // test that you are in amazon

        driver.get("https://amazon.com");

        String actualTitleText = driver.getTitle();
        String expectedKey ="Amazon";

        Assert.assertTrue(actualTitleText.contains(expectedKey));


        // in a new tab go to the wisequarter.com
        // test that you are in wisequarter

        // to take first page's handle value we need to take it before jumping to second tab
        // by using this unique handle value we can jump back to the first tab after going to the second tab
        String firstTabsHandleValue = driver.getWindowHandle();

        // to open a new tab we use this code
        // when we create a new tab ( willingly) by using this code, driver will also jump to the new tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrlWord = "wisequarter";

        Assert.assertTrue(actualUrl.contains(expectedUrlWord));
        Thread.sleep(3000);

        // after this go back to the amazon.com tab and test that url contains amazon

        // our driver will jump to the first tab by using first tab's unique handle value
        driver.switchTo().window(firstTabsHandleValue);

        String actualURL = driver.getCurrentUrl();
        String expectedURLWord = "amazon";

        Assert.assertTrue(actualURL.contains(expectedURLWord));

        Thread.sleep(3000);


    }

}
