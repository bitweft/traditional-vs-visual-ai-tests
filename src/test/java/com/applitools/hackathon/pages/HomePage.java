package com.applitools.hackathon.pages;

import com.applitools.hackathon.models.TransactionDetail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends BasePage {
    private String loggedInUserNameLocator = "logged-user-name";
    private String amountColumnLocator = "amount";
    private String recentTransactionRowLocator = "//table[@id='transactionsTable']/tbody/tr";
    private String dataTag = "td";
    private String imageTag = "img";
    private String srcAttribute = "src";

    public String getLoggedInUserName() {
        return driver.findElement(By.id(loggedInUserNameLocator)).getText();
    }

    public void sortByAmount() {
        driver.findElement(By.id(amountColumnLocator)).click();
    }

    public List<TransactionDetail> getRecentTransactionDetails() {
        List<WebElement> rows = driver.findElements(By.xpath(recentTransactionRowLocator));
        return rows.stream().map(row -> {
            List<WebElement> rowValues = row.findElements(By.tagName(dataTag));
            String status = rowValues.get(0).getText();
            String date = rowValues.get(1).getText();
            String icon = rowValues.get(2).findElement(By.tagName(imageTag)).getAttribute(srcAttribute);
            String description = rowValues.get(2).getText();
            String category = rowValues.get(3).getText();
            String amount = rowValues.get(4).getText();
            return new TransactionDetail(status, date, icon, description, category, amount);
        }).collect(Collectors.toList());
    }
}