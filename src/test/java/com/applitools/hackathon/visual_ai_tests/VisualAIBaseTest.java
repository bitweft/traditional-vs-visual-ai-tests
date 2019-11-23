package com.applitools.hackathon.visual_ai_tests;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.hackathon.common.helpers.ThisRun;
import com.applitools.hackathon.visual_ai_tests.helpers.BatchSetupHelper;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.google.common.base.Strings.isNullOrEmpty;

public class VisualAIBaseTest {
    Eyes eyes;
    private WebDriver driver;
    private String appName = "HackathonApp";
    private String testName = "Smoke Test";
    private RectangleSize viewportSize = new RectangleSize(800, 800);
    private String applitools_api_key = System.getenv("APPLITOOLS_API_KEY");

    @Before
    public void setup() {
        driver = new ChromeDriver();
        ThisRun.getInstance().add("DRIVER", driver);

        if (isNullOrEmpty(applitools_api_key)) {
            throw new RuntimeException("No API Key found");
        }
        eyes = new Eyes(new ClassicRunner());
        eyes.setApiKey(applitools_api_key);
        eyes.setBatch(BatchSetupHelper.getInstance().getBatchInfo());
        eyes.open(driver, appName, testName, viewportSize);
    }
}
