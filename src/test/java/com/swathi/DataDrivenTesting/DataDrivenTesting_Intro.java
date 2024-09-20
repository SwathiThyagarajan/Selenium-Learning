package com.swathi.DataDrivenTesting;

public class DataDrivenTesting_Intro {

/*       Data Driven Testing

1. Apache POI is used for Excel sheet and csv data
2. Nowadays most of the companies are using snake YAML or directly JSON files even though the data is huge
   but still there are few companies which are using Apache POI to read data from Excel files
   and people are preferring to read from the csv file -> (comma separated values) text files.
   So there are multiple ways to read the data either by using the JSON, YAML, CSV or XLSX Excel directly.
3. Snake YAML is a java library
4. There are 2 libraries which we can use to read the data
    1. Apache POI supports only the Microsoft XLSX files
    2. Fillo Excel library - advantage of Fillo is that you can run SQL queries with the csv or Excel files.
       if u have Excel file present u can get the data as if it is a SQL query.
    3. To work with YAML there is a library known as Snake YAML.
    4. If u want to read JSON data directly u can use Json objects

To work with different type of test data Java provides different 3rd party libraries.

5. You need the basic knowledge of reading data from
    - XLSX, JSON & YAML
    Nowadays, YAML is very popular because it is very simple and human friendly syntax

   What is Data Driven Testing:-
   Data Driven Testing means reading data from different files and using it in a Framework.

 ->  Data Driven Testing means that you have a Data file - Data file can be a xlsx file, text file,
   Json file it can be MySQL Database, csv or a Yaml file. Format can be anything.

 ->   What we will do is we will fetch the Test Data from the Data file and
   inject the Data into the  Driver Script. Then we will Run the testcase and verify the Test result.
   Sometimes Expected output is also present in the Data file. or we already know the output

 -> we can fetch data from MySQL Database by using JDBC SQL connector.
 It will give the data in the form of List or Map.


  Apache POI is a library which will help u to read the Microsoft Excel documents

In Microsoft Excel we have a Workbook in the workbook we have a Sheet, sheet has a Row and a cell

You can use Apache open office or LibreOffice or WPS office all these are free
which can be used instead of Microsoft Excel

Task 1
create an Excel file and adding data using Apache POI

-> for this 1st go to maven repository type Maven Apache POI copy the dependency latest version
and paste it in your project in pom.xml file

now create a java class by name taskExcel01



*/

}
