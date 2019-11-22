package com.applitools.hackathon.traditional_tests;

import com.applitools.hackathon.traditional_tests.pages.CompareExpensesPage;
import com.applitools.hackathon.traditional_tests.pages.LoginPage;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CanvasPageTraditionalTest extends TraditionalBaseTest {
    /*
        The chart's internal data is not available in the DOM.

        So, there is no way of checking whether the title is correct,
        whether data for the required years are displayed,
        whether their values are correct,
        whether correct months are displayed, etc.

        The only possible assertion to have at this point is to check whether the chart locator is present or not.
    */

    @Test
    public void shouldShowExpenseComparisionChart() {
        CompareExpensesPage compareExpensesPage = new LoginPage()
                .loginWith("someUserName", "somePassword")
                .gotoCompareExpensesPage();

        assertTrue(compareExpensesPage.isExpenseComparisonChartDisplayed());
        assertEquals("Show data for next year", compareExpensesPage.getAddYearDataText());

        compareExpensesPage.addYearData();
        assertTrue(compareExpensesPage.isExpenseComparisonChartDisplayed());
    }
}
