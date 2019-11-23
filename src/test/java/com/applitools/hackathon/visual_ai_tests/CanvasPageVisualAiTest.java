package com.applitools.hackathon.visual_ai_tests;

import com.applitools.hackathon.visual_ai_tests.pages.CompareExpensesPage;
import com.applitools.hackathon.visual_ai_tests.pages.LoginPage;
import org.junit.Test;

public class CanvasPageVisualAiTest extends VisualAIBaseTest {

    @Test
    public void shouldShowExpenseComparisionChart() {
        CompareExpensesPage compareExpensesPage = new LoginPage()
                .loginWith("someUserName", "somePassword")
                .gotoCompareExpensesPage();

        eyes.checkWindow("InitialCompareExpenseChart");

        compareExpensesPage.addYearData();

        eyes.checkWindow("CompareExpenseChartAfterAddingYear");
    }
}
