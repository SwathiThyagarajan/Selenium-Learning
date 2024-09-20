package com.swathi.DataDrivenTesting;

import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader_AllScenarios {


    public FileInputStream fi; // Used to read data from an existing Excel file.
    public FileOutputStream fo; // Used to write data to an Excel file, either for updates or for creating a new file.
    public XSSFWorkbook workbook; // Represents the entire Excel workbook and allows access to its sheets.
    public XSSFSheet sheet; // Represents a specific sheet in the workbook, allowing operations on that sheet.
    public XSSFRow row; // Represents a specific row in the sheet, allowing access to its cells.
    public XSSFCell cell; // Represents a specific cell within a row, allowing read/write operations on the cell.

    public CellStyle style; // Used to define and apply formatting styles (like colors) to cells in the Excel sheet.
    String path; // Holds the file path of the Excel workbook, used to open and manipulate the file.


//  Constructor: Initializes the path of the Excel file.
    // Constructor that takes the path of the Excel file as an argument.
    public ExcelReader_AllScenarios(String path)
        {
            this.path=path;
        }


    // Method to get the total number of rows in a specified sheet.
        public int getRowCount(String sheetName) throws IOException {
            fi=new FileInputStream(path);
            workbook=new XSSFWorkbook(fi);
            int index = workbook.getSheetIndex(sheetName);
            if(index==-1)
                return 0;// Sheet does not exist.
            else{
                sheet = workbook.getSheetAt(index);
                int number=sheet.getLastRowNum()+1; // Total rows including header.
                return number;
            }
        }


    // Method to get the number of cells in a specific row of a sheet.
        public int getCellCount(String sheetName,int rownum) throws IOException
        {
            fi=new FileInputStream(path);
            workbook=new XSSFWorkbook(fi);
            sheet=workbook.getSheet(sheetName);
            row=sheet.getRow(rownum);
            int cellcount=row.getLastCellNum();
            workbook.close();
            fi.close();
            return cellcount;
        }


    // Method to get the data from a specific cell.
        public String getCellData(String sheetName,int rownum,int colnum) throws IOException
        {
            fi=new FileInputStream(path);
            workbook=new XSSFWorkbook(fi);
            sheet=workbook.getSheet(sheetName);
            row=sheet.getRow(rownum);
            cell=row.getCell(colnum);

            DataFormatter formatter = new DataFormatter();
            String data;
            try{
                data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
            }
            catch(Exception e)
            {
                data="";// Return empty string if there's an error.
            }
            workbook.close();
            fi.close();
            return data;
        }

    // Method to set data in a specific cell.
        public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
        {
            File xlfile=new File(path);
            if(!xlfile.exists())    // If file not exists then create new file
            {
                workbook=new XSSFWorkbook();
                fo=new FileOutputStream(path);
                workbook.write(fo);
            }

            fi=new FileInputStream(path);
            workbook=new XSSFWorkbook(fi);

            if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
                workbook.createSheet(sheetName);

            sheet=workbook.getSheet(sheetName);

            if(sheet.getRow(rownum)==null)   // If row not exists then create new Row
                sheet.createRow(rownum);
            row=sheet.getRow(rownum);

            cell=row.createCell(colnum);// Create or update the cell.
            cell.setCellValue(data);
            fo=new FileOutputStream(path);
            workbook.write(fo);// Write data to the file.
            workbook.close();
            fi.close();
            fo.close();
        }

    // Method to fill a cell with green color.
        public void fillGreenColor(String sheetName,int rownum,int colnum) throws IOException
        {
            fi=new FileInputStream(path);
            workbook=new XSSFWorkbook(fi);
            sheet=workbook.getSheet(sheetName);

            row=sheet.getRow(rownum);
            cell=row.getCell(colnum);

            style=workbook.createCellStyle();

            style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            cell.setCellStyle(style);
            workbook.write(fo); // Write changes to the file.
            workbook.close();
            fi.close();
            fo.close();
        }

    // Method to fill a cell with red color.
        public void fillRedColor(String sheetName,int rownum,int colnum) throws IOException
        {
            fi=new FileInputStream(path);
            workbook=new XSSFWorkbook(fi);
            sheet=workbook.getSheet(sheetName);
            row=sheet.getRow(rownum);
            cell=row.getCell(colnum);

            style=workbook.createCellStyle();

            style.setFillForegroundColor(IndexedColors.RED.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            cell.setCellStyle(style);
            workbook.write(fo);
            workbook.close();
            fi.close();
            fo.close();
        }


    // Method to get data from the specified sheet and return it as a 2D array.
        public String[][] getDataFromSheet(String workbookLocation, String workSheetName) throws IOException {
            XSSFWorkbook workbook = new XSSFWorkbook(System.getProperty("user.dir") + "/" + workbookLocation);
            XSSFSheet workSheet = workbook.getSheet(workSheetName);

            int noOfRows = workSheet.getLastRowNum() + 1;// Total number of rows.
            int noOfColumns = workSheet.getRow(0).getLastCellNum();// Total number of columns.
            String[][] dataTable = new String[noOfRows][noOfColumns];

            for (int i = workSheet.getFirstRowNum(); i < workSheet.getLastRowNum() + 1; i++) {
                Row row = workSheet.getRow(i);
                for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    dataTable[i][j] = cell.getStringCellValue();// Store cell data in the array.
                }
            }

            workbook.close();// Close the workbook.
            return dataTable;// Return the data array.
        }
}
