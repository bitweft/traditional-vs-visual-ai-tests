package com.applitools.hackathon.visual_ai_tests.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private String loginPageUrl = "https://demo.applitools.com/hackathon.html";
    private String usernameFieldLocator = "username";
    private String passwordFieldLocator = "password";
    private String loginButtonLocator = "log-in";

    public LoginPage() {
        driver.get(loginPageUrl);
    }

    public HomePage loginWith(String userName, String password) {
        driver.findElement(By.id(usernameFieldLocator)).sendKeys(userName);
        driver.findElement(By.id(passwordFieldLocator)).sendKeys(password);
        driver.findElement(By.id(loginButtonLocator)).click();
        return new HomePage();
    }
}
