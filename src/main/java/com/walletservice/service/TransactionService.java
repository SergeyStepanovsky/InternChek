package com.walletservice.service;

import com.walletservice.model.Player;
import com.walletservice.model.Transaction;
import java.util.List;

/**
 * ��������� ��� ������� ����������, ��������������� �������� �������� �� ��������� ����������.
 */
public interface TransactionService {

    /**
     * �������� ��������� ���������� ��� ���������� ������.
     *
     * @param player �����, ���� �������� ������� �������.
     * @param amount ����� ��������.
     * @return true, ���� �������� ������ �������, false, ���� �� ����� ������ ������������ �������.
     */
    boolean debit(Player player, double amount);

    /**
     * �������� ���������� ���������� ��� ���������� ������.
     *
     * @param player �����, �� ���� �������� ������� ��������� ��������.
     * @param amount ����� ����������.
     */
    void credit(Player player, double amount);

    /**
     * ���������� ������� ���������� ��� ���������� ����� ������������.
     *
     * @param username ��� ������������.
     * @return ������ ���������� ��� ������� ������������. ���������� ������ ������, ���� ��� ������������ ��� ����������.
     */
    List<Transaction> getTransactionHistory(String username);
}
