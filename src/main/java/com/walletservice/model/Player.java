package com.walletservice.model;

/**
 * Класс Player представляет собой пользователя в системе кошелька.
 */
public class Player {

    /**
     * Имя пользователя.
     */
    private final String username;

    /**
     * Пароль пользователя.
     */
    private final String password;

    /**
     * Текущий баланс пользователя.
     */
    private double balance;

    /**
     * Конструктор для создания нового экземпляра Player.
     *
     * @param username Имя пользователя.
     * @param password Пароль пользователя.
     */
    public Player(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Получить имя пользователя.
     *
     * @return Имя пользователя.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Получить пароль пользователя.
     *
     * @return Пароль пользователя.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Получить текущий баланс пользователя.
     *
     * @return Текущий баланс.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Установить баланс пользователя.
     *
     * @param balance Новое значение баланса.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
