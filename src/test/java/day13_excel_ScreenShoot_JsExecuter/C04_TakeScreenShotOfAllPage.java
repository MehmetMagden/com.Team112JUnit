package day13_excel_ScreenShoot_JsExecuter;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_TakeScreenShotOfAllPage extends TestBase {

    @Test
    public void test01() throws IOException {

        // go the amazon.com
        // write Nutella to searchbox
        // and test that result has nutella keyword


        driver.get("https://www.amazon.com");

        // write Nutella to searchbox

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);

        // and test that result has nutella keyword
        WebElement result = driver.findElement(By.xpath("//div[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));

        String actualResultStr = result.getText();
        String expectedWord = "Nutella";

        Assert.assertTrue(actualResultStr.contains(expectedWord));

        // take a screenshot of the page

//        //1 ) Create a screenshot object
//        TakesScreenshot tss = (TakesScreenshot) driver;
//
//        // creating a file path for our ss
//        String filePath = "target/fullPageSS/ScreenShotSS.jpeg";
//        // creating the file
//        File FullPageSS = new File(filePath);
//
//        //creting a tempfile to save ss ( otherwise it does not work)
//        File tempFile = tss.getScreenshotAs(OutputType.FILE);
//
//        // coping copy file to the orinigal file
//        FileUtils.copyFile(tempFile,FullPageSS);

        // let's write all this code to reusable method class
        /*
        when we try to create a method to take ss, we should also send the driver
         */
        ReusableMethods.fullPageScreenShot(driver);






    }

}
