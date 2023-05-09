package day11_cookies_tables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    @Test
    public void test(){

        //Go to "https://www.amazon.com"
        //Scroll to the bottom of the page
        //Print the entire body of the web table
        //Test that the number of rows in the web table is 9
        //Print all lines
        //Test that the number of columns in the web table is 13
        //print column 5
        //Create a method that takes the number of rows and columns as parameters and returns the information in the cell

        //Go to "https://www.amazon.com"
        driver.get("https://www.amazon.com");

        //Scroll to the bottom of the page
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //Print the entire body of the web table
        WebElement tableBody = driver.findElement(By.xpath("//tbody"));
        // Sometimes we can not print the body directly
//        System.out.println(tableBody.getText());
//        System.out.println(tableBody);

        //Test that the number of rows in the web table is 10

        List<WebElement> trList = driver.findElements(By.xpath("//tbody/tr"));


        int actualNumberOfRows = trList.size();
        int expectedNumberOfRows = 10;

        Assert.assertEquals(expectedNumberOfRows,actualNumberOfRows);


        //Print all lines

        //System.out.println(trList);
        // to print the list of rows
        for (WebElement eachElement: trList
        ) {
            System.out.println(eachElement.getText());
        }


        //Test that the number of columns in the web table is 13

        List<WebElement> columnNumber =driver.findElements(By.xpath("//tbody/tr[1]/td"));

        int expectedNumberOfColumn = 13;
        int actualNumberOfColumn = columnNumber.size();

        Assert.assertEquals(expectedNumberOfColumn,actualNumberOfColumn);

        //print column 5

        System.out.println("===================");
        List<WebElement> ListOfColumns = driver.findElements(By.xpath("//tbody/tr/td[5]"));

        for (WebElement eachEelement: ListOfColumns
             ) {
            System.out.println(eachEelement.getText());;

        }

        //Create a method that takes the number of rows and columns as parameters and returns the information in the cell

        WebElement cellValue = valueOfCell(3,7);

        System.out.println(cellValue.getText());
    }


    public WebElement valueOfCell(int rowNumber, int columnNumber) {

        // //tbody/tr[3]/td[7]
        String xpath = "//tbody/tr["+ rowNumber  +"]/td["+   columnNumber  +"]";
        System.out.println(xpath);

        WebElement cellValueOfTable = driver.findElement(By.xpath(xpath)); // tbody/tr[3]/td[7] we dynamicly created an xpath (line 90) and used it as a locater

        return cellValueOfTable;
    }

}
