package com.walletservice.service;

import com.walletservice.model.Player;
import com.walletservice.model.Transaction;
import com.walletservice.model.TransactionType;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Реализация сервиса для выполнения транзакций.
 */
public class TransactionServiceImpl implements TransactionService {

    /**
     * Хранение истории транзакций для каждого игрока. Ключ - имя пользователя игрока.
     */
    private Map<String, List<Transaction>> transactionHistory = new HashMap<>();

    /**
     * Проводит дебетовую транзакцию для указанного игрока.
     *
     * @param player игрок, счет которого следует списать.
     * @param amount сумма списания.
     * @return true, если операция прошла успешно, false, если на счету игрока недостаточно средств.
     */
    @Override
    public boolean debit(Player player, double amount) {
        if (player.getBalance() < amount) {
            return false;
        }

        player.setBalance(player.getBalance() - amount);
        addTransaction(player.getUsername(), new Transaction(amount, TransactionType.DEBIT));

        return true;
    }

    /**
     * Проводит кредитовую транзакцию для указанного игрока.
     *
     * @param player игрок, на счет которого следует зачислить средства.
     * @param amount сумма зачисления.
     */
    @Override
    public void credit(Player player, double amount) {
        player.setBalance(player.getBalance() + amount);
        addTransaction(player.getUsername(), new Transaction(amount, TransactionType.CREDIT));
    }

    /**
     * Возвращает историю транзакций для указанного имени пользователя.
     *
     * @param username имя пользователя.
     * @return список транзакций для данного пользователя. Возвращает пустой список, если для пользователя нет транзакций.
     */
    @Override
    public List<Transaction> getTransactionHistory(String username) {
        return transactionHistory.getOrDefault(username, new ArrayList<>());
    }

    /**
     * Добавляет транзакцию в историю транзакций пользователя.
     *
     * @param username имя пользователя.
     * @param transaction объект транзакции, который следует добавить.
     */
    private void addTransaction(String username, Transaction transaction) {
        transactionHistory.computeIfAbsent(username, k -> new ArrayList<>()).add(transaction);
    }
}
