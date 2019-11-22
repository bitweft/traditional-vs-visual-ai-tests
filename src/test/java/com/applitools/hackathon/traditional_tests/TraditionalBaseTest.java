package com.applitools.hackathon.traditional_tests;

import com.applitools.hackathon.common.helpers.ThisRun;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TraditionalBaseTest {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        ThisRun.getInstance().add("DRIVER", driver);
    }
}
