package com.walletservice.repository;

import com.walletservice.model.Transaction;

import java.util.List;

/**
 * ����������� ��� ������ � ������������.
 * ������������� ������ ��� ���������� ���������� � ������ ���������� �� ����� ������������.
 */
public interface TransactionRepository {

    /**
     * ���� � ���������� ������ ���� ���������� ��� ������� ����� ������������.
     *
     * @param username ��� ������������, ��� �������� ���������� ����� ����������.
     * @return ������ ���������� ������������ ��� ������ ������, ���� ���������� �� �������.
     */
    List<Transaction> findByUsername(String username);

    /**
     * ��������� ����� ���������� � �����������.
     *
     * @param transaction ������ ����������, ������� ���������� ���������.
     */
    void save(Transaction transaction);
}

