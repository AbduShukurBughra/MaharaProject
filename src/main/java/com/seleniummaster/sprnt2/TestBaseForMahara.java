package com.seleniummaster.sprnt2;


import com.seleniummaster.io.ExcelUtility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class TestBaseForMahara {
    public static WebDriver driver;
    private static int timeOut = 30;
    public static String browserName= ExcelUtility.readFromExcel("doc/maharaInfo.xlsx","SettingInfo",
            1,1);;
    public static String  url= ExcelUtility.readFromExcel("doc/maharaInfo.xlsx","SettingInfo",
            1,0);;

    public static void browserSetUp(){
        if (driver == null) {
            if(browserName.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
                ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                //define chrome driver object instance
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                driver.get(url);
            }
            else if(browserName.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver","c:\\webdriver\\geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                //define chrome driver object instance
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                driver.get(url);
            }
        }
    }

    public static void  closeBrowser(){
        driver.close();
        driver.quit();
    }

    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //explicit wait  500 millisecond
    public static void waitForElementPresent(WebElement element){
        WebDriverWait webDriverWait=new WebDriverWait(driver,timeOut);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
    //fluent wait
/*    public static void fluentWait(WebElement element){
        Wait<WebDriver> wait=new FluentWait<>(driver)
                .withTimeout(5, TimeUnit.SECONDS)
                .pollingEvery(200,TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));

    }*/

    public static void takeScreenShot(String fileName){
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File screenShotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File file = new File("mahara-screenShout" + File.separator + fileName);
        try {
            FileUtils.copyFile(screenShotFile,file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
