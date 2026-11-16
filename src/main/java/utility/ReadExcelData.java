package utility;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadExcelData {
    public static String getparticularData(int rowval, int cellval) {
        String data = null;
        try {
            File file = new File("/Users/apple/IdeaProjects/Maven_November1/ExcelSheet/DataDriven_IPT.xlsx");
            Workbook book = new XSSFWorkbook(file);
            Sheet sheet = book.getSheet("Sheet1");
            Row row = sheet.getRow(rowval);
            Cell cell = row.getCell(cellval);
            // dataformatter__> convert each cell in to string value
            DataFormatter dataFormatter = new DataFormatter();
            data = dataFormatter.formatCellValue(cell);
            System.out.println(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    public  static void getAlldata() {

        try {
            File file = new File("/Users/apple/IdeaProjects/Maven_November1/ExcelSheet/DataDriven_IPT.xlsx");
            Workbook book = new XSSFWorkbook(file);
            Sheet sheet = book.getSheet("Sheet1");

            int lastRowNUm = sheet.getLastRowNum();
            System.out.println("no of rows: " + lastRowNUm);

            short lastCellnum = sheet.getRow(0).getLastCellNum();
            System.out.println("no of cell: " + lastCellnum);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    // dataformatter__> convert each cell in to string value
                    DataFormatter dataFormatter = new DataFormatter();
                    String data = dataFormatter.formatCellValue(cell);
                    System.out.println(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public static void writeData() {
//        try {
//            File file = new File("/Users/apple/IdeaProjects/Maven_November1/ExcelSheet/DataDriven_IPT.xlsx");
//            FileInputStream fileInput = new FileInputStream(file);
//            Workbook book = new XSSFWorkbook(fileInput);
//            //			book.createSheet("JUL-IPT").createRow(0).createCell(0).setCellValue("Raju");
//            book.getSheet("JUL-IPT").createRow(1).createCell(0).setCellValue("Muthu");
//            FileOutputStream fileOutput = new FileOutputStream(file);
//            book.write(fileOutput);
//            book.close();
//            System.out.println("--Successfully created---");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
      getparticularData(1,2);
    }
}




