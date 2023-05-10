package day12_table_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel  {

    @Test
    public void test() throws IOException {

        /*
        when we use an excel file, actually we are not using that file. Java will create a copy of it and it will work on it
       */
        // file path from content root
        String filePath ="src/test/java/day12_table_excel/countries.xlsx";

        // adding file to the project by creating a fis object
        FileInputStream fis = new FileInputStream(filePath);

        // we will create a copy of the file to work on
        Workbook workbook = WorkbookFactory.create(fis);

        // now we have a copy of excel file

        // step by step we will try to reach the data

        Sheet sheet = workbook.getSheet("Sayfa1"); // reaching the sheet

        // let's try to reach row 5 // index starts from zero so to reach 6th row we need to enter 5
        Row row = sheet.getRow(8);

        //  let's reach 3rd column
        Cell cell = row.getCell(3);     //Erivan

        System.out.println("value of the cell : "+cell); //Erivan





















    }

}
