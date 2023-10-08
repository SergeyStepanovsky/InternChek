package com.walletservice.model;

public enum TransactionType {
    CREDIT("Credit Transaction", "Adding funds to the account"),
    DEBIT("Debit Transaction", "Removing funds from the account");

    private final String displayName;
    private final String description;

    TransactionType(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return displayName + ": " + description;
    }
}
