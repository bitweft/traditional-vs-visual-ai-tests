package com.applitools.hackathon.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    String loggedInUserNameLocator = "logged-user-name";

    public String getLoggedInUserName() {
        return driver.findElement(By.id(loggedInUserNameLocator)).getText();
    }
}
