package day12_table_excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_Table extends TestBase {

    //Create a Class D19_WebtablesHomework
    //Go to “https://demoqa.com/webtables” page
    //Print the headers found in Headers
    //Print the title of the 3rd column
    //Print all the data in the table
    //Print how many non-empty cells (data) are in the table
    //Print the number of rows in the table
    //Print the number of columns in the table
    //Print the 3rd column in the table
    //Print the Salary of the person whose "First Name" is Kierra in the table
    //Create a method on the Page page, it will print the data for me when I enter the number of rows and columns from the Test page.

    @Test
    public void test01(){


        ////Go to “https://demoqa.com/webtables” page
        driver.get("https://demoqa.com/webtables");

        //Print the headers found in Headers
        WebElement headersWebElement = driver.findElement(By.xpath("//div[@class='rt-thead -header']"));
        System.out.println("Titles : "+headersWebElement.getText());

        //Print the title of the 3rd column
        /*
                * save all titles in a list
                * from the list take the third element
         */

        List<WebElement> titleList = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println(titleList.get(2).getText());

        //Print all the data in the table
        WebElement tableBody = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        System.out.println("body of the table : "+tableBody.getText());

        //Print how many non-empty cells (data) are in the table
        System.out.println("===============");
        List<WebElement> allDataList = driver.findElements(By.xpath("//div[@class='rt-td']"));
        for (WebElement eachWebElement: allDataList
             ) {
            System.out.println(eachWebElement.getText());

        }

        // we stored all the datas in a list but we have emptyelements, and also we have elements which has a space in them
        // we should not count them.
        System.out.println("===============");
        int counter=0;
        for (WebElement eachWebElement: allDataList
             ) {
            if (!(eachWebElement.getText().equals("") || eachWebElement.getText().equals(" "))){
                counter++;
                System.out.println(eachWebElement.getText());

            }
        }

        System.out.println("number of the data : "+counter);


        //Print the number of rows in the table
        List<WebElement> rowsList = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Number of rows = "+rowsList.size());

        //Print the number of columns in the table
        List<WebElement> listOfColumn = driver.findElements(By.xpath("(//div[@role='row'])[1]/div"));
        System.out.println("number of columns : "+listOfColumn.size());

        //Print the 3rd column in the table

        System.out.println("title of third column : "+titleList.get(2).getText());
        System.out.println("elements of third column : ");

        List<WebElement> thirdrdColumnDataValues = driver.findElements(By.xpath("(//div[@class='rt-tr-group'])//div[3]"));
        for (WebElement eachElement: thirdrdColumnDataValues
             ) {
            System.out.println(eachElement.getText());
        }


        //Print the Salary of the person whose "First Name" is Kierra in the table

        System.out.println("===============");

        for (int i = 0; i < allDataList.size(); i++) {
            if (allDataList.get(i).getText().equals("Kierra")){
                System.out.println("the salari of desired person : "+allDataList.get(i+4).getText());
            }
        }


        //Create a method on the Page page, it will print the data for me when I enter the number of rows and columns from the Test page.

        String valueOfData = getTableValueUsingRowAndColumn(1,4); // //div[@class='rt-tr-group'][1]//div[4]

        System.out.println("value of desired data : "+valueOfData); // cierra@example.com



    }

    public String getTableValueUsingRowAndColumn(int row, int column) {
        /*
                We have created a dynamic xpath to locate desired webelement using row and column numbers

         */
                //div[@class='rt-tr-group'][1]//div[4]
        String xpath = "//div[@class='rt-tr-group']["+row+"]//div["+column+"]";     // //div[@class='rt-tr-group'][1]//div[4]

        WebElement valueWebElement = driver.findElement(By.xpath(xpath));

        // if we wanted to make a hard code we could write it like this. but you have to change numbers manually
        //WebElement valueWebElement = driver.findElement(By.xpath("//div[@class='rt-tr-group'][1]//div[4]"));

        // we got the value of the desired webelement
        String valueOfElement = valueWebElement.getText(); // cierra@example.com

        // we returned value of the webelement where the method is called
        return valueOfElement;

    }


}
