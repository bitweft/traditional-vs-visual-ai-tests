package com.applitools.hackathon.visual_ai_tests.pages;

import org.openqa.selenium.By;

public class CompareExpensesPage extends BasePage {
    private String addYearDataLocator = "addDataset";

    public void addYearData() {
        driver.findElement(By.id(addYearDataLocator)).click();
    }
}
