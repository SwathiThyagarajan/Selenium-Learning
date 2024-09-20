package com.swathi.DataDrivenTesting;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class taskExcel03 {

    public static void main(String[] args) throws IOException {

        // writing data to a particular cell
        // Task - Create cell at specific position

// Create a workbook and a new sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sheet02");

        // To create cell at specific position u need a row
        Row row = sheet.createRow(1);
        Cell cell = row.createCell(1);// getting cell from the row
        cell.setCellValue("Swathi Venkatesh");



        // FileOutputStream is necessary to save the Excel file that you've created in memory
        // to a physical file on disk. Without it, the data you are adding to the Excel workbook
        // would exist only in memory and not be saved as an actual file

        // If you were reading data from an existing file, you'd use FileInputStream
        // for  creating a new file and writing data to it, FileOutputStream is appropriate

        FileOutputStream outputStream = new FileOutputStream(new File("cellSpecific.xlsx"));
        workbook.write(outputStream);
        outputStream.close();
    }
}
