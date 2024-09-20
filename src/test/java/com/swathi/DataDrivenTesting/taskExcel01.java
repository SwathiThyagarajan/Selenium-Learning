package com.swathi.DataDrivenTesting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class taskExcel01 {

    public static void main(String[] args) throws IOException {


        // In any Excel file we have a Workbook -> Sheet -> Row, Cell.
        // we have 2 formats.
        // old prior 2007 HSSFWorkbook XLS and
        // new format from 2008 XSSFWorkbook  XLSX

//        Task 1
//        create an Excel file and adding data using Apache POI
        // I have some data username and password I will add this data
        // for this purpose I will create a Map

        // Creating data to add to Excel
        Map<String, Object> data = new TreeMap<>();
        data.put("1", new Object[]{"LoginId", "Email", "Password"}); // 1st row  Header row
        data.put("2", new Object[]{"1", "pramod@live.com", "Pass123456"}); // 2nd row data that I want to add
        data.put("3", new Object[]{"2", "test@gmail.com", "Password123"}); // 3rd row data that I want to add

        createExcel("CTD2.xlsx", data);

    }

    static String createExcel(String name, Map data) throws IOException {

        // Get all keys from the map
        Set<String> keyset = data.keySet();

        // Create a new workbook and sheet
        XSSFWorkbook workbook = new XSSFWorkbook();// CTD.xlsx is the name for the workbook
        XSSFSheet sheet = workbook.createSheet("Main");// Main is the sheet name

        // we have 3 keyset so 3 times the for loop will run
        int rownum = 0; // Start row number

        for (String key : keyset) {
            Row r = sheet.createRow(rownum++); // Create a new row for each key
            Object[] objectA = (Object[]) data.get(key); // Get the data (array) for each row
            int cellnum = 0;
            for (Object o : objectA) {
                Cell cell = r.createCell(cellnum++); // Create a new cell for each data item
                if (o instanceof String) {
                    cell.setCellValue((String) o); // Set cell value (cast to String)
                }
                if (o instanceof Integer) {
                    cell.setCellValue((Integer) o);
                }
            }

            FileOutputStream outputStream = new FileOutputStream(new File(name));
            workbook.write(outputStream);
            outputStream.close();

            // new FileOutputStream(new File("CTD.xlsx")): Opens a file output stream to write
// the workbook content into the file CTD.xlsx.
//workbook.write(outputStream): Writes the data in the workbook to the file output stream.
//outputStream.close(): Closes the output stream to free up system resources.
        }
        return name;
    }
//    Purpose of FileOutputStream
//    FileOutputStream is used to write data to a file.
//    In this case, after you create the Excel file in memory (using Apache POI),
//    you need to save this file to the disk. This is where FileOutputStream comes into play.
//
//            FileOutputStream(new File(name)):
//            This opens a stream to the file you specify (in this case, "CTD2.xlsx").
//            If the file doesn't exist, it creates a new one. If it already exists,
//            it will overwrite the existing file.
//
//            workbook.write(outputStream):
//            This writes the contents of the Excel workbook (created in memory)
//            to the file through the outputStream.
//
//            outputStream.close():
//            Closing the FileOutputStream releases system resources
//            associated with it and ensures that all data has been properly written to the file.
}
