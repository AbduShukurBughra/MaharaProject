package com.seleniummaster.sprnt2;

import com.seleniummaster.io.ExcelUtility;

public class TestRunner extends TestBaseForMahara {
    public static void main(String[] args) {
        browserSetUp();
        LibraryOfFunctions library = new LibraryOfFunctions();
        String username = ExcelUtility.readFromExcel("doc/maharaInfo.xlsx","UserInfo", 1,0);
        String password = ExcelUtility.readFromExcel("doc/maharaInfo.xlsx","UserInfo", 1,1);
        library.login(username,password);

        String title = ExcelUtility.readFromExcel("doc/maharaInfo.xlsx","PlanInfo", 1,0);
        String description = ExcelUtility.readFromExcel("doc/maharaInfo.xlsx","PlanInfo", 1,1);
        String tags = ExcelUtility.readFromExcel("doc/maharaInfo.xlsx","PlanInfo", 1,2);
        library.createNewPlan(title,description,tags);

        String taskTile = ExcelUtility.readFromExcel("doc/maharaInfo.xlsx","TaskInfo",1,0);
        String time = ExcelUtility.readFromExcel("doc/maharaInfo.xlsx","TaskInfo",1,1);
        String reminder = ExcelUtility.readFromExcel("doc/maharaInfo.xlsx","TaskInfo",1,2);
        String taskDescription = ExcelUtility.readFromExcel("doc/maharaInfo.xlsx","TaskInfo",1,3);
        String taskTags = ExcelUtility.readFromExcel("doc/maharaInfo.xlsx","TaskInfo",1,4);
        library.addTaskToPlan(taskTile,time,reminder,taskDescription,taskTags);

        String editTitle = ExcelUtility.readFromExcel("doc/maharaInfo.xlsx","TaskInfo",2,0);
        String editDescription = ExcelUtility.readFromExcel("doc/maharaInfo.xlsx","TaskInfo",2,3);
        library.editTask(editTitle,editDescription);

        library.viewTask();

//        closeBrowser();

    }
}
