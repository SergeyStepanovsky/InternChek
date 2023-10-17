package com.walletservice.model;


import java.util.UUID;

/**
 * ����� Transaction ������������ ����� ��������� ���������� � ������� ��������.
 */
public class Transaction {

    /**
     * ���������� ������������� ����������.
     */
    private final UUID transactionId;

    /**
     * ����� ����������.
     */
    private final double amount;

    /**
     * ��� ���������� (������ ��� �����).
     */
    private final TransactionType type;

    /**
     * ����������� ��� �������� ����� ����������.
     *
     * @param amount ����� ����������.
     * @param type ��� ����������.
     */
    public Transaction(double amount, TransactionType type) {
        this.transactionId = UUID.randomUUID();
        this.amount = amount;
        this.type = type;
    }

    public Transaction(UUID transactionId, double amount, TransactionType type) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.type = type;
    }


    /**
     * �������� ���������� ������������� ����������.
     *
     * @return ���������� ������������� ����������.
     */
    public UUID getTransactionId() {
        return transactionId;
    }

    /**
     * �������� ����� ����������.
     *
     * @return ����� ����������.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * �������� ��� ����������.
     *
     * @return ��� ����������.
     */
    public TransactionType getType() {
        return type;
    }
}

