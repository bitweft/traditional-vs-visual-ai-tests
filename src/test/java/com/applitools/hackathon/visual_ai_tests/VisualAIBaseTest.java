package com.applitools.hackathon.visual_ai_tests;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.StitchMode;
import com.applitools.hackathon.common.helpers.ThisRun;
import com.applitools.hackathon.visual_ai_tests.helpers.BatchSetupHelper;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.google.common.base.Strings.isNullOrEmpty;

public class VisualAIBaseTest {
    Eyes eyes;
    WebDriver driver;
    String appName = "HackathonApp";
    RectangleSize viewportSize = new RectangleSize(800, 800);
    private String applitools_api_key = System.getenv("APPLITOOLS_API_KEY");
    private ClassicRunner runner;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        ThisRun.getInstance().add("DRIVER", driver);

        if (isNullOrEmpty(applitools_api_key)) {
            throw new RuntimeException("No API Key found");
        }

        runner = new ClassicRunner();
        eyes = new Eyes(runner);
        eyes.setApiKey(applitools_api_key);
        eyes.setSaveNewTests(true);
        eyes.setStitchMode(StitchMode.CSS);
        eyes.setBatch(BatchSetupHelper.getInstance().getBatchInfo());
    }

    @After
    public void tearDown() {
        driver.quit();
        eyes.abortIfNotClosed();
    }
}
