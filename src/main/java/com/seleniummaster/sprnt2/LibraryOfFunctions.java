package com.seleniummaster.sprnt2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LibraryOfFunctions extends TestBaseForMahara{
    public void login(String username, String password){
        WebElement userNameElement= driver.findElement(By.id("login_login_username"));
        waitForElementPresent(userNameElement);
        userNameElement.sendKeys(username);
        WebElement passwordElement=driver.findElement(By.id("login_login_password"));
        waitForElementPresent(passwordElement);
        passwordElement.sendKeys(password);
        WebElement loginElement=driver.findElement(By.id("login_submit"));
        waitForElementPresent(loginElement);
        loginElement.click();

    }

    public boolean createNewPlan(String title,String description,String tags){
        WebElement mainMenuElement = driver.findElement(By.xpath("//span[@class=\"icon icon-bars icon-lg\"]"));
        waitForElementPresent(mainMenuElement);
        mainMenuElement.click();

        WebElement createMenuDownLink = driver.findElement(By.xpath("//a[@class=\"create menu-dropdown-toggle\"]"));
        waitForElementPresent(createMenuDownLink);
        createMenuDownLink.click();

        WebElement plansLinkElement = driver.findElement(By.xpath("//*[@id=\"childmenu-1\"]/li[5]/*"));
        waitForElementPresent(plansLinkElement);
        plansLinkElement.click();

        WebElement newPlanLink = driver.findElement(By.xpath("//a[@class=\"btn btn-secondary\"]"));
        waitForElementPresent(newPlanLink);
        newPlanLink.click();

        WebElement titleName = driver.findElement(By.id("addplan_title"));
        waitForElementPresent(titleName);
        titleName.sendKeys(title);

        WebElement descriptionElement = driver.findElement(By.id("addplan_description"));
        waitForElementPresent(descriptionElement);
        descriptionElement.sendKeys(description);
        driver.switchTo().defaultContent();

        TestBaseForMahara.sleep(3);
        WebElement templateButton = driver.findElement(By.xpath("//span[@class=\"state-label off\"]"));
        waitForElementPresent(templateButton);
        templateButton.click();
        driver.switchTo().defaultContent();

        WebElement tagElement = driver.findElement(By.xpath("//input[@class=\"select2-search__field\"]"));
        waitForElementPresent(tagElement);
        tagElement.sendKeys(tags);

        WebElement savePlanButton = driver.findElement(By.id("addplan_submit"));
        waitForElementPresent(savePlanButton);
        savePlanButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class=\"alert alert-success\"]/div"));
        waitForElementPresent(successMessage);
        if (successMessage.isDisplayed()){
            TestBaseForMahara.takeScreenShot("createNewPlan.png");
            System.out.println("Plan saved successfully");
            return true;
        }else {
            System.out.println("Plan saved failed");
            return false;
        }
    }

    public boolean addTaskToPlan(String taskTitle,String time,String reminder,String taskDescription,String taskTags){
   /*     WebElement manageTaskElement = driver.findElement(By.xpath("//span[@class=\"icon icon-lg icon-cog\"]"));
        waitForElementPresent(manageTaskElement);
        manageTaskElement.click();
*/
        WebElement newTaskLink = driver.findElement(By.xpath("//a[@class=\"btn btn-secondary settings\"]"));
        waitForElementPresent(newTaskLink);
        newTaskLink.click();

        WebElement taskTitleElement = driver.findElement(By.id("edittask_title"));
        waitForElementPresent(taskTitleElement);
        taskTitleElement.sendKeys(taskTitle);

        WebElement timeElement = driver.findElement(By.id("edittask_reminder_units"));
        waitForElementPresent(timeElement);
        Select selectTime = new Select(timeElement);
        selectTime.selectByVisibleText(time);

        WebElement taskReminder = driver.findElement(By.id("edittask_reminder"));
        waitForElementPresent(taskReminder);
        taskReminder.sendKeys(reminder);

        WebElement taskDescriptionElement = driver.findElement(By.id("edittask_description"));
        waitForElementPresent(taskDescriptionElement);
        taskDescriptionElement.sendKeys(taskDescription);

        WebElement taskTagsElement = driver.findElement(By.xpath("//input[@class=\"select2-search__field\"]"));
        waitForElementPresent(taskTagsElement);
        taskTagsElement.sendKeys(taskTags);

        WebElement saveButton = driver.findElement(By.id("edittask_submit"));
        waitForElementPresent(saveButton);
        saveButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class=\"alert alert-success\"]/div"));
        waitForElementPresent(successMessage);
        if (successMessage.isDisplayed()){
            TestBaseForMahara.takeScreenShot("addTaskToPlan.png");
            System.out.println("Task saved successfully.");
            return true;
        }else {
            System.out.println("Task saved failed.");
            return false;
        }

    }

    public boolean editTask(String taskTitle, String taskDescription){
        WebElement editTaskButton = driver.findElement(By.xpath("//span[@class=\"icon icon-pencil-alt icon-lg\"]"));
        waitForElementPresent(editTaskButton);
        editTaskButton.click();

        WebElement taskTitleInput = driver.findElement(By.id("edittask_title"));
        waitForElementPresent(taskTitleInput);
        taskTitleInput.clear();
        taskTitleInput.sendKeys(taskTitle);

        WebElement taskDescriptionInput = driver.findElement(By.id("edittask_description"));
        waitForElementPresent(taskDescriptionInput);
        taskDescriptionInput.clear();
        taskDescriptionInput.sendKeys(taskDescription);

        WebElement saveButton = driver.findElement(By.id("edittask_submit"));
        waitForElementPresent(saveButton);
        saveButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class=\"alert alert-success\"]/div"));
        waitForElementPresent(successMessage);
        if (successMessage.isDisplayed()){
            TestBaseForMahara.takeScreenShot("editTask.png");
            System.out.println("Edit task successfully.");
            return true;
        }else {
            System.out.println("Edit task failed.");
            return false;
        }



    }

    public boolean viewTask(){
        WebElement mainMenuElement = driver.findElement(By.xpath("//span[@class=\"icon icon-bars icon-lg\"]"));
        waitForElementPresent(mainMenuElement);
        mainMenuElement.click();

        WebElement createMenuDownLink = driver.findElement(By.xpath("//a[@class=\"create menu-dropdown-toggle\"]"));
        waitForElementPresent(createMenuDownLink);
        createMenuDownLink.click();

        WebElement plansLinkElement = driver.findElement(By.xpath("//*[@id=\"childmenu-1\"]/li[5]/*"));
        waitForElementPresent(plansLinkElement);
        plansLinkElement.click();

        WebElement manageTasksButton = driver.findElement(By.xpath("//span[@class=\"icon icon-lg icon-cog\"]"));
        waitForElementPresent(manageTasksButton);
        manageTasksButton.click();

        WebElement taskViewMessage = driver.findElement(By.xpath("//span[@class=\"section-heading\"]"));
        waitForElementPresent(taskViewMessage);
        if (taskViewMessage.isDisplayed()){
            TestBaseForMahara.takeScreenShot("viewTasks.png");
            System.out.println("Tasks View Successfully");
            return true;
        }else {
            System.out.println("Tasks View Failed");
            return false;
        }
    }
}
