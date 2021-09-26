package com.seleniummaster.io;

import com.seleniummaster.sprnt1.LoginUser;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {
    //write a method to read data from excel cell
    public static String readFromExcel(String fileName, String sheetName, int rowNumber, int columnNumber) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = workbook.getSheet(sheetName);
        XSSFRow row = sheet.getRow(rowNumber);
        String cellValue = null;
        if (row == null) {
            System.out.println("Empty row, no data in the excel sheet");
        } else {
            XSSFCell cell = row.getCell(columnNumber);
            CellType cellType = cell.getCellType();
            switch (cellType) {
                case STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
            }
        }
        return cellValue;

    }

    public static List<LoginUser> readMultipleCellvalue(String fileName, String sheetName, int stratRow) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<LoginUser> loginUser = new ArrayList<>();
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        for (int r = stratRow; r <= rowCount; r++) {
            XSSFRow rows = sheet.getRow(r);
            if (rows == null) {
                System.out.println("Empty Row");
            } else {
                XSSFCell usernameCell = rows.getCell(0);
                XSSFCell passwordCell = rows.getCell(1);
                loginUser.add(new LoginUser(usernameCell.getStringCellValue(),
                        passwordCell.getStringCellValue()));
            }
        }
        return loginUser;
    }

//    public void writeToExcellCells(String fileName,String sheetName,List<String> contents){
//        //define a file to write content
//        File excelFile=new File(fileName);
//        //define a work book
//        XSSFWorkbook workbook=new XSSFWorkbook();
//        XSSFSheet sheet=workbook.createSheet(sheetName);
//        int numberOfRows=contents.size();//4
//        for(int rowNumber=0;rowNumber<numberOfRows;rowNumber++){
//            XSSFRow row=sheet.createRow(rowNumber);
//            String[] rowContent=contents.get(rowNumber).split(",");
//            System.out.println(Arrays.toString(rowContent));
//            int totalCell=rowContent.length;//2
//            for(int cellNumber=0;cellNumber<totalCell;cellNumber++){
//                XSSFCell cell=row.createCell(cellNumber);
//                cell.setCellValue(rowContent[cellNumber]);
//            }
//        }
//        FileOutputStream outputStream= null;
//        try {
//            outputStream = new FileOutputStream(excelFile);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            workbook.write(outputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            workbook.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}

