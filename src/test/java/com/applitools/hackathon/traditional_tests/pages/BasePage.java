package com.applitools.hackathon.traditional_tests.pages;

import com.applitools.hackathon.common.helpers.ThisRun;
import org.openqa.selenium.WebDriver;

class BasePage {
    WebDriver driver = (WebDriver) ThisRun.getInstance().get("DRIVER");
}
