package day07_dropDown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {

    // 1) locate the webElement

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown(){

        driver.close();
    }


    @Test
    public void test01() throws InterruptedException {

    driver.get("https://www.amazon.com");

    WebElement dropDownWebElement =driver.findElement(By.id("searchDropdownBox"));

    // selenium developers have created a select class for us. By using this class we can handle dropDowns
    // If we face a problem shown by a redline, we can always hold down ctrl key and left click on it to understand
    // When we create a select object, we have to write dropDown webelement in normal brackets
        Select select = new Select(dropDownWebElement);

        // to select an option from the drop down we can use visible text
        select.selectByVisibleText("Books");

        // getFirstSelectedOption retunrs the selected option
        String expectedSelectedObjectText = "Books";
        String actualSelectedObjectText = select.getFirstSelectedOption().getText();  // Books

        Assert.assertEquals(expectedSelectedObjectText,actualSelectedObjectText);

        select.selectByIndex(7); // because of this number, it chose 7th option staring from zero

        select.selectByValue("search-alias=digital-music");

        // search for Java in digital-music section and test that title has Java word

        // refreshing the page
        driver.navigate().refresh();

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java"+ Keys.ENTER);

        String expectedWord = "Java";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedWord));


            // to get all the options of a dropdown

        // tast that the dropdown has 28 options

        /*
        When we refresh the page, it takes new information from the server so system will create a newer page for us
        It can be totally same with the previous one but it is actually a newer version
        So we need to relocate all elements to use them, otherwise we may face StaleElementException
         */

        // we relocated webelement by using same webelement //dropDownWebElement, so it solved the stale element problem
        dropDownWebElement =driver.findElement(By.id("searchDropdownBox"));
        select = new Select(dropDownWebElement);
        List<WebElement> lisfOfOptions = select.getOptions();

        int expectedOptionsNumber = 28;
        int actualOptionNumber = lisfOfOptions.size();

        Assert.assertEquals(expectedOptionsNumber,actualOptionNumber);


        Thread.sleep(15000);













    }

}
