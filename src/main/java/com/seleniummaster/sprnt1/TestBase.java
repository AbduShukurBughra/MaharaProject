package com.seleniummaster.sprnt1;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

    public static WebDriver driver;
    static int timeOut = 20;
    public static String browserName = "chrome";
    public static String url = "http://mahara.unitedcoderschool.com/mahara/";

    public static void browserSetUp() {
        if (driver == null) {
            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                //define chrome driver object instance
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                driver.get(url);
            } else if (browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "c:\\webdriver\\geckodriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                //define chrome driver object instance
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                driver.get(url);
            }
        }
    }

    public static void closeBrowser() {
        driver.close();
        driver.quit();
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // explicit wait
    public static void waitForElementPresent(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}



