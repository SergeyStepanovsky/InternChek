package com.walletservice.model;

/**
 * ����� Player ������������ ����� ������������ � ������� ��������.
 */
public class Player {

    /**
     * ��� ������������.
     */
    private final String username;

    /**
     * ������ ������������.
     */
    private final String password;

    /**
     * ������� ������ ������������.
     */
    private double balance;

    /**
     * ����������� ��� �������� ������ ���������� Player.
     *
     * @param username ��� ������������.
     * @param password ������ ������������.
     */
    public Player(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * �������� ��� ������������.
     *
     * @return ��� ������������.
     */
    public String getUsername() {
        return username;
    }

    /**
     * �������� ������ ������������.
     *
     * @return ������ ������������.
     */
    public String getPassword() {
        return password;
    }

    /**
     * �������� ������� ������ ������������.
     *
     * @return ������� ������.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * ���������� ������ ������������.
     *
     * @param balance ����� �������� �������.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
