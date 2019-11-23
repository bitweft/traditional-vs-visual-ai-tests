package com.applitools.hackathon.visual_ai_tests;

import com.applitools.hackathon.visual_ai_tests.pages.LoginPage;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.HashMap;

public class HomePageVisualAiTest extends VisualAIBaseTest {

    @Test
    public void shouldAllowSortingTransactionByAmount() {
        eyes.open(driver, appName, "shouldAllowSortingTransactionByAmount", viewportSize);

        new LoginPage().loginWith("someUserName", "somePassword").sortByAmount();

        eyes.setForceFullPageScreenshot(true);
        eyes.checkWindow("RecentTransactionsListPostSorting");
        eyes.closeAsync();
    }

    @Test
    public void shouldDisplayAds() throws URISyntaxException {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("showAd", "true");

        eyes.open(driver, appName, "shouldDisplayAds", viewportSize);

        new LoginPage(queryParams).loginWith("someUserName", "somePassword");

        eyes.checkWindow("Ads");
        eyes.closeAsync();
    }
}
