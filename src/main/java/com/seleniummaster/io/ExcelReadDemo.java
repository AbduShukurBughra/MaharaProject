package com.seleniummaster.io;

public class ExcelReadDemo {
    public static void main(String[] args) {
        String cell= ExcelUtility.readFromExcel("doc/maharaInfo.xlsx","UserInfo",0, 0);
        System.out.println(cell);

    }
}
