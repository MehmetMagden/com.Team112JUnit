package day10_Waits_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownloadTest extends TestBase {

    //         //1. Let's create a class under the Tests package: C04_FileDownload
    //        //Go to https://the-internet.herokuapp.com/download
    //        //3. Download the test.png file my hand
    //        //4 . Let 's test if the file was downloaded successfully

    @Test
    public void test01(){
        //        //Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");

        //        //3. Download the test.png file my hand
        driver.findElement(By.xpath("//a[text()='test.png']")).click();
        ReusableMethods.waitFor(5);

        // dynamic part will work in all computers because we are getting changing part from the system itself
                                                // C:\Users\Maden
        String downloadedFileDinamicPath = System.getProperty("user.home")+"\\Downloads\\test.png";

        // static path will only work in my computer, but we can use this path to get solid pard of the path
        //String staticPath ="C:\\Users\\Maden\\Downloads\\test.png";

        // If we have the path that the file will be downloaded to, rest is easy.
        Assert.assertTrue(Files.exists(Paths.get(downloadedFileDinamicPath)));

        ReusableMethods.waitFor(5);








    }

}
