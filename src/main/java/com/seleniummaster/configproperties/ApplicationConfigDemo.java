package com.seleniummaster.configproperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ApplicationConfigDemo {
    //create a method read from properties file--filename, key
    public static String readFromPropertiesFile(String fileName,String key){
        Properties properties=new Properties();
        FileInputStream inputStream= null;
        String value;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        value=properties.getProperty(key);
        System.out.println(String.format("%s=%s",key,value));
        return value;
    }
}
