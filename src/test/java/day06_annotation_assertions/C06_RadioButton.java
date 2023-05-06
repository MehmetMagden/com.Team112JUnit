package day06_annotation_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButton {

    //Create the required structure and complete the following task.
    // a. Go to the given web page.
    //      https://facebook.com
    // b. Accept cookies
    // c. Press the Create an account button
    // D. Locate the radio button elements and choose the one that suits you

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
        // a. Go to the given web page.
        //      https://facebook.com

        driver.get("https://www.facebook.com");

        // b. Accept cookies
        // I did not face any cookies

        // c. Press the Create an account button
        WebElement createNewAccButton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        createNewAccButton.click();

        // D. Locate the radio button elements and choose the one that suits you
        WebElement manRadioButton = driver.findElement(By.xpath("//input[@value='2']"));
        manRadioButton.click();




        Thread.sleep(30000);
    }

}
