package day09_actions_faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_MoveToElement  extends TestBase {

    //Let's create a new class: MouseActions3
    //1- Go to https://www.amazon.com/
    //2- Move the mouse over the menu to open the “Account & Lists” menu in the upper right section.
    //3- Press the “Create a list” button
    //4- Test that "Your Lists" is written on the page that opens.

    @Test
    public void test(){

        //1- Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //2- Move the mouse over the menu to open the “Account & Lists” menu in the upper right section.

        Actions actions = new Actions(driver);

        WebElement toMoveElement = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
        actions.moveToElement(toMoveElement).perform();

        //3- Click the “Create a list” button
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();


        //4- Test that "Your Lists" is written on the page that opens.

        WebElement yourListText = driver.findElement(By.xpath("//div[@role='heading']"));

        Assert.assertTrue(yourListText.isDisplayed());

        ReusableMethods.waitFor(3);



    }
}
