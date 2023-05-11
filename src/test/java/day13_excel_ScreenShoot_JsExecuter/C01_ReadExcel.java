package day13_excel_ScreenShoot_JsExecuter;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

       // to work on a file, first we need to complete 3 steps
        // 1) file path
        String filePath = "src/test/java/day12_table_excel/countries.xlsx";
        // 2) let's inroduce file with the java project
        FileInputStream fis = new FileInputStream(filePath);
        // 3) Let's create a copy of the original excel file (apachi depencies)
        Workbook workbook = WorkbookFactory.create(fis);

        // let's reach row 1 and column 2 of sheet named Sayfa1
        System.out.println(workbook.getSheet("Sayfa1").getRow(1).getCell(1)); // Kabul

        // when we dont use toString() method at the end, the data type of the value will be a "Cell" so I can not assing it
        // to a String variable. By using toString method we made "Cell"  a string variable. So we could be able to assing it
        String desiredCellStr = workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString(); //Kabul
        System.out.println(desiredCellStr); // Kabul

        //  test that 2. row and 4.cell value is Kabil
        String actualCellValue = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedCellValue ="Kabil";
        Assert.assertEquals(expectedCellValue,actualCellValue);

        // let's try to find how many rows are being used in sheet named Sayfa2
        System.out.println("last number of the sheet : "+workbook.getSheet("Sayfa2").getLastRowNum());  // 23

        // try to find how many used rows we have in the second sheet
        System.out.println("number of used rows in the sheet : "+workbook.getSheet("Sayfa2").getPhysicalNumberOfRows()); // 8

        Map<String,String> countriesMap = new TreeMap<>();

        String key ="";
        String value ="";

        int lastRowNumberOfSheet = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(lastRowNumberOfSheet);



        for (int i = 0; i <= lastRowNumberOfSheet; i++) {

            key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            // when we dont use toString() method at the end, the data type of the value will be a "Cell" so I can not assing it
            // to a String variable. By using toString method we made "Cell"  a string variable. So we could be able to assing it
            value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+"- "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+"- "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            countriesMap.put(key,value);
        }

        System.out.println(countriesMap);

        for (String eachKey: countriesMap.keySet()
             ) {
            System.out.println(); // to jump to next tile for each loop
            System.out.print(eachKey); // will bring the keys
            System.out.print(" "+countriesMap.get(eachKey)); // will get the values of the each key


        }























    }

}
