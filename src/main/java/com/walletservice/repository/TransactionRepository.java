package com.walletservice.repository;

import com.walletservice.model.Transaction;

import java.util.List;

/**
 * Репозиторий для работы с транзакциями.
 * Предоставляет методы для сохранения транзакций и поиска транзакций по имени пользователя.
 */
public interface TransactionRepository {

    /**
     * Ищет и возвращает список всех транзакций для данного имени пользователя.
     *
     * @param username имя пользователя, для которого необходимо найти транзакции.
     * @return список транзакций пользователя или пустой список, если транзакций не найдено.
     */
    List<Transaction> findByUsername(String username);

    /**
     * Сохраняет новую транзакцию в репозитории.
     *
     * @param transaction объект транзакции, который необходимо сохранить.
     */
    void save(Transaction transaction);
}

