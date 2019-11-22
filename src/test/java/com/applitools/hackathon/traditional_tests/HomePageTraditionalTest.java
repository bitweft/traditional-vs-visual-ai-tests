package com.applitools.hackathon.traditional_tests;

import com.applitools.hackathon.BaseTest;
import com.applitools.hackathon.models.TransactionAmountComparator;
import com.applitools.hackathon.models.TransactionDetail;
import com.applitools.hackathon.pages.HomePage;
import com.applitools.hackathon.pages.LoginPage;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

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

    @Test
    public void shouldDisplayAds() throws URISyntaxException {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("showAd", "true");

        HomePage homePage = new LoginPage(queryParams).loginWith("someUserName", "somePassword");

        assertTrue(homePage.isFlashSalePresentForSaleNumber(1));
        assertTrue(homePage.isFlashSalePresentForSaleNumber(2));
        assertFalse(homePage.getFlashSaleImageUrlForSaleNumber(1).isEmpty());
        assertFalse(homePage.getFlashSaleImageUrlForSaleNumber(2).isEmpty());

        /*
            If the image url is incorrect / doesn't exist, then on UI, the image will not be displayed.
            But this test will not be able to catch the issue.
         */
    }
}
