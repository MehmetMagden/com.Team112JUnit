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

public class C02_IFrame {

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
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        // 1) Go to https://the-internet.herokuapp.com/iframe.

        driver.get("https://the-internet.herokuapp.com/iframe");

        //2 ) Create a method: iframeTest

        // - “An IFrame containing….” Test that the text is accessible and print it in the console.
        WebElement bigText = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(bigText.isEnabled());
        System.out.println(bigText.getText());
        Thread.sleep(3000);

        // - Write "Hello World!" to Text Box.

        // to locate an element inside an iframe, you need to switch your driver to that iframe

        // first we can use iframe's id or name
//        driver.switchTo().frame("mce_0_ifr");

        // second we can use iframe's index
        //driver.switchTo().frame(0);

        // third we can locate the iframe first than use the webElement to swtich
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        WebElement textBox = driver.findElement(By.tagName("p"));
        // to clear previous text
        textBox.clear();
        textBox.sendKeys("Hello World!");
        Thread.sleep(5000);



        // - Verify that the text of the “Elemental Selenium” link at the bottom of the TextBox is visible and print it on the console.

        //this one will directly take driver to main page
        driver.switchTo().defaultContent();



        // now we can not reach outside of the Iframe because our driver is inside of the Iframe
        WebElement elementalSeleniumText = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));

        // to reach outside of the Iframe we need to take our driver back to main page
        // parentFrame will go only one level higher
        //driver.switchTo().parentFrame();

        // it will test if the selenium text is diplayed
        Assert.assertTrue(elementalSeleniumText.isDisplayed());
        // it will print text value of it
        System.out.println(elementalSeleniumText.getText());




    }

    // 1) Go to https://the-internet.herokuapp.com/iframe.
    //2 ) Create a method: iframeTest
    // - “An IFrame containing….” Test that the text is accessible and print it in the console.
    // - Write "Hello World!" to Text Box.
    // - Verify that the text of the “Elemental Selenium” link at the bottom of the TextBox is visible and print it on the console.
}
