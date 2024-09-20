package com.swathi.DataDrivenTesting;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class taskExcel02 {

        // Task 02
    // Open the File and Read the data - Excel file

    public static void main(String[] args) throws IOException {

        // 1st - find the file
        FileInputStream inputStream = new FileInputStream("CTD2.xlsx");

        // Find the workbook and sheet
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        // you can use getSheet by name or index, here index 0 means the 1st sheet in the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);// this will get u Main sheet

        // Sheet has an Iterator method
        // Iterator to get the rows and cells
        Iterator<Row> rowIterator = sheet.iterator();// getting all the rows from sheet.iterator

    // this while loop is used to get the rows
        while(rowIterator.hasNext()){
            Row row = rowIterator.next();// this will give u the current row
            Iterator<Cell> cellIterator = row.cellIterator();//from the current row we are getting the cell

            // this while loop is used to get the cells
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                //  if cell type is numeric then use below
                if (cell.getCellType() == CellType.NUMERIC){
                    System.out.println(cell.getNumericCellValue());
                }
                //  if cell type is String
                if (cell.getCellType() == CellType.STRING){
                    System.out.println(cell.getStringCellValue());
                }

            }
        }
    }
}
