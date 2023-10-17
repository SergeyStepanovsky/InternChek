package com.walletservice.repository;

import com.walletservice.model.Transaction;
import com.walletservice.model.TransactionType;
import com.walletservice.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransactionRepositoryImpl implements TransactionRepository {

    private static final String FIND_BY_USERNAME_QUERY = "SELECT transaction_id, amount, type FROM transactions WHERE username = ?";
    private static final String INSERT_QUERY = "INSERT INTO transactions (transaction_id, username, amount, type) VALUES (?, ?, ?, ?)";

    @Override
    public List<Transaction> findByUsername(String username) {
        List<Transaction> transactions = new ArrayList<>();

        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_USERNAME_QUERY)) {

            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Transaction transaction = new Transaction(
                            UUID.fromString(resultSet.getString("transaction_id")),
                            resultSet.getDouble("amount"),
                            TransactionType.valueOf(resultSet.getString("type").toUpperCase())
                    );
                    transactions.add(transaction);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return transactions;
    }

    @Override
    public void save(Transaction transaction) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {

            preparedStatement.setString(1, transaction.getTransactionId().toString());
            // Ошибка в следующих двух строках. Используйте setDouble для amount и setString для username и type.
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setString(4, transaction.getType().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
