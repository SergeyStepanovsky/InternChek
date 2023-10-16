package com.walletservice.app;

import com.walletservice.model.Player;
import com.walletservice.model.Transaction;
import com.walletservice.service.PlayerService;
import com.walletservice.service.TransactionService;
import com.walletservice.service.TransactionServiceImpl;

import java.util.Scanner;

/**
 * Основной класс приложения, предоставляющий пользовательский интерфейс для работы с кошельком.
 */
/**
 * Главный класс приложения, обеспечивающий интерфейс пользователя для работы с кошельками игроков.
 */
public class WalletServiceApplication {

    /**
     * Главная точка входа в приложение.
     *
     * @param args аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        PlayerService playerService = new PlayerService();
        TransactionService transactionService = new TransactionServiceImpl();

        try (Scanner scanner = new Scanner(System.in)) {
            Player loggedInPlayer = null;

            /**
             * Основной цикл интерфейса пользователя.
             */
            while (true) {
                System.out.println("1. Регистрация\n2. Вход\n3. Показать баланс\n4. Дебет\n5. Кредит\n6. История транзакций\n7. Выход");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        /**
                         * Регистрация нового пользователя.
                         */
                        System.out.println("Регистрация нового пользователя:");
                        System.out.print("Введите имя пользователя: ");
                        String regUsername = scanner.nextLine();
                        System.out.print("Введите пароль: ");
                        String regPassword = scanner.nextLine();
                        if (playerService.register(regUsername, regPassword)) {
                            System.out.println("Регистрация выполнена успешно!");
                        } else {
                            System.out.println("Пользователь с таким именем уже существует.");
                        }
                        break;
                    case 2:
                        /**
                         * Вход в систему.
                         */
                        System.out.println("Вход в систему:");
                        System.out.print("Введите имя пользователя: ");
                        String loginUsername = scanner.nextLine();
                        System.out.print("Введите пароль: ");
                        String loginPassword = scanner.nextLine();
                        loggedInPlayer = playerService.login(loginUsername, loginPassword);
                        if (loggedInPlayer != null) {
                            System.out.println("Вход выполнен успешно!");
                        } else {
                            System.out.println("Неверные имя пользователя или пароль.");
                        }
                        break;
                    case 3:
                        /**
                         * Показать баланс.
                         */
                        if (loggedInPlayer == null) {
                            System.out.println("Сначала выполните вход.");
                            break;
                        }
                        System.out.println("Баланс: " + loggedInPlayer.getBalance());
                        break;
                    case 4:
                        /**
                         * Дебет.
                         */
                        if (loggedInPlayer == null) {
                            System.out.println("Сначала выполните вход.");
                            break;
                        }
                        System.out.println("Введите сумму для дебета:");
                        double debitAmount = scanner.nextDouble();
                        if (transactionService.debit(loggedInPlayer, debitAmount)) {
                            System.out.println("Дебет успешно выполнен.");
                        } else {
                            System.out.println("Недостаточно средств.");
                        }
                        break;
                    case 5:
                        /**
                         * Кредит.
                         */
                        if (loggedInPlayer == null) {
                            System.out.println("Сначала выполните вход.");
                            break;
                        }
                        System.out.println("Введите сумму для кредита:");
                        double creditAmount = scanner.nextDouble();
                        transactionService.credit(loggedInPlayer, creditAmount);
                        System.out.println("Кредит успешно выполнен.");
                        break;

                    case 6:
                        /**
                         * История транзакций.
                         */
                        if (loggedInPlayer == null) {
                            System.out.println("Сначала выполните вход.");
                            break;
                        }
                        System.out.println("История транзакций:");
                        for (Transaction transaction : transactionService.getTransactionHistory(loggedInPlayer.getUsername())) {
                            System.out.println(transaction.getType() + ": " + transaction.getAmount() + ", ID: " + transaction.getTransactionId());
                        }
                        break;

                    case 7:
                        /**
                         * Выход из программы.
                         */
                        System.out.println("Выход из программы.");
                        return;

                    default:
                        /**
                         * Неправильный выбор.
                         */
                        System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                        break;
                }
            }
        }
    }
}