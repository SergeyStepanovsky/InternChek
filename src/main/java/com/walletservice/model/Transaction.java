package com.walletservice.model;

import java.util.UUID;

public class Transaction {
    private final UUID transactionId;
    private final double amount;
    private final TransactionType type;

    public Transaction(double amount, TransactionType type) {
        this.transactionId = UUID.randomUUID();
        this.amount = amount;
        this.type = type;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }
}

