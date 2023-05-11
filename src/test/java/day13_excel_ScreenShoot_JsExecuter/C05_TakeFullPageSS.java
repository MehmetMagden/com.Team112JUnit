package day13_excel_ScreenShoot_JsExecuter;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_TakeFullPageSS extends TestBase {

    @Test
    public void test01(){
        // wisequarter
        // test that you are in wisequarter
        // take a SS

        // wisequarter
        driver.get("https://www.wisequarter.com");

        // test that you are in wisequarter
        String actualUrl = driver.getCurrentUrl();

        String expectedUrlWord = "wisequarter";

        Assert.assertTrue(actualUrl.contains(expectedUrlWord));

        // take a SS

        ReusableMethods.fullPageScreenShot(driver);



    }


}
