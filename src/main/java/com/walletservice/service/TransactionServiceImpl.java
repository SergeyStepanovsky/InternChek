package com.walletservice.service;

import com.walletservice.model.Player;
import com.walletservice.model.Transaction;
import com.walletservice.model.TransactionType;
import com.walletservice.service.TransactionService;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionServiceImpl implements TransactionService {
    // Это просто пример, в реальной реализации вы бы использовали репозиторий транзакций или другое хранилище данных
    private Map<String, List<Transaction>> transactionHistory = new HashMap<>();

    @Override
    public boolean debit(Player player, double amount) {
        if (player.getBalance() < amount) {
            return false;
        }

        player.setBalance(player.getBalance() - amount);
        addTransaction(player.getUsername(), new Transaction(amount, TransactionType.DEBIT));

        return true;
    }

    @Override
    public void credit(Player player, double amount) {
        player.setBalance(player.getBalance() + amount);
        addTransaction(player.getUsername(), new Transaction(amount, TransactionType.CREDIT));

    }

    @Override
    public List<Transaction> getTransactionHistory(String username) {
        return transactionHistory.getOrDefault(username, new ArrayList<>());
    }

    private void addTransaction(String username, Transaction transaction) {
        transactionHistory.computeIfAbsent(username, k -> new ArrayList<>()).add(transaction);
    }
}
