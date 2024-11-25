package utils;


import constants.AppConstants;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    static String fileLocation;
    static XSSFSheet sheetName;
    static XSSFWorkbook workBook;
    static File location;
    static FileInputStream fileStream;

    //constructor
    public ExcelUtils(String dotXlsFileName, String sheetname){

        try {

            fileLocation = System.getProperty("user.dir");
            location = new File(fileLocation+ AppConstants.TEST_DATA_DIRECTORY + dotXlsFileName + ".xlsx");
            fileStream = new FileInputStream(location);

            workBook = new XSSFWorkbook(fileStream);
            sheetName = workBook.getSheet(sheetname);
            System.out.println("Excel Loaded.");

        }catch (IOException e){

            Assert.fail("Invalid Excel.");
            System.out.println("Invalid Excel.");
        }
    }


    //get row count
    public int getRowCount(){
        int rowCount = sheetName.getPhysicalNumberOfRows();
        System.out.println("Total number of rows: "+rowCount);
        return rowCount;
    }

    //get column count
    public int getColCount(){
        int colCount = sheetName.getRow(0).getPhysicalNumberOfCells();
        System.out.println("Total number of columns: "+colCount);
        return colCount;
    }

    public String getCellDataString(int rowCount, int columnCount){

        String cellData = new DataFormatter().formatCellValue(sheetName.getRow(rowCount).getCell(columnCount));
        return cellData;
    }

    public Object[][] getTestData(String sheetName){

        int rowCount = getRowCount(); // get total number of rows
        int colCount = getColCount(); // get total number of columns

        Object data[][] = new Object[rowCount-1][colCount];

        for(int i=1; i<rowCount; i++){
            for (int j=0; j<colCount; j++){
                String fullData = getCellDataString(i,j);
                data[i-1][j] = fullData;
            }
        }
        System.out.println("Returned all Values.");
        return data;
    }








}
