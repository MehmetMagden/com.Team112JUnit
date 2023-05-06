package day09_actions_faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_FakerClass extends TestBase {

    // 1 - Go to https://www.facebook.com
    //2 - Let's press the create new account button
    //3 - Write the value in the name, surname, e-mail and password boxes and press the register button
    //4 - Let's hit the sign up button

    @Test
    public void test01(){

        // 1 - Go to https://www.facebook.com
        driver.get("https://www.facebook.com ");

        //2 - Let's press the create new account button
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        //3 - Write the value in the name, surname, e-mail and password boxes and press the register button

        driver.findElement(By.name("firstname")).click();

        Actions actions = new Actions(driver);

        Faker faker = new Faker();

        String fakeEmail = faker.internet().emailAddress();

        actions.sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB) // to jump to the next box, we need to press tab twice
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys("1999")
                .sendKeys(Keys.TAB) // to jump to the next box, we need to press tab twice
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();

        driver.findElement(By.name("websubmit")).click();


        ReusableMethods.waitFor(30);









    }
}
