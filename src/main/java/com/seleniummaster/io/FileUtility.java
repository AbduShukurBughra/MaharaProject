package com.seleniummaster.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtility {
    //create a method to write a text file
    public void writeToFile(String folderName, String fileName, String fileExtension, String fileContent) {
        //create a folder if the folder does not exist
        String workingDirectory = System.getProperty("user.dir");
        String finalDirectory = workingDirectory + File.separator + folderName;
        System.out.println(finalDirectory);
        //Define the file
        File file = new File(finalDirectory);
        // if the folder does not exist
        if (!file.exists()) {
            file.mkdir();
            System.out.println("Folder is created.");
        }
        String finalFileName = finalDirectory + File.separator + fileName + "-" +
                System.currentTimeMillis() + fileExtension;
        System.out.println(finalFileName);
        //define a file to write
        File f=new File(finalFileName);
        FileWriter fileWriter=null;
        try {
            fileWriter=new FileWriter(f.getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //create a buffered writer instance
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        try {
            bufferedWriter.write(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

