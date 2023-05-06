package day09_actions_faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_DragAndDrop extends TestBase {

    //Let's create a new class: MouseActions2
    //1- Let's go to https://demoqa.com/droppable
    //2- Let's hold the "Drag me" button and drop it above the "Drop here" box
    //3-  Test that,Instead of “Drop here” text “Dropped!” text is there

    @Test
    public void test01(){

        //

        //1- Let's go to https://demoqa.com/droppable
        driver.get("https://demoqa.com/droppable");

        //2- Let's hold the "Drag me" button and drop it above the "Drop here" box
        Actions actions = new Actions(driver);

        WebElement dragMeWebElement = driver.findElement(By.xpath("//div[text()='Drag me']"));
        WebElement dropPlace = driver.findElement(By.xpath("(//div[@class='drop-box ui-droppable'])[1]"));


        actions.dragAndDrop(dragMeWebElement,dropPlace).perform();

        ReusableMethods.waitFor(5);

        //3-  Test that,Instead of “Drop here” text “Dropped!” text is there
        WebElement droppedWebElement =driver.findElement(By.xpath("//p[text()='Dropped!']"));

        String actualText = droppedWebElement.getText();
        String expectedText = "Dropped!";

        Assert.assertEquals(expectedText,actualText);

        ReusableMethods.waitFor(3);




    }


}
