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
            System.out.println("1. �����������\n2. ����\n3. �������� ������\n4. �����\n5. ������\n6. ������� ����������\n7. �����");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("����������� ������ ������������:");
                    System.out.print("������� ��� ������������: ");
                    String regUsername = scanner.nextLine();
                    System.out.print("������� ������: ");
                    String regPassword = scanner.nextLine();
                    if(playerService.register(regUsername, regPassword)) {
                        System.out.println("����������� ��������� �������!");
                    } else {
                        System.out.println("������������ � ����� ������ ��� ����������.");
                    }
                    break;
                case 2:
                    System.out.println("���� � �������:");
                    System.out.print("������� ��� ������������: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("������� ������: ");
                    String loginPassword = scanner.nextLine();
                    loggedInPlayer = playerService.login(loginUsername, loginPassword);
                    if (loggedInPlayer != null) {
                        System.out.println("���� �������� �������!");
                    } else {
                        System.out.println("�������� ��� ������������ ��� ������.");
                    }
                    break;
                case 3:
                    if (loggedInPlayer == null) {
                        System.out.println("������� ��������� ����.");
                        break;
                    }
                    System.out.println("������: " + playerService.getBalance(loggedInPlayer.getUsername()));
                    break;
                case 4:
                    if (loggedInPlayer == null) {
                        System.out.println("������� ��������� ����.");
                        break;
                    }
                    System.out.println("������� ����� ��� ������:");
                    double debitAmount = scanner.nextDouble();
                    if (playerService.debit(loggedInPlayer, debitAmount)) {
                        System.out.println("����� ������� ��������.");
                    } else {
                        System.out.println("������������ �������.");
                    }
                    break;
                case 5:
                    if (loggedInPlayer == null) {
                        System.out.println("������� ��������� ����.");
                        break;
                    }
                    System.out.println("������� ����� ��� �������:");
                    double creditAmount = scanner.nextDouble();
                    playerService.credit(loggedInPlayer, creditAmount);
                    System.out.println("������ ������� ��������.");
                    break;
                case 6:
                    if (loggedInPlayer == null) {
                        System.out.println("������� ��������� ����.");
                        break;
                    }
                    System.out.println("������� ����������:");
                    for (Transaction transaction : playerService.getTransactionHistory(loggedInPlayer.getUsername())) {
                        System.out.println(transaction.getType() + ": " + transaction.getAmount() + ", ID: " + transaction.getTransactionId());
                    }
                    break;
                case 7:
                    System.out.println("����� �� ���������.");
                    return;
            }
        }
    }
}