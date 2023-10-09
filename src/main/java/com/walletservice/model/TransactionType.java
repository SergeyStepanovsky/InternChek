package com.walletservice.model;

/**
 * Перечисление TransactionType представляет собой типы транзакций, которые могут быть выполнены в системе кошелька.
 */
public enum TransactionType {

    /**
     * Кредитная транзакция, которая представляет собой добавление средств на счет.
     */
    CREDIT("Credit Transaction", "Adding funds to the account"),

    /**
     * Дебетовая транзакция, которая представляет собой списание средств со счета.
     */
    DEBIT("Debit Transaction", "Removing funds from the account");

    /**
     * Отображаемое имя типа транзакции.
     */
    private final String displayName;

    /**
     * Описание типа транзакции.
     */
    private final String description;

    /**
     * Конструктор для инициализации типа транзакции с его отображаемым именем и описанием.
     *
     * @param displayName Отображаемое имя типа транзакции.
     * @param description Описание типа транзакции.
     */
    TransactionType(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    /**
     * Получить отображаемое имя типа транзакции.
     *
     * @return Отображаемое имя типа транзакции.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Получить описание типа транзакции.
     *
     * @return Описание типа транзакции.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Переопределенный метод для возвращения строки, представляющей тип транзакции.
     *
     * @return Строка, представляющая тип транзакции.
     */
    @Override
    public String toString() {
        return displayName + ": " + description;
    }
}
