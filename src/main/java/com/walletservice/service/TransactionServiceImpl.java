package com.walletservice.service;

import com.walletservice.model.Player;
import com.walletservice.model.Transaction;
import com.walletservice.model.TransactionType;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ���������� ������� ��� ���������� ����������.
 */
public class TransactionServiceImpl implements TransactionService {

    /**
     * �������� ������� ���������� ��� ������� ������. ���� - ��� ������������ ������.
     */
    private Map<String, List<Transaction>> transactionHistory = new HashMap<>();

    /**
     * �������� ��������� ���������� ��� ���������� ������.
     *
     * @param player �����, ���� �������� ������� �������.
     * @param amount ����� ��������.
     * @return true, ���� �������� ������ �������, false, ���� �� ����� ������ ������������ �������.
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
     * �������� ���������� ���������� ��� ���������� ������.
     *
     * @param player �����, �� ���� �������� ������� ��������� ��������.
     * @param amount ����� ����������.
     */
    @Override
    public void credit(Player player, double amount) {
        player.setBalance(player.getBalance() + amount);
        addTransaction(player.getUsername(), new Transaction(amount, TransactionType.CREDIT));
    }

    /**
     * ���������� ������� ���������� ��� ���������� ����� ������������.
     *
     * @param username ��� ������������.
     * @return ������ ���������� ��� ������� ������������. ���������� ������ ������, ���� ��� ������������ ��� ����������.
     */
    @Override
    public List<Transaction> getTransactionHistory(String username) {
        return transactionHistory.getOrDefault(username, new ArrayList<>());
    }

    /**
     * ��������� ���������� � ������� ���������� ������������.
     *
     * @param username ��� ������������.
     * @param transaction ������ ����������, ������� ������� ��������.
     */
    private void addTransaction(String username, Transaction transaction) {
        transactionHistory.computeIfAbsent(username, k -> new ArrayList<>()).add(transaction);
    }
}
