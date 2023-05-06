package day09_actions_faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_KeyBoardActions extends TestBase {

    //1 - Let's create a Class KeyboardActions1
    //2 - Go to https://www.amazon.com
    //3 - Type Samsung A71 using actions methods in the search box and press Enter to search
    //4 - test that the search is completed in amazon website


    @Test
    public void test01(){

        //2 - Go to https://www.amazon.com
        driver.get("https://www.amazon.com");

        //3 - Type Samsung A71 using actions methods in the search box and press Enter to search

        Actions actions = new Actions(driver);
        // to write something on searchbox, first we need to click on it
        driver.findElement(By.id("twotabsearchtextbox")).click();

        // Samsung A71
        actions.keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71"+Keys.ENTER)
                .perform();

        ReusableMethods.waitFor(3);

        //4 - test that the search is completed in amazon website

        WebElement resultText = driver.findElement(
                By.xpath("//div[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));

        String actualText = resultText.getText();
        System.out.println(actualText);
        String expectedTextWord = "Samsung A71";

        Assert.assertTrue(actualText.contains(expectedTextWord));


    }
}
