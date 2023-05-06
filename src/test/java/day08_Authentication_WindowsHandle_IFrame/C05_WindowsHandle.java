package day08_Authentication_WindowsHandle_IFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C05_WindowsHandle {


    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        // driver.close(); // it will only close the last tab instead of all tabs
        // to close all tabs we should use driver.quit();
        // driver.quit() will close all opened tabs
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {

        // go to the "https://the-internet.herokuapp.com/iframe"

        driver.get("https://the-internet.herokuapp.com/iframe");

        // click on selenium link
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        // when you clicked test that the new tabs title has Elemental Selenium
        String actualTitle = driver.getTitle();
        String expectedTitleWord = "Elemental Selenium";

        // we can not get second tab's unique handle value without visiting there

        // driver.getWindowHandles() this method will bring all tab's unique handle values. Our drive is stillin the first
        // tab so we can reach first tab's unique handle value.
        // by comparing these handle values I can reach the different handle value and it will be second tab's handle value

        String firstTabHandleValue = driver.getWindowHandle();

        Set<String> handleValues = driver.getWindowHandles();
        String secondTabsHandleValue ="";

        for (String each: handleValues
             ) {

            if (!firstTabHandleValue.equals(each)){
                secondTabsHandleValue= each; // here we will be able to receive second tab's handle value
            }
        }
        // to take my driver to second tab
        driver.switchTo().window(secondTabsHandleValue);

        String expectedTitleWord2  = "Selenium";
        String actualTitle2 = driver.getTitle();
        System.out.println(actualTitle2);

        Assert.assertTrue(actualTitle2.contains(expectedTitleWord2));



        // test the text "Elemental Selenium"

        Thread.sleep(3000);


    }

}
