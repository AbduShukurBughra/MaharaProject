package com.seleniummaster.configproperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationConfig {
    public static void main(String[] args) throws FileNotFoundException {
        Properties properties=new Properties();
        FileInputStream inputStream= null;
        try {
            inputStream = new FileInputStream("config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(properties.getProperty("username"));
//        System.out.println(properties.getProperty("password"));
        System.out.println("Before Change "+properties.getProperty("timeout"));
        properties.setProperty("timeout","20");
        FileOutputStream fileOutputStream=new FileOutputStream("config.properties");
        try {
            properties.store(fileOutputStream,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("After Change "+properties.getProperty("timeout"));


    }
}
