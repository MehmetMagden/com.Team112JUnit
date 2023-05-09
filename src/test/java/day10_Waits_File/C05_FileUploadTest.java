package day10_Waits_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_FileUploadTest extends TestBase {

    @Test
    public void test(){

        //Create a class under the Tests package: C05_ UploadFile
        //Let's go to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        //Let's press the chooseFile button
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

        // create a dynamic path for the file we want to upload
        // "C:\Users\Maden\Desktop\HelloJava.txt"

                                // C:\Users\Maden
        String dynamicpath = System.getProperty("user.home")+"\\Desktop\\HelloJava.txt"; // the file we want to upload

        //Select the file you want to upload .

        chooseFileButton.sendKeys(dynamicpath);
        //Hit the upload button .

        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” Let's test that the text is displayed .
        WebElement uplatedText = driver.findElement(By.id("uploaded-files"));

        Assert.assertTrue(uplatedText.isDisplayed());


        ReusableMethods.waitFor(5);




    }
}
