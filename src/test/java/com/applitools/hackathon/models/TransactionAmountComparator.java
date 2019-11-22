package com.applitools.hackathon.models;

import java.util.Comparator;

public class TransactionAmountComparator implements Comparator<TransactionDetail> {

    @Override
    public int compare(TransactionDetail t1, TransactionDetail t2) {
        Double firstTransactionAmount = getAmountFromString(t1.getAmount());
        Double secondTransactionAmount = getAmountFromString(t2.getAmount());
        return firstTransactionAmount.compareTo(secondTransactionAmount);

    }

    private Double getAmountFromString(String amount) {
        String regex = "\\s*,*";
        String currencySymbol = "USD";
        String sanitizedAmount = amount.replaceAll(regex, "").replaceAll(currencySymbol, "");
        return Double.parseDouble(sanitizedAmount);
    }
}
