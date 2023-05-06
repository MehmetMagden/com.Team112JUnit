package day08_Authentication_WindowsHandle_IFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Authentication {

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

        //1- Create a class: BasicAuthentication
        //2- Go to https://the-internet.herokuapp.com/basic_auth

        driver.get("https://the-internet.herokuapp.com/basic_auth");

        Thread.sleep(1555);


        //3- Do the authentication using the following method and test data
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        // when you are asked a username and a password by the system , you should get in touch with the company the get
        // that info

        // rule ( command) my be different for every company so they should also give you the rule
        // (rule)Html command: https://username:password@URL
        //Username: admin
        //password: admin
        //
        //4- Verify that the page has been successfully entered

        String expectedStr ="Congratulations! You must have the proper credentials.";
        String actualStr =driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(expectedStr,actualStr);

        Thread.sleep(3000);


    }



}
