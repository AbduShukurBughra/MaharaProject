package com.seleniummaster.configproperties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class CubeCartConfigTestDemo {
    static String configFile="config.properties";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //define chrome driver object instance
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(ApplicationConfigDemo.readFromPropertiesFile(configFile,"qaurl"));
        Uiutility uiutility=new Uiutility(driver);
        WebElement userNameElement= driver.findElement(By.name("username"));
        uiutility.waitForElementPresent(userNameElement);
        userNameElement.sendKeys(ApplicationConfigDemo.readFromPropertiesFile(configFile,"username"));
        WebElement passwordElement=driver.findElement(By.id("password"));
        uiutility.waitForElementPresent(passwordElement);
        passwordElement.sendKeys(ApplicationConfigDemo.readFromPropertiesFile(configFile,"password"));
        WebElement loginElement=driver.findElement(By.id("login"));
        loginElement.click();
        WebElement logoutIcon=driver.findElement(By.cssSelector("i.fa.fa-sign-out"));
        uiutility.waitForElementPresent(logoutIcon);
        StringBuilder result=new StringBuilder();
        if(logoutIcon.isDisplayed()){
            result.append("Logout button displayed,CubeCart Login Successfully");
            uiutility.takeScreenShot("loginSuccess.png");
        }
        File file=new File("Test-Result"+File.separator+"CubeCart-Login-Test"+System.currentTimeMillis()+".txt");
        try {
            FileUtils.writeStringToFile(file,result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.close();
        driver.quit();
    }
}
