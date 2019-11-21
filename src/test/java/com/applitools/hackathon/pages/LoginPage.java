package com.applitools.hackathon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class LoginPage extends BasePage {
    private String labelsLocator = "form-group";
    private String placeHolderAttribute = "placeholder";
    private String loginButtonLocator = "log-in";
    private String loginFormTitleLocator = "auth-header";
    private String userNameIconLocator = "os-icon-user-male-circle";
    private String passwordIconLocator = "os-icon-fingerprint";
    private String usernameFieldLocator = "username";
    private String passwordFieldLocator = "password";
    private String checkboxLabelLocator = "form-check-label";
    private String checkboxInputLocator = "form-check-input";
    private String socialIconsLocator = "//div[@class='buttons-w']//img";
    private String logoLocator = "//div[@class='logo-w']//img";
    private String srcAttribute = "src";
    private String loginErrorMessageLocator = "alert-warning";

    public String getFormTitle() {
        return driver.findElement(By.className(loginFormTitleLocator)).getText();
    }

    public String getUserNameFieldLabel() {
        return driver.findElements(By.className(labelsLocator)).get(0).getText();
    }

    public String getPasswordFieldLabel() {
        return driver.findElements(By.className(labelsLocator)).get(1).getText();
    }

    public boolean isUserNameIconDisplayed() {
        return driver.findElement(By.className(userNameIconLocator)).isDisplayed();
    }

    public boolean isPasswordIconDisplayed() {
        return driver.findElement(By.className(passwordIconLocator)).isDisplayed();
    }

    public String getUserNamePlaceholderText() {
        return driver.findElement(By.id(usernameFieldLocator)).getAttribute(placeHolderAttribute);
    }

    public String getPasswordPlaceholderText() {
        return driver.findElement(By.id(passwordFieldLocator)).getAttribute(placeHolderAttribute);
    }

    public String getLoginButtonText() {
        return driver.findElement(By.id(loginButtonLocator)).getText();
    }

    public String getRememberMeCheckboxLabel() {
        return driver.findElement(By.className(checkboxLabelLocator)).getText();
    }

    public boolean isCheckboxDisplayed() {
        return driver.findElement(By.className(checkboxInputLocator)).isDisplayed();
    }

    public List<String> getSocialIconImageSource() {
        List<WebElement> socialIcons = driver.findElements(By.xpath(socialIconsLocator));
        return socialIcons
                .stream()
                .map(socialIcon -> socialIcon.getAttribute(srcAttribute))
                .collect(Collectors.toList());
    }

    public String getLogoImageSource() {
        return driver.findElement(By.xpath(logoLocator)).getAttribute(srcAttribute);
    }

    public HomePage loginWith(String userName, String password) {
        driver.findElement(By.id(usernameFieldLocator)).sendKeys(userName);
        driver.findElement(By.id(passwordFieldLocator)).sendKeys(password);
        driver.findElement(By.id(loginButtonLocator)).click();
        return new HomePage();
    }

    public String getLoginErrorMessage() {
        return driver.findElement(By.className(loginErrorMessageLocator)).getText();
    }
}
