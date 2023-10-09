package com.walletservice.service;

import com.walletservice.model.Player;
import com.walletservice.model.Transaction;
import com.walletservice.model.TransactionType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ������, ��������������� ������ ��� ���������� �������� � �� ������������.
 */
public class PlayerService {

    /** �������, �������� ���� ������������������ ������� �� �� ������ ������������. */
    private Map<String, Player> players = new HashMap<>();

    /** �������, �������� ������� ���������� ������� ������ �� �� ������ ������������. */
    private Map<String, List<Transaction>> playerTransactions = new HashMap<>();

    /**
     * ������������ ������ ������ � �������.
     *
     * @param username ��� ������������ ��� �����������.
     * @param password ������ ������������ ��� �����������.
     * @return true ���� ����������� �������, false ���� ��� ������������ ��� ����������.
     */
    public boolean register(String username, String password) {
        if (players.containsKey(username)) {
            return false;
        }
        players.put(username, new Player(username, password));
        playerTransactions.put(username, new ArrayList<>());
        return true;
    }

    /**
     * ��������� ������� ������ � ���������� ������ ������ ��� �������� ��������������.
     *
     * @param username ��� ������������ ��� �����.
     * @param password ������ ������������ ��� �����.
     * @return ������ Player ��� �������� �����, null ��� �������.
     */
    public Player login(String username, String password) {
        Player player = players.get(username);
        if (player != null && player.getPassword().equals(password)) {
            return player;
        }
        return null;
    }

    /**
     * ���������� ������ ������ �� ��� ����� ������������.
     *
     * @param username ��� ������������.
     * @return ������� ������ ������ ��� -1, ���� ����� �� ������.
     */
    public double getBalance(String username) {
        Player player = players.get(username);
        return (player != null) ? player.getBalance() : -1;
    }

    /**
     * ��������� ����� �� ��������� ����� � ������� ������.
     *
     * @param player �����, ������� ����� ������������ � �������� ������.
     * @param amount ����� ��� ������.
     * @return true ���� �������� ������� ���������, false ���� ������������ �������.
     */
    public boolean debit(Player player, double amount) {
        if (player.getBalance() >= amount) {
            player.setBalance(player.getBalance() - amount);
            playerTransactions.get(player.getUsername()).add(new Transaction(amount, TransactionType.DEBIT));
            return true;
        }
        return false;
    }

    /**
     * ��������� ������ �� ��������� ����� �� ������ ������.
     *
     * @param player �����, ������� ����� ������������ � �������� �������.
     * @param amount ����� ��� �������.
     */
    public void credit(Player player, double amount) {
        player.setBalance(player.getBalance() + amount);
        playerTransactions.get(player.getUsername()).add(new Transaction(amount, TransactionType.CREDIT));
    }

    /**
     * ���������� ������� ���������� ��� ���������� ������.
     *
     * @param username ��� ������������.
     * @return ������ ���������� ��� ������ ������, ���� ��� ������� ������������ ��� ����������.
     */
    public List<Transaction> getTransactionHistory(String username) {
        return playerTransactions.getOrDefault(username, new ArrayList<>());
    }
}
