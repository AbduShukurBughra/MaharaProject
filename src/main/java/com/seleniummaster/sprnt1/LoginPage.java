package com.seleniummaster.sprnt1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends TestBase{
    public void login(LoginUser loginUser){
        WebElement userNameElement = driver.findElement(By.id("login_login_username"));
        waitForElementPresent(userNameElement);
        userNameElement.sendKeys(loginUser.getUserName());
        WebElement passwordElement = driver.findElement(By.id("login_login_password"));
        waitForElementPresent(passwordElement);
        passwordElement.sendKeys(loginUser.getPassword());
        WebElement loginElement = driver.findElement(By.id("login_submit"));
        waitForElementPresent(loginElement);
        loginElement.click();

    }

}
