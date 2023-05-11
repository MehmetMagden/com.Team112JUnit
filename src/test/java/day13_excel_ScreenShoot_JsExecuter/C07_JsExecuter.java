package day13_excel_ScreenShoot_JsExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C07_JsExecuter extends TestBase {

    @Test
    public void test01(){

        driver.get("https://www.amazon.com");

        WebElement giftCards = driver.findElement(By.xpath("//a[text()='Gift Cards']"));

        //giftCards.click();

         //1) First we need to create a javaScriptExecuter Object

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // by using object we will apply js code to the element

        js.executeScript("arguments[0].click();",giftCards);

        js.executeScript("alert('Thats it')");

        ReusableMethods.waitFor(10);
    }
}
