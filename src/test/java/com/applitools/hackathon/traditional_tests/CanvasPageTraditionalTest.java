package com.applitools.hackathon.traditional_tests;

import com.applitools.hackathon.BaseTest;
import com.applitools.hackathon.pages.CompareExpensesPage;
import com.applitools.hackathon.pages.LoginPage;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CanvasPageTraditionalTest extends BaseTest {
    CompareExpensesPage compareExpensesPage;

    @Before
    public void setup() {
        super.setup();
        driver.get("https://demo.applitools.com/hackathon.html");
        compareExpensesPage = new LoginPage()
                .loginWith("someUserName", "somePassword")
                .gotoCompareExpensesPage();
    }

    @Test
    public void shouldShowExpenseComparisionChart() {
        assertTrue(compareExpensesPage.isExpenseComparisonChartDisplayed());
        assertEquals("Show data for next year", compareExpensesPage.getAddYearDataText());

        compareExpensesPage.addYearData();
        assertTrue(compareExpensesPage.isExpenseComparisonChartDisplayed());
/*
        The chart's internal data is not available in the DOM.

        So, there is no way of checking whether the title is correct,
        whether data for the required years are displayed,
        whether their values are correct,
        whether correct months are displayed, etc.

        The only possible assertion to have at this point is to check whether the chart locator is present or not.
 */
    }
}
