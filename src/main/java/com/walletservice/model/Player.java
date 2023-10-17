package com.walletservice.model;

public class Player {

    /**
     * Идентификатор игрока.
     */
    private int id;

    /**
     * Имя пользователя.
     */
    private String username;

    /**
     * Пароль пользователя.
     */
    private String password;

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

    public Player(int id, String username, double balance) {
        this.id = id;
        this.username = username;
        this.balance = balance;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
