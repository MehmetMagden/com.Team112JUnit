package day06_annotation_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_AssertMethods {

    // create 3 test method
    // 1) go to the amazon.com and test that you are in amazon.com
    // 2) search for nutella and test that you have searched for nutella
    // 3) test that there are more than 30 result of nutella
    static WebDriver driver;

    // When we use beforeclass or after class annotations, we have to make them static ( rule of the JUnit framework)
    // when we want to use any variable in these static methods, of course they should be static too

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown(){
        driver.close();

    }

    // 1) go to the amazon.com and test that you are in amazon.com
    @Test
    public void test01(){
        driver.get("https://amazon.com");
        String expectedUrlWord= "amazon";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue("ActualURL does not contaion amazonKeyword",actualUrl.contains(expectedUrlWord));

//        if (actualUrl.contains(expectedUrlWord)){
//            System.out.println("Test PASSED");
//        }else {
//            System.out.println("Test FAILED");
//        }


    }



    // 2) search for nutella and test that you have searched for nutella
    @Test
    public void test02(){

        WebElement amazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        amazonSearchBox.sendKeys("Nutella"+ Keys.ENTER);

        WebElement resultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedText ="Nutella";
        String actualText = resultText.getText();

        Assert.assertTrue(actualText.contains(expectedText));

//        if (actualText.contains(expectedText)){
//            System.out.println("Result Test PASSED");
//        }else {
//            System.out.println("Result Test FAILED");
//        }

    }


    // 3) test that there are more than 30 result of nutella
    @Test
    public void test03(){

        WebElement resultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualText = resultText.getText(); // 37 results for "Nutella"

        String[] arr = actualText.split(" ");
        String actualStringNumber = arr[0];
        int actualNumber = Integer.valueOf(actualStringNumber);
        int expectedNumber = 30;

        Assert.assertTrue(actualNumber>expectedNumber);

//        if (actualNumber>expectedNumber){
//            System.out.println("Result Number Test PASSED");
//        }else {
//            System.out.println("Result Number Test FAILED");
//        }

    }
}
