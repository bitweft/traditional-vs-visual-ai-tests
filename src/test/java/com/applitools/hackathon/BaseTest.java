package com.applitools.hackathon;

import com.applitools.hackathon.helpers.ThisRun;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        ThisRun.getInstance().add("DRIVER", driver);
    }
}
