package com.applitools.hackathon.models;

public class TransactionDetail {
    private String status;
    private String dateTime;
    private String icon;
    private String description;
    private String category;
    private String amount;

    public TransactionDetail(String status, String dateTime, String icon, String description, String category, String amount) {
        this.status = status;
        this.dateTime = dateTime;
        this.icon = icon;
        this.description = description;
        this.category = category;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TransactionDetail)) {
            return false;
        }
        TransactionDetail transactionDetail = (TransactionDetail) o;
        return status.equals(transactionDetail.status) &&
                dateTime.equals(transactionDetail.dateTime) &&
                icon.equals(transactionDetail.icon) &&
                description.equals(transactionDetail.description) &&
                category.equals(transactionDetail.category) &&
                amount.equals(transactionDetail.amount);
    }

    public String getAmount() {
        return amount;
    }
}
