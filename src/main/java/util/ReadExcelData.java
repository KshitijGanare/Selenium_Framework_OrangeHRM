package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelData {

    public static String getExcelData(int rowNum, int colNum) throws IOException {

        FileInputStream file = new FileInputStream("src/test/resources/TestData.xlsx");
        Sheet sh = WorkbookFactory.create(file).getSheet("TestSheet");
        String data = sh.getRow(rowNum).getCell(colNum).getStringCellValue();

        return data;

    }

    public static Object[][] getAllExcelData(String sheetName) throws IOException {
        FileInputStream file = new FileInputStream("src/test/resources/TestData.xlsx");
        Sheet sh = WorkbookFactory.create(file).getSheet(sheetName);

        int rowCount = sh.getLastRowNum(); // total rows
        int colCount = sh.getRow(0).getLastCellNum(); // total columns

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i][j] = sh.getRow(i + 1).getCell(j).toString(); // i+1 to skip header
            }
        }
        return data;
    }
}
