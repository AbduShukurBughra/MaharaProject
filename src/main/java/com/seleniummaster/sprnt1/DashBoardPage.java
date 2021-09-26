package com.seleniummaster.sprnt1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashBoardPage extends TestBase{
    public void clickMainMenu(){
        WebElement clickMainMenu=driver.findElement(By.xpath("//span[2]"));
        waitForElementPresent(clickMainMenu);
        clickMainMenu.click();
    }

    public void clickOnEngageLink(){
        WebElement engageLink=driver.findElement(By.xpath("//*[@id=\"nav\"]/li[4]/a"));
        waitForElementPresent(engageLink);
        engageLink.click();
    }
    public void clickOnGroupsLink(){
        WebElement groupLink=driver.findElement(By.xpath("//*[@id=\"childmenu-3\"]/li[2]/a"));
        waitForElementPresent(groupLink);
        groupLink.click();
    }
    public void clickGroupsLink(){
        WebElement groupLink=driver.findElement(By.linkText("Create group"));
        waitForElementPresent(groupLink);
        groupLink.click();
    }
    public void groupName(){
        WebElement groupName=driver.findElement(By.id("editgroup_name"));
        waitForElementPresent(groupName);
        groupName.sendKeys("United Coder-Group 1");
    }
    public void groupDescription(){
      driver.switchTo().frame(driver.findElement(By.id("editgroup_description_ifr")));
      WebElement groupDescription=driver.findElement(By.id("tinymce"));
      waitForElementPresent(groupDescription);
      groupDescription.sendKeys("This is for test");
      driver.switchTo().defaultContent();
    }
    public void friendInvitationsButton(){
        WebElement friendInvitationsButton=driver.findElement(By.xpath("//div[@id='editgroup_invitefriends_container']/div/div/label/span[4]"));
        waitForElementPresent(friendInvitationsButton);
        friendInvitationsButton.click();
    }
    public void  publiclyViewableGroupButton(){
        WebElement publiclyViewableGroupButton=driver.findElement(By.xpath("//*[@id=\"editgroup_public_container\"]/div[1]/div/label/span[4]"));
        waitForElementPresent(publiclyViewableGroupButton);
        publiclyViewableGroupButton.click();
    }
    public void  participationReportButton(){
        WebElement participationReportButton=driver.findElement(By.xpath("//*[@id=\"editgroup_groupparticipationreports_container\"]/div[1]/div/label/span[4]"));
        waitForElementPresent(participationReportButton);
        participationReportButton.click();
    }
    public void  startDate(){
        WebElement startDate=driver.findElement(By.id("editgroup_name"));
        waitForElementPresent(startDate);
        startDate.click();
    }
    public void   groupCategoryDropdownList(){
        WebElement groupDescription=driver.findElement(By.id("editgroup_name"));
        waitForElementPresent(groupDescription);
        groupDescription.sendKeys("This is for test");
    }
    public void   saveGroupButton(){
        WebElement saveGroupButton=driver.findElement(By.id("editgroup_submit"));
        waitForElementPresent(saveGroupButton);
        saveGroupButton.click();
    }
    public void verifyGroup(){
        WebElement verifyGroup=driver.findElement(By.xpath("//*[@id=\"messages\"]/div/div"));
        waitForElementPresent(verifyGroup);
        if (verifyGroup.isDisplayed()){
            System.out.println("Verify Group Is successfully");
        }else{
            System.out.println("Verify Group Is Failed");
        }


    }

}
