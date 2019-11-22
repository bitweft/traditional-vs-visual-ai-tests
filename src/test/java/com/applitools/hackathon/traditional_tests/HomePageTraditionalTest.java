package com.applitools.hackathon.traditional_tests;

import com.applitools.hackathon.BaseTest;
import com.applitools.hackathon.models.TransactionAmountComparator;
import com.applitools.hackathon.models.TransactionDetail;
import com.applitools.hackathon.pages.HomePage;
import com.applitools.hackathon.pages.LoginPage;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HomePageTraditionalTest extends BaseTest {

    @Test
    public void shouldAllowSortingTransactionByAmount() {
        HomePage homePage = new LoginPage().loginWith("someUserName", "somePassword");

        List<TransactionDetail> initialTransactionDetails = homePage.getRecentTransactionDetails();
        initialTransactionDetails.sort(new TransactionAmountComparator());

        homePage.sortByAmount();
        List<TransactionDetail> transactionDetailsAfterSorting = homePage.getRecentTransactionDetails();

        assertEquals(initialTransactionDetails, transactionDetailsAfterSorting);
    }
}
