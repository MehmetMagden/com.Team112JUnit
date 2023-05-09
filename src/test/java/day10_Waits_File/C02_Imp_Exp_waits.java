package day10_Waits_File;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_Imp_Exp_waits {


    //1. Create a class : WaitTest
    //2. Create two methods: implicitWaitTest() , explicitWaitTest()
    //
    // Test the following steps for both methods.
    //3. Go to https://the-internet.herokuapp.com/dynamic_controls.
    //4. Press the Remove button.
    //5. “It's gone!” Verify that the message is displayed.
    //6. Press the Add button
    //7. Test that it's back message appears

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();



    }

    @After
    public void tearDown() {

        driver.close();
    }

    @Test
    public void implicitWaitTest() {

        // to set a global waiting time for each step we code in the project we use implicitlywait

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //3. Go to https://the-internet.herokuapp.com/dynamic_controls.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Press the Remove button.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        //5. “It's gone!” Verify that the message is displayed.
        WebElement message = driver.findElement(By.id("message"));
        Assert.assertTrue(message.isDisplayed());

        //6. Press the Add button
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //7. Test that it's back message appears
        WebElement message2 = driver.findElement(By.id("message"));
        Assert.assertTrue(message2.isDisplayed());

    }

    @Test
    public void explicitWaitTest() {


        // for exceptional situations if you neet to wait more than implicitly wait ( global waiting time)
        // you need to use explicitly wait.

        // first you need to create an object from webDriverWait class
        // by using this object, you should choose a condition, system will wait until the conditions are met
        // then system will continue to next step


        //3. Go to https://the-internet.herokuapp.com/dynamic_controls.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Press the Remove button.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        //5. “It's gone!” Verify that the message is displayed.



       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000000));

       //WebElement message2 = driver.findElement(By.id("message")); // we are tring to locate a webelement which is not there

        //wait.until(ExpectedConditions.visibilityOf(message2));
//
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        WebElement message = driver.findElement(By.id("message"));

        // WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        // wait.until method returns the webElement we are waiting for, so we do not need to locate it after waiting for it
        // instead we can directly make the assignment

        Assert.assertTrue(message.isDisplayed());



        //6. Press the Add button
        //7. Test that it's back message appears



    }


}
