package com.applitools.hackathon.visual_ai_tests.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private String amountColumnLocator = "amount";
    private String compareExpensePageLocator = "showExpensesChart";

    public void sortByAmount() {
        driver.findElement(By.id(amountColumnLocator)).click();
    }

    public com.applitools.hackathon.visual_ai_tests.pages.CompareExpensesPage gotoCompareExpensesPage() {
        driver.findElement(By.id(compareExpensePageLocator)).click();
        return new CompareExpensesPage();
    }
}
