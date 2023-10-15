package com.walletservice.service;

import com.walletservice.model.Player;
import com.walletservice.model.Transaction;
import com.walletservice.repository.TransactionRepository;
import java.util.List;

public interface TransactionService {

    boolean debit(Player player, double amount);

    void credit(Player player, double amount);

    List<Transaction> getTransactionHistory(String username);
}
