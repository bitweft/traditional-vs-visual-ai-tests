package com.applitools.hackathon;

import com.applitools.hackathon.pages.HomePage;
import com.applitools.hackathon.pages.LoginPage;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(DataProviderRunner.class)
public class TraditionalTests extends BaseTest {

    @Before
    public void launchLoginPage() {
        driver.get("https://demo.applitools.com/hackathon.html");
    }

    @Test
    public void shouldDisplayLoginPageInformationCorrectly() {

        LoginPage loginPage = new LoginPage();

        assertTrue(loginPage.getLogoImageSource().contains("img/logo-big.png"));

        assertEquals("Login Form", loginPage.getFormTitle());

        assertTrue(loginPage.isUserNameIconDisplayed());
        assertEquals("Username", loginPage.getUserNameFieldLabel());
        assertEquals("Enter your username", loginPage.getUserNamePlaceholderText());

        assertTrue(loginPage.isPasswordIconDisplayed());
        assertEquals("Password", loginPage.getPasswordFieldLabel());
        assertEquals("Enter your password", loginPage.getPasswordPlaceholderText());

        assertEquals("Log In", loginPage.getLoginButtonText());
        assertEquals("Remember Me", loginPage.getRememberMeCheckboxLabel());
        assertTrue(loginPage.isCheckboxDisplayed());

        verifySocialIcons(loginPage);
    }

    @Test
    @UseDataProvider("testDataForErrors")
    public void shouldShowErrorMessageWhenUserNameOrPasswordInvalid(String userName, String password, String errorMessage) {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWith(userName, password);

        assertEquals(errorMessage, loginPage.getLoginErrorMessage());
    }

    @Test
    public void shouldLoginToAppWhenCredentialsAreCorrect() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.loginWith("someUserName", "somePassword");

        assertEquals("https://demo.applitools.com/hackathonApp.html", driver.getCurrentUrl());
        assertEquals("Jack Gomez", homePage.getLoggedInUserName());
    }


    private void verifySocialIcons(LoginPage loginPage) {
        List<String> expectedSocialIconImageSources =
                Arrays.asList("img/social-icons/twitter.png", "img/social-icons/facebook.png", "img/social-icons/linkedin.png");

        List<String> actualSocialIconImageSources = loginPage.getSocialIconImageSource();

        assertEquals(expectedSocialIconImageSources.size(), actualSocialIconImageSources.size());
        for (int i = 0; i < expectedSocialIconImageSources.size(); i++) {
            assertTrue(actualSocialIconImageSources.get(i).contains(expectedSocialIconImageSources.get(i)));
        }
    }

    @DataProvider()
    public static Object[][] testDataForErrors() {
        return new Object[][]{
                {"", "", "Both Username and Password must be present"},
                {"someUserName", "", "Password must be present"},
                {"", "somePassword", "Username must be present"}
        };
    }

}
