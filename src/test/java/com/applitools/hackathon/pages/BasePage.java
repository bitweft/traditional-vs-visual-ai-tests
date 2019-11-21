package com.applitools.hackathon.pages;

import com.applitools.hackathon.helpers.ThisRun;
import org.openqa.selenium.WebDriver;

class BasePage {
    WebDriver driver = (WebDriver) ThisRun.getInstance().get("DRIVER");
}
