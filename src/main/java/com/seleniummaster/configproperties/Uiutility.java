package com.seleniummaster.configproperties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Uiutility {

    private int timeOut=Integer.parseInt(
            ApplicationConfigDemo.readFromPropertiesFile("config.properties","timeout"));
    private WebDriver driver;

    public Uiutility(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void takeScreenShot(String fileName){
        TakesScreenshot screenshot=(TakesScreenshot)driver;
        File scrennShotFile=screenshot.getScreenshotAs(OutputType.FILE);
        File file=new File("screen-shot"+File.separator+fileName);
        try {
            FileUtils.copyFile(scrennShotFile,file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
