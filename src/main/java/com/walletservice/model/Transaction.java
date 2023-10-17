package com.walletservice.model;


import java.util.UUID;

/**
 * Класс Transaction представляет собой отдельную транзакцию в системе кошелька.
 */
public class Transaction {

    /**
     * Уникальный идентификатор транзакции.
     */
    private final UUID transactionId;

    /**
     * Сумма транзакции.
     */
    private final double amount;

    /**
     * Тип транзакции (кредит или дебет).
     */
    private final TransactionType type;

    /**
     * Конструктор для создания новой транзакции.
     *
     * @param amount Сумма транзакции.
     * @param type Тип транзакции.
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
     * Получить уникальный идентификатор транзакции.
     *
     * @return Уникальный идентификатор транзакции.
     */
    public UUID getTransactionId() {
        return transactionId;
    }

    /**
     * Получить сумму транзакции.
     *
     * @return Сумма транзакции.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Получить тип транзакции.
     *
     * @return Тип транзакции.
     */
    public TransactionType getType() {
        return type;
    }
}

