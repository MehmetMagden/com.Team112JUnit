package day09_actions_faker;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C02_ActionsClass extends TestBase {

    //1- Let's create a new class: MouseActions1
    //2- Go to https://the-internet.herokuapp.com/context_menu
    //3- Right click on the drawn area
    //4- Test that the text in Alert is “You selected a context menu”.
    //5- Let's close the alert by saying OK
    //6- Click on Elemental Selenium link
    //7- Let's test that "Elemental Selenium" is written in the h1 tag on the page that opens.

    @Test
    public void test01(){



        //2- Go to https://the-internet.herokuapp.com/context_menu
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Right click on the drawn area
        WebElement rightClickArea = driver.findElement(By.id("hot-spot"));

        // to use premade methods from Actions class we need to create an object from it
        Actions actions = new Actions(driver);

        ReusableMethods.waitFor(1);
        // to right click on a webelement : contextClick(WebElement)
        // to use aciton class in action, at the end we need to write perform() method
        actions.contextClick(rightClickArea).perform();
        ReusableMethods.waitFor(1);
        //4- Test that the text in Alert is “You selected a context menu”.

        String actualAlertText =driver.switchTo().alert().getText();
        String expectedAlertText ="You selected a context menu";

        Assert.assertEquals(expectedAlertText,actualAlertText);

        ReusableMethods.waitFor(1);

        //5- Let's close the alert by clicking OK
        driver.switchTo().alert().accept();

        //6- Click on Elemental Selenium link
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();




        String firstPageHW = driver.getWindowHandle(); // this will take the handle value of the tab that driver still inside

        Set<String> handleValuesSet = driver.getWindowHandles(); // this set will store all handle values from all tabs

        // I know first tabs handle value, I also have All tabs' handle values

        String secondTabHW="";
        for (String each: handleValuesSet
             ) {

            if (!each.equals(firstPageHW)){
                secondTabHW = each;
            }
        }

        //7- Let's test that "Elemental Selenium" is written in the h1 tag on the page that opens.
        // bu using second tab's handle value, driver will jump to the second tab
        driver.switchTo().window(secondTabHW);

        WebElement elementalSelenium = driver.findElement(By.tagName("h1"));
        String actualText = elementalSelenium.getText();
        String expectedText = "Elemental Selenium";

        Assert.assertEquals(expectedText,actualText);




    }

}
