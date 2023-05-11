package day13_excel_ScreenShoot_JsExecuter;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcelMethod {

    @Test
    public void tst01() throws IOException {

        String filePath = "src/test/java/day12_table_excel/countries.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(2));


        // we will create a method which prints the value of row and cell

        ReusableMethods.getvalueOfExcelFileUsingRowAndCell(3,2);
        ReusableMethods.getvalueOfExcelFileUsingRowAndCell(15,3);
        ReusableMethods.getvalueOfExcelFileUsingRowAndCell(66,1);

    }




}
