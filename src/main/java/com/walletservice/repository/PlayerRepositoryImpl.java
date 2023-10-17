package com.walletservice.repository;




import com.walletservice.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import com.walletservice.model.Player;

public class PlayerRepositoryImpl implements PlayerRepository {

    private static final String FIND_BY_ID_QUERY = "SELECT id, name, balance FROM players WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO players (name, balance) VALUES (?, ?)";
    private static final String UPDATE_QUERY = "UPDATE players SET name = ?, balance = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM players WHERE id = ?";
    private static final String FIND_BY_USERNAME_QUERY = "SELECT * FROM players WHERE username = ?"; // предполагая, что ваша таблица называется "players"

    @Override
    public Player findByUsername(String username) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_USERNAME_QUERY)) {

            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Player(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getDouble("balance")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null; // вернуть null, если игрок с таким именем пользователя не найден
    }


    @Override
    public Optional<Player> findById(Integer id) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(new Player(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getDouble("balance")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public void save(Player player) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, player.getUsername());
            preparedStatement.setDouble(2, player.getBalance()); // предполагая, что баланс это BigDecimal
            preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    player.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating player failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

  public void delete(Integer id) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate() == 0) {
                throw new SQLException("Deleting player failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void update(Player player) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {

            preparedStatement.setString(1, player.getUsername());
            preparedStatement.setDouble(2, player.getBalance());
            preparedStatement.setInt(3, player.getId());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating player failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}