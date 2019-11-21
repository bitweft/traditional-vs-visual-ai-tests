package com.applitools.hackathon;

import com.applitools.hackathon.pages.LoginPage;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TraditionalTests extends BaseTest {


    @Test
    public void shouldDisplayLoginPageInformationCorrectly() {
        driver.get("https://demo.applitools.com/hackathon.html");
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

    private void verifySocialIcons(LoginPage loginPage) {
        List<String> expectedSocialIconImageSources =
                Arrays.asList("img/social-icons/twitter.png", "img/social-icons/facebook.png", "img/social-icons/linkedin.png");

        List<String> actualSocialIconImageSources = loginPage.getSocialIconImageSource();

        assertEquals(expectedSocialIconImageSources.size(), actualSocialIconImageSources.size());
        for (int i = 0; i < expectedSocialIconImageSources.size(); i++) {
            assertTrue(actualSocialIconImageSources.get(i).contains(expectedSocialIconImageSources.get(i)));
        }
    }
}
