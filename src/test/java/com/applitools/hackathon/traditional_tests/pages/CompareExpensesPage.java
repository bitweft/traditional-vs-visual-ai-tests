package com.applitools.hackathon.traditional_tests.pages;

import org.openqa.selenium.By;

public class CompareExpensesPage extends BasePage {
    private String chartLocator = "canvas";
    private String addYearDataLocator = "addDataset";

    public boolean isExpenseComparisonChartDisplayed() {
        return driver.findElement(By.id(chartLocator)).isDisplayed();
    }

    public void addYearData() {
        driver.findElement(By.id(addYearDataLocator)).click();
    }

    public String getAddYearDataText() {
        return driver.findElement(By.id(addYearDataLocator)).getText();
    }
}
