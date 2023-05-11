package day13_excel_ScreenShoot_JsExecuter;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcel {

    @Test
    public void test01() throws IOException {

        /*
        If you want to write something to an excel file, be sure that it is closed, otherwise process may damage your
        excel file
         */
        // to write something to an excel file first we neet to create a workbook

        String filePath = "src/test/java/day12_table_excel/countries.xlsx";

        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook = WorkbookFactory.create(fis); //// created a copy of the excel file

        workbook.getSheet("Sayfa1").getRow(0).createCell(3).setCellValue("Products");
        // when we make a change in workbook, actually we are changing something in the copy of the original file

        workbook.getSheet("Sayfa1").getRow(4).createCell(4).setCellValue("Apple");
        workbook.getSheet("Sayfa1").getRow(5).createCell(4).setCellValue("Windows");
        workbook.getSheet("Sayfa1").getRow(7).createCell(4).setCellValue("Java");
        //// chaged a lot of cells in this copy

        //// to save the copy file to original one

        // now we will take something out of the project so we will use fileoutputStream
        FileOutputStream fos = new FileOutputStream(filePath);
        // to write all changes to the original file, workbook.write
        // so we will save this copy to the original file.
        workbook.write(fos);



    }
}
