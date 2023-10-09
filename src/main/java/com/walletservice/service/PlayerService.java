package com.walletservice.service;

import com.walletservice.model.Player;
import com.walletservice.model.Transaction;
import com.walletservice.model.TransactionType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Сервис, предоставляющий методы для управления игроками и их транзакциями.
 */
public class PlayerService {

    /** Словарь, хранящий всех зарегистрированных игроков по их именам пользователя. */
    private Map<String, Player> players = new HashMap<>();

    /** Словарь, хранящий историю транзакций каждого игрока по их именам пользователя. */
    private Map<String, List<Transaction>> playerTransactions = new HashMap<>();

    /**
     * Регистрирует нового игрока в системе.
     *
     * @param username имя пользователя для регистрации.
     * @param password пароль пользователя для регистрации.
     * @return true если регистрация успешна, false если имя пользователя уже существует.
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
     * Проверяет учетные данные и возвращает объект игрока при успешной аутентификации.
     *
     * @param username имя пользователя для входа.
     * @param password пароль пользователя для входа.
     * @return объект Player при успешном входе, null при неудаче.
     */
    public Player login(String username, String password) {
        Player player = players.get(username);
        if (player != null && player.getPassword().equals(password)) {
            return player;
        }
        return null;
    }

    /**
     * Возвращает баланс игрока по его имени пользователя.
     *
     * @param username имя пользователя.
     * @return текущий баланс игрока или -1, если игрок не найден.
     */
    public double getBalance(String username) {
        Player player = players.get(username);
        return (player != null) ? player.getBalance() : -1;
    }

    /**
     * Выполняет дебет на указанную сумму с баланса игрока.
     *
     * @param player игрок, который будет задействован в операции дебета.
     * @param amount сумма для дебета.
     * @return true если операция успешно выполнена, false если недостаточно средств.
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
     * Выполняет кредит на указанную сумму на баланс игрока.
     *
     * @param player игрок, который будет задействован в операции кредита.
     * @param amount сумма для кредита.
     */
    public void credit(Player player, double amount) {
        player.setBalance(player.getBalance() + amount);
        playerTransactions.get(player.getUsername()).add(new Transaction(amount, TransactionType.CREDIT));
    }

    /**
     * Возвращает историю транзакций для указанного игрока.
     *
     * @param username имя пользователя.
     * @return список транзакций или пустой список, если для данного пользователя нет транзакций.
     */
    public List<Transaction> getTransactionHistory(String username) {
        return playerTransactions.getOrDefault(username, new ArrayList<>());
    }
}
