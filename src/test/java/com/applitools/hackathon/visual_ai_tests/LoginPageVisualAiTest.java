package com.applitools.hackathon.visual_ai_tests;

import com.applitools.hackathon.visual_ai_tests.pages.LoginPage;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@RunWith(DataProviderRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginPageVisualAiTest extends VisualAIBaseTest {

    @Test
    public void shouldDisplayLoginPageInformationCorrectly() {
        eyes.open(driver, appName, "shouldDisplayLoginPageInformationCorrectly", viewportSize);

        new LoginPage();

        eyes.checkWindow("LoginPage");
        eyes.closeAsync();
    }

    @Test
    @UseDataProvider("testDataForErrors")
    public void shouldShowErrorMessageWhenUserNameOrPasswordInvalid(String userName, String password, String testName) {
        eyes.open(driver, appName, "shouldShowErrorMessageWhen" + testName, viewportSize);

        new LoginPage().loginWith(userName, password);

        eyes.checkWindow("LoginPageErrorMessageWhen" + testName);
        eyes.closeAsync();
    }

    @Test
    public void shouldLoginToAppWhenCredentialsAreCorrect() {
        eyes.open(driver, appName, "shouldLoginToAppWhenCredentialsAreCorrect", viewportSize);

        new LoginPage().loginWith("someUserName", "somePassword");

        eyes.setForceFullPageScreenshot(true);
        eyes.checkWindow("LoginSuccess");
        eyes.closeAsync();
    }

    @DataProvider()
    public static Object[][] testDataForErrors() {
        return new Object[][]{
                {"", "", "NoData"},
                {"someUserName", "", "NoPassword"},
                {"", "somePassword", "NoUserName"}
        };
    }
}
