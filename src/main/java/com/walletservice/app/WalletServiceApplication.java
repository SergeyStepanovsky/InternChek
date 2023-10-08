package com.walletservice.app;

import com.walletservice.model.Player;
import com.walletservice.model.Transaction;
import com.walletservice.service.PlayerService;

import java.util.Scanner;

public class WalletServiceApplication {
    public static void main(String[] args) {
        PlayerService playerService = new PlayerService();
        Scanner scanner = new Scanner(System.in);
        Player loggedInPlayer = null;

        while (true) {
            System.out.println("1. Регистрация\n2. Вход\n3. Показать баланс\n4. Дебет\n5. Кредит\n6. История транзакций\n7. Выход");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Регистрация нового пользователя:");
                    System.out.print("Введите имя пользователя: ");
                    String regUsername = scanner.nextLine();
                    System.out.print("Введите пароль: ");
                    String regPassword = scanner.nextLine();
                    if(playerService.register(regUsername, regPassword)) {
                        System.out.println("Регистрация выполнена успешно!");
                    } else {
                        System.out.println("Пользователь с таким именем уже существует.");
                    }
                    break;
                case 2:
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
                    if (loggedInPlayer == null) {
                        System.out.println("Сначала выполните вход.");
                        break;
                    }
                    System.out.println("Баланс: " + playerService.getBalance(loggedInPlayer.getUsername()));
                    break;
                case 4:
                    if (loggedInPlayer == null) {
                        System.out.println("Сначала выполните вход.");
                        break;
                    }
                    System.out.println("Введите сумму для дебета:");
                    double debitAmount = scanner.nextDouble();
                    if (playerService.debit(loggedInPlayer, debitAmount)) {
                        System.out.println("Дебет успешно выполнен.");
                    } else {
                        System.out.println("Недостаточно средств.");
                    }
                    break;
                case 5:
                    if (loggedInPlayer == null) {
                        System.out.println("Сначала выполните вход.");
                        break;
                    }
                    System.out.println("Введите сумму для кредита:");
                    double creditAmount = scanner.nextDouble();
                    playerService.credit(loggedInPlayer, creditAmount);
                    System.out.println("Кредит успешно выполнен.");
                    break;
                case 6:
                    if (loggedInPlayer == null) {
                        System.out.println("Сначала выполните вход.");
                        break;
                    }
                    System.out.println("История транзакций:");
                    for (Transaction transaction : playerService.getTransactionHistory(loggedInPlayer.getUsername())) {
                        System.out.println(transaction.getType() + ": " + transaction.getAmount() + ", ID: " + transaction.getTransactionId());
                    }
                    break;
                case 7:
                    System.out.println("Выход из программы.");
                    return;
            }
        }
    }
}