package com.applitools.hackathon.visual_ai_tests.pages;

import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.By;

import java.net.URISyntaxException;
import java.util.Map;

public class LoginPage extends BasePage {
    private String loginPageUrl = "https://demo.applitools.com/hackathon.html";
    private String usernameFieldLocator = "username";
    private String passwordFieldLocator = "password";
    private String loginButtonLocator = "log-in";

    public LoginPage() {
        driver.get(loginPageUrl);
    }

    public LoginPage(Map<String, String> queryParams) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(loginPageUrl);
        for (Map.Entry<String, String> queryParam : queryParams.entrySet()) {
            uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
        }
        driver.get(uriBuilder.toString());
    }

    public HomePage loginWith(String userName, String password) {
        driver.findElement(By.id(usernameFieldLocator)).sendKeys(userName);
        driver.findElement(By.id(passwordFieldLocator)).sendKeys(password);
        driver.findElement(By.id(loginButtonLocator)).click();
        return new HomePage();
    }
}
