package day07_dropDown_jsAlerts;

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
import java.util.TreeMap;

public class C02_JsAlerts {

    // set required options
    // go to the https://the-internet.herokuapp.com/javascript_alerts
    // create 3 different methods to click jsAlerts
    // handle them

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsFirstButton = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        jsFirstButton.click();

        Thread.sleep(2000);
        // when we see an js allert we need to swicth our driver to that alert


        // to accept the jsAlert
        //driver.switchTo().alert().accept();

        //Test that jsAlert thext is "I am a JS Alert"

        String actualTextOfJsAlert = driver.switchTo().alert().getText();
        String expectedTextOfJsAlert =  "I am a JS Alert";

        Assert.assertEquals(expectedTextOfJsAlert,actualTextOfJsAlert);

        driver.switchTo().alert().accept();





    }

    @Test
    public void test02(){


        // test that after clicking jsConfirmButton and accepting it
        // result text will be "You clicked: Ok

        // test that after clicking jsConfirmButton and canceling it
        // result text will be "You clicked: Calcel
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirmButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        jsConfirmButton.click();

        driver.switchTo().alert().accept();

        WebElement resultText = driver.findElement(By.id("result"));

        String actualText = resultText.getText();
        String expectedText = "You clicked: Ok";

        Assert.assertEquals(expectedText,actualText);

        String actualResultText = driver.findElement(By.id("result")).getText();
        String expectedResultText = "You clicked: Ok";

        Assert.assertEquals(expectedResultText,actualResultText);




    }

    @Test
    public void test03(){

        // test click for JS Prompt
        // after entering Java and clicking ok, test that result text is "You entered: Java"

        // go to the website
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // click on  click for JS Prompt button
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        // write Java on JS alert
        driver.switchTo().alert().sendKeys("Java");

        // accept js alert
        driver.switchTo().alert().accept();

        // take the text of Result and test that result text is "You entered: Java"
        String actualResultText = driver.findElement(By.id("result")).getText();
        String expectedResultText = "You entered: Java";

        Assert.assertEquals(expectedResultText,actualResultText);

        //






    }

    @Test
    public void test04(){

        // test that when we click on 3rd button and cancel result text is "You entered: null"

        // go to the website
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // click on  click for JS Prompt button
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        // clicked on cancel button
        driver.switchTo().alert().dismiss();

        String actualResultText = driver.findElement(By.id("result")).getText();
        String expectedResultText = "You entered: null";

        Assert.assertEquals(expectedResultText,actualResultText);





    }







}
