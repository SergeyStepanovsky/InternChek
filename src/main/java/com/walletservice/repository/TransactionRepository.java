package com.walletservice.repository;

import com.walletservice.model.Transaction;

import java.util.List;

public interface TransactionRepository {
    List<Transaction> findByUsername(String username);
    void save(Transaction transaction);
}
