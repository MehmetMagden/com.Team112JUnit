package day10_Waits_File;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ImplicitlyWait {

    @Test
    public void test01(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // We have set a waiting time for each step we use in a Selenium Project
        // At each step, system will wait for at max 15 seconds until the action is completed
        // if it can find it at third second it complete the task and the system will continue from the next step
        //( it won't wait for full 15 seconds)



        /*
        Thread.sleep(); comes from java , it stops the code and because of that it is called hard wait

        implicitlyWait(): comes from selenium, It will wait for the job completed, when it is done, it will jump to the
        next step

        explicitlyWait(): if we want to set a longer waiting time than implicitlywait  for a web element,
        We can  use this wait type

        fluentwait() :


         */




    }




}
