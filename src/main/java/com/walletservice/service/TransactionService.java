package com.walletservice.service;

import com.walletservice.model.Player;
import com.walletservice.model.Transaction;
import java.util.List;

/**
 * Интерфейс для сервиса транзакций, предоставляющий основные операции по обработке транзакций.
 */
public interface TransactionService {

    /**
     * Проводит дебетовую транзакцию для указанного игрока.
     *
     * @param player игрок, счет которого следует списать.
     * @param amount сумма списания.
     * @return true, если операция прошла успешно, false, если на счету игрока недостаточно средств.
     */
    boolean debit(Player player, double amount);

    /**
     * Проводит кредитовую транзакцию для указанного игрока.
     *
     * @param player игрок, на счет которого следует зачислить средства.
     * @param amount сумма зачисления.
     */
    void credit(Player player, double amount);

    /**
     * Возвращает историю транзакций для указанного имени пользователя.
     *
     * @param username имя пользователя.
     * @return список транзакций для данного пользователя. Возвращает пустой список, если для пользователя нет транзакций.
     */
    List<Transaction> getTransactionHistory(String username);
}
