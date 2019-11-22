package com.applitools.hackathon.traditional_tests;

import com.applitools.hackathon.traditional_tests.models.TransactionAmountComparator;
import com.applitools.hackathon.traditional_tests.models.TransactionDetail;
import com.applitools.hackathon.traditional_tests.pages.HomePage;
import com.applitools.hackathon.traditional_tests.pages.LoginPage;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class HomePageTraditionalTest extends TraditionalBaseTest {
    /*
        If the image urls are incorrect / don't exist, then on UI, the image will not be displayed.
        But these tests will not be able to catch the issue.
    */

    @Test
    public void shouldAllowSortingTransactionByAmount() {
        HomePage homePage = new LoginPage().loginWith("someUserName", "somePassword");

        List<TransactionDetail> initialTransactionDetails = homePage.getRecentTransactionDetails();
        initialTransactionDetails.sort(new TransactionAmountComparator());

        homePage.sortByAmount();
        List<TransactionDetail> transactionDetailsAfterSorting = homePage.getRecentTransactionDetails();

        assertEquals(initialTransactionDetails, transactionDetailsAfterSorting);
    }

    @Test
    public void shouldDisplayAds() throws URISyntaxException {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("showAd", "true");

        HomePage homePage = new LoginPage(queryParams).loginWith("someUserName", "somePassword");

        assertTrue(homePage.isFlashSalePresentForSaleNumber(1));
        assertTrue(homePage.isFlashSalePresentForSaleNumber(2));
        assertFalse(homePage.getFlashSaleImageUrlForSaleNumber(1).isEmpty());
        assertFalse(homePage.getFlashSaleImageUrlForSaleNumber(2).isEmpty());
    }
}
